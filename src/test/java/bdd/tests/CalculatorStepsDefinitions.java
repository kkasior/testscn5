package bdd.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class CalculatorStepsDefinitions {

    Calculator calculator;
    Integer resultFromCalculator;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }
    @When("I add {int} and {int}")
    public void i_add_and(Integer a, Integer b) {
        resultFromCalculator = calculator.addTwoNumbers(a,b);
    }
    @When("I subtract {int} from {int}")
    public void i_subtract_from(Integer a, Integer b) {
        resultFromCalculator = calculator.subtractTwoNumbers(a,b);
    }
    @Then("I should get {int}")
    public void i_should_get(Integer resultFromScenario) {
        assertEquals(resultFromScenario,resultFromCalculator);
    }
}
