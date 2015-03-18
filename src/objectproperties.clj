;; 对象属性可以用 . 或者 [] 来访问

(= bunny (bouny: true fluffy: false))
bunny.bouny
bunny["fluffy"]

;; bunny = {
;;   bouncy: true,
;;   fluffy: false
;; };
;; bunny.bouncy;
;; bunny['fluffy'];

;; jisp 的正统做法是使用 (get obj prop) 的form.

(get bunny bouncy)
(get bunny "fluffy")

;; bunny[bouncy];
;; bunny['fluffy'];

;; 也可以更自然的形式

(String 113) .length
(String 113) [(+ 1 1)]

;; String(113).length;
;; String(113)[1 + 1];

;; 依然可以用 get form 来访问和 do form
;; 这个在定义宏的时候很有用 特别是单独传对象和属性的时候
(get (String 113) "length")
(get (String 113) (+ 1 1))

;; String(113)['length'];
;; String(113)[1 + 1];

;; 链式调用方法 用 do form 来包裹它们
(do cartooonSnake
  (.crawlForward 10)
  (.turnLeft)
  (['.crawlForward'] 5)
  (.eat "bunny")
  (.elongtages food.weight))

;; cartoonSnake
;;   .crawlForward(10)
;;   .turnLeft()['crawlForward'](5)
;;   .eat('bunny')
;;   .elongate(food.weight);

;; (snake: 还是要特别关注那些有默认 do form 功能的语法 因为在jisp里面 do form 真心很累)
