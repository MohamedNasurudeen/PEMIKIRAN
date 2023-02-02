package genericLibrariesScenarios;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import genericLibraries.ExcelFileUtility;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;
import genericLibraries.iConstantPath;

public class ContactExistingOrgnaizationTest {

	public static void main(String[] args) {

             PropertiesFileUtility property = new PropertiesFileUtility();
             ExcelFileUtility excel = new ExcelFileUtility();
             JavaUtility javaUtil = new JavaUtility();
             WebDriverUtility web = new WebDriverUtility();
             property.propertyFileInitialization(iConstantPath.PROPERTY_FILE_PATH);
             excel.excelFileInitialization(iConstantPath.EXCEL_FILE_PATH);             
             long time = Long.parseLong(property.fetchproperty("timeouts"));
             WebDriver driver = web.openApplication(property.fetchproperty("browser"), property.fetchproperty("url"), time);
   
//             String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
             if(driver.getTitle().contains("vtiger"))
   	    	  System.out.println("Login page should be Displayed-------Testcase Pass");
   	      else
   	    	  System.out.println("Login page should not be Displayed-------Testcase Fail");
             driver.findElement(By.name("user_name")).sendKeys(property.fetchproperty("username"));
   	         driver.findElement(By.name("user_password")).sendKeys(property.fetchproperty("password"));
   	         driver.findElement(By.id("submitButton")).click();
   	      if(driver.getTitle().contains("Home"))
	    	  System.out.println("Home page should be displayed--------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed-------Testcase Fail");
   	         driver.findElement(By.linkText("Contacts")).click();

 //	      String contactsLabel = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	      if(driver.getTitle().contains("Contacts"))
	    	  System.out.println("Contacts page should be dispalyed--------Testcase Pass");
	      else
	    	  System.out.println("Contacts page should not be displayed--------Testcase Fail");
	      
	      driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	      String createContacts = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	      if(createContacts.contains("Creating New Contact"))
	    	  System.out.println("create new Contact page should be displayed------Testcase Pass");
	      else
	    	  System.out.println("create new Contact page should not be displayed-------Testcase Fail");
	      
	      Map<String, String> map = excel.readDataFromExcel("Create Contact", "TestData");
	      WebElement salutationDropdown = driver.findElement(By.name("salutationtype"));
	      web.dropdown(map.get("salutation"), salutationDropdown);
	      String firstName = map.get("First Name");
	      driver.findElement(By.name("firstname")).sendKeys(firstName);
	      String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
	      driver.findElement(By.name("lastname")).sendKeys(lastName);
	      String currentwindow = web.getParentWindowID();	    
	      driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	      web.childBrowserPopup();
	      driver.findElement(By.linkText("EcoUnfield")).click();
	      driver.switchTo().window(currentwindow);
	      driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
	      String contactsinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(contactsinfo.contains(firstName))
	    	   System.out.println("New Contact information page should be display--------Testcase Pass");
	       else
	    	   System.out.println("New Contact information page should not be display-------Testcase Fail");
		
		    driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		    String newcontactstable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[4]/a")).getText();
		     if(newcontactstable.equals(lastName))
		    	 System.out.println("new created leads name list should be displayed-------Testcase Pass ");
		     else
		    	 System.out.println("new created leads name list should not be displayed------Testcase Fail");
		     
		     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		     web.mouseHover(administratorIcon);
		     web.closeWindows();
		     excel.closeWorkbook();
	      
             

	}

}
