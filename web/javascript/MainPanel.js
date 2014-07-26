// This Javascript object will represent the MainPanel (center div that displays posts
// Holds a list of Post objects

var MainPanel = (function() {
  
  var config = {};
  var postsList = [];
  
  // Input:
    // currentUser
    // isAdmin
    // currentCategory
    // currentTopicId
    // currentPost(?)
  var init = function(settings){
    console.log("MainPanel instantiated");
    $.extend(config, settings);
    // console.log(config);
  };
  
  // Input:
    // Post JSON object
    // Object is processed in Post object
  var addPost = function(postJson){
    console.log("Adding post");
    console.log(postJson);
    var postObject = new Post();
    postObject.init(postJson);
    postsList.push(postObject);
  };
  
  return {
    config: config,
    postsList: postsList,
    init: init,
    addPost: addPost
  };
  
})();