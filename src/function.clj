;; jisp 的函数沿用了javascript的, 但是做了一些变更

;; (def <name> [<... params>] [<body>])
;; 命名函数
(def fact x
  (if (is x 0)
    1
    (* x (fact (- x 1)))))

;; function fact(x) {
;;   return ((x === 0) ? 1 : (x * fact(x - 1)));
;; }
;; fact;

;; 匿名函数 lambda
;; (fn [<... params>] [<body>])

(fn first second (+ first second))
(fn returnMe)
(fn)

;; (function(first, second) {
;;   return (first + second);
;; });
;; (function() {
;;   return returnMe;
;; });
;; (function() {});

;; 没有参数就直接返回
;; 调用并且返回
(= ringMyBell (fn bell (prn bell)))
(ringMyBell "\x07")
((fn x (+ "Hello " x)) "World!")

;; var ringMyBell;
;; ringMyBell = (function(bell) {
;;   return console.log(bell);
;; });
;; ringMyBell('\x07');
;; (function(x) {
;;   return ('Hello ' + x);
;; })('World!');

;; 函数的返回值就是它的body体
;; 你几乎没有必要返回它的值
(def numerify x
  (if (isNaN (Number x))
    (do (prn "not a number:" x) NaN)
    (Number x)))

;; function numerify(x) {
;;   var _ref;
;;   if (isNaN(Number(x))) {
;;     console.log('not a number:', x);
;;     _ref = NaN;
;;   } else {
;;     _ref = Number(x);
;;   }
;;   return _ref;
;; }
;; numerify;

;; 保持函数的每个判断分支都有返回值是不错的
;; 在函数体内 可以使用 # 来返回参数的第几个
((fn (* #0 #2)) 3 100 4)
;; (function() {
;;   return (arguments[0] * arguments[2]);
;; })(3, 100, 4);

;; 如果你想要当做一个构造函数 那么请明确使用 this 当做返回值 (snake: 可能是因为语法生成的原因 所以必须手动返回this)

;; lambda语法
;; {<body>}
{+ 3 4}
{+ (+ 3 4) (- 5 1)}

;; (function() {
;;     return (3 + 4);
;;   });
;;   return (function() {
;;     return ((3 + 4) + (5 - 1));
;;   });

{let _ 4 (+ _ 4)}
;; return (function() {
;;     return (function(_) {
;;       return (_ + 4);
;;     })(4);
;;   });

;; (snake: 使用 lambda 和 let 一起使用 可以使得语法还是比较简单的清爽的)
(= array `(0 1 2 3 4 5))
{* #0 #1}
(array.filter {> #0 1})

;; array = [0, 1, 2, 3];
;; (function() {
;;   return (arguments[0] * arguments[1]);
;; });
;; array.filter((function() {
;;   return (arguments[0] > 1);
;; }));

;; let
;; let可以在局部作用域内定义参数然后返回它的值 (snake: 用的是javascript的匿名函数 所以 它不能像clojure那样使用 局部变量在定义的时候不能够互相引用的 只有在它的body里面才可以)
;; (let [var value [var value ...]] [<body>])
(let health 100
  (prn health))
(? health)

;; (function(health) {
;;   return console.log(health);
;; })(100);
;; typeof health !== 'undefined';

;; let form默认有do form的效果 但是键值对
(let plush 110
  minus -12
  (prn (^ plush minus)))

;; (function(plush, minus) {
;;     return console.log(plush ^ minus);
;;   })(110, -12);

(? plush minus)
;; (typeof plus !== 'undefined') || (typeof minus !== 'undefined');
