Forum
=====

Forum made with Java EE. Goal is to make a forum with modular, customized views for each category to suit different categories and communities.

To Do:

* (done) --------------- Get basic forum structure up
* (done) --------------- Get all forms working properly
* (done) --------------- Fix up Topic data structure
* (done) --------------- Add working user register/login system
* (done) --------------- Implement Categories (do this ASAP before things get too complicated)
* (done) --------------- Show topic/post statistics (use @Transient entity bean annotation)

* (in progress) ------- Add category-specific custom data post options
* (in progress) ------- Admin functionality (removal of posts, editing, etc)
* (in progress) ------- Add rating system per post (db system required to track who voted for what)
* (in progress) ------- Documentation for file layout/structure and overall goals

* ------------------------- Improve user login/registration security (sending passwords over http, etc)
* ------------------------- Add pagination for when the number of topics/posts get too large
* ------------------------- Add rating system per post, store in db
* ------------------------- Sort posts chronologically, add option for sorting by rating
* (delay) --------------- Use ajax to load tables instead of refreshing whole page

Progress screenshots:

![Alt text](/src/img/July 6.png?raw=true "July 6")
![Alt text](/src/img/July 12.png?raw=true "July 12")
![Alt text](/src/img/July 13.PNG?raw=true "July 13")
![Alt text](/src/img/July 22.PNG?raw=true "July 22")
