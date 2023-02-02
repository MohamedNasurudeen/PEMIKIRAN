package genericLibrariesScenarios;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericLibraries.ExcelFileUtility;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;
import genericLibraries.iConstantPath;

public class CreateOrganizationIndustryTypeTest {

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
	    String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
	      if(title.contains("vtiger"))
	    	  System.out.println("Login page should be Displayed----------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed------------Testcase Fail");
	      
	      driver.findElement(By.name("user_name")).sendKeys(property.fetchproperty("username"));
	      driver.findElement(By.name("user_password")).sendKeys(property.fetchproperty("password"));
	      driver.findElement(By.id("submitButton")).click();
	      String homepageLable = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();      
	      if(homepageLable.contains("Home"))
	    	  System.out.println("Home page should be displayed----------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed----------Testcase Fail");
	    
	      driver.findElement(By.linkText("Organizations")).click();
	      String organizationLabel = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	      if(organizationLabel.contains("Organizations"))
	    	  System.out.println("organization page should be dispalyed---------Testcase Pass");
	      else
	    	  System.out.println("organization page should not be displayed --------Testcase Fail");
	      driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	      String createNeworganizationPageHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	      if(createNeworganizationPageHeader.contains("Creating New Organization"))
	    	  System.out.println("create new organization page should be displayed----------Testcase Pass");
	      else
	    	  System.out.println("create new organization page should not be displayed-------Testcase Fail");
          
	        Map<String, String> map = excel.readDataFromExcel("Create Organization", "TestData");
            String organizationName = map.get("Organization Name")+javaUtil.generateRandomNumber(100); 
            driver.findElement(By.name("accountname")).sendKeys(organizationName);
            WebElement industrydropdown = driver.findElement(By.name("industry"));
            web.dropdown(map.get("Industry"), industrydropdown);            
            WebElement typedropdown = driver.findElement(By.name("accounttype"));
            web.dropdown(map.get("Type"), typedropdown);
  
            driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
 	       String organizationinfoPageHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
 	       if(organizationinfoPageHeader.contains(organizationName))
 	    	   System.out.println("New organization information page should be display-------Testcase Pass");
 	       else
 	    	   System.out.println("New organization information page should not be display------Testcase Fail");
 		
 		    driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
 		    String neworgtable = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
 		     if(neworgtable.equals(organizationName))
 		    	 System.out.println("new created organization name list should be displayed------Testcase Pass ");
 		     else
 		    	 System.out.println("new created organization name list should not be displayed---------Testcase Fail");
 		     
 		     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 		     web.mouseHover(administratorIcon);
 		    driver.findElement(By.linkText("Sign Out")).click();
 		    web.closeWindows();
 		    excel.closeWorkbook();
            
	}

}
