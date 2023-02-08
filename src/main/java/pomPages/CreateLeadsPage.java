package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

/**
 * This Class contains all the elements,locators and respective business libraries of Create leads page
 * @author windows
 *
 */
public class CreateLeadsPage {
	@FindBy (xpath="//span[@class='lvtHeaderText']") private WebElement pageHeader;
	@FindBy (name="salutationtype") private WebElement salutationDropDown;
	@FindBy (name="firstname") private WebElement firstNameTF;
	@FindBy (name="lastname") private WebElement lastNameTF;
	@FindBy (name="company") private WebElement companyTF;
	@FindBy (xpath="//input[contains(@value,' Save ')]") private WebElement saveButton;
	
	
	public CreateLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to fetch the create lead page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to create lead information
	 * @param web
	 * @param index
	 * @param firstName
	 * @param lastName
	 * @param companyName
	 */
	public void leadInformation(WebDriverUtility web, String text, String firstName, String lastName, String companyName) {
		web.dropdown(salutationDropDown, text);
		firstNameTF.sendKeys(firstName);
		lastNameTF.sendKeys(lastName);
		companyTF.sendKeys(companyName);
	}

	public void enterLastNameTF(String lastName) {
		lastNameTF.clear();
		lastNameTF.sendKeys(lastName);
		
	}
	
	/**
	 * This method is used to Click on Save button
	 */
	public void clickSaveButton() {
		saveButton.click();
	}
}
