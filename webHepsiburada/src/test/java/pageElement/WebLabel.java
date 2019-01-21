package pageElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;

public class WebLabel extends PageElementModel {
    private static final Log log = LogFactory.getLog(WebButton.class);
    public WebLabel(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public String getElementText(){
        log.info("Getting elements's text :" + getLoggingName());
        String elementText = "";
        WebElement me = getAnElement();
        elementText = me.getText();
        return  elementText;
    }
}
