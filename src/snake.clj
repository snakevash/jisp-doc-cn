; 导出
(prn "翻译:" "snake")
(prn "希望大家喜欢")

;; 我认为比较好的实践

;; ex 1
;; 多用let少用do

;; 用do的场景
;; A.链式调用
;; B.这个调用需要上一个调用直接顺序结果
;; 解释一下 B操作直接依赖A操作并且有先后顺序 一定要先做完A操作才能做完B操作

;; 用let的场景
;; A.副作用
;; B.参数之间没有顺序
;; C.参考一下do的场景 没有就用let
;; 原因我认为是 let的实现是用匿名参数调用 有默认的连续赋值 但是值之间是没有相关联系的

;; test case
;; (= exports.add (fn x y (+ x y)))

;; (= array
;;    `(("drink" "milk")
;;      ("sweet" "icecream")
;;      ("drink" "coffee")))
;; (prn (for x array x))
