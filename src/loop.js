(function() {
  var animals, key, val, cats, name, catnames, color, bigcolors, cat, mCats, index, char, array, x, bugs, even, _ref, _key, _res, _ref0, _res0, _ref1, _key0, _res1, _ref2, _ref3, _ref4, _i, _res2, _ref5, _i0, _ref6, _res3, _ref7, _res4, _ref8;
  animals = {
    squirrel: "Eevee",
    fox: "Vulpix"
  };
  _ref = animals;
  for (key in _ref) {
    val = _ref[key];
    console.log(key, val);
  }
  cats = {
    pink: "Persian",
    yellow: "Skitty"
  };
  _res = [];
  _ref0 = cats;
  for (_key in _ref0) {
    name = _ref0[_key];
    if (typeof name !== 'undefined') _res.push(name);
  }
  catnames = _res;
  _res0 = [];
  _ref1 = cats;
  for (color in _ref1) {
    name = _ref1[color];
    if (typeof color.toUpperCase() !== 'undefined') _res0.push(color.toUpperCase());
  }
  bigcolors = _res0;
  cats = {
    pink: "Mew",
    yellow: "Meowth",
    white: "Absol"
  };
  _res1 = [];
  _ref2 = cats;
  for (_key0 in _ref2) {
    cat = _ref2[_key0];
    if (typeof(_ref3 = ((cat[0] === "M") ? cat : undefined)) !== 'undefined') _res1.push(_ref3);
  }
  mCats = _res1;
  _ref4 = "Meow";
  for (index = 0; index < _ref4.length; ++index) {
    char = _ref4[index];
    console.log(index, char);
  }
  array = [
    ["drink", "milk"],
    ["sweet", "icecream"],
    ["drink", "coffee"]
  ];
  _res2 = [];
  _ref5 = array;
  for (_i = 0; _i < _ref5.length; ++_i) {
    x = _ref5[_i];
    if (typeof x !== 'undefined') _res2.push(x);
  }
  console.log(_res2);
  _ref6 = array;
  for (_i0 = 0; _i0 < _ref6.length; ++_i0) {
    x = _ref6[_i0];
    if ((x[0] === "drink")) x;
  }
  bugs = ["missing comma", "missing semicolon"];
  _res3 = [];
  while (bugs.length > 0) {
    if (typeof(_ref7 = (bugs.shift() + " avoided")) !== 'undefined') _res3.push(_ref7);
  }
  console.log(_res3);
  array = [0, 1, 2, 3, 4];
  _res4 = [];
  while (array.length > 0) {
    x = array.pop();
    if (typeof(_ref8 = (((x % 2) === 0) ? x : undefined)) !== 'undefined') _res4.push(_ref8);
  }
  return even = _res4;
})['call'](this);