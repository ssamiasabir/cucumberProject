package stepDef;

import java.sql.Blob;
import java.time.Duration;

import javax.naming.directory.DirContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class login_steps {

	WebDriver driver;
	
	
	
	
@Given("User open chrome browser")
public void user_open_chrome_browser() {
   
	driver = new ChromeDriver();
	
	
	
}

@Given("User go to Sdemov1 url")
public void user_go_to_sdemov1_url() {
	driver.get("https://www.saucedemo.com/v1/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
  
  
  
}

@When("User enter username and password")
public void user_enter_username_and_password() {
	driver.findElement(By.xpath("//*[@class='form_input' and @id='user-name']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//*[@class='form_input' and @id='password']")).sendKeys("secret_sauce");
	 
   
}

@When("User click the login button")
public void user_click_the_login_button() {
	 driver.findElement(By.xpath("//*[@class='btn_action' and @id='login-button']")).click();
}

@Then("User landed to sdemo main page")
public void user_landed_to_sdemo_main_page() {

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	String expectedTitle = "Swag Labs";
	
	String actualTitle = driver.getTitle();
//	System.out.println(actualTitle);
	if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		System.out.println("User is landed on main page successfully");
	}else {
		System.out.println("User is not landed on main page successfully");
	}
		


}

@Then("User close the browers")
public void user_close_the_browers() throws InterruptedException {
  
	Thread.sleep(2000);
	
	
	driver.quit();
	
}
	
	
	
	
}
