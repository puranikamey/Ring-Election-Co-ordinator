Skip to content
 
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 @puranikamey Sign out
0
0 0 puranikamey/RING-ELECTION-CO-ORDINATOR-
 Code  Issues 0  Pull requests 0  Projects 0  Wiki  Insights  Settings
RING-ELECTION-CO-ORDINATOR-/READ ME TEXT DOC (ring election cordinator).txt
704ba41  on Jun 27, 2017
@puranikamey puranikamey Add files via upload
    
84 lines (34 sloc)  3.12 KB


RING ELECTION CO-ORDINATOR  
 
This is an ring election coordinator  application developed in java/ j-frames. The main terminology if the project is based on Socket programming.  
  
System Information and pre-requisites. 
•    IDE : The code is developed in NetBeans IDE 8.2 (Build 201609300101)   
•    Java: 1.8.0_111; Java HotSpot(TM) 64-Bit Server VM 25.111-b14  
•    Runtime: Java(TM) SE Runtime Environment 1.8.0_111-b14  
•    System: Windows 10 version 10.0 running on amd64; Cp1252; en_US (nb)  
•    User directory: C:\Users\WIN 10\AppData\Roaming\NetBeans\8.2  
•    Cache directory: C:\Users\WIN 10\AppData\Local\NetBeans\Cache\8.2  
  
  
To create the entire environment in the lab we need to install and open the Netbeans IDE. The main pre-requisite for the project is to have jdk 1.8 installed in the system. Save  The zip file in the package ring electioncordinator. 
  
Instructions:-  (Netbeans) 
  
•    Click on Files on the top left corner of the screen. 
•    Click on Import project or click on Open project. 
•    Select the project mentioned in the package. 
•    Open the project. 
•    Expand the source package tab. 
•    Expand the ringelectioncordinator tab. 
 
 
 
 
 
 
•    Right click on the rinelectionserver and run the file. (Note:Run the server file first.) Following screen will be displayed. 
 
 
 
  
                                     
Click on the INITIATE to start the sever.                         
                                           
  
 
 
 
 
 
 
 
 
 
•    Then again right click on ring electioncoordinatorprocrss  and run the file. Following screen  will appear. 
 
 Note:- we need to manually give the process No and process in the character format.Example if the we are executing the ringelectionco-orrdinatorprocess java file for the first time the the process No will be "one" and the process will be "one "  
 Then ,click on the connect button. 
We need to run the ringelectionco-orrdinatorprocess file four time and follow the procedue given the above note. 
The send button is used for sending message. Logout button is used for Looging out and closing the socket. 
                                               
  
 
  
  
 
 
Note: The IP Address and the Port number users in this Project are Local to my computer hence they will definitely differ.(Without changing the IP address and the Port number  this project will  project will  not run on different environment. 
  
To Find the IP address and the port of the system open the command prompt.  
  
Type:  netstat  -aon  
Limitation:- This project is limits its useability to four process connected in the ring topology. 
  
REFERANCES: 
  
The entire code is self- developed however, I have taken some reference form the youtube link mentioned below. 
  
Link:- https://www.youtube.com/watch?v=hZgntu7889Q&t=62s  
  
Moreover, to understand the logic and nature of the terminology of the string and socket programing I have taken reference form the following links. 
Links:- https://www.javatpoint.com/java-string  
  
Links:- http://www.javatpoint.com/java-string-intern   




© 2018 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
API
Training
Shop
Blog
About
Press h to open a hovercard with more details.
