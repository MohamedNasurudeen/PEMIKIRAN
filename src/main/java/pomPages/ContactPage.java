package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This Class contains all the elements,locators and respective business libraries of Contact page
 * @author windows
 *
 */
public class ContactPage {
	@FindBy (xpath="//img[@alt='Create Contact...']") private WebElement plusButton;
	@FindBy (xpath="//table[@class='lvt small']/descendant::tr[last()]/td[4]/a") private WebElement contacttable;
	@FindBy (xpath="//a[@class='hdrLink']") private WebElement pageHeader;
	@FindBy (xpath="(//img)[43]") private WebElement lastPage;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to fetch the contact page header
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	/**
	 * This method is used to click on plus button to create new contact
	 */
	public void clickPlusButton() {
		plusButton.click();
	}
	
	/**
	 * This method is used to fetch the new contact table
	 * @return
	 */
	public String getContact() {
		return contacttable.getText();
	}
	
	/**
     * This method is used to last page of the table
     */
	public void clickLastPage() {
		lastPage.click();
	}
	
	
	

}
