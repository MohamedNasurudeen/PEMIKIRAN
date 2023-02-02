package testNGImplimentation;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.iConstantPath;


public class CreateOrganizationTest extends BaseClass {

	@Test
	public  void createOrganization() {
		 SoftAssert soft = new SoftAssert();
	      home.clickOrganizations();	        
	     soft.assertTrue(organization.getPageHeader().contains("Organizations"));
	      organization.clickPlusButton();
          soft.assertTrue(createOrganization.getPageHeader().contains("Creating"));	      
//	      String organizationName = excel.readDataFromExcel("TestData", 1, 3) + javaUtil.generateRandomNumber(100);
          Map<String, String> map = excel.readDataFromExcel("Create Organization", "OrganizationTestData");
	      String organizationName = map.get("Org Name")+ javaUtil.generateRandomNumber(100);    
	    
	      createOrganization.setOrganizationName(organizationName);	    
	      createOrganization.clickSaveButton();
	      soft.assertTrue(newOrganization.getPageHeader().contains(organizationName));	 
	       newOrganization.clickOrganizationsLink();
	       organization.clickLastPage();
	 	 soft.assertTrue(organization.getOrganization().equals(organizationName));
	      if(organization.getOrganization().equals(organizationName))
	 	    	 excel.setDataToExcel("Create Organization", "Pass", iConstantPath.EXCEL_FILE_PATH, "OrganizationTestData");
	 	     else
	 	       	excel.setDataToExcel("Create Organization", "Fail", iConstantPath.EXCEL_FILE_PATH, "OrganizationTestData");
          soft.assertAll();  
	}

}
