(function() {
  var ringMyBell, array;

  function fact(x) {
    return ((x === 0) ? 1 : (x * fact(x - 1)));
  }
  fact;
  (function(first, second) {
    return (first + second);
  });
  (function() {
    return returnMe;
  });
  (function() {});
  ringMyBell = (function(bell) {
    return console.log(bell);
  });
  ringMyBell("\x07");
  (function(x) {
    return ("Hello " + x);
  })("World!");

  function numerify(x) {
    var _ref;
    if (isNaN(Number(x))) {
      console.log("not a number:", x);
      _ref = NaN;
    } else {
      _ref = Number(x);
    }
    return _ref;
  }
  numerify;
  (function() {
    return (arguments[0] * arguments[2]);
  })(3, 100, 4);
  (function() {
    return (3 + 4);
  });
  (function() {
    return ((3 + 4) + (5 - 1));
  });
  (function() {
    return (function(_) {
      return (_ + 4);
    })(4);
  });
  array = [0, 1, 2, 3, 4, 5];
  (function() {
    return (arguments[0] * arguments[1]);
  });
  array.filter((function() {
    return (arguments[0] > 1);
  }));
  (function(health) {
    return console.log(health);
  })(100);
  typeof health !== 'undefined';
  (function(plush, minus) {
    return console.log(plush ^ minus);
  })(110, -12);
  return (typeof plush !== 'undefined') || (typeof minus !== 'undefined');
})['call'](this);