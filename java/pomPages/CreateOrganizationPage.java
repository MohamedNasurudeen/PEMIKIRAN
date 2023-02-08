package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

/**
 * This Class contains all the elements,locators and respective business libraries of Create Organization page
 * @author S.MD.Nasurudeen
 *
 */
public class CreateOrganizationPage {
	@FindBy (xpath="//span[@class='lvtHeaderText']") private WebElement pageHeader;
	@FindBy (name="accountname") private WebElement organizationNameTF;
	@FindBy (name="industry") private WebElement industryDropDown;
	@FindBy (name="accounttype") private WebElement typeDropDown;
	@FindBy (xpath="//input[contains(@value,' Save ')]") private WebElement saveButton;
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to fetch the create organizations page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to set the organization name in text field
	 * @param name
	 */
	public void setOrganizationName(String name) {
		organizationNameTF.sendKeys(name);
	}
	
	/**
	 * This method is used to choose the industry from industry drop down 
	 * @param web
	 * @param text
	 */
	public void selectIndustry(WebDriverUtility web, String text) {
		web.dropdown(text, industryDropDown);
	}
	
	/**
	 * This method is used to choose the investor type from type drop down
	 * @param web
	 * @param text
	 */
	public void selectType(WebDriverUtility web, String text) {
		web.dropdown(text, typeDropDown);
	}
	
	/**
	 * This method is used to Click on Save button 
	 */
	public void clickSaveButton() {
		saveButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
