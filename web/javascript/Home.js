Home = (function() {
  var config = {};

  var init = function(settings) {
    $.extend(config, settings);
  };

  return {
    init: init
  };
})();