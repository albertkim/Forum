Forum
=====

Forum made with Java EE. Goal is to make a forum with modular, customized views for each category to suit different categories and communities.

If you want to see the deployed application and experience it in it's non-complete, buggy state, check it out here
http://ec2-54-191-101-201.us-west-2.compute.amazonaws.com:8080/Debate_Platform/

To Do:

* (done) --------------- Get basic forum structure up
* (done) --------------- Get all forms working properly
* (done) --------------- Fix up Topic data structure
* (done) --------------- Add working user register/login system
* (done) --------------- Implement Categories (do this ASAP before things get too complicated)
* (done) --------------- Show topic/post statistics (use Transient entity bean annotation)
* (done) --------------- Add rating system per post (db system required to track who voted for what)
* (done) --------------- Deploy on EC2
* (done) --------------- Server-side handling of new-line characters
* (done) --------------- Added display for top threads, added email field for registration, css changes
* (done) --------------- Properly organize javascript model instantiations (right now it's a mess)
* (done) --------------- Add 'About Me' page
* (done) --------------- Add/display URL fields for topics when users post links
* (done) --------------- Removed javascript onclick links to a href

* (in progress) ------- Add category-specific custom data post options
* (in progress) ------- Admin functionality (removal of posts, editing, etc)
* (in progress) ------- Documentation for file layout/structure and overall goals

* ------------------------- Capture click/view statistics per page, store and display in an intuitive report
* ------------------------- Improve user login/registration security
* ------------------------- Add pagination for when the number of topics/posts get too large
* ------------------------- Add option for sorting by rating
* (delay) --------------- Use ajax to load tables instead of refreshing whole page

Progress screenshots:

![Alt text](/src/img/July 6.png?raw=true "July 6")
![Alt text](/src/img/July 12.png?raw=true "July 12")
![Alt text](/src/img/July 13.PNG?raw=true "July 13")
![Alt text](/src/img/July 22.PNG?raw=true "July 22")
![Alt text](/src/img/August 2-1.PNG?raw=true "August 2")
![Alt text](/src/img/August 2-2.PNG?raw=true "August 2")
![Alt text](/src/img/August 4-1.PNG?raw=true "August 4")
![Alt text](/src/img/August 4-2.PNG?raw=true "August 4")