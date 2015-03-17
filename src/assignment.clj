;; 赋值
;; 赋值采用前置运算

;; (= var value [... var value])
;; (= var value)

;; (snake: 看到赋值 我就不得不说一点 赋值真心是包含一个do的form 在jisp是比较难得的)
;; (snake: 赋值是采用var的 我一般采用 _ 来执行一些副作用 或者prn 等辅助的表达式 记住 它是一个可以连续执行的不需要包含do的form)

;; eg
(= newvar "some value")
(= pi (if (is 2 3)
        NaN
        Math.PI))

;; newvar = 'some value';
;; pi = ((2 === 3) ? NaN : Math.PI);

;; (snake: 表达式可以嵌套的)
;; 所有的jisp赋值不单单是=, 是var的.
;; 而且变量的申明是在作用域内的.
;; 可以使用 let 来申明一个在临时作用域的运行的代码断.
;; (snake: 就是那些变量在某个特定的作用域内 运行完就不需要了 当然 很多时候代码块都是这样子的)
;; 赋值可以连续的, 采用键值对就行, 嵌套的话取最后一个表达式的值

(= lastest (= first "Coffee"
              second "Beer"
              third "Milk"))
;; first = 'Coffee';
;; second = 'Beer';
;; lastest = (third = 'Milk');

;; 正确地使用赋值, 它是一个强大的form, 特别是block.
(= x (= shifty null
        picky (if false "nose up" "smile")
        dodgy (try (+ something) "unsuccessful")))

;; shifty = null;
;; picky = (false ? 'nose up' : 'smile');
;; try {
;;   _ref = something;
;; } catch (_err) {
;;   _ref = 'unsuccessful';
;; }
;; x = (dodgy = _ref);

;; (snake: 慎用 因为它和let的区别在于那些遗留的变量 可能会造成很多问题)

;; 调用空 = 的含义在于在作用域内申明变量
