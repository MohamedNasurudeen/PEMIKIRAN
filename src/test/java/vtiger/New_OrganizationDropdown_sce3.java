package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class New_OrganizationDropdown_sce3 {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
	      if(title.contains("vtiger"))
	    	  System.out.println("Login page should be Displayed----------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed------------Testcase Fail");
	      
	      driver.findElement(By.name("user_name")).sendKeys("admin");
	      driver.findElement(By.name("user_password")).sendKeys("admin");
	      driver.findElement(By.id("submitButton")).submit();
	      
	      String homepageLable = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();      
	      if(homepageLable.contains("Home"))
	    	  System.out.println("Home page should be displayed----------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed----------Testcase Fail");
	    
	      driver.findElement(By.linkText("Organizations")).click();
	      String organizationLabel = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	      if(organizationLabel.contains("Organizations"))
	    	  System.out.println("organization page should be dispalyed---------Testcase Pass");
	      else
	    	  System.out.println("organization page should not be displayed --------Testcase Fail");
	      driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	      String createNeworganizationPageHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	      if(createNeworganizationPageHeader.contains("Creating New Organization"))
	    	  System.out.println("create new organization page should be displayed----------Testcase Pass");
	      else
	    	  System.out.println("create new organization page should not be displayed-------Testcase Fail");

	       driver.findElement(By.name("accountname")).sendKeys("Goodday");
	       WebElement industrydropdown = driver.findElement(By.name("industry"));
	       Select selectindustry = new Select(industrydropdown);
	       selectindustry.selectByVisibleText("Technology");
	       WebElement typedropdown = driver.findElement(By.name("accounttype"));
	       Select selecttype = new Select(typedropdown);
	       selecttype.selectByVisibleText("Investor");
	       driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
	       String organizationinfoPageHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(organizationinfoPageHeader.contains("Goodday"))
	    	   System.out.println("New organization information page should be display-------Testcase Pass");
	       else
	    	   System.out.println("New organization information page should not be display------Testcase Fail");
		
		    driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		    String neworgtable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
		     if(neworgtable.equals("Goodday"))
		    	 System.out.println("new created organization name list should be displayed------Testcase Pass ");
		     else
		    	 System.out.println("new created organization name list should not be displayed---------Testcase Fail");
		     
		     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		     Actions action = new Actions(driver);
		     action.doubleClick(administratorIcon).perform();
		     driver.findElement(By.linkText("Sign Out")).click();
		     driver.quit();


	}

}
