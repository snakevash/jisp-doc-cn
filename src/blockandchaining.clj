;; 代码块和调用链
;; jisp代码是由嵌套的表达式块组成
;; 甚至多行表达式也需要一个简单的表达式 (snake: 这个有点麻烦 没有默认包含默认的do form 所以 let可能比do更好用)
;; do form 可以包含多条代码的块

;; eg
(def elongate str
  (do (+= str str)
    (prn "duplicated:" str)
    str))

;; function elongate(str) {
;;   str += str;
;;   console.log('duplicated:', str);
;;   return str;
;; }
;; elongate;

;; jisp在编译的时候会把整个文件再包一层do form
;; do form 会返回最后一个表达式的值 (snake: 就是return)
(prn (do (= bugs `())
       (bugs.push "butterfree")
       (bugs.push "beedrill")
       bugs))

;; bugs = [];
;; bugs.push('butterfree');
;; bugs.push('beedrill');
;; console.log(bugs);

;; do form 可以形成调用链
(= str ",...x")
(= grated
   (do str
     (.replace /.../g " ... ")
     (.replace /,/g " , ")
     (.trim)))

;; str = ',…x';
;; grated = str
;;   .replace(/…/g, ' … ')
;;   .replace(/,/g, ' , ')
;;   .trim();

;; do form 是jisp唯一组合多个表达式, 其他的 函数、循环等都是单个表达式, 都需要do form
;; (snake: 这也是jisp比clojurescript麻烦的地方 但是如果只为副作用 可以使用let 或者 解构的form 都可以表达这种块逻辑)
