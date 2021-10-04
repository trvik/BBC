package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends BasePage{

    @FindBy(xpath = "//textarea[@placeholder='Tell us your story. ']")
    private WebElement storyField;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//p[text()='I accept the ']/../../../input")
    private WebElement acceptButton;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[text()=' must be accepted']")
    private WebElement mustBeAcceptedMessage;

    @FindBy(xpath = "//div[contains(text(),'t be blank')]")
    private WebElement cantBeBlankMessage;

    public FormPage(WebDriver driver) {super(driver);}

    public void fillInForm(String story, String name, String accept) {
        waitVisibilityOfElement(5,storyField).sendKeys(story);
        waitVisibilityOfElement(5,nameField).sendKeys(name);
        if (accept.equals("yes")) acceptButton.click();
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public boolean isMistakeMessageDisplayed(String acceptRadioButton){
        if(acceptRadioButton.equals("no"))
            return waitVisibilityOfElement(3, mustBeAcceptedMessage).isDisplayed();
        else if (acceptRadioButton.equals("yes"))
            return waitVisibilityOfElement(3, cantBeBlankMessage).isDisplayed();
        return false;
    }
}

