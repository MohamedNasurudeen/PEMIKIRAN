package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NewContacts_Sce2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
	      if(title.contains("vtiger"))
	    	  System.out.println("Login page should be Displayed-------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed-------Testcase Fail");
	      
	      driver.findElement(By.name("user_name")).sendKeys("admin");
	      driver.findElement(By.name("user_password")).sendKeys("admin");
	      driver.findElement(By.id("submitButton")).submit();
	      
	      String homepageLable = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();      
	      if(homepageLable.contains("Home"))
	    	  System.out.println("Home page should be displayed--------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed-------Testcase Fail");
	    
	      driver.findElement(By.linkText("Contacts")).click();
	      String contactsLabel = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	      if(contactsLabel.contains("Contacts"))
	    	  System.out.println("Contacts page should be dispalyed--------Testcase Pass");
	      else
	    	  System.out.println("Contacts page should not be displayed--------Testcase Fail");
	      
	      driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	      String createContactsPageHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	      if(createContactsPageHeader.contains("Creating New Contact"))
	    	  System.out.println("create new Contact page should be displayed------Testcase Pass");
	      else
	    	  System.out.println("create new Contact page should not be displayed-------Testcase Fail");
	      
	      WebElement salutation = driver.findElement(By.name("salutationtype"));
	      Select select = new Select(salutation);
	      select.selectByIndex(1);
	      driver.findElement(By.name("firstname")).sendKeys("Mohamed");
	      driver.findElement(By.name("lastname")).sendKeys("Halith");
	      driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
	      String contactsinfoPageHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(contactsinfoPageHeader.contains("Mohamed"))
	    	   System.out.println("New Contact information page should be display--------Testcase Pass");
	       else
	    	   System.out.println("New Contact information page should not be display-------Testcase Fail");
		
		    driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		    String newcontactstable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[4]/a")).getText();
		     if(newcontactstable.equals("Halith"))
		    	 System.out.println("new created leads name list should be displayed-------Testcase Pass ");
		     else
		    	 System.out.println("new created leads name list should not be displayed------Testcase Fail");
		     
		     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		     Actions action = new Actions(driver);
		     action.moveToElement(administratorIcon).perform();
		    // action.doubleClick(administratorIcon).perform();
		     driver.findElement(By.linkText("Sign Out")).click();
		     driver.quit();

	}

}
