Feature: Login to Leaftaps 

Background: 
	Given Launch the chrome browser 
	And Load the URL and maximize 
	When Enter Username as 'DemoSalesManager' 
	And Enter Password as 'crmsfa' 
	And Click on Login 
	When Click on CRMSFA link 
	When Click on Leads link 
	
#	#CreateLead
Scenario: 
	When Click on Create Lead link 
	When Enter Company Name as 'TestLeaf' 
	And Enter First Name as 'Anu' 
	And Enter Last Name as 'M' 
	
	And Click on Create Lead button 
	
	
#	#	Examples: 
#	#		|username|password|
#	#		|'DemoSalesManager'|'crmsfa'|
#	#		|'DemoCSR'|'crmsfa'|

#	#EditLead
Scenario: 
	When Click on Find Leads link 
	When Click on Phone tab 
	And Enter Phone Number field as '959595' 
	When Click on Find Leads button 
	And Click on the first result of the LeadId 
	When Click on Edit button 
	And Update Company Name as 'HCL' 
	And Click on Update button 
	
#	#DuplicateLead	
Scenario: 
	When Click on Find Leads link
	When Click on Phone tab
	And Enter Phone Number field as '959595' 
	When Click on Find Leads button
	And Click on the first result of the LeadId
	When Click on Duplicate Lead button
	And Click on Create Lead button
	
	#MergeLead
Scenario: 
	When Click on Merge Leads link 
	When Click on the Lookup next to From Lead 
	And Enter FirstName as 'Poorna' in FindLeads page 
	When Click on Find Leads button
	And Click on the first result of LeadId and get the result for verification 
	When Click on Lookup next to To Lead 
	And Enter FirstName as 'Anu' in FindLeads page 
	When Click on Find Leads button
	And Click on the first result of LeadId 
	And Click on Merge button and confirm the merge 
	When Click on Find Leads link
	And Enter LeadID in Lead ID field which was merged earlier 
	When Click on Find Leads button
	Then Verify that the LeadId which is merged is not available to display 
	
	#DeleteLead
Scenario: 
	When Click on Find Leads link 
	When Click on Phone tab 
	And Enter Phone Number field as '959595' 
	When Click on Find Leads button 
	And Click on the first result of the LeadId to be deleted
	And Click on Delete button 
	When Click on Find Leads link 
	And Enter the leadID
	And Click on Find Leads button 
	Then Verify deleted lead is not available 