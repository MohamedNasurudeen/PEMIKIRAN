package testNGImplimentation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
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

public class CreateContactTest extends BaseClass {

	@Test
	public void createContact() {
		SoftAssert soft = new SoftAssert();
	      home.clickContacts();	      
	    //  soft.assertTrue(contact.getPageHeader().contains("Contacts "));
	      contact.clickPlusButton();
	      soft.assertTrue(createContact.getPageHeader().contains("Creating New Contact"));
	      
	      Map<String, String> map = excel.readDataFromExcel("Create Contact", "ContactTestData");	      	    
	      String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
	      createContact.contactinformation(web, map.get("Salutation"), map.get("First Name"), lastName);
   	     createContact.clickSaveButton();
	      soft.assertTrue(newContactinfo.getPageHeader().contains(lastName));

		    newContactinfo.clickContactsLink();
		    soft.assertTrue(contact.getContact().equals(lastName));

		     if(contact.getContact().equals(lastName))
                excel.setDataToExcel("Create Contact", "Pass", iConstantPath.EXCEL_FILE_PATH, "ContactTestData");
		     else
		    	 excel.setDataToExcel("Create Contact", "Fail", iConstantPath.EXCEL_FILE_PATH, "ContactTestData");
	
           soft.assertAll();
	}

}
