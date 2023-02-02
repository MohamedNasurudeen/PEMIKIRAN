package testNGImplimentation;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.ExcelFileUtility;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;
import genericLibraries.iConstantPath;
import pomPages.CreateLeadsPage;
import pomPages.HomePage;
import pomPages.LeadPage;
import pomPages.LoginPage;
import pomPages.NewLeadInfoPage;

public class CreateLeadAndDuplicateTest extends BaseClass {

	@Test
	public void createLeadAndDuplicate() {
		SoftAssert soft = new SoftAssert();
	      home.clickLeads();
	    //  soft.assertTrue(driver.getTitle().contains("Leads"));
	      
	      lead.clickPlusButton();	     
	      soft.assertTrue(createLead.getPageHeader().contains("New Lead"));
	       
	      Map<String, String> map = excel.readDataFromExcel("Create lead", "LeadTestData");
	      String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
	      createLead.leadInformation(web, map.get("Salutation"), map.get("First Name"), lastName, map.get("Company"));
	      createLead.clickSaveButton();      
	      soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
	     
	     newLeadInfo.clickDuplicateButton();
	     soft.assertTrue(createLead.getPageHeader().contains(lastName));
	     String newLastName=map.get("New Last Name")+javaUtil.generateRandomNumber(100);
	     createLead.enterLastNameTF(newLastName);
	     createLead.clickSaveButton();
	     soft.assertTrue(newLeadInfo.getPageHeader().contains(newLastName));
	     
	       newLeadInfo.clickLeadsLink();
	       soft.assertTrue(lead.getLead().equals(newLastName));
	       if(lead.getLead().equals(newLastName))
		    	 excel.setDataToExcel("Create lead", "Pass", iConstantPath.EXCEL_FILE_PATH, "LeadTestData");
		    else
		    	excel.setDataToExcel("Create lead", "Fail", iConstantPath.EXCEL_FILE_PATH, "LeadTestData");
	       soft.assertAll();
	
	}

}
