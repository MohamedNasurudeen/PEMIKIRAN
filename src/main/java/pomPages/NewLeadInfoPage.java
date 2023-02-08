package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the elements,locators and respective business libraries of New Leads Info Page
 * @author windows
 *
 */
public class NewLeadInfoPage {
	@FindBy (xpath="//span[@class='dvHeaderText']") private WebElement pageHeader;
	@FindBy (xpath="(//input[@title='Duplicate [Alt+U]'])[1]") private WebElement duplicateButton;
	@FindBy (xpath="//a[@class='hdrLink']") private WebElement leadsLink;
	
	public NewLeadInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * This method is used to fetch the new lead info page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * This method is used to Click on Duplicate button
	 */
	public void clickDuplicateButton() {
		duplicateButton.click();
	}
	
	/**
	 * This method is used to click on leads link
	 */
	public void clickLeadsLink() {
		leadsLink.click();
	}

}
