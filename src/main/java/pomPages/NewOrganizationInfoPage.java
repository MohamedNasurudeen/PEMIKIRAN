package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class contains all the elements,locators and respective business libraries of New Organization Info Page
 * @author windows
 *
 */
public class NewOrganizationInfoPage {
	@FindBy (xpath="//span[@class='dvHeaderText']") private WebElement pageHeader;
	@FindBy (xpath="//a[@class='hdrLink']") private WebElement organizationsLink;
	

	public NewOrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 *This method is used to fetch the new organization info page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 *This method is used to click on organization link
	 */
	public void clickOrganizationsLink() {
		organizationsLink.click();
	}
}
