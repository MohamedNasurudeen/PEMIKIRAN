package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This Class contains all the elements,locators and respective business libraries of Organization page
 * @author windows
 *
 */
public class OrganizationPage {
	@FindBy (xpath="//a[@class='hdrLink']") private WebElement pageheader;
    @FindBy (xpath="//img[@alt='Create Organization...']") private WebElement plusButton;
    @FindBy (xpath="//table[@class='lvt small']/descendant::tr[last()]/td[3]/a") private WebElement organizationtable;
	@FindBy (xpath="(//img)[43]") private WebElement lastPage;
    public OrganizationPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
	
    /**
     * This method is used to fetch the organization page header
     * @return
     */
    public String getPageHeader() {
    	return pageheader.getText();
    }
    /**
     * This method is used to click on plus button to create new organization
     */
    public void clickPlusButton() {
    	plusButton.click();
    }
    
    /**
     * This method is used to fetch the new organization table
     * @return
     */
    public String getOrganization() {
    	return organizationtable.getText();
    }
	
    /**
     * This method is used to last page of the table
     */
	public void clickLastPage() {
		lastPage.click();
	}
	
	
	
	
}
