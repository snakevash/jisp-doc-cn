(prn '测试一下 snake lee')
(prn 'snake')
(prn 'czq')
(prn '世界 lee!')


; (def <name> [<... params>] [<body>])
; 标准函数定义
(def fact x
	(if (is x 0) 1
		(* x (fact (- x 1)))))
(prn (fact 5))

; 匿名函数定义
; (fn [<... params>] [<body>])
(prn `测试匿名函数： ((fn first second (+ first second)) 1 2))

(= test (require './src/snake'))
(console.log (test.add 1 2))