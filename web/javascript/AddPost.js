AddPost = (function() {
  // config parameters passed in from index.jsp
  // currentCategory
  // currentTopic
  var config = {};

  var init = function(settings) {
    console.log("AddPost initialized");
    $.extend(config, settings);
    initAddPostHandlers();
  };
  
  var initAddPostHandlers = function() {
    // Bring up the 'Add Posts' popup
    $(".addPostButton").on("click", function() {
      console.log("clicked");
      // $(".popup-background").show();
      $(".add-post-wrapper").show();
    });

    // Popup close button should close popup
    $(".popupCloseButton").on("click", function() {
      // $(".popup-background").hide();
      $(".add-post-wrapper").hide();
    });
  };
  
  return {
    init: init
  };
})();