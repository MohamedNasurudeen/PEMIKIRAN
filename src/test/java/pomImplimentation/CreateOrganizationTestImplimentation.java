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

public class CreateOrganizationTestImplimentation {

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
	    NewOrganizationInfoPage newOrganization = new NewOrganizationInfoPage(driver);
	    
	   // String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
	      if(driver.getTitle().contains("vtiger"))
	    	  System.out.println("Login page should be Displayed------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed------Testcase Fail");    
	      login.loginToApp(property.fetchproperty("username"), property.fetchproperty("password"));
	      
//	      driver.findElement(By.name("user_name")).sendKeys(property.fetchproperty("username"));
//	      driver.findElement(By.name("user_password")).sendKeys(property.fetchproperty("password"));
//	      driver.findElement(By.id("submitButton")).click();
	      
//	      String homepageLable = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();      
	   
	      if(driver.getTitle().contains("Home"))
	    	  System.out.println("Home page should be displayed----------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed----------Testcase Fail");
	    
	      home.clickOrganizations();
//	      driver.findElement(By.linkText("Organizations")).click();
//	      String organizationLabel = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	
	      if(driver.getTitle().contains("Organizations"))
	    	  System.out.println("organization page should be dispalyed-------Testcase Pass");
	      else
	    	  System.out.println("organization page should not be displayed-------Testcase Fail");
	  
	      organization.clickPlusButton();
//	      driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//	      String createNeweorganizationPageHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	 
	      if(createOrganization.getPageHeader().contains("Creating New Organization"))
	    	  System.out.println("create new organization page should be displayed------------Testcase Pass");
	      else
	    	  System.out.println("create new organization page should not be displayed----------Testcase Fail");
	      
	      String organizationName = excel.readDataFromExcel("TestData", 1, 3) + javaUtil.generateRandomNumber(100);
//	        Map<String, String> map = excel.readDataFromExcel("Create Organization", "TestData");
//	        String organizationName = map.get("Organization Name")+ javaUtil.generateRandomNumber(100);    
	    
	      createOrganization.setOrganizationName(organizationName);
//	      driver.findElement(By.name("accountname")).sendKeys(organizationName);
	    
	      createOrganization.clickSaveButton();
//	        driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
//	        String organizationinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	      
	        if(newOrganization.getPageHeader().contains(organizationName))
	     	   System.out.println("New organization information should be display--------Testcase Pass");
	        else
	     	   System.out.println("New organization information should not be display-------Testcase Fail");
	 
	        newOrganization.clickOrganizationsLink();
//	 	    driver.findElement(By.xpath("//a[@class='hdrLink']")).click();        
//	      String neworgtable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
	 	 
	      if(organization.getOrganization().equals(organizationName))
	 	    	 System.out.println("new created organization name list should be displayed-------Testcase Pass ");
	 	     else
	 	    	 System.out.println("new created organization name list should not be displayed------Testcase Fail");
	 
	      home.signOutOfApp(web);
//	 	     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	         web.mouseHover(administratorIcon);
//	         driver.findElement(By.xpath("//a[.='Sign Out']")).click();
             web.closeWindows();
	         excel.closeWorkbook();  
	}

}
