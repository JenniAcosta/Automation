package starter.authentication;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.PageElement;
import org.openqa.selenium.By;

public class ErrorMessages {
//    public static Target CURRENTLY_VISIBLEE = PageElement.located(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
    public static Target CURRENTLY_VISIBLE = Target.the("error message")
            .locatedBy("//p[contains(text(),'Your email or password is incorrect!')]");
}