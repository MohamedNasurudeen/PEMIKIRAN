package vtiger;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.netty.util.internal.SystemPropertyUtil;
                                
public class QuickDropdown_Sce6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();
	      if(title.contains("vtiger"))
	    	  System.out.println("Login page should be Displayed-------Testcase Pass");
	      else
	    	  System.out.println("Login page should not be Displayed-------Testcase Fail");
	      
	      driver.findElement(By.name("user_name")).sendKeys("admin");
	      driver.findElement(By.name("user_password")).sendKeys("admin");
	      driver.findElement(By.id("submitButton")).submit();
	      
	      String homepageLable = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();      
	      if(homepageLable.contains("Home"))
	    	  System.out.println("Home page should be displayed--------Testcase Pass");
	      else
	    	  System.out.println("Home page should not be displayed-------Testcase Fail");
	      WebElement quickdropdown = driver.findElement(By.id("qccombo"));
	      quickdropdown.click();
	      Select selectdropdown = new Select(quickdropdown);
	      selectdropdown.selectByVisibleText("New Event");
	     Thread.sleep(2000);
	      String quickpage = driver.findElement(By.xpath("//td[@class='mailSubHeader']/b")).getText();
	      Thread.sleep(2000);
          if(quickpage.contains("Create To Do"))
        	  System.out.println("new event page should be display--------Testcase Pass");
          else
        	  System.out.println("new event page should not be display--------Testcase Fail");
          
          driver.findElement(By.name("subject")).sendKeys("Tech Vision1");
          driver.findElement(By.id("jscal_trigger_date_start")).click();
          String currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                     String[] str = currentMonthYear.split(",");
      int currentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
                       int currentYearInNum = Integer.parseInt(str[1].trim());
              int requiredYear = 2021;
              int requiredMonth = 11;
              int requiredDate = 24;
              while(currentYearInNum < requiredYear) {
            	  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='»']")).click();
            	   currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                   str = currentMonthYear.split(",");
                   currentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
                   currentYearInNum = Integer.parseInt(str[1].trim());
              if(currentYearInNum == requiredYear) {
            	  while(currentMonthInNum < requiredMonth) {
            		  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='›']")).click();
               	   currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                      str = currentMonthYear.split(",");
                      currentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
            	  }
            	  while(currentMonthInNum > requiredMonth) {
            		  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='‹']")).click();
                  	   currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                         str = currentMonthYear.split(",");
                         currentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);      	   
            	  }
              }                                         
              }
              while(currentYearInNum > requiredYear) {
            	  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='«']")).click();
            	   currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                   str = currentMonthYear.split(",");
                   currentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
                   currentYearInNum = Integer.parseInt(str[1].trim());
              if(currentYearInNum == requiredYear) {
            	  while(currentMonthInNum < requiredMonth) {
            		  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='›']")).click();
               	   currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                      str = currentMonthYear.split(",");
                      currentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
            	  }
            	  while(currentMonthInNum > requiredMonth) {
            		  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='‹']")).click();
                  	   currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                         str = currentMonthYear.split(",");
                         currentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);      	   
            	  }
              }                                         
              }
              driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[.='"+requiredDate+"']")).click();    
          WebElement status = driver.findElement(By.name("eventstatus"));
	      Select selectstatus = new Select(status);
	      selectstatus.selectByIndex(1);
	      WebElement activitytype = driver.findElement(By.name("activitytype"));
	      Select selectactivitytype = new Select(activitytype);
	      selectactivitytype.selectByIndex(1);
	      
	      driver.findElement(By.id("jscal_trigger_due_date")).click();
	      String endcurrentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
	             String[] str1 = endcurrentMonthYear.split(","); 
	             int endcurrentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0]).get(ChronoField.MONTH_OF_YEAR);
                 int endcurrentYearInNum = Integer.parseInt(str1[1].trim());
        int descYear = 2027;
        int descMonth = 05;
        int descDate = 04;
        while(endcurrentYearInNum < descYear) {
      	  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='»']")).click();
      	   endcurrentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
             str1 = endcurrentMonthYear.split(",");
             endcurrentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0]).get(ChronoField.MONTH_OF_YEAR);
             endcurrentYearInNum = Integer.parseInt(str1[1].trim());
        if(endcurrentYearInNum == descYear) {
      	  while(endcurrentMonthInNum < descMonth) {
      		  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='›']")).click();
         	   endcurrentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                str1 = endcurrentMonthYear.split(",");
                endcurrentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0]).get(ChronoField.MONTH_OF_YEAR);
      	  }
      	  while(endcurrentMonthInNum > descMonth) {
      		  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='‹']")).click();
            	   endcurrentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                   str1 = endcurrentMonthYear.split(",");
                   endcurrentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0]).get(ChronoField.MONTH_OF_YEAR);      	   
      	  }
        }                                         
        }
        while(endcurrentYearInNum > descYear) {
      	  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='«']")).click();
      	   endcurrentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
             str1 = endcurrentMonthYear.split(",");
             endcurrentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0]).get(ChronoField.MONTH_OF_YEAR);
             endcurrentYearInNum = Integer.parseInt(str1[1].trim());
        if(endcurrentYearInNum == descYear) {
      	  while(endcurrentMonthInNum < descMonth) {
      		  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='›']")).click();
         	   endcurrentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                str1 = endcurrentMonthYear.split(",");
                endcurrentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0]).get(ChronoField.MONTH_OF_YEAR);
      	  }
      	  while(endcurrentMonthInNum > descMonth) {
      		  driver.findElement(By.xpath("//div[@class='calendar'  and contains(@style,'block')]/descendant::td[.='‹']")).click();
            	   endcurrentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
                   str1 = endcurrentMonthYear.split(",");
                   endcurrentMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0]).get(ChronoField.MONTH_OF_YEAR);      	   
      	  }
        }                                         
        }
        driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[.='"+descDate+"']")).click();    
        driver.findElement(By.xpath("//input[contains(@value,' Save')]")).click();   
	    String quickinfo = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();  
	    if(quickinfo.contains("Vision1"))
	    	System.out.println("new quickcreate eventinfo page should be display----------Testcase Pass");
	    else
	    	System.out.println("new quickcreate eventinfo page should not be display----------Testcase Fail");
	    driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
	    driver.findElement(By.linkText("All Events & Todos")).click();
	    String neweventtable = driver.findElement(By.xpath("//div[@class='calDIV']/descendant::tr[last()]/td[4]/a")).getText();
	     if(neweventtable.equals("Tech Vision1"))
	    	 System.out.println("new created event name should be displayed------Testcase Pass");
	     else
	    	 System.out.println("new created event name should not be displayed------Testcase Fail");
	     WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     Actions action = new Actions(driver);
	     action.doubleClick(administratorIcon).perform();
	     driver.findElement(By.linkText("Sign Out")).click();
	     driver.quit();   
	}

}












