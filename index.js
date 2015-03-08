(function() {
  var newvar, pi, first, second, third, lastest, shifty, picky, dodgy, x, emptyVar, ringMyBell, _ref, _err;
  newvar = "赋值一个字符窜";
  pi = ((2 === 3) ? NaN : Math.PI);
  first = "coffee";
  second = "Beer";
  lastest = (third = "Milk");
  shifty = null;
  picky = (false ? "nose up" : "smile");
  try {
    _ref = something;
  } catch (_err) {
    _ref = "unsuccessful";
  }
  x = (dodgy = _ref);
  emptyVar;
  [1, 2, 3];
  [1, 2, 3];
  "myvar";
  "'mystring'";
  (2 ^ 1) + (3 ^ 2);
  [+, [ ^ , 2, 1],
    [ ^ , 3, 2]
  ];
  [
    [ * , 2, 3],
    [+, 4, 5]
  ];
  [2 * 3, 4 + 5];

  function fact(x) {
    return ((x === 0) ? 1 : (x * fact(x - 1)));
  }
  fact;
  (function(first, second) {
    return (first + second);
  });
  ringMyBell = (function(bell) {
    return console.log(bell);
  });
  ringMyBell("\x07");
  (function(x) {
    return ("hello " + x);
  })("World!");

  function numerify(x) {
    var _ref0;
    if (isNaN(Number(x))) {
      console.log("not a number:", x);
      _ref0 = NaN;
    } else {
      _ref0 = Number(x);
    }
    return _ref0;
  }
  numerify;
  (function() {
    return (arguments[0] * arguments[2]);
  })(3, 100, 4, 2);
  (function() {
    return alert("It's a dragon!");
  });
  return (function() {});
})['call'](this);