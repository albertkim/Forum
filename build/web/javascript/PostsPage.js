PostsPage = (function() {
  var config = {};

  var init = function(settings) {
    $.extend(config, settings);
    initTitleHandlers();
    initTopicHandlers();
    initPostHandlers();
    initRegisterHandlers();
    initDeleteTopicHandlers();
    initDeletePostHandlers();
  };

  var initTitleHandlers = function() {
    $(".title").on("click",  function() {
      var url = window.location.protocol + "//" + window.location.host + "/Debate_Platform/mainServlet";
      console.log(url);
      location.href = (url);
    });
  };

  var initTopicHandlers = function() {
    // Highlight current topic
    $(".topicElement").on("click", function() {
      var url = window.location.protocol + "//" + window.location.host + window.location.pathname;
      var parameters = "?" + "topicId=" + $(this).find(".categoryWrapper").html().toString();
      location.href = (url + parameters);
    });
  };

  var initPostHandlers = function() {
    $(".postElement").on("click", function() {
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
    $(".deleteTopic").on("click", function(){
      var topicId = $(this).attr("topicId");
      var currentTopicId = $(this).attr("currentTopicId");
      $.ajax({
        url: "postAction",
        data: {
          action: "deleteTopic",
          topicId: topicId,
          currentTopicId: currentTopicId
        },
        success: function(data){
          console.log(data);
          // New post set gets returned in ajax form
          // TODO: Implement Backbone.js to display elements properly
          // For now, just refresh the page
          location.reload();
        }
      });
    });
  };
  
  var initDeletePostHandlers = function() {
    $(".deletePost").on("click", function(){
      var postId = $(this).attr("postId");
      var topicId = $(this).attr("topicId");
      $.ajax({
        url: "postAction",
        data: {
          action: "deletePost",
          postId: postId,
          topicId: topicId
        },
        success: function(data){
          console.log(data);
          // New post set gets returned in ajax form
          // TODO: Implement Backbone.js to display elements properly
          // For now, just refresh the page
          location.reload();
        }
      });
    });
  };

  return {
    init: init
  };
})();