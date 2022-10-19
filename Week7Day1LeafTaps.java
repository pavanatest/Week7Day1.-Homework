package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Week7Day1LeafTaps extends BaseClass {
	
	
	
	@When("Click on CRMSFA link")
	public void CRMSFAlink()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	}
	
	@When("Click on Leads link")
	//Click on Leads link
	public void clickLeadsLink()
	{
		driver.findElement(By.linkText("Leads")).click();	
	}
		
	
	@When("Click on Create Lead link")
	//Click on Create Lead link
	public void clickCreateLeadLink()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}
		
	
	@When("Enter Company Name as {string}")
			//Enter Company Name as 'TestLeaf'
	public void enterCompanyName(String companyName)
	{
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}

	
	@And("Enter First Name as {string}")
	//Enter First Name as 'Anu'
	public void enterFirstName(String firstName)
	{
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
	
	
	@And("Enter Last Name as {string}")
	//Enter Last Name as 'M'
	public void enterLastName(String lastName)
	{
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}

	@And("Click on Create Lead button")
	//Click on Create Lead button
	public void createLeadButton() throws InterruptedException
	{
			driver.findElement(By.name("submitButton")).click();
			Thread.sleep(5000);
	}

		
	@When("Click on Find Leads link")
	public void clickFindLeadsLink()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	
	@When("Click on Phone tab")
	public void clickPhoneTab()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	
	
	@And("Enter Phone Number field as {string}")
	public void enterPhoneNumber(String phone)
	{
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phone);
	}
	
	
	@When("Click on Find Leads button")
	public void clickFindLeadsButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(9000);
	}
	
	
	@And("Click on the first result of the LeadId")
	public void clickFirstResultLeadId() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(4000);
	}
	
	
	@When("Click on Edit button")
	public void clickEditButton()
	{
		driver.findElement(By.linkText("Edit")).click();
	}
	
	
	@And("Update Company Name as {string}")
	public void enterCoName(String coName)
	{
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(coName);
	}
	
	
	@And("Click on Update button")
	public void clickUpdateButton()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	
	@When("Click on Duplicate Lead button")
	public void clickDuplicateLeadButton()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	
	
		
	@When("Click on Merge Leads link")
	public void clickMergeLeadsLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.linkText("Merge Leads")).click();
		Thread.sleep(2000);
	}
	
	@When("Click on the Lookup next to From Lead")
	public void clickLookUpFromLead()
	{
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}
	
	
	@And("Enter FirstName as {string} in FindLeads page")
	public void enterFirstNameFindLeads(String fn)
	{
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fn);
	}
	
	
	@And("Click on the first result of LeadId and get the result for verification")
	public String clickFirstResultLeadID()
	{
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	
		//System.out.println("LeadID fetched :"+leadID);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(0));
		return leadID;
	
	}
	
	@When("Click on Lookup next to To Lead")
	public void clickLookUpToLead()
	{
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
	}
	
	
	@And("Click on the first result of LeadId")
	public void clickOnFirstResultLeadID()
	{
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(0));
	}
	
	@And("Click on Merge button and confirm the merge")
	public void clickMergeButton()
	{
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
	}
	

	@And("Enter LeadID in Lead ID field which was merged earlier") 
	public void enterLeadIDInLeadIDField() throws InterruptedException
	{
	Thread.sleep(4000);

	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	Thread.sleep(3000);
	}
	
	
	@Then("Verify that the LeadId which is merged is not available to display")
	public void verifyLeadIDMerge()
	{
		
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display"))
		{
			System.out.println("Text matched");
		} 
		else 
		{
			System.out.println("Text not matched");
		}
	
	}
	
	
	@And("Click on the first result of the LeadId to be deleted")
	public static String clickFirstDelete()
	{
		leadIDENTIFIER = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println("LeadID to be deleted:"+leadIDENTIFIER);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return leadIDENTIFIER;
	}
	
	@And("Click on Delete button")
	public void clickDeleteButton()
	{
		driver.findElement(By.linkText("Delete")).click();
	}
	
	@And("Enter the leadID")
	public void enterLeadIDDeletedEarlier()
	{

		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadIDENTIFIER);
	}
	
	@Then("Verify deleted lead is not available")
	public void verifiyDeletedLead()
	{
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display"))
		{
			System.out.println("Text matched");
		}
		else
		{
			System.out.println("Text not matched");
		}
	}
	
}
