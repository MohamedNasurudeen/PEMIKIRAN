package vtiger;
                        //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 githup token
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class New_Leads_DuplicateButton_Sce5 {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
	      if(title.contains("vtiger"))
	    	  System.out.println("Login page should be Displayed----------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed-------Testcase Fail");
	      
	      driver.findElement(By.name("user_name")).sendKeys("admin");
	      driver.findElement(By.name("user_password")).sendKeys("admin");
	      driver.findElement(By.id("submitButton")).submit();
	      
	      String homepageLable = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();      
	      if(homepageLable.contains("Home"))
	    	  System.out.println("Home page should be displayed---------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed-------Testcase Fail");
	    
	      driver.findElement(By.linkText("Leads")).click();
	      String leadsLabel = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	      if(leadsLabel.contains("Leads"))
	    	  System.out.println("Leads page should be dispalyed------------Testcase Pass");
	      else
	    	  System.out.println("Leads page should not be displayed----------Testcase Fail");
	      
	      driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
	      String createLeads = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	      if(createLeads.contains("New Lead"))
	    	  System.out.println("create new Leads page should be displayed----------Testcase Pass");
	      else
	    	  System.out.println("create new Leads page should not be displayed---------Testcase Fail");
	      
	      WebElement salutation = driver.findElement(By.name("salutationtype"));
	      Select select = new Select(salutation);
	      select.selectByIndex(1);
	      driver.findElement(By.name("firstname")).sendKeys("Mohamed");
	      driver.findElement(By.name("lastname")).sendKeys("Yasin");
	      driver.findElement(By.name("company")).sendKeys("Google");
	      driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
	      String leadsinfopageHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(leadsinfopageHeader.contains("Mohamed"))
	    	   System.out.println("New Lead information page should be display-------Testcase Pass");
	       else
	    	   System.out.println("New Lead information page should not be display-------Testcase Fail");
		
	       driver.findElement(By.xpath("(//input[@title='Duplicate [Alt+U]'])[1]")).click();
	       String duplicateLeads = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		   if(duplicateLeads.contains("Mohamed"))
			   System.out.println("Duplicating leads page should be open--------Testcase Pass");
		   else
			   System.out.println("Duplicating leads page should not be open--------Testcase Fail");
		   WebElement lastnameTF = driver.findElement(By.name("lastname"));
		   lastnameTF.clear();
		   lastnameTF.sendKeys("Yafid");
		   driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
		   String duplicateleadsinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(duplicateleadsinfo.contains("Yafid"))
	    	   System.out.println("Duplicate Lead information page should be display-------Testcase Pass");
	       else
	    	   System.out.println("Duplicate Lead information page should not be display-------Testcase Fail");
		
	       driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		    String newleadstable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
		     if(newleadstable.equals("Yafid"))
		    	 System.out.println("new created leads name list should be displayed---------Testcase Pass ");
		     else
		    	 System.out.println("new created leads name list should not be displayed-----------Testcase Fail");
//		     List<WebElement> checkingname = driver.findElements(By.xpath("//table[@class='lvt small']/descendant::tr[@class='lvtColData']"));
	     String oldleadstable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()-1]/td[3]/a")).getText();
	             if(oldleadstable.equals("Yasin"))
		    		 System.out.println("previous leads name display-----Testcase Pass");
		    	 else
		    		 System.out.println("previous leads name not display------Testcase Fail");		
			
		     
		     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		     Actions action = new Actions(driver);
		     action.doubleClick(administratorIcon).perform();
		     driver.findElement(By.linkText("Sign Out")).click();
		     driver.quit();
		
	}

}
