var url =  window.location.protocol + "//" + window.location.host + window.location.pathname;

function createPostElement(postId, userId, content) {
    
    var postIdTextNode = document.createTextNode(postId);
    var userIdTextNode = document.createTextNode(userId);
    var contentTextNode = document.createTextNode(content);
    
    var userWrapper = document.createElement("div");
    userWrapper.className = "userWrapper";
    userWrapper.appendChild(userIdTextNode);
    userWrapper.appendChild(postIdTextNode);
    
    var contentWrapper = document.createElement("div");
    contentWrapper.className = "contentWrapper";
    contentWrapper.appendChild(contentTextNode);
    
    var postElement = document.createElement("div");
    postElement.className = "postElement";
    postElement.appendChild(userWrapper);
    postElement.appendChild(contentWrapper);
    
    document.getElementById("postDiv").appendChild(postElement);
    
}

function createTopicElement(topicId, content){
    console.log("Topic made");
    
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "index.jsp", true);
    
    var topicTextNode = document.createTextNode(topicId);
    var categoryTextNode = document.createTextNode(content);
    
    var topicWrapper = document.createElement("div");
    topicWrapper.className = "topicWrapper";
    topicWrapper.appendChild(topicTextNode);
    
    var contentWrapper = document.createElement("div");
    contentWrapper.className = "categoryWrapper";
    contentWrapper.appendChild(categoryTextNode);
    
    var topicElement = document.createElement("div");
    topicElement.className = "topicElement";
    topicElement.appendChild(topicWrapper);
    topicElement.appendChild(contentWrapper);
    
    // Add click handler
    // TODO: Modify just query parameters, don't recreate whole string
    var parameters = "?" + "topicId=" + topicId.toString();
    $(topicElement).on("click", function() {
        location.href = (url + parameters);
    });
    
    document.getElementById("topicDiv").appendChild(topicElement);
    
}