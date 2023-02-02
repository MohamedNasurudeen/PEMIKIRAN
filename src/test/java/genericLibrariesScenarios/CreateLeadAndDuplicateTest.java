package genericLibrariesScenarios;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericLibraries.ExcelFileUtility;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;
import genericLibraries.iConstantPath;

public class CreateLeadAndDuplicateTest {

	public static void main(String[] args) {
		PropertiesFileUtility property = new PropertiesFileUtility();
		ExcelFileUtility excel = new ExcelFileUtility();
		JavaUtility javaUtil = new JavaUtility();
		WebDriverUtility web = new WebDriverUtility();
		property.propertyFileInitialization(iConstantPath.PROPERTY_FILE_PATH);
		excel.excelFileInitialization(iConstantPath.EXCEL_FILE_PATH);
		long time = Long.parseLong(property.fetchproperty("timeouts"));
		WebDriver driver = web.openApplication(property.fetchproperty("browser"), property.fetchproperty("url"), time);
		if(driver.getTitle().contains("vtiger"))
	    	  System.out.println("Login page should be Displayed----------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed-------Testcase Fail");
	      
	      driver.findElement(By.name("user_name")).sendKeys(property.fetchproperty("username"));
	      driver.findElement(By.name("user_password")).sendKeys(property.fetchproperty("password"));
	      driver.findElement(By.id("submitButton")).click();
	      if(driver.getTitle().contains("Home"))
	    	  System.out.println("Home page should be displayed---------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed-------Testcase Fail");
	    
	      driver.findElement(By.linkText("Leads")).click();
//	      String leadsLabel = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	      if(driver.getTitle().contains("Leads"))
	    	  System.out.println("Leads page should be dispalyed------------Testcase Pass");
	      else
	    	  System.out.println("Leads page should not be displayed----------Testcase Fail");
	      
	      driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
	      String createLeads = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	      if(createLeads.contains("New Lead"))
	    	  System.out.println("create new Leads page should be displayed----------Testcase Pass");
	      else
	    	  System.out.println("create new Leads page should not be displayed---------Testcase Fail");
	      
	      Map<String, String> map = excel.readDataFromExcel("Cread Lead", "TestData");
	      WebElement salutationDropdown = driver.findElement(By.name("salutationtype"));
	      web.dropdown(map.get("Salutation"), salutationDropdown);
	      driver.findElement(By.name("firstname")).sendKeys(map.get("First Name"));
	      String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
	      driver.findElement(By.name("lastname")).sendKeys(lastName);
	      driver.findElement(By.name("company")).sendKeys(map.get("Company"));
	      driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
	      String leadsinfopageHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(leadsinfopageHeader.contains(lastName))
	    	   System.out.println("New Lead information page should be display-------Testcase Pass");
	       else
	    	   System.out.println("New Lead information page should not be display-------Testcase Fail");
		
	       driver.findElement(By.xpath("(//input[@title='Duplicate [Alt+U]'])[1]")).click();
	       String duplicateLeads = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		   if(duplicateLeads.contains(lastName))
			   System.out.println("Duplicating leads page should be open--------Testcase Pass");
		   else
			   System.out.println("Duplicating leads page should not be open--------Testcase Fail");
		   WebElement lastnameTF = driver.findElement(By.name("lastname"));
		   lastnameTF.clear();
		   String newLastName=map.get("New Last Name")+javaUtil.generateRandomNumber(100);
		   lastnameTF.sendKeys(newLastName);
		   driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
		   String duplicateleadsinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(duplicateleadsinfo.contains(newLastName))
	    	   System.out.println("Duplicate Lead information page should be display-------Testcase Pass");
	       else
	    	   System.out.println("Duplicate Lead information page should not be display-------Testcase Fail");
		
	       driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		    String newleadstable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
		     if(newleadstable.equals(newLastName))
		    	 System.out.println("new created leads name list should be displayed---------Testcase Pass ");
		     else
		    	 System.out.println("new created leads name list should not be displayed-----------Testcase Fail");
	     String oldleadstable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()-1]/td[3]/a")).getText();
	             if(oldleadstable.equals(lastName))
		    		 System.out.println("previous leads name display-----Testcase Pass");
		    	 else
		    		 System.out.println("previous leads name not display------Testcase Fail");		
				     
		     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
             web.mouseHover(administratorIcon);
             web.closeWindows();
             excel.closeWorkbook();
	}

}
