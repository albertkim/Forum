Home = (function() {
  var config = {};

  var init = function(settings) {
    $.extend(config, settings);
    initCategoryHandlers();
  };

  var initCategoryHandlers = function() {
    $(".bigCategory").on("click",  function() {
      var category = $(this).attr("category");
      var url = window.location.protocol + "//" + window.location.host + "/Debate_Platform/mainServlet?category=" + category;
      console.log(url);
      location.href = (url);
    });
  };

  return {
    init: init
  };
})();