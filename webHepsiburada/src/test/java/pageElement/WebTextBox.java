package pageElement;

import backend.WebAutomationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;

public class WebTextBox extends PageElementModel{
    private static final Log log = LogFactory.getLog(WebTextBox.class);
    public WebTextBox(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public void type(String inputText){
        log.info("ABOUT TO TYPE TEXTBOX " + getLoggingName());
        WebElement me = getAnElement();
        try {
            me.sendKeys(inputText);
        } catch (Exception e) {
            String error = "COULD NOT TYPE TEXTBOX: " + getLoggingName() + " TEXT IS: " + inputText;
            log.error(error);
            throw new WebAutomationException(error);
        }
    }

    public void clearText(){
        log.info("ABOUT TO CLEAR TEXTBOX " + getLoggingName());
        WebElement me = getAnElement();
        me.clear();
    }
}
