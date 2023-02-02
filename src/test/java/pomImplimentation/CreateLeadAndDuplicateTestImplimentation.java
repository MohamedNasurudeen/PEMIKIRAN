package pomImplimentation;

import java.util.Map;

import org.openqa.selenium.WebDriver;

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

public class CreateLeadAndDuplicateTestImplimentation {

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
		 LeadPage lead = new LeadPage(driver);
		 CreateLeadsPage createLead = new CreateLeadsPage(driver);
		 NewLeadInfoPage newLeadInfo = new NewLeadInfoPage(driver);
		 
		 if(driver.getTitle().contains("vtiger"))
	    	  System.out.println("Login page should be Displayed-------Testcase Pass");
	      else
	          System.out.println("Leads page should not be displayed----------Testcase Fail");
		  login.loginToApp(property.fetchproperty("username"), property.fetchproperty("password"));	           
	      if(driver.getTitle().contains("Home"))
	    	  System.out.println("Home page should be displayed--------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed-------Testcase Fail");
	      home.clickLeads();
	      if(driver.getTitle().contains("Leads"))
	    	  System.out.println("Leads page should be dispalyed------------Testcase Pass");
	      else
	    	  System.out.println("Leads page should not be displayed----------Testcase Fail");
	      lead.clickPlusButton();	      
	      if(createLead.getPageHeader().contains("New Lead"))
	    	  System.out.println("create new Leads page should be displayed----------Testcase Pass");
	      else
	    	  System.out.println("create new Leads page should not be displayed---------Testcase Fail");
	      
	      Map<String, String> map = excel.readDataFromExcel("Cread Lead", "TestData");
	      String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
	      createLead.leadInformation(web, map.get("Salutation"), map.get("First Name"), lastName, map.get("Company"));
	      createLead.clickSaveButton();      
	      if(newLeadInfo.getPageHeader().contains(lastName))
	    	   System.out.println("New Lead information page should be display-------Testcase Pass");
	       else
	    	   System.out.println("New Lead information page should not be display-------Testcase Fail");
	     newLeadInfo.clickDuplicateButton();	     
	     if(createLead.getPageHeader().contains(lastName))
			   System.out.println("Duplicating leads page should be open--------Testcase Pass");
		   else
			   System.out.println("Duplicating leads page should not be open--------Testcase Fail");
	     String newLastName=map.get("New Last Name")+javaUtil.generateRandomNumber(100);
	     createLead.enterLastNameTF(newLastName);
	     createLead.clickSaveButton();
	     
	     if(newLeadInfo.getPageHeader().contains(newLastName))
	    	   System.out.println("Duplicate Lead information page should be display-------Testcase Pass");
	       else
	    	   System.out.println("Duplicate Lead information page should not be display-------Testcase Fail");
	       newLeadInfo.clickLeadsLink();	       
	       if(lead.getLead().equals(newLastName))
		    	 System.out.println("new created leads name list should be displayed---------Testcase Pass ");
		    else
		    	 System.out.println("new created leads name list should not be displayed-----------Testcase Fail");
	       home.signOutOfApp(web);
	       web.closeWindows();
	       excel.closeWorkbook();
	
	}

}
