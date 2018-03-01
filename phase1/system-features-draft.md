We can all enter our interpretations of the features here and then synthesize them for the final document. 

Chelsea & Thoa
## Sign up
### Description and Priority
The user will create an account with a valid stjohns.edu email. This is required to begin using FEASTA. They will receive a confirmation email when signed up successfully. Otherwise, if address is not valid, they will see an error message denying app access "You are not eligible to use this app. Must be a St. John's University student and must use a valid school address."

### Stimulus/Response Sequences
  #### Basic Data Flow
  * User opens the app. The landing page has two tabs: Log In and Sign Up.
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
> * REQ-1: There will be two tabs - Log In and Sign Up - when a user opens the newly-installded FEASTA app.
> * REQ-2: The email address entered by the user will be verified to make sure it is an (1) existing and (2) stjohns.edu address.
> * REQ-3: When the email address is valid, and is not associated with an existing FEASTA account, a new account in the system will be created for this user. A confirmation email is sent to user's inbox. The confirmation screen in the app will display the message "A confirmation email has been sent to you!" and a button "Find me free food" that will take user to the app's Home page.
> * REQ-4: When the email address entered is not valid, the app will display an error message "You are not eligible to use this app. Must be a St. John's University student and must use a valid school address". The message will disappear when the user taps outside of it.
> * REQ-5: When the account already exists, the app will display "This account already exists. Please sign in instead." The message will disappear when the user taps outside of it.
  
 ## Log in
### Description and Priority
  The user will log in with their verified email

### Stimulus/Response Sequences
 * User opens app,
 * User enters verified email,
 * App opens to homepage with locations
  
 #### OR
  
 * User opens app,
 * Home page loads since user is already logged in from previous use
  
### Functional Requirements
  FEASTA must be downloaded and installed 
  User must enter .edu email  
    
 ## Browse by location
### Description and Priority
  The user will select a building on campus to see events taking place there
  
### Stimulus/Response Sequences
 * User opens app,
 * App opens to homepage with locations
 * User taps on the location they want
 * Feed of events appear for that location (only events taking place in that building)
  
### Functional Requirements
    FEASTA must be downloaded and installed  

##  Search by keyword
#### Description and Priority
  The user enters a food related word and results containing that word are returned
  
#### Stimulus/Response Sequences
 * User opens app,
 * User taps search icon on the top
 * User enters word into search box, clicks enter
 * All events mentioning that word appear, if none exist, user will see "No results match your search"
  
#### Functional Requirements
  *  FEASTA must be downloaded and installed 
    
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
