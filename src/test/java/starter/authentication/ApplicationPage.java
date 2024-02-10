package starter.authentication;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.PageElement;
import org.openqa.selenium.By;

public class ApplicationPage {
    public static Target NAME_HEADER = PageElement.located(By.xpath("//b[contains(text(),'Jennifer')]"));

}
