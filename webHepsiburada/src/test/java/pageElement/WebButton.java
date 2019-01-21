package pageElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import backend.WebAutomationException;
import org.openqa.selenium.WebElement;

public class WebButton extends PageElementModel {

    private static final Log log = LogFactory.getLog(WebButton.class);
    public WebButton(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public void click(){
        log.info("ABOUT TO CLICK BUTTON " + getLoggingName());
        WebElement me = getAnElement();
        try {
            me.click();
        } catch (Exception e) {
            String error = "COULD NOT CLICK BUTTON: " + getLoggingName();
            log.error(error);
            throw new WebAutomationException(error);
        }
    }
}
