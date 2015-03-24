;; 宏是编译时生成代码的函数
;; 宏是接受代码并且替换代码
;; 宏在编译时展开代码,然后编译成JS.

;; (mac name [<param>] <body>)
;; (<name> [<code>])

;; eg
(mac firstDefinedTruthy ...values
     `(or ,...(for value values
                `(and (? ,value) ,value))))
(firstDefinedTruthy NaN Infinity myVar)

;; ((typeof NaN !== 'undefined') && NaN) || ((typeof Infinity !== 'undefined') && Infinity) || ((typeof myVar !== 'undefined') && myVar);

;; 大多数jisp是由宏写的
;; 没有宏的代码生存周期
;; code -> compile into JS -> execute

;; 有宏的代码生存周期
;; code => parse macros <-> expand macros -> compile into JS => execute

;; 宏是完整、自定义函数,可以使用所有的语言能力.

;; template
;; 模板经常被用来生成代码
;; 表达式之前使用`符号
;; `(<code>)
;; 在表达式之前使用 , 符号可以执行表达式
;; `(<code> ,<elem> <code>)
;; ,<elem> 这个表达式就会执行而不是输出代码

(mac makeReduce name operator
     `(def ,name ...args
        (if (isnt args.length 0)
          (args.reduce {,operator #0 #1}))))

;; 定义一个函数
(makeReduce mul *)

;; 使用函数
(mul 2 3)

;; ` 可以让阻止表达式求值, 以原来方式输出
;; 这样子可以定义自己的结构 也就是dsl

;; 再来一个范例
(mac makeReduce name operator zeroValue
     `(def ,name ...args (do
                           ,(if (? zeroValue)
                              `(args.unshift ,zeroValue))
                           (if (is args.length 0)
                             (args.reduce {,operator #0 #1})))))
(makeReduce add +)

;; function add() {
;;     var _i;
;;     var args = 1 <= arguments.length ? [].slice.call(arguments, 0, _i = arguments.length - 0) : (_i = 0, []);
;;     return ((args.length === 0) ? args.reduce((function() {
;;       return (arguments[0] + arguments[1]);
;;     })) : undefined);
;;   }

(add 1 2 3)

;; code construction
;; 因为jisp代码是一个嵌套的数组, 宏可以解构和重组它. 这就是为什么有括号的原因.
;; 作为一个比较傻的示例, 你可以把语法反过来.

(mac reverse form (do
                    (def rev form
                      (if (Array.isArray form)
                        (do (for f form
                              (rev f))
                          (.reverse))
                        form))
                    (rev form)))

(reverse
 (("world" "hello " (() quote) +) prn))

;; console.log([] + 'hello ' + 'world');

;; 来一个比较复杂的例子
(mac task name ...args (do
                         (= pipeline `(do (handle (,(args.shift)
                                                    ,(args.shift)))))
                         (while (> args.length 0) (do
                                                    (= left (args.shift)
                                                       right (args.shift))
                                                    (pipeline.push `(.piple (handle (,left ,right))))))
                         `(gulp.task ,name (fn ,pipeline))))

;; gulp.task('jisp', (function() {
;;   return handle(gulp.src(jispFiles))
;;     .pipe(handle(conc('app.js')))
;;     .pipe(handle(jisp()))
;;     .pipe(handle(uglify({
;;       mangle: false
;;     })))
;;     .pipe(handle(gulp.dest('public/js/tmp/')));
;; }));

;; (snake: 宏可以生成一个代码结构 然后专注于逻辑部分 不需要脚手架代码)

;; 宏能够让任意的符号或者字面量字符串当做它的名字.
;; 假设你写了很多原生的扩展并且想要缩写定义.
;; 在其他语言中,如果有这方面的语法你觉得很幸运.
;; 在jisp中,你可以自己创造.

(mac @ obj method ...args body
     `(= (get (get ,obj "prototype") ,(JSON.stringify method))
         (fn ,...args ,body)))

(@ Plant grow time speed
   (+= this.length (* time speed)))
(@ Animal growl decibels
   (= this.loudness decibels))

;; Plant["prototype"]["grow"] = (function(time, speed) {
;;   return (this.length += (time * speed));
;; });
;; Animal["prototype"]["growl"] = (function(decibels) {
;;   return (this.loudness = decibels);
;; });

;; (snake: 相当于coffeescript中的@语法了 想来觉得很好用 宏是一个好东西)

;; 有些时候你想要代码能够返回包含绑定参数的变量
;; 在一个变量前面放置#来使得在当前作用域中它是唯一的
;; 如果它跟其他变量命名冲突 那么它将会被重定义

(mac myDefinition
  `(= #uniq 'my unique variable'))
(myDefinition)
(= uniq 'declared outside macro')

;; var uniq, uniq0;
;; uniq0 = 'my unique variable';
;; uniq = 'declared outside macro';

;; 最后宏在定义是就可以自我展开
((mac pr x `(process.stdout.write ,x)) "hello world")
(pr "another call")

;; (snake: 也就是说 在函数位置就可以自己展开变成函数了)

((mac add ...x `(+ ,...x)) 99 44 11)
(add Infinity -Infinity)

;; Macro Import and Export 宏的导入和导出
;; 宏有三种途径可以被导入
;; 编译或者包含有宏的文件 在节点运行时或者页面之前
;; 使用全局的jisp对象暴露出来的importMacros方法
;; 访问编译器暴露出的宏

;; 宏一直存在宏对象中 当它们在编译运行时
;; 它被jisp对象暴露并且能够直接被访问和修改
;; 推荐的方法是调用 importMacros 方法 然后导入宏存储库 就是一个hash表
;; 合并它们到对象中覆盖当前存在的宏

(= myStore (testMacro: (fn `nameToReturn)))
(= jisp (require 'jisp'))
(jisp.importMacros myStore)
(testMacro)  ; replaced by `nameToReturn`

