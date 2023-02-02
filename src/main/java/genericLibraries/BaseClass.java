package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomPages.ContactPage;
import pomPages.CreateContactsPage;
import pomPages.CreateLeadsPage;
import pomPages.CreateOrganizationPage;
import pomPages.HomePage;
import pomPages.LeadPage;
import pomPages.LoginPage;
import pomPages.NewContactInfoPage;
import pomPages.NewLeadInfoPage;
import pomPages.NewOrganizationInfoPage;
import pomPages.OrganizationPage;

public class BaseClass {
	protected PropertiesFileUtility property;
	protected ExcelFileUtility excel;
	protected JavaUtility javaUtil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected LoginPage login;
	protected HomePage home;
	protected OrganizationPage organization;
	protected CreateOrganizationPage createOrganization;
	protected NewOrganizationInfoPage newOrganization;
	protected ContactPage contact;
	protected CreateContactsPage createContact;
	protected NewContactInfoPage newContactinfo;
	protected LeadPage lead;
	protected CreateLeadsPage createLead;
	protected NewLeadInfoPage newLeadInfo;
	
		
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
         public void classSetup() {
		 property = new PropertiesFileUtility();
		 excel = new ExcelFileUtility();
		 javaUtil = new JavaUtility();
		 web = new WebDriverUtility();
		
		property.propertyFileInitialization(iConstantPath.PROPERTY_FILE_PATH);
		excel.excelFileInitialization(iConstantPath.EXCEL_FILE_PATH);
	}
	
	
	
	@BeforeMethod
	   public void methodSetup() {
		String browser = property.fetchproperty("browser");
	    String url = property.fetchproperty("url");
	    long time = Long.parseLong(property.fetchproperty("timeouts"));	
	    WebDriver driver = web.openApplication(browser, url, time);
	    Assert.assertTrue(driver.getTitle().contains("vtiger"));
	    
	    login = new LoginPage(driver);
	    login.loginToApp(property.fetchproperty("username"), property.fetchproperty("password"));
        Assert.assertTrue(driver.getTitle().contains("Home"));
        
        home = new HomePage(driver);
	    organization = new OrganizationPage(driver);
	    createOrganization = new CreateOrganizationPage(driver);
	    newOrganization = new NewOrganizationInfoPage(driver);
	    contact = new ContactPage(driver);
	    createContact = new CreateContactsPage(driver);
	    newContactinfo = new NewContactInfoPage(driver); 
	    lead = new LeadPage(driver);
	    createLead = new CreateLeadsPage(driver);
	    newLeadInfo = new NewLeadInfoPage(driver);
        
	}
	@AfterMethod
	public void methodTeardown() {
		 home.signOutOfApp(web);
		 web.closeWindows();
	}
	@AfterClass
	public void classTeardown() {
		excel.closeWorkbook();
	}
	
	
	//@AfterTest
	//@AfterSuite
	

}
