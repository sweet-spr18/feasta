# feasta
Free-Food-Event Finder - Project for Software Engineering course Spring 2018

## Phase I - Requirement Analysis

### C-Requirements:
* open the app:
  * get taken to the Home page since your log-in is remembered
  * select Sign Up
  * select Log In
* sign up with a valid stjohns.edu email address
  * receive a confirmation email when signed up successfully
  * see an error message denying app access when email address is not valid: "You are not eligible to use this app. Must be a St. John's University student and must use a valid school address"
* log in using email address and password
  * log in successfully and get taken to the Home page
  * see an error message when email address or password is wrong or non-existent
  * request a password change by clicking on "Forgot your password?"
* browse Locations on the Home page
* on Home page, click on one Location and get taken to a list of event entries + a search box on top
  * click Back to go back to Home page
* enter a food keyword into the search box and click Enter:
  * search results are displayed as in a list, with the number of results returned (e.g. "3 events found")
  * (advanced. want it or not?) search term suggestions appear live as you are typing
  * click Back to view all events at this location
* view a list of search results:
  * see a thumbnail of the food image
  * see the Event Name (most prominent info)
  * see other details: org name, time (start & end), room number, food type(s), diners' ratings (5 star scale), number of comments
* click on an event entry and get taken to a new screen (or do we want a pop-up window?) displaying everything about that event:
  * see Event Name (most prominent info)
  * (if you are the host) see a Pencil symbol that you can click on to get to the event Editable form 
  * see other details: 
    * org name, 
    * time (start & end), room number, 
    * food type(s) and food images,
    * diners' ratings (5 star scale), 
    * all comments
  * leave either a comment or a rating or both
  * bookmark as Favorite to receive a noti later (e.g. when you are browsing at noon and want to plan for dinner)
  * (want it or not?) contact the org
  * click Back to go back to the previous screen
* on Home page, click on the Hamburger button to open the Side Menu
* in the Side Menu, click on "Post an Event":
  * a new screen opens, asking you to select a Location
  * a new screen opens with the Editable form where you:
    * type in event details: name, datetime (start & end), event description
    * check boxes (or radio buttons?) for food type: Pizza, Italian, Mexican, Asian, American, Donuts/Cookies/Bagels/Hot Chocolate
    * turn on/off the Vegetarian toggle
    * post or select 1 food photo, including a 1-3 word description
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

**BELOW ARE OLD STUFF**

#### Homepage / Browsing / Searching for food:
* home page: groupings by location --> can select a location to browse
* browse the feeds: 
  * feeds are curated to saved preferences
  * feeds are "fresh": only display on-going and upcoming events upto 11:59pm today
* leave ratings

#### Food/Event database updates:
* hide past events
* hide events that have run out of food
* inventory events at midnight

#### Profile creation and setting:
* create a new account with an email address:
  * .edu verification
* register to be a promoter
  * specify your role in the event
  * specify your organization
* save your preferences (favorite foods or dietary restrictions)
* opt in for daily push notifications:
  * select a time to receive noti

#### Event management: 
(this button only become available to a user one s/he registers to be a promoter)
* create a new entry:
  * fill in the name, description, time, location
  * upload food pictures or select from prebuilt gallery
  * smart-tag food categorities
  * save as draft or publish
* edit an entry
* delete an entry
* see analytics of an entry:
  * select attributes to view

#### Event analytics (internal working):
* attributes:
  * calculate...
  * track ...
  * 

