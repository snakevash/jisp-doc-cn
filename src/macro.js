(function() {
  var uniq, myStore, jisp, uniq0;
  ((typeof NaN !== 'undefined') && NaN) || ((typeof Infinity !== 'undefined') && Infinity) || ((typeof myVar !== 'undefined') && myVar);

  function mul() {
    var _i;
    var args = 1 <= arguments.length ? [].slice.call(arguments, 0, _i = arguments.length - 0) : (_i = 0, []);
    return ((args.length === 0) ? args.reduce((function() {
      return (arguments[0] * arguments[1]);
    })) : undefined);
  }
  mul;
  mul(2, 3);

  function add() {
    var _i;
    var args = 1 <= arguments.length ? [].slice.call(arguments, 0, _i = arguments.length - 0) : (_i = 0, []);
    return ((args.length === 0) ? args.reduce((function() {
      return (arguments[0] + arguments[1]);
    })) : undefined);
  }
  add;
  1 + 2 + 3;
  console.log([] + "hello " + "world");
  Plant["prototype"]["grow"] = (function(time, speed) {
    return (this.length += (time * speed));
  });
  Animal["prototype"]["growl"] = (function(decibels) {
    return (this.loudness = decibels);
  });
  uniq0 = 'my unique variable';
  uniq = 'declared outside macro';
  process.stdout.write("hello world");
  process.stdout.write("another call");
  99 + 44 + 11;
  Infinity + -Infinity;
  myStore = {
    testMacro: (function() {
      return "nameToReturn";
    })
  };
  jisp = require('jisp');
  jisp.importMacros(myStore);
  return testMacro();
})['call'](this);