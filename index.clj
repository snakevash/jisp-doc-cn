;; 个人认为 jisp 比 clojurescript 轻量
;; 也就更能发挥 lisp 在小型项目上的作用
;; 少了clojurescript默认包含的google框架
;; 一切就显得很舒服

;; 它可以写 nodejs 和 前端js
;; 个人的工作环境是这样子的
;; 用Light Table来写jisp
;; 然后用 webstorm 来做即时的转换

;; 上线可以用 grunt 或者 gulp 或者 npm script 来进行工作流处理

;; 其实 jisp写npm模块更好 这样子就不用和原生的js混合


;; jisp有几个需要改进的地方
;; 首先它产生的js代码质量还需加强 不过clojurescript也差不多 反正没有coffeescript好
;; 其次 调试jisp 个人是用chrome dev来调试前端 然后用 webstorm 来调试后端
;; 调试的时候 还是需要对js有深入的了解 因为产生的js代码语法是比较啰嗦和奇怪的

(+ "Hello Snake!" "Hello jisp!")
