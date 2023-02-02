package pomImplimentation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericLibraries.ExcelFileUtility;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;
import genericLibraries.iConstantPath;
import pomPages.ContactPage;
import pomPages.CreateContactsPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.NewContactInfoPage;

public class CreateContactTestImplimentation {

	public static void main(String[] args) {
		PropertiesFileUtility property =new PropertiesFileUtility();
		ExcelFileUtility excel = new ExcelFileUtility();
		JavaUtility javaUtil = new JavaUtility();
		WebDriverUtility web = new WebDriverUtility();
		
		property.propertyFileInitialization(iConstantPath.PROPERTY_FILE_PATH);
		excel.excelFileInitialization(iConstantPath.EXCEL_FILE_PATH);
		 String browser = property.fetchproperty("browser");
		 String url = property.fetchproperty("url");
		 long time = Long.parseLong(property.fetchproperty("timeouts"));
		 WebDriver driver = web.openApplication(browser, url, time);
		 
		 LoginPage login = new LoginPage(driver);
		 HomePage home = new HomePage(driver);
		 ContactPage contact = new ContactPage(driver);
		 CreateContactsPage createContact = new CreateContactsPage(driver);
		 NewContactInfoPage newContactinfo = new NewContactInfoPage(driver);
		 
		 
	      if(driver.getTitle().contains("vtiger"))
	    	  System.out.println("Login page should be Displayed-------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed-------Testcase Fail");
	      login.loginToApp(property.fetchproperty("username"), property.fetchproperty("password"));	           
	      if(driver.getTitle().contains("Home"))
	    	  System.out.println("Home page should be displayed--------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed-------Testcase Fail");
	  
	      home.clickContacts();
	      if(driver.getTitle().contains("Contacts"))
	    	  System.out.println("Contacts page should be dispalyed--------Testcase Pass");
	      else
	    	  System.out.println("Contacts page should not be displayed--------Testcase Fail");
	   
	      contact.clickPlusButton();
	      if(createContact.getPageHeader().contains("Creating New Contact"))
	    	  System.out.println("create new Contact page should be displayed------Testcase Pass");
	      else
	    	  System.out.println("create new Contact page should not be displayed-------Testcase Fail");

	      Map<String, String> map = excel.readDataFromExcel("Create Contact", "TestData");	      	      
//	      WebElement salutationDropdown = driver.findElement(By.name("salutationtype"));
//	      web.dropdown(map.get("Salutation"), salutationDropdown);
	      String firstName = map.get("First Name");
	   //   driver.findElement(By.name("firstname")).sendKeys(firstName);
	      String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
	  //    driver.findElement(By.name("lastname")).sendKeys(lastName);
	      createContact.contactinformation(web, map.get("Salutation"), firstName, lastName);
	      
//	      driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
	     createContact.clickSaveButton();
	      
	  //    String contactsinfoPageHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(newContactinfo.getPageHeader().contains(firstName))
	    	   System.out.println("New Contact information page should be display--------Testcase Pass");
	       else
	    	   System.out.println("New Contact information page should not be display-------Testcase Fail");
		
//		    driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		    newContactinfo.clickContactsLink();
		   
//		    String newcontactstable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[4]/a")).getText();
		     if(contact.getContact().equals(lastName))
		    	 System.out.println("new created leads name list should be displayed-------Testcase Pass ");
		     else
		    	 System.out.println("new created leads name list should not be displayed------Testcase Fail");
		   
		     home.signOutOfApp(web);
//		     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	         web.mouseHover(administratorIcon);
//	         driver.findElement(By.linkText("Sign Out")).click();
	         web.closeWindows();
	         excel.closeWorkbook();
	      
	

	}

}
