package StepDefinition;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import cucumber.api.java.en.Given;

public class StepDefinition {
	public WebDriver driver;
	//HtmlUnitDriver unitdriver;
	@Given("^Open the browser$")
	public void open_the_browser() throws IOException, AWTException {
	   //System.setProperty("webdriver.chrome.driver", "/Users/tatralab/Documents/Drivers/chromedriver");
	   //driver=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "/Users/tatralab/Documents/Drivers/geckodriver");
		driver=new FirefoxDriver();
		//unitdriver=new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
	   //TestRecorder.StartTestRecording();
	   String currentwindowhandle=driver.getWindowHandle();
	   driver.switchTo().window(currentwindowhandle);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	      
	}

	@Given("^User navigates to 'http://testapps\\.in/qjump/admin/'$")
	public void user_navigates_to_http_testapps_in_qjump_admin()  {
	    driver.get("http://testapps.in/qjump/admin/");
		//unitdriver.get("http://testapps.in/qjump/admin/");
	    driver.manage().window().setSize(new Dimension(1300, 768));
	}
	
	@Given("^User navigates to 'http://testapps\\.in/qjump/restaurant/'$")
	public void user_navigates_to_http_testapps_in_qjump_restaurant()  {
		driver.get("http://testapps.in/qjump/restaurant/");
	    driver.manage().window().setSize(new Dimension(1300, 768));
	}

	@Given("^User enters username$")
	public void user_enters_username()  {
	    driver.findElement(By.name("email")).sendKeys("admin@qjump.com");
		//unitdriver.findElement(By.name("email")).sendKeys("admin@qjump.com");
	}
	
	@Given("^User enters username of restaurant$")
	public void user_enters_username_of_restaurant()  {
		driver.findElement(By.name("email")).sendKeys("m.zahran@softcare.io");
	}

	@Given("^User enters incorrect password$")
	public void user_enters_incorrect_password()  {
	   driver.findElement(By.name("password")).sendKeys("654321");
	   //unitdriver.findElement(By.name("password")).sendKeys("654321");
	}

	@Given("^User clicks Login button$")
	public void user_clicks_Login_button()  {
	    driver.findElement(By.className("btn-success")).click();
		//unitdriver.findElement(By.className("btn-success")).click();
	}

	@Given("^User will not be logged in as well$")
	public void user_will_not_be_logged_in_as_well() {
	    Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("QJump - Admin Login"));
		//Assert.assertTrue(unitdriver.findElement(By.tagName("h3")).getText().contains("QJump - Admin Login"));
	}
	
	@Given("^User will not be logged in as well for restaurant$")
	public void user_will_not_be_logged_in_as_well_for_restaurant()  {
		Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("QJump - Restaurant Login"));
	}

	@Given("^User enters correct password$")
	public void user_enters_correct_password()  {
		driver.findElement(By.name("password")).clear();
		//unitdriver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123456");
		//unitdriver.findElement(By.name("password")).sendKeys("123456");
	}

	@Given("^User will be logged in as well$")
	public void user_will_be_logged_in_as_well()  {
		Assert.assertTrue(driver.findElements(By.id("title-screen")).get(1).getText().contains("Dashboard"));
		//Assert.assertTrue(unitdriver.findElements(By.id("title-screen")).get(1).getText().contains("Dashboard"));
	}

	@Given("^User clicks RememberMe option$")
	public void user_clicks_RememberMe_option()  {
	  driver.findElements(By.name("remember")).get(0).click();
	}

	@Given("^User will be logged in to DashBoard as well$")
	public void user_will_be_logged_in_to_DashBoard_as_well() throws InterruptedException  {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElements(By.id("title-screen")).get(1).getText().contains("Dashboard"));
	}
	
	@Given("^User logs out$")
	public void user_logs_outßßß() {
	   driver.findElement(By.linkText("الخروج")).click();
	}

	@Given("^User will be logged out as well$")
	public void user_will_be_logged_out_as_well()  {
	    driver.getPageSource().contains("Successfully Logged out");
	}
	
	@Given("^User clicks 'Stadium Management'$")
	public void user_clicks_Stadium_Management() {
	  driver.findElement(By.xpath(".//ul[@id='side-menu']/li[2]/a")).click();
	}

	@Given("^User clicks 'Add Stadium'$")
	public void user_clicks_Add_Stadium()  {
	   driver.findElement(By.linkText("Add Stadium")).click();
	}

	@Given("^user adds a stadium$")
	public void user_adds_a_stadium() {
	   //Stadium name in AR
		driver.findElement(By.id("name_ar")).sendKeys("ستاد اتوميشن");
		//Stadium name in EN
		driver.findElement(By.id("name_en")).sendKeys("Automation Stadium");
		//City in AR
		driver.findElement(By.id("city_ar")).sendKeys("القاهرة");
		//City in EN
		driver.findElement(By.id("city_en")).sendKeys("Cairo");
		//Address in AR
		driver.findElement(By.id("addr_ar")).sendKeys("مدينة نصر");
		//Address in EN
		driver.findElement(By.id("addr_en")).sendKeys("Nasr City");	
		//Image
		driver.findElement(By.id("uploadphoto")).sendKeys("/Users/tatralab/Downloads/Stadium.jpeg");
	}

	@Given("^User clicks Submit$")
	public void user_clicks_Submit()  {
	    driver.findElement(By.id("btn_submit")).click();
	}

	@Given("^Stadium will be added successfully$")
	public void stadium_will_be_added_successfully() throws InterruptedException {
	    driver.findElement(By.id("txt_data")).sendKeys("ستاد اتوميشن");
	    Thread.sleep(3000);
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("ستاد اتوميشن"));
	}
	
	@Given("^User clicks 'All Stadium'$")
	public void user_clicks_All_Stadium() {
	    driver.findElement(By.linkText("All Stadium")).click();
	}

	@Given("^User clicks Edit for a stadium$")
	public void user_clicks_Edit_for_a_stadium() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("ستاد اتوميشن");
		Thread.sleep(3000);
	    driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[7]/samp[1]/img")).click();
	    driver.findElement(By.id("name_ar")).clear();
	    driver.findElement(By.id("name_ar")).sendKeys("ستاد اتوميشن معدل");
	}

	@Given("^Stadium will be edited successfully$")
	public void stadium_will_be_edited_successfully() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("ستاد اتوميشن معدل");
		Thread.sleep(3000);
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("ستاد اتوميشن معدل"));
	}

	@Given("^User searches for the added stadium$")
	public void user_searches_for_the_added_stadium() {
		driver.findElement(By.id("txt_data")).sendKeys("ستاد اتوميشن معدل");    
	}

	@Given("^The system will get the result as well$")
	public void the_system_will_get_the_result_as_well() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("ستاد اتوميشن معدل"));  
	}

	@Given("^User clicks Delete for a stadium$")
	public void user_clicks_Delete_for_a_stadium() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("ستاد اتوميشن معدل"); 
		Thread.sleep(8000);
		driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[7]/samp[2]/img")).click();
		driver.switchTo().alert().accept();
	}

	@Given("^Stadium will be deleted successfully$")
	public void stadium_will_be_deleted_successfully() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("txt_data")).sendKeys("ستاد اتوميشن معدل"); 
		Thread.sleep(8000);
		Assert.assertTrue(driver.findElement(By.id("no_data_css")).getText().contains("No Records Found"));
	}
	
	@Given("^User clicks 'Restaurant Management'$")
	public void user_clicks_Restaurant_Management() {
		driver.findElement(By.xpath(".//ul[@id='side-menu']/li[3]/a")).click();
	}

	@Given("^User clicks 'Add restaurant'$")
	public void user_clicks_Add_restaurant()  {
	   driver.findElement(By.linkText("Add Restaurant")).click();
	}
	
	@Given("^User clicks 'All restaurant'$")
	public void user_clicks_All_restaurant()  {
	  driver.findElement(By.linkText("All Restaurant")).click();
	}

	@Given("^user adds a restaurant$")
	public void user_adds_a_restaurant() {
		        //Restaurant name in AR
				driver.findElement(By.id("name_ar")).sendKeys("مطعم اتوميشن");
				//Restaurant name in EN
				driver.findElement(By.id("name_en")).sendKeys("Automation Restaurant");
				//Description in AR
				driver.findElement(By.id("description_ar")).sendKeys("مطعم يقدم اكلات جديدة وفريدة");
				//Description in EN
				driver.findElement(By.id("description_en")).sendKeys("Restaurant presents new and wow! meals");
				//Image
				driver.findElement(By.id("uploadphoto")).sendKeys("/Users/tatralab/Downloads/Restaurant.jpeg");
				//UserName
				driver.findElement(By.id("txt_username")).sendKeys("m.zahran@softcare.io");
				//Password
				driver.findElement(By.id("txt_password")).sendKeys("123456");
				//Confirm Password
				driver.findElement(By.id("txt_c_password")).sendKeys("123456");
				//Contact No
				driver.findElement(By.id("txt_contact")).sendKeys("11111111111111");
	}

	@Given("^Restaurant will be added successfully$")
	public void restaurant_will_be_added_successfully() throws InterruptedException  {
	   driver.findElement(By.id("txt_data")).sendKeys("مطعم اتوميشن");
	   Thread.sleep(3000);
	   Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("مطعم اتوميشن"));
	}

	@Given("^User clicks Edit for a restaurant$")
	public void user_clicks_Edit_for_a_restaurant() throws InterruptedException  {
		driver.findElement(By.id("txt_data")).sendKeys("مطعم اتوميشن");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[7]/samp[1]/img")).click();  
		driver.findElement(By.id("name_ar")).clear();
		driver.findElement(By.id("name_ar")).sendKeys("مطعم اتوميشن معدل");
	}

	@Given("^Restaurant will be edited successfully$")
	public void restaurant_will_be_edited_successfully() throws InterruptedException  {
		driver.findElement(By.id("txt_data")).sendKeys("مطعم اتوميشن معدل");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("مطعم اتوميشن معدل"));
	}

	@Given("^User searches for the added restaurant$")
	public void user_searches_for_the_added_restaurant() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("مطعم اتوميشن معدل");
		Thread.sleep(3000);
	}
	
	@Given("^The system will get the result as well for restaurant$")
	public void the_system_will_get_the_result_as_well_for_restaurant() {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("مطعم اتوميشن معدل"));
	}

	@Given("^User clicks Delete for a restaurant$")
	public void user_clicks_Delete_for_a_restaurant() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("مطعم اتوميشن معدل");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[7]/samp[2]/img")).click();
		driver.switchTo().alert().accept();
	}

	@Given("^Restaurant will be deleted successfully$")
	public void restaurant_will_be_deleted_successfully() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("مطعم اتوميشن معدل");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.id("no_data_css")).getText().contains("No Records Found"));
	}
	
	@Given("^User clicks 'Runner Management'$")
	public void user_clicks_Runner_Management() {
		 driver.findElement(By.xpath(".//ul[@id='side-menu']/li[4]/a")).click();
	}

	@Given("^User clicks 'Add Runner'$")
	public void user_clicks_Add_Runner() {
	   driver.findElement(By.linkText("Add Runner")).click();
	}

	@Given("^user adds a runner$")
	public void user_adds_a_runner()  {
	    //Name in AR
		driver.findElement(By.id("name_ar")).sendKeys("موصل طلبات اتوميشن");
		//Name in EN
		driver.findElement(By.id("name_en")).sendKeys("Automation Runner");
		//Image
		driver.findElement(By.id("uploadphoto")).sendKeys("/Users/tatralab/Documents/My Photo.jpg");
		//UserName
		driver.findElement(By.id("txt_username")).sendKeys("m.zahran@softcare.io");
		//Password
		driver.findElement(By.id("txt_password")).sendKeys("123456");
		//Confirm Password
		driver.findElement(By.id("txt_c_password")).sendKeys("123456");
		//Contact No
		driver.findElement(By.id("txt_contact")).sendKeys("1111111111111");
	}

	@Given("^Runner will be added successfully$")
	public void runner_will_be_added_successfully() throws InterruptedException  {
	    driver.findElement(By.id("txt_data")).sendKeys("موصل طلبات اتوميشن");
	    Thread.sleep(3000);
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("موصل طلبات اتوميشن"));
	}

	@Given("^User clicks 'All Runner'$")
	public void user_clicks_All_Runner()  {
		driver.findElement(By.linkText("All Runner")).click();
	}

	@Given("^User clicks Edit for a runner$")
	public void user_clicks_Edit_for_a_runner() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("موصل طلبات اتوميشن");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[6]/samp[1]/img")).click();
	    driver.findElement(By.id("name_ar")).clear();
	    driver.findElement(By.id("name_ar")).sendKeys("موصل طلبات اتوميشن معدل");
	}

	@Given("^Runner will be edited successfully$")
	public void runner_will_be_edited_successfully() throws InterruptedException  {
		driver.findElement(By.id("txt_data")).sendKeys("موصل طلبات اتوميشن معدل");
	    Thread.sleep(3000);
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("موصل طلبات اتوميشن معدل"));
	}

	@Given("^User searches for the added runner$")
	public void user_searches_for_the_added_runner() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("موصل طلبات اتوميشن معدل");
	    Thread.sleep(3000);    
	}

	@Given("^The system will get the result as well for runner$")
	public void the_system_will_get_the_result_as_well_for_runner() {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("موصل طلبات اتوميشن معدل")); 
	}

	@Given("^User clicks Delete for a runner$")
	public void user_clicks_Delete_for_a_runner() throws InterruptedException  {
		driver.findElement(By.id("txt_data")).sendKeys("موصل طلبات اتوميشن معدل");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[6]/samp[2]/img")).click();
		driver.switchTo().alert().accept();
	    
	}

	@Given("^Runner will be deleted successfully$")
	public void runner_will_be_deleted_successfully() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("موصل طلبات اتوميشن معدل"); 
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.id("no_data_css")).getText().contains("No Records Found"));
	}
	
	@Given("^Close the browser$")
	public void close_the_browser() throws IOException, AWTException, InterruptedException {
	    driver.quit();
		//unitdriver.quit();
	    Thread.sleep(3000);
	    //TestRecorder.EndTestRecording();
	}
	
	@Given("^User clicks 'Product Management'$")
	public void user_clicks_Product_Management() {
		driver.findElement(By.xpath(".//ul[@id='side-menu']/li[2]/a")).click();
	}

	@Given("^User clicks 'Add product'$")
	public void user_clicks_Add_product()  {
		driver.findElement(By.linkText("Add Products")).click();
	}

	@Given("^user adds a product$")
	public void user_adds_a_product()  {
	    //Name in AR
		driver.findElement(By.id("name_ar")).sendKeys("فراخ علي الفحم");
		//Name in EN
		driver.findElement(By.id("name_en")).sendKeys("Coal Chicken");
		//Description in AR
		driver.findElement(By.id("description_ar")).sendKeys("فراخ مخلية مشوية علي الفحم الحار");
		//Description in EN
		driver.findElement(By.id("description_en")).sendKeys("Chicken done on coal");
		//Image
		driver.findElement(By.id("uploadphoto")).sendKeys("/Users/tatralab/Downloads/coal chicken.jpeg");
		//Category
		WebElement catselector=driver.findElement(By.id("txt_cat"));
		Select catelement=new Select(catselector);
		catelement.selectByVisibleText("Food");
		//Price
		driver.findElement(By.id("txt_price")).sendKeys("30");
	}

	@Given("^Product will be added successfully$")
	public void product_will_be_added_successfully() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("فراخ علي الفحم");
	    Thread.sleep(3000);
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("فراخ علي الفحم"));
	}

	@Given("^User clicks 'All product'$")
	public void user_clicks_All_product()  {
		driver.findElement(By.linkText("All Products")).click();
	}

	@Given("^User clicks Edit for a product$")
	public void user_clicks_Edit_for_a_product() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("فراخ علي الفحم");
		Thread.sleep(3000);
	    driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[7]/samp[1]/img")).click();
	    driver.findElement(By.id("name_ar")).clear();
	    driver.findElement(By.id("name_ar")).sendKeys("فراخ علي الفحم معدلة");
	}

	@Given("^Product will be edited successfully$")
	public void product_will_be_edited_successfully() throws InterruptedException {
		driver.findElement(By.id("txt_data")).sendKeys("فراخ علي الفحم معدلة");
		Thread.sleep(3000);
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("فراخ علي الفحم معدلة"));
	}

	@Given("^User searches for the added product$")
	public void user_searches_for_the_added_product() throws InterruptedException  {
		driver.findElement(By.id("txt_data")).sendKeys("فراخ علي الفحم معدلة");
		Thread.sleep(3000);
	}

	@Given("^The system will get the result as well for product$")
	public void the_system_will_get_the_result_as_well_for_product() {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[3]/samp")).getText().contains("فراخ علي الفحم معدلة"));
	}

	@Given("^User clicks Delete for a product$")
	public void user_clicks_Delete_for_a_product() throws InterruptedException  {
		driver.findElement(By.id("txt_data")).sendKeys("فراخ علي الفحم معدلة"); 
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//table[@id='dataTables-example2']/tbody/tr[2]/td[7]/samp[2]/img")).click();
		driver.switchTo().alert().accept();
	}

	@Given("^Product will be deleted successfully$")
	public void product_will_be_deleted_successfully() throws InterruptedException  {
		driver.findElement(By.id("txt_data")).sendKeys("فراخ علي الفحم معدلة"); 
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.id("no_data_css")).getText().contains("No Records Found"));
	}
	
}

	