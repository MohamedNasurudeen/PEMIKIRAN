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
import pomPages.CreateOrganizationPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.NewOrganizationInfoPage;
import pomPages.OrganizationPage;

public class CreateOrganizationIndustryTypeTestImplimentation {

	public static void main(String[] args) {
		PropertiesFileUtility property = new PropertiesFileUtility();
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
	    OrganizationPage organization = new OrganizationPage(driver);
	    CreateOrganizationPage createOrganization = new CreateOrganizationPage(driver);
	    NewOrganizationInfoPage newOrganizationinfo = new NewOrganizationInfoPage(driver);
	    
	    if(driver.getTitle().contains("vtiger"))
	    	  System.out.println("Login page should be Displayed------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed------Testcase Fail");    
	      login.loginToApp(property.fetchproperty("username"), property.fetchproperty("password"));
        
	      if(driver.getTitle().contains("Home"))
	    	  System.out.println("Home page should be displayed----------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed----------Testcase Fail");
	    
	      home.clickOrganizations();
	      
	      if(driver.getTitle().contains("Organizations"))
	    	  System.out.println("organization page should be dispalyed-------Testcase Pass");
	      else
	    	  System.out.println("organization page should not be displayed-------Testcase Fail");
	  
	      organization.clickPlusButton();
	      if(createOrganization.getPageHeader().contains("Creating New Organization"))
	    	  System.out.println("create new organization page should be displayed------------Testcase Pass");
	      else
	    	  System.out.println("create new organization page should not be displayed----------Testcase Fail");

	      Map<String, String> map = excel.readDataFromExcel("Create Organization", "TestData");
	      String organizationName = map.get("Organization Name")+ javaUtil.generateRandomNumber(100);        
	      createOrganization.setOrganizationName(organizationName);
	      createOrganization.selectIndustry(web, map.get("Industry"));
	      createOrganization.selectType(web, map.get("Type"));
	      createOrganization.clickSaveButton();      
	      if(newOrganizationinfo.getPageHeader().contains(organizationName))
	    	   System.out.println("New organization information page should be display-------Testcase Pass");
	       else
	    	   System.out.println("New organization information page should not be display------Testcase Fail");
	    newOrganizationinfo.clickOrganizationsLink();
	     if(organization.getOrganization().equals(organizationName))
	    	 System.out.println("new created organization name list should be displayed------Testcase Pass ");
	     else
	    	 System.out.println("new created organization name list should not be displayed---------Testcase Fail");
	   
	     home.signOutOfApp(web);
	    web.closeWindows();
	    excel.closeWorkbook();
	      
	}

}
