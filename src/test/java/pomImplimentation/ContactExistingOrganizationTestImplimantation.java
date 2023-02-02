package pomImplimentation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

public class ContactExistingOrganizationTestImplimantation {

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
	      String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
	      createContact.contactinformation(web, map.get("Salutation"), map.get("First Name"), lastName);
	      String currentwindow = web.getParentWindowID();	    
	      driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	      web.childBrowserPopup();
	      driver.findElement(By.id("4")).click();
	      driver.switchTo().window(currentwindow);
	      createContact.clickSaveButton();
	      if(newContactinfo.getPageHeader().contains(lastName))
   	          System.out.println("New Contact information page should be display--------Testcase Pass");
          else
   	          System.out.println("New Contact information page should not be display-------Testcase Fail");
	      newContactinfo.clickContactsLink();
	      if(contact.getContact().equals(lastName))
		    	 System.out.println("new created leads name list should be displayed-------Testcase Pass ");
	     else
		    	 System.out.println("new created leads name list should not be displayed------Testcase Fail");
		   
		     home.signOutOfApp(web);
		     web.closeWindows();
	         excel.closeWorkbook();
	}

}
