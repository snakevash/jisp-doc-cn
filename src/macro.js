(function() {
  ((typeof A !== 'undefined') && A) || ((typeof B !== 'undefined') && B) || ((typeof C !== 'undefined') && C);

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
  add(1, 2, 3);
  console.log([] + "hello " + "world");
  return;
})['call'](this);