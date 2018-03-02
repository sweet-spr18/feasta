We can all enter our interpretations of the features here and then synthesize them for the final document. 

Chelsea & Thoa
## 1. Sign up (Diners only)
### Description and Priority
The diner-user will create an account with a valid stjohns.edu email. This is required to begin using FEASTA. They will receive a confirmation email when signed up successfully. Otherwise, if address is not valid, they will see an error message denying app access "You are not eligible to use this app. Must be a St. John's University student and must use a valid school address."

### Stimulus/Response Sequences
  #### Basic Data Flow
  * User opens the app. The landing page has two tabs: Log In (default tab) and Sign Up.
  * User selects the Sign Up tab.
  * User enters their SJU email and creates a password, then clicks "Sign Up". 
  * User sees a confirmation screen saying "A confirmation email has been sent to you!" and receives a confirmation email.
  * User clicks the "Find me free food" button on the confirmation screen and is taken to the app's Home page.
  #### Alternative Data Flow 1
  * User enters a non-valid email address. Only existing stjohns.edu email addresses are accepted to use FEASTA.
  * User sees an error message saying "You are not eligible to use this app. Must be a St. John's University student and must use a valid school address"
  * User can tap outside this message and re-attempt a different email address.
  #### Alternative Data Flow 2
  * User enters an address associated with an existing FEASTA account.
  * User sees an error message saying "This account already exists. Please sign in instead."
  * User can tap outside this message and switch to the Log In tab.
  
### Functional Requirements
> * REQ-1: There will be two tabs - Log In (default tab) and Sign Up - when a user opens the newly-installded FEASTA app.
> * REQ-2: The email address entered by the user will be verified to make sure it is an (1) existing and (2) stjohns.edu address.
> * REQ-3: When the email address is valid, and is not associated with an existing FEASTA account, a new account in the system will be created for this user. A confirmation email is sent to user's inbox. The confirmation screen in the app will display the message "A confirmation email has been sent to you!" and a button "Find me free food" that will take user to the app's Home page.
> * REQ-4: When the email address entered is not valid, the app will display an error message "You are not eligible to use this app. Must be a St. John's University student and must use a valid school address". The message will disappear when the user taps outside of it.
> * REQ-5: When the account already exists, the app will display "This account already exists. Please sign in instead." The message will disappear when the user taps outside of it.
  
## 2. Log in
### Description and Priority
The user will log in with their registered email address and correct password. Log-in will be remembered for the next app launches.

### Stimulus/Response Sequences
  #### Basic Data Flow
 * User opens the app. The landing page has two tabs: Log In (default tab) and Sign Up.
 * User enters their registered email address and password, then clicks "Log In". 
 * App opens to Home page with locations
 #### Alternative Data Flow
 * User enters incorrect log-in credentials. User will see a message "Incorrect email or password."
 * User can attempt as many times as they want.
  
### Functional Requirements
> * REQ-1: There will be two tabs - Log In (default tab) and Sign Up - when a user opens the newly-installded FEASTA app.
> * REQ-6: On the Log In tab, when the correct credentials are entered, the app will take the user to the Home page.
> * REQ-7: On the Log In tab, when the incorrect credentials are entered, the app will display the message "Incorrect email or password.", erase both email and password fields and let the user re-attempt as many times as they want.
 
## 3. Log out
### Description and Priority
While logged in, the user can log out of the app anytime by opening the Navigation Menu and selecting the "Log Out" option. A message pop-up will ask user to confirm their action before actually logging them out.

### Stimulus/Response Sequences
  #### Basic Data Flow
  * User opens the Navigation Menu and selects the "Log Out" option.
  * A message pops up, asking "Are you sure you want to log out?"
  * User clicks "Yes" and gets taken to the Sign Up/Log In screen
  #### Alternative Data Flow
  * User clicks "No" and the message pop-up disappears. User lands back at the Navigation Menu.

### Functional Requirements
> * REQ-8: The Navigation Menu has the following options: "Set My Preferences", "Log Out", "About", "Post an Event", "View Analytics" (the last two options are only visible to promoter's accounts).
> * REQ-9: Before the user logs out, a message pop-up will ask the user to confirm their action "Are you sure you want to log out?" This pop-up has two clickable buttons "Yes" and "No"
> * REQ-10: When user confirms their log out action, they are taken to the Sign Up/Log In screen.

## 4. Browse events by location
### Description and Priority
From the Home page, the user selects a building on campus to see events taking place there.
  
### Stimulus/Response Sequences
  #### Basic Data Flow
 * Already logged-in user opens the app and lands at the Home page that displays many names of buildings on campus.
 * User taps on one of the locations and gets taken to the event feed: a list of event entries.
 * The feed displays events up to 11:59pm that day, sorted by time (most imminent first). 
 * User can click Back to go back to the Home page.
  
### Functional Requirements
> * REQ-11: The Home page displays names of buildings on campus. These names are tappable.  
> * REQ-12: Tapping on one of the locations takes the user to the event feed. User can click Back to go back to the Home page.
> * REQ-13: The event list always displays events up to 11:59pm that day, sorted by time (most imminent first). Each entry in the list includes a thumbnail of the food image, the Event Name (most prominent info), time (start and end), room number, and diners' ratings (5 star scale). 

## 5. Search for events by food-related keyword
### Description and Priority
From either the Home page or the Per-Location Event Feed, the user can tap the Search Icon, type in a food-related keyword, and results containing that word are returned.
  
### Stimulus/Response Sequences
  #### Basic Data Flow
 * From either the Home page or the Per-Location Event Feed, the user taps the Search Icon and types in a food-related keyword and hits Enter.
 * User will see a list of search results up to 11:59pm that day, ordered by time (most immiment first), as well as the number of results returned (e.g. "3 events found" or "0 event found").
 * Scope-based search results are returned. That means, if the user is searching from Home page, all locations are searched. Otherwise, search is limited to the Location the user is currently at.
  
### Functional Requirements
> * REQ-13: The event list always displays events up to 11:59pm that day, sorted by time (most imminent first). Each entry in the list includes a thumbnail of the food image, the Event Name (most prominent info), time (start and end), room number, and diners' ratings (5 star scale). 
> * REQ-14: The Search Icon is visible from anywhere in the app: whether the user is on the Home page or inside the Per-Location Event Feed.
> * REQ-15: Search results are conducted based on scope. That means, if the user is searching from Home page, all locations are searched. Otherwise, search is limited to the Location the user is currently at.
> * REQ-16: Search will always inform user of the number of results returned (e.g. "3 events found" or "0 event found").

## 6. Select an event to view details
### Description and Priority
The user taps an event from either the per-location feed or search results to view. The user can always click Back to go back to the list.
  
### Stimulus/Response Sequences
  #### Basic Data Flow
 * From either the per-location feed or search results, user taps an event to view.
 * A new screen opens with all details of the event: Event Name (most prominent), organization name, time (start and end), room number, food type(s) and food image(s), diners' ratings (5 star scale) and comments.
 * If the user is the promoter of that event, they will see a Pencil symbol that they can click to get to the Event Editable form.
 * User can leave a comment, a rating, or both. User can delete their comment(s).
 * User can bookmark the event as Favorite to review a notification later. 
 * User clicks Back to go back to the previous screen.
  
### Functional Requirements
> * REQ-17: An Event Detail screen will display the Event Name (most prominent), organization name, time (start and end), room number, food type(s) and food image(s), diners' ratings (5 star scale) and comments. If the user is the promoter of that event, the Pencil symbol is visible. The Bookmark symbol is always visible, and displayed as bookmarked or not bookmarked. 

## 7. Leave a comment
### Description and Priority
From the Event Detail screen, the user can give opinions or ask questions about an event.
  
### Stimulus/Response Sequences
  #### Basic Data Flow
 * After user selects an event, the screen with event details shows up. 
 * User scroll downs to see all comments, if any.
 * User clicks "Start typing" below.
 * User types comment and clicks "Post" after done.
 * Comment immediately shows up under event.
  
### Functional Requirements
> * REQ-18: The clickable "Start typing" box is located below all comments (if any). When user clicks on it, they can start typing and clicks "Post" after done.

## 8. Delete/Edit a comment
### Description and Priority
The user can delete or edit a comment that they posted.
  
### Stimulus/Response Sequences
  #### Basic Data Flow
 * After user selects an event, the screen with event details shows up. 
 * User scroll downs to see all comments.
 * At their comment, user slides left to view the Delete and Edit options.
 * Taping Delete will remove the comment immediately. 
 * Tapping Edit will allows user to type. User clicks "Post" after done typing to update the comment. Comment's timestamp is kept as orginal. 
  
### Functional Requirements
> * REQ-19: At their comment, user can slide left to view Delete and Edit options. Taping Delete will remove the comment immediately. Tapping Edit will allows user to type. User clicks "Post" after done typing to update the comment. Comment's timestamp is kept as orginal. 
  
## Post/Edit an event (Promoters only)
### Description and Priority
The promoter-user can post and edit an event that they posted. 
  
### Stimulus/Response Sequences
  #### Basic Data Flow
 * User opens the Navigation Menu and selects "Post an Event"
 * A new screen opens, asking user to select a Location
 * After user chooses a location, a new screen opens with the Editable form where user will:
    * type in event details: event name, datetime (start and end), event discription
    * check boxes for food type(s): Pizza, Italian, Mexican, Asian, American, Donuts/Cookies/Bagels/Hot Chocolate
    * turn on/off the Vegetarian toggle
    * post or select 1 food photo, including a 1-3 word description. Photo can be taken on the spot, or chosen the Gallery's app on user's device, or chosen from our app's built-in gallery.
    * click "Publish" and get taken to the Event Detail screen, or click "Cancel" to dismiss their action.
  #### Alternative Data Flow
 * Inside an Event Detail screen of an event they created, user clicks on the Pencil symbol.
 * The Editable form opens, allowing user to modify their post.
 * User clicks "Publish" to save the changes, or click "Cancel" to dimiss their action.
  
### Functional Requirements
> * REQ-8: The Navigation Menu has the following options: "Set My Preferences", "Log Out", "About", "Post an Event", "View Analytics" (the last two options are only visible to promoter's accounts).
> * REQ-20: When the user wants to post an event, the first screen will ask for the location. The next screen is an Editable form where user can type in event details (event name, start and end datetime, event discription), check boxes for food type(s) (Pizza, Italian, Mexican, Asian, American, Donuts/Cookies/Bagels/Hot Chocolate), turn on/off the Vegetarian toggle, post or select 1 food photo, including a 1-3 word description. Photo can be taken on the spot, or chosen the Gallery's app on user's device, or chosen from our app's built-in gallery. After done, user can click "Publish" and get taken to the Event Detail screen, or click "Cancel" to dismiss their action.
> * REQ-21: Clicking on the Pencil symbol will open the Event Editable form.
    
## View event analytics
### Description and Policy
Promoter-users can have posted more than 5 events can view analytics.

### Stimulus/Response Sequences
  #### Basic Data Flow
  * User opens to Navigation Menu and selects "View Analytics"
  * A new screen opens showing the charts of past events:
    * aggregate event ratings by location
    * aggregate event ratings by time
    * aggregate event ratings by food type
   * User clicks Back to go back to the previous screen
  #### Alternative Data Flow
  * User opens to Navigation Menu and selects "View Analytics". 
  * Since this user has posted only 5 events or fewer, they will see the message pop-up "Analytics is only available if you have hosted more than 5 events"
  * The user clicks Back or taps outside the message to dismiss it.

### Functional Requirements
> * REQ-8: The Navigation Menu has the following options: "Set My Preferences", "Log Out", "About", "Post an Event", "View Analytics" (the last two options are only visible to promoter's accounts).
> * REQ-22: If the user has posted more than 5 events, they will be able to see the charts of past events, showing aggregate event ratings by location, time, and food type. Otherwise, they will see the message pop-up "Analytics is only available if you have hosted more than 5 events." They can click Back or tap outside the message to dismiss it.

## Be notified of bookmark events
### Description and Policy
If the user has bookmarked an event before, the app will notified them 30 minutes before the event's start time.

### Stimulus/Response Sequences
  #### Basic Data Flow
  * 30 minutes before the event's start time, the app sends a notification to the user's phone system.
  * Depending on the device, user swipes up or down to view the notification. When they tap it, the app will bring up the Event Detail page. 
  
### Functional Requirements
> * REQ-23: The app keeps track of user's bookmarks and sends a notificatoin to the user's phone system 30 minutes before the event's start time. When the user taps on the notification, the app will bring up the Event Detail page.

## Set dining preferences
### Description and Policy
The user can set their dining preferences, which will dictate the future feeds that display to them.

### Stimulus/Response Sequences
  #### Basic Data Flow
  * User opens the Navigation Menu and selects "Set My Preferences".
  * A new screen opens, where user can check boxes: Vegetarian, Pizza, Italian, Mexican, Asian, American, Donuts/Cookies/Bagels/Hot Chocolate.
  * User clicks "Save" to save or "Cancel" dismiss their action. Either way, they will be brought back to the Navigation Menu.

### Functional Requirements
> * REQ-8: The Navigation Menu has the following options: "Set My Preferences", "Log Out", "About", "Post an Event", "View Analytics" (the last two options are only visible to promoter's accounts).
> * REQ-24: The preference setting screen has check boxes for user to opt in/out: Vegetarian, Pizza, Italian, Mexican, Asian, American, Donuts/Cookies/Bagels/Hot Chocolate. User can click "Save" to save or "Cancel" dismiss their action. Either way, they will be brought back to the Navigation Menu.

## Access help
### Description and Policy
The user can rate the app, learn more about the app, or get help via an FAQs or direct email to the SWEET team.

### Stimulus/Response Sequences
  #### Basic Data Flow
  * User opens the Navigation Menu and selects "About".
  * The new screen has the following items:
    * Rate Us - clicking on this brings up the app page on Apple App Store or Google Play Store
    * Legal - clicking on this brings a new screen with the following items:
      * Privacy
      * Terms of Service
      * Cookie Policy
    * Help - clicking on this brings up a web-hosted documentation or FAQs, or brings up the default email app with SWEET's email address and email subject prefilled
    * Acknowledgements - clicking on this displays brings up a screen with all the open source licenses (if the SWEET team use any)
    
### Functional Requirements
> * REQ-8: The Navigation Menu has the following options: "Set My Preferences", "Log Out", "About", "Post an Event", "View Analytics" (the last two options are only visible to promoter's accounts).
> * REQ-25: Nested under "About" are Rate Us, Legal, Help, and Acknowledgements. Clicking on Rate Us will bring up the app page on Apple App Store or Google Play Store. Clicking on Legal will display Privacy, Terms of Service, and Cookie Policy documents. Clicking on Help will bring up a web-hosted FAQs, or bring up the default email app with SWEET's email address and email subject prefilled. Clicking on Acknowledgements will bring up a screen with all the open source licenses (if the SWEET team use any).
