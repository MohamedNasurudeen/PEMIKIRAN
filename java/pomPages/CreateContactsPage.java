package pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

/**
 * This Class contains all the elements,locators and respective business libraries of Create Contacts page
 * @author windows
 *
 */
public class CreateContactsPage {
	@FindBy (xpath="//span[@class='lvtHeaderText']") private WebElement pageHeader;
	@FindBy (name="salutationtype") private WebElement salutationDropDown;
	@FindBy (name="firstname") private WebElement firstNameTF;
	@FindBy (name="lastname") private WebElement lastNameTF;
	@FindBy(xpath = "//img[contains(@onclick,'Accounts&action')]") private WebElement organizationPlusButton;
	@FindBy(xpath = "//form[@name='selectall']/descendant::tr[contains(@onmouseout,'lvtColData')]/td[1]/a")
	private List<WebElement> organizationsList;
	@FindBy (xpath="//input[contains(@value,' Save ')]") private WebElement saveButton;
	
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	
	/**
	 * This method is used to fetch the create contacts page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to create contacts information
	 * @param web
	 * @param index
	 * @param firstName
	 * @param lastName
	 */
	public void contactinformation(WebDriverUtility web, String text, String firstName, String lastName) {
		web.dropdown(salutationDropDown, text);
		firstNameTF.sendKeys(firstName);
		lastNameTF.sendKeys(lastName);
	}
	
	/**
	 * This method is used to select required organization from the existing organizations list
	 * @param web
	 * @param orgName
	 */
	public void selectExistingOrganization(WebDriverUtility web, String orgName) {
		organizationPlusButton.click();
		String parentID = web.getParentWindowID();
		web.childBrowserPopup();
				
		for(WebElement org: organizationsList) {
			if(org.getText().equals(orgName)) {
				org.click();
				break;
			}
		}
		web.switchToWindow(parentID);
	}
	
	/**
	 * This method is used to Click on Save button
	 */
	public void clickSaveButton() {
		saveButton.click();
	}

}
