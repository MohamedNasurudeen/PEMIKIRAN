package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

/**
 * This Class contains all the elements,locators and respective business libraries of Home Page
 * @author S.MD.Nasurudeen
 *
 */
public class HomePage {
	

	@FindBy (xpath = "//a[text()='Organizations']") private WebElement organizationsTab;
	@FindBy (linkText="Contacts") private WebElement contactsTab;
	@FindBy (linkText="Leads") private WebElement leadsTab;
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement administratorIcon;
	@FindBy (linkText="Sign Out") private WebElement signOutButton;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	/**
	 * This method is used to click organizations tab
	 */
	public void clickOrganizations() {
		organizationsTab.click();
	}
	
	/**
	 * This method is used to click contacts tab
	 */
	public void clickContacts() {
		contactsTab.click();
	}
	
	/**
	 * This method is used to click leads tab
	 */
	public void clickLeads() {
		leadsTab.click();
	}
	
	/**
	 * This method is used to sign out of the application
	 * @param web
	 */
	public void signOutOfApp(WebDriverUtility web) {
		web.mouseHover(administratorIcon);
		signOutButton.click();
	}

}
