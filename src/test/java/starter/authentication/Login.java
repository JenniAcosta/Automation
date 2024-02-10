package starter.authentication;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import org.openqa.selenium.By;


public class Login {
    public static Performable withCredentials(String username, String password) {
        return Task.called("{0} logs in with username " + username + " and password " + password)
                .whereTheActorAttemptsTo(
                        Click.on(By.linkText("Signup / Login")),
                        Enter.theValue(username).into(InputField.withNameOrId("email")),
                        Enter.theValue(password).into(InputField.withNameOrId("password")),
                        Click.on(Button.withText("Login"))
                );
    }

}
