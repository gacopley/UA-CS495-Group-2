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
For Sprint 2, five unit tests were devised. They were executed by Blayde Dill successfully in Apache Netbeans, though any compiler for Java theoretically would work. All that is required in set-up is to ensure that the OpenBCI GUI is running and is streaming data via UDP utilizing localhost. The following are descriptions of the five tests, found in Java/osc/src/test/java.
   
   Connection Established <br>
   -This unit test checks to see if the UDP connection between the GUI and the Java program was successful. <br>

   Disconnect <br>
   -This unit test checks to see if it is possible to disconnect from the data stream at will. <br>
    
   IP <br>
   -This unit test checks to see if the connection is utilizing the system's localhost. <br>
   
   Port <br>
   -This unit test checks to see if the connection is utilizing the correct local port. <br>
   
   Receive <br>
   -This unit test, requiring that data is being streamed from OpenBCI's GUI, checks whether or not data is being sent from the GUI and received by the program.
   
## Team Members
[Pavan Kurkal](mailto:pkurkal@crimson.ua.edu), [Eian Landis](mailto:ellandis@crimson.ua.edu), [Blayde Dill](mailto:badill@crimson.ua.edu), and [Alex Copley](mailto:gacopley@crimson.ua.edu)
