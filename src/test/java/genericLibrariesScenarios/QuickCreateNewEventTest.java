package genericLibrariesScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import genericLibraries.ExcelFileUtility;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;
import genericLibraries.iConstantPath;

public class QuickCreateNewEventTest {
	
	public static void main(String[] args) {
		
		 PropertiesFileUtility property = new PropertiesFileUtility();
		 ExcelFileUtility excel = new ExcelFileUtility();
		 JavaUtility javaUtil = new JavaUtility();
		 WebDriverUtility web = new WebDriverUtility();
		 property.propertyFileInitialization(iConstantPath.PROPERTY_FILE_PATH);
		 excel.excelFileInitialization(iConstantPath.EXCEL_FILE_PATH);
		 long time = Long.parseLong(property.fetchproperty("timeouts"));
	     WebDriver driver = web.openApplication(property.fetchproperty("browser"),property.fetchproperty("url"), time);
	     if(driver.getTitle().contains("vtiger"))
	    	  System.out.println("Login page should be Displayed-------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed-------Testcase Fail");
	      driver.findElement(By.name("user_name")).sendKeys(property.fetchproperty("usernam"));
	      driver.findElement(By.name("user_password")).sendKeys(property.fetchproperty("password"));
	      driver.findElement(By.id("submitButton")).click();
	      if(driver.getTitle().contains("Home"))
	    	  System.out.println("Home page should be displayed--------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed-------Testcase Fail");
	      
		
		
		
		
		
	}
	

}
