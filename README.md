<h1 align = "center">
CS495 Capstone Project: OpenBCI Android Extension App
</h1>

## Goals
Our team will be building an android app that gets EEG/EMG data from the Ganglion Board and provides processed data to users.

## Approach
   Tools <br>
      - Android Studio <br>
      - OpenBCI GUI <br>
      - Visual Studio Code <br>
	
   APIs <br>
      -OSC (Open Sound Control) <br>

   Frameworks <br>
      -Java <br>
      -React <br>

## Experience Description
(step-by-step explanation of a user’s experience, example scenario). Full explanation pending upon project completion.

## Unit Tests, Sprint 2
For Sprint 2, five unit tests were devised:

   Sending/Receiving Data Over OSC <br>
   -This refers to the sending of data from the OpenBCI GUI to a separate source, the first step of sending it to Android. This is implemented by oscp5Client.pde. <br>
    
   Streaming Data Over OSC <br>
   -This refers to the next step of sending data. Rather than sending one piece of data, the data is now to be continuously streamed over a time period. This is also implemented by oscp5Client.pde.
   
   Testing to Ensure Connection is Successful <br>
   -This would involve adding a check to ensure the connection does not fail mid-data transfer, and including a means of alerting the user to this occurring.
   
   Testing Null Input <br>
   -This would be testing to see the result of no input, intending to generate a different response than no connection.
   
   Testing Invalid Input <br>
   -This would be testing to see the result of an incorrectly entered or invalid input, again generating a different error result.

## Team Members
[Pavan Kurkal](mailto:pkurkal@crimson.ua.edu), [Eian Landis](mailto:ellandis@crimson.ua.edu), [Blayde Dill](mailto:badill@crimson.ua.edu), and [Alex Copley](mailto:gacopley@crimson.ua.edu)
