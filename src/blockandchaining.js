(function() {
  var bugs, str, grated;

  function elongate(str) {
    str += str;
    console.log("duplicated:", str);
    return str;
  }
  elongate;
  bugs = [];
  bugs.push("butterfree");
  bugs.push("beedrill");
  console.log(bugs);
  str = ",...x";
  return grated = str
    .replace(/.../g, " ... ")
    .replace(/,/g, " , ")
    .trim();
})['call'](this);