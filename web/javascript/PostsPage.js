PostsPage = (function(){
  var config = {};
  
  var init = function(settings){
    $.extend(config, settings);
    initTopicHandlers();
    initPostHandlers();
    initRegisterHandlers();
  };
  
  var initTopicHandlers = function(){
    $(".topicElement").on("click", function(){
      var url = window.location.protocol + "//" + window.location.host + window.location.pathname;
      var parameters = "?" + "topicId=" + $(this).find(".categoryWrapper").html().toString();
      console.log(url + parameters);
      location.href = (url + parameters);
    });
  }
  
  var initPostHandlers = function(){
    $(".postElement").on("click", function(){
      // Remove selected class and reply elements from all other posts
      $(".postElement").not($(this)).removeClass("selected");
      $(".postElement").not($(this)).find(".detailsWrapper").hide();
      if ($(this).hasClass("selected")) {
        // Give some option to remove the selected state of the post
      } else {
        // Add selected tag and reply element
        $(this).addClass("selected");
        $(this).find(".detailsWrapper").show();
      }
    });
  }
  
  var initRegisterHandlers = function(){
    // Register button should bring up popup
    $(".registerButton").on("click", function(){
      $(".popup-background").show();
      $(".register-popup-wrapper").show();
    });
    
    // Popup close button should close popup
    $(".popupCloseButton").on("click", function(){
      $(".popup-background").hide();
      $(".register-popup-wrapper").hide();
    });
  }
  
  return {
    init: init
  };
})();