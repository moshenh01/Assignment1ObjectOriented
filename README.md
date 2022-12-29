# Assignment1ObjectOriented
<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="Assignment1ObjectOriented"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/moshenh01/Assignment1ObjectOriented">
    <img src="disgn.jpg" alt="Logo" width="400" height="400">
  </a>

<h3 align="center">Observer and Observables</h3>

  <p align="center">
    
    we build a design pattern code of Observer and Observables.
    
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
   
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
we build a design pattern code that contains a sender and members interface in which we 
implement the sender in groopAdmin class,
and the member in concrete member class.
the groopAdmin goal is to make a messege and update the members of that msg.  





<!-- GETTING STARTED -->
## Getting Started

First we need to build a groop admin and concrete members so we can registar members to his list of subscribers.
After that we will have an option to make strings with undoStringBuilder and update oure members.
all the optinals changes we can do on the string builder is alredy expained in oure code.

<!-- USAGE EXAMPLES -->
## Usage
we use maven to track the memory system footprint(mamory changes behind the sence)
      
     1. in the first pic we can see the test code.
     we used JvmUtilities class for the function.
 
   <div align="left">
         <img src="Screenshot 2022-12-28 at 20.35.05.png" alt="Logo" width="400" height="400">
        
   
      
        
     2. here we see the first print of the groopAdmin footprint.
      as you can see in the first footprint we initialize one stack (UndoStringBilder) ,one array list,one stringBuilder,and some reserve.
      in a sum mem total of 232.
      after we added the three concreteMembers.
      we cam see in the secomd picture that 3 concreteMember added to the memory and also the reserve got biger.
      in a sum mem total of 344.
  
       
         
   <img src="D648FB7F-85ED-4D01-BAAB-05B2F077443E.jpeg" alt="Logo" width="400" height="400">
      
     3.this is after the test we append and insert some strings, and we can see that memory added to
      oure list "string" line of the string in oure StringBilder.
   <img src="53B7BF3D-E6BD-4B10-ADA8-8C78649F420E.jpeg" alt="Logo" width="400" height="400">
   <img src="72D933A8-2785-4986-A424-43D63F7BA583.jpeg" alt="Logo" width="400" height="400">
     
     
     

 



<!-- CONTRIBUTING -->
## Made by moshe nahshon and yogev ofir 



