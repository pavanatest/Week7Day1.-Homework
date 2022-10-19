Feature: Login to Leaptaps

Scenario: Login Positive flow
Given Launch  the Chrome Browser
And Load the URL and  Maximize 
When Enter Username
And Enter Passoword 
And click on Login 
Then Verify HomePage  is displayed 

