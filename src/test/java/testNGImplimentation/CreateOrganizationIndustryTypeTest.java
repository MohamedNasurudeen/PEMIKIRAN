package testNGImplimentation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.ExcelFileUtility;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;
import genericLibraries.iConstantPath;
import pomPages.CreateOrganizationPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.NewOrganizationInfoPage;
import pomPages.OrganizationPage;

public class CreateOrganizationIndustryTypeTest extends BaseClass{

	@Test
	public  void createOrganizationIndTyp() {
		SoftAssert soft = new SoftAssert();
	    
	      home.clickOrganizations();
	   //   soft.assertTrue(driver.getTitle().contains("Organizations"));
	     
	  
	      organization.clickPlusButton();
	      soft.assertTrue(createOrganization.getPageHeader().contains("Creating New Organization"));
	     

	      Map<String, String> map = excel.readDataFromExcel("Create Organization With Industry And Type", "OrganizationTestData");
	      String organizationName = map.get("Organization Name")+ javaUtil.generateRandomNumber(100);        
	      createOrganization.setOrganizationName(organizationName);
	      createOrganization.selectIndustry(web, map.get("Industry"));
	      createOrganization.selectType(web, map.get("Type"));
	      createOrganization.clickSaveButton(); 
	      soft.assertTrue(newOrganization.getPageHeader().contains(organizationName));    
	     newOrganization.clickOrganizationsLink();
	     soft.assertTrue(organization.getOrganization().equals(organizationName));
	     if(organization.getOrganization().equals(organizationName))
	    	excel.setDataToExcel("Create Organization With Industry And Type", "Pass", iConstantPath.EXCEL_FILE_PATH, "OrganizationTestData");
	     else
	    	 excel.setDataToExcel("Create Organization With Industry And Type", "Fail", iConstantPath.EXCEL_FILE_PATH, "OrganizationTestData");
	   
	     soft.assertAll();
	      
	}

}
