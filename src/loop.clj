;; 循环
;; 把JavaScript的循环细节抽象出来, 使得更据表达力

;; for over while

;; over
;; 遍历对象的方法和属性
;; 也能遍历继承的属性和定义的原型方法
;; (over [<value> [<key>]] <iterable> <body>)

;; eg
(= animals (squirrel: "Eevee" fox: "Vulpix"))

;; var animals, key, val, _ref;
;; animals = {
;;   squirrel: 'Eevee',
;;   fox: 'Vulpix'
;; };

(over val key animals (prn key val))

;; _ref = animals;
;; for (key in _ref) {
;;   val = _ref[key];
;;   console.log(key, val);
;; }

;; over 会自动为每个迭代建立一个列表来收集结果

;; eg
(= cats (pink: "Persian" yellow: "Skitty"))

;; cats = {
;;   pink: 'Persian',
;;   yellow: 'Skitty'
;; };

(= catnames
   (over name cats name))

;; 如果想过要直接返回val 那么不需要在name左右套括号
;; (over name cats (name)) 是调用name()

;; _res = [];
;; _ref = cats;
;; for (_key in _ref) {
;;   name = _ref[_key];
;;   if (typeof name !== 'undefined') _res.push(name);
;; }
;; catnames = _res;

(= bigcolors
   (over name color cats (color.toUpperCase)))

;; 注意看 _res0 _ref0 这种辅助参数
;; _res0 = [];
;; _ref0 = cats;
;; for (colour in _ref0) {
;;   name = _ref0[colour];
;;   if (typeof colour.toUpperCase() !== 'undefined') _res0.push(colour.toUpperCase());
;; }
;; bigcolours = _res0;

;; 迭代收集的结果是过滤掉 undefined

(= cats (pink: "Mew" yellow: "Meowth" white: "Absol"))

;; cats = {
;;   pink: 'Mew',
;;   yellow: 'Meowth',
;;   white: 'Absol'
;; };

(= mCats
   (over cat cats
         (if (is (car cat) "M")
           cat)))

;; _res = [];
;; _ref = cats;
;; for (_key in _ref) {
;;   cat = _ref[_key];
;;   if (typeof(_ref0 = ((cat[0] === 'M') ? cat : undefined)) !== 'undefined') _res.push(_ref0);
;; }
;; mCats = _res;

;; for
;; 适用于遍历数组和字符串
;; (for [<value> [<index>]] <iterable> <body>)

;; eg
(for char index "Meow"
  (prn index char))

;; _ref = 'meow';
;; for (index = 0; index < _ref.length; ++index) {
;;   char = _ref[index];
;;   console.log(index, char);
;; }

;; 结果集同样过滤 undefined
(= array
   `(("drink" "milk")
     ("sweet" "icecream")
     ("drink" "coffee")))

;; `() 会产生数组 其中每个() 都会产生一个数组
;; array = [
;;   ['drink', 'milk'],
;;   ['sweet', 'icecream'],
;;   ['drink', 'coffee']
;; ];

(prn (for x array x))

;; _res = [];
;; _ref = array;
;; for (_i = 0; _i < _ref.length; ++_i) {
;;   x = _ref[_i];
;;   if (typeof x !== 'undefined') _res.push(x);
;; }
;; console.log(_res);

(for x array
  (if (is (car x) "drink")
    x))

;; _ref0 = array;
;; for (_i0 = 0; _i0 < _ref0.length; ++_i0) {
;;   x = _ref0[_i0];
;;   if ((x[0] === 'drink')) x;
;; }

;; while
;; 细粒度的遥控, 使用 while 循环, 像 原生while那样工作 拥有 for 和 over 一样的特性
;; eg
;; (while <test> <body>)

(= bugs
   `("missing comma" "missing semicolon"))

;; bugs = ['missing comma', 'missing semicolon'];

(prn
 (while (> bugs.length 0)
   (+ (bugs.shift)
      " avoided")))

;; _res = [];
;; while (bugs.length > 0) {
;;   if (typeof(_ref = (bugs.shift() + ' avoided')) !== 'undefined') _res.push(_ref);
;; }
;; console.log(_res);

(= array
   `(0 1 2 3 4))
(= even
   (while (> array.length 0)
     (do
       (= x (array.pop))
       (if (is (% x 2) 0)
         x))))

;; array = [0, 1, 2, 3, 4];
;; _res0 = [];
;; while (array.length > 0) {
;;   x = array.pop();
;;   if (typeof(_ref0 = (((x % 2) === 0) ? x : undefined)) !== 'undefined') _res0.push(_ref0);
;; }
;; even = _res0;
