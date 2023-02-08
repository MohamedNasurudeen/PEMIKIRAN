package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This Class contains all the elements,locators and respective business libraries of Lead page
 * @author windows
 *
 */
public class LeadPage {
      @FindBy (xpath="//img[@alt='Create Lead...']") private WebElement plusButton;
      @FindBy (xpath="//table[@class='lvt small']/descendant::tr[last()]/td[3]/a") private WebElement leadtable;
      
      
      public LeadPage(WebDriver driver) {
    	  PageFactory.initElements(driver, this);
      }
	
      /**
       * This method is used to click on plus button to create new Lead
       */
      public void clickPlusButton() {
    	  plusButton.click();
      }
      
      /**
       * This method is used to fetch the new lead table
       * @return
       */
      public String getLead() {
    	  return leadtable.getText();
      }
	
	
	
}
