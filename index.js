(function() {
  var test;
  console.log('测试一下 snake lee');
  console.log('snake');
  console.log('czq');
  console.log('世界 lee!');

  function fact(x) {
    return ((x === 0) ? 1 : (x * fact(x - 1)));
  }
  fact;
  console.log(fact(5));
  console.log("测试匿名函数：", (function(first, second) {
    return (first + second);
  })(1, 2));
  test = require('./src/snake');
  return console.log(test.add(1, 2));
})['call'](this);