Login = (function() {
  var config = {};

  var init = function(settings) {
    $.extend(config, settings);
    initLogoutHandlers();
  };

  var initLogoutHandlers = function() {
    $(".logoutButton").on("click",  function() {
      $.ajax({
        url: "loginServlet",
        data: {
          action: "logout"
        },
        success: function(){
          location.reload();
        }
      });
    });
  };

  return {
    init: init
  };
})();