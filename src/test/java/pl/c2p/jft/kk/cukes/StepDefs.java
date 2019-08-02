package pl.c2p.jft.kk.cukes;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pl.c2p.jft.kk.calc.controler.CalcController;
import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

import static org.assertj.core.api.Assertions.assertThat;


public class StepDefs {

    private CalcModel calcModel;
    private CalcWindow calcWindow;
    private CalcController calcController;

    public StepDefs() {
    }

    @Given("^I Just switch on my calculator$")
    public void iJustSwithOnMyCalculator() {
        calcModel = new CalcModel();
        calcWindow = new CalcWindow();
        calcController = new CalcController(calcModel, calcWindow);
        calcWindow.registerObserver(calcController);
    }

    @When("^I click button (\\d)$")
    public void i_click_button(int digit) {
        calcController.buttonPressed("" + digit);
    }

    @And("^I click button ([\\-+*/])$")
    public void iClickOperationButton(String operation) {
        calcController.buttonPressed("" + operation);
    }

    @And("^I click button (=)$")
    public void iClickEqualsButton(String operation) {
        calcController.buttonPressed("" + operation);
    }

    @When("^I should see on display number (\\d+\\.\\d+)$")
    public void iShouldSeeOnDisplayNumber(String result){
        String display = calcWindow.readDisplay();
        assertThat(display).isEqualTo(result);
    }

}
