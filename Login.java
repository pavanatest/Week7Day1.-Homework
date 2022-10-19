package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseClass {
	//public ChromeDriver driver;
	
	@Given ("Launch the chrome browser")
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	
	@And("Load the URL and maximize")
	public void loadUrl()
	{
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@When("Enter Username as {string}")
	public void enterUsername(String username)
	{
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	
	@When("Enter Password as {string}")
	public void enterPassword(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@And("Click on Login")
	public void clickLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	

	
}
