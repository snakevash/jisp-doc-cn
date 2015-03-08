;; 赋值语句
;; (= var value [... var value])
;; (= var)

(= newvar "赋值一个字符窜")
(= pi (if (is 2 3)
        NaN
        Math.PI))

;; 赋值可以多条件
(= lastest (= first "coffee"
              second "Beer"
              third "Milk"))

;; 赋值语句可以正确处理代码块
(= x (= shifty null
        picky (if false "nose up" "smile")
        dodgy (try (+ something) "unsuccessful")))

;; 单个=就是定义
(= emptyVar)

;; 引用
`(1 2 3)
(quote (1 2 3))
`myvar
`'mystring'

;; 没有语法quote
(+ (^ 2 1) (^ 3 2))
`(+ (^ 2 1) (^ 3 2))

;; 解引用
`((* 2 3) (+ 4 5))
`(,(* 2 3) ,(+ 4 5))

;; 命名函数
;; (def <name> [<... params>] [<body>])
(def fact x
  (if (is x 0)
    1
    (* x (fact (- x 1)))))

;; 匿名函数
;; (fn [<... params>] [<body>])
(fn first second
  (+ first second))

;; 调用和返回
(= ringMyBell (fn bell
                (prn bell)))
(ringMyBell "\x07")
((fn x (+ "hello " x)) "World!")

;; 函数返回值
(def numerify x
  (if (isNaN (Number x))
    (do (prn "not a number:" x)
      NaN)
    (Number x)))

;; #(NYI) 调用arguments
((fn (* #0 #2)) 3 100 4 2)

;; {<body>}
{alert "It's a dragon!"}
{}

;; let 局部代码块 用函数来实现的
;; (let [var value [var value ...]] [<body>])


