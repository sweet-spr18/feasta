## Phase I - Requirement Analysis

### C-Requirements:
* open the app:
  * **speedy launch (how fast?)**
  * get taken to the Home page since your log-in is remembered
  * select Sign Up
  * select Log In
* sign up with a valid stjohns.edu email address
  * receive a confirmation email when signed up successfully
  * see an error message denying app access when email address is not valid: "You are not eligible to use this app. Must be a St. John's University student and must use a valid school address"
* log in using email address and password
  * log in successfully and get taken to the Home page
  * see an error message when email address or password is wrong or non-existent
  * request a password change by clicking on "Forgot your password?" **- new function: password change (how do we want this function?
  One possible sequence:
    (1) a new screen in the app opens, asking the user to type in their email address, then click Next (background verification to ensure this address has been registered in our app database already), 
    (2) the next screen asks the user to type & re-type the new password, then click Submit, 
    (3) the next screen is a Confirmation screen and the user can click OK to go back to the log-in screen, an email is also sent to confirm this action)**
* browse Locations on the Home page
* on Home page, click on one Location and get taken to a list of event entries + a search box on top
  * **this Per-Location list lists events for: WHICH ONE SHOULD WE CHOOSE
    * either: today, tomorrow, (and 3 days from now?)
    * or: within 24 hours from now**
  * click Back to go back to Home page
* enter a food keyword into the search box and click Enter:
  * search results are displayed as in a list, with the number of results returned (e.g. "3 events found")
  * (advanced. want it or not?) search term suggestions appear live as you are typing
  * click Back to view all events at this location
* view a list of search results:
  * **the list is ordered by time (most recent first) rather than randomly**
  * see a thumbnail of the food image
  * see the Event Name (most prominent info)
  * see other details: org name, time (start & end), room number, food type(s), diners' ratings (5 star scale), number of comments
* click on an event entry and get taken to a new screen (or do we want a pop-up window?) displaying everything about that event: - **non-functional requirement: display info such that users don’t have to scroll / click “Read more” (want this or not?)**
  * see Event Name (most prominent info)
  * (if you are the host) see a Pencil symbol that you can click on to get to the event Editable form 
  * (want it or not? If we do allow sharing about a particular event, what will we be sharing: a URL? A summary of Event Name-Place-Time-Food?) see a Share button (i.e. an arrow symbol) **– new function: the Share button will hook up with other communication apps existing on the user’s device (e.g. Texting, Messenger, Slack, Gmail, Facebook, Copy to clipboard, etc.)**
  * see other details: 
    * org name, 
    * time (start & end), **- - maybe the time stamp will hook up with the Calendar app on the user’s device and display how this event will fit into their schedule – similar to Gmail or Doodle**
    * room number, 
    * food type(s) and food images,
    * diners' ratings (5 star scale), 
    * all comments
  * leave either a comment or a rating or both **- more advanced: can the user delete a comment?**
  * bookmark as Favorite to receive a noti later (e.g. when you are browsing at noon and want to plan for dinner) **- new function: send a reminder notification 30 mins before the event's start time**
  * click Back to go back to the previous screen
* on Home page, click on the Hamburger button to open the Side Menu
* in the Side Menu, click on "Post an Event": **- advanced functions (don't know where to put it yet) create duplicate events, create repeating events, delete an event (do we allow these?)**
  * a new screen opens, asking you to select a Location
  * a new screen opens with the Editable form where you:
    * type in event details: name, datetime (start & end), event description
    * check boxes (or radio buttons?) for food type: Pizza, Italian, Mexican, Asian, American, Donuts/Cookies/Bagels/Hot Chocolate
    * turn on/off the Vegetarian toggle
    * post or select 1 food photo, including a 1-3 word description; **photo can be taken on the spot, or chosen the Gallery's app on user's device, or chosen from our app's built-in gallery**
    * click Publish and get taken to the event entry page
  * click Back to get back to Home page
* in the Side Menu, click on "Analytics" and get taken to a screen:
  * see the graphs and charts of your past events:
    * aggregate event ratings by location
    * aggregate event ratings by time
    * aggregate event ratings by food type
  * otherwise, see the message "Analytics is only available if you have hosted more than 5 events"
  * click Back to get back to Home page
* in the Side Menu, click on "Change my Preferences" and get taken to a screen:
  * check boxes: Vegetarian, Pizza, Italian, Mexican, Asian, American, Donuts/Cookies/Bagels/Hot Chocolate
  * click Save or Cancel to get back to Side Menu
* in the Side Menu, click on "Log out" and a message pops up asking "Are you sure you want to log out?"
  * click "Yes" and get taken to the Sign Up/Log In screen
  * click "No" and the message pop-up disappears
* in the Side Menu, click on "About" and get taken to a new screen. This screen displays the following items:
  * Rate Us - clicking on this brings up the app page on Apple App Store or Google Play Store
  * Legal - clicking on this brings a new screen with the following items:
    * Privacy
    * Terms of Service
    * Cookie Policy
  * Help - clicking on this brings up a web-hosted documentation or FAQs, or brings up the default email app with our email address and email subject prefilled
  * Acknowledgements - clicking on this displays brings up a screen with all the open source licenses (if we use any)
  
### D-Requirements:
