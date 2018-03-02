We can all enter our interpretations of the features here and then synthesize them for the final document. 

Chelsea & Thoa
## Diner's sign up 
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
  
## Log in
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
 
## Log out
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
> * REQ-8: The Navigation Menu has the "Log Out" option.
> * REQ-9: Before the user logs out, a message pop-up will ask the user to confirm their action "Are you sure you want to log out?" This pop-up has two clickable buttons "Yes" and "No"
> * REQ-10: When user confirms their log out action, they are taken to the Sign Up/Log In screen.

## Browse events by location
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
> * REQ-13: The event list always displays events up to 11:59pm that day, sorted by time (most imminent first).

## Search for events by food-related keyword
### Description and Priority
From either the Home page or the Per-Location Event Feed, the user can tap the Search Icon, type in a food-related keyword, and results containing that word are returned.
  
### Stimulus/Response Sequences
  #### Basic Data Flow
 * From either the Home page or the Per-Location Event Feed, the user taps the Search Icon and types in a food-related keyword and hits Enter.
 * User will see a list of search results up to 11:59pm that day, ordered by time (most immiment first), as well as the number of results returned (e.g. "3 events found" or "0 event found").
 * Scope-based search results are returned. That means, if the user is searching from Home page, all locations are searched. Otherwise, search is limited to the Location the user is currently at.
  
### Functional Requirements
> * REQ-13: The event list always displays events up to 11:59pm that day, sorted by time (most imminent first).
> * REQ-14: The Search Icon is visible from anywhere in the app: whether the user is on the Home page or inside the Per-Location Event Feed.
> * REQ-15: Search results are conducted based on scope. That means, if the user is searching from Home page, all locations are searched. Otherwise, search is limited to the Location the user is currently at.
> * REQ-16: Search will always inform user of the number of results returned (e.g. "3 events found" or "0 event found").
    
 ## Select event
#### Description and Priority
  The user selects an event to view from the search results or location listings
  
#### Stimulus/Response Sequences
 * After searching or selecting location, user views a list of events
 * User selects one
 * New screen opens with all details of the event, additional photos (?) and comments
  
#### Functional Requirements
 * FEASTA must be downloaded and installed 
 * There should be a back button to return to previous page.
    
 ## Edit event
#### Description and Priority
  The user can edit an event that they posted
  
#### Stimulus/Response Sequences
 * After selecting an event, screen with event details shows up 
 * Click on pencil icon on the left
 * Modify post
  
#### Functional Requirements
  *  FEASTA must be downloaded and installed 
  *  User must be the one who posted the event
    
 ## Comment
#### Description and Priority
  The user can give opinions or ask questions about an event
  
#### Stimulus/Response Sequences
 * After selecting an event, screen with event details shows up 
 * Scroll down to see comments
 * Click "Start typing" below
 * Type comment
 * Click "post"
 * Comment immediately shows up under event
  
#### Functional Requirements
   * FEASTA must be downloaded and installed 

  ## Delete/Edit Comment
#### Description and Priority
  The user can delete a comment that they posted
  
#### Stimulus/Response Sequences
 * After selecting an event, screen with event details shows up 
 * Scroll down to see comments
 * (NOT SURE HOW OUR UI WILL HANDLE THIS) Slide left to view delete and edit options
 * Tap either delete which will remove the comment completely 
 * OR tap edit which allows you to modify your text. 
  
#### Functional Requirements
  * FEASTA must be downloaded and installed 
 
  ## Delete/Edit Comment
#### Description and Priority
  The user can delete a comment that they posted
  
#### Stimulus/Response Sequences
 * After selecting an event, screen with event details shows up 
 * Scroll down to see comments
 * (NOT SURE HOW OUR UI WILL HANDLE THIS) Slide left to view delete and edit options
 * Tap either delete which will remove the comment completely 
 * OR tap edit which allows you to modify your text. 
  
#### Functional Requirements
  * FEASTA must be downloaded and installed 
