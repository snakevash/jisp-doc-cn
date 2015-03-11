(function() {
  var newvar, pi, first, second, third, lastest, shifty, picky, dodgy, x, emptyVar, ringMyBell, smaller, bigger, mid, closing, pair, animals, key, val, cats, name, catnames, _ref, _err, _ref0, _i, _ref1, _i0, _ref2, _key, _res, _ref3;
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
  (function() {});
  (function(health) {
    return console.log(health);
  })(100);
  typeof health !== 'undefined';
  (function(plus, minus) {
    return console.log(plus ^ minus);
  })(110, -12);
  _ref0 = [3, Infinity];
  smaller = _ref0[0];
  bigger = _ref0[1];
  _ref1 = [4, 8, 0, 3];
  first = _ref1[0];
  var mid = 3 <= _ref1.length ? [].slice.call(_ref1, 1, _i0 = _ref1.length - 1) : (_i0 = 1, []);
  closing = _ref1[_i0++];
  console.log(mid, closing);
  pair = ["dog", "lizard"];
  console.log.apply(console, [].concat(["cat"]).concat(pair));
  !!true;
  grass === "green";
  she === "smart" || she === "beautiful" || she === "artistic";
  animals = {
    "spuirrel": "Eevee",
    "fox": "Vulpix"
  };
  _ref2 = animals;
  for (key in _ref2) {
    val = _ref2[key];
    console.log(key, val);
  }
  cats = {
    pink: "Persian",
    yellow: "Skitty"
  };
  _res = [];
  _ref3 = cats;
  for (_key in _ref3) {
    name = _ref3[_key];
    if (typeof name !== 'undefined') _res.push(name);
  }
  catnames = _res;
  return x[0];
})['call'](this);