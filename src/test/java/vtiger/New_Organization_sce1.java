package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class New_Organization_sce1 {

	public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("http://localhost:8888/index.php?action=Login&module=Users");
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
      if(title.contains("vtiger"))
    	  System.out.println("Login page should be Displayed");
      else
    	  System.out.println("Login page should not be Displayed");
      
      driver.findElement(By.name("user_name")).sendKeys("admin");
      driver.findElement(By.name("user_password")).sendKeys("admin");
      driver.findElement(By.id("submitButton")).submit();
      
      String homepageLable = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();      
      if(homepageLable.contains("Home"))
    	  System.out.println("Home page should be displayed");
      else
    	  System.out.println("Home page should not be displayed");
    
      driver.findElement(By.linkText("Organizations")).click();
      String organizationLabel = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
      if(organizationLabel.contains("Organizations"))
    	  System.out.println("organization page should be dispalyed");
      else
    	  System.out.println("organization page should not be displayed");
      
      driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
      String createorganization = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
      if(createorganization.contains("Creating New Organization"))
    	  System.out.println("create new organization page should be displayed");
      else
    	  System.out.println("create new organization page should not be displayed");

       driver.findElement(By.name("accountname")).sendKeys("Aliyas1");
       driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
       String organizationinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
       if(organizationinfo.contains("Aliyas1"))
    	   System.out.println("New organization information should be display");
       else
    	   System.out.println("New organization information should not be display");
	
	    driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
	    String neworgtable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]")).getText();
	     if(neworgtable.equals("Aliyas1"))
	    	 System.out.println("new created organization name list should be displayed ");
	     else
	    	 System.out.println("new created organization name list should not be displayed");
	     
	     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     Actions action = new Actions(driver);
	     action.doubleClick(administratorIcon).perform();
	     driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	     driver.quit();
	
	}
	
	

}
