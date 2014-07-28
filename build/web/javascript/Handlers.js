// To be used for click handling on universal elements

Handlers = (function() {
  // config parameters passed in from index.jsp
  // currentCategory
  // currentTopicId
  var config = {};

  var init = function(settings) {
    $.extend(config, settings);
    initTitleHandlers();
    initCurrentCategoryHandlers();
    initCategoryHandlers();
    initTopicHandlers();
    initRegisterHandlers();
    initDeleteTopicHandlers();
  };
  
  var initTitleHandlers = function() {
    $(".title").on("click",  function() {
      var url = window.location.protocol + "//" + window.location.host + "/Debate_Platform/mainServlet";
      console.log(url);
      location.href = (url);
    });
  };
  
  var initCurrentCategoryHandlers = function() {
    // Clicking on the current category (top of page) should go to category home page
    $(".currentCategory").on("click", function() {
      var url = window.location.protocol + "//" + window.location.host + window.location.pathname;
      var parameters = "?" + "category=" + config.currentCategory; 
      location.href = (url + parameters);
    });
  };
  
  var initCategoryHandlers = function() {
    $(".category").on("click", function() {
      var url = window.location.protocol + "//" + window.location.host + window.location.pathname;
      var parameters = "?" + "category=" + $(this).html(); 
      location.href = (url + parameters);
    });
  };

  var initTopicHandlers = function() {
    // Highlight current topic
    $(".topicElement").on("click", function() {
      var url = window.location.protocol + "//" + window.location.host + window.location.pathname;
      var parameters = "?" + "category=" + config.currentCategory + "&topicId=" + $(this).attr("topicId");
      location.href = (url + parameters);
    });
  };

  var initRegisterHandlers = function() {
    // Register button should bring up popup
    $(".registerButton").on("click", function() {
      $(".popup-background").show();
      $(".register-popup-wrapper").show();
    });

    // Popup close button should close popup
    $(".popupCloseButton").on("click", function() {
      $(".popup-background").hide();
      $(".register-popup-wrapper").hide();
    });
  };
  
  var initDeleteTopicHandlers = function() {
    $(".deleteTopic").on("click", function(event){
      var topicId = $(this).attr("topicId");
      var currentTopicId = $(this).attr("currentTopicId");
      $.ajax({
        url: "topicAction",
        data: {
          action: "deleteTopic",
          topicId: topicId,
          currentTopicId: currentTopicId
        },
        success: function(data){
          console.log("data: " + data);
          // New post set gets returned in ajax form
          // TODO: Implement Backbone.js to display elements properly
          // For now, just refresh the page
          location.reload();
        }
      });
      event.stopImmediatePropagation();
    });
  };

  return {
    init: init
  };
  
})();