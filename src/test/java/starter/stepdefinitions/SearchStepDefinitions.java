package starter.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.model.util.EnvironmentVariables;
import starter.authentication.ApplicationPage;
import starter.authentication.ErrorMessages;
import starter.authentication.Login;
import starter.model.Customer;
import starter.model.UserCredentials;
import starter.navigation.NavigateTo;

import java.util.Map;

public class SearchStepDefinitions {

    @DataTableType
    public UserCredentials userCredentials(Map<String, String> entry) {
        return new UserCredentials(entry.get("username"), entry.get("password"));
    }

    EnvironmentVariables environmentVariables;
    @Given("{actor} is on the login page")
    public void onTheLoginPage(Actor actor) {
        System.out.println("RUNNING ON THREAD " + Thread.currentThread());
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} logs in with valid credentials")
    public void logsInWithValidCredentials(Actor actor) {
        Customer customer = Customer.valueOf(actor.getName());
        actor.attemptsTo(
                Login.withCredentials(customer.getUsername(), customer.getPassword())
        );
    }

    @Then("{actor} should see their name logged {string} and the product catalog")
    public void shouldBeOnHomePage(Actor actor, String name) {
        actor.attemptsTo(
                Ensure.that(Text.of(ApplicationPage.NAME_HEADER)).isEqualTo(name)
        );
    }


    @When("{actor} attempts to login with the following credentials:")
    public void attemptsToLoginWithTheFollowingCredentials(Actor actor, UserCredentials userCredentials) {
        actor.attemptsTo(
                Login.withCredentials(userCredentials.username(), userCredentials.password())
        );
    }

    @Then("{actor} should be presented with the error message {}")
    public void heShouldBePresentedWithTheErrorMessageMessage(Actor actor, String errorMessage) {
        actor.attemptsTo(
                Ensure.that(Text.of(ErrorMessages.CURRENTLY_VISIBLE)).contains(errorMessage)
        );
    }

}
