package pl.c2p.jft.kk.calc.controler;

import java.util.HashMap;

public abstract class State {
    CalcController calcController;

    HashMap<String, ClickableCommand> keyboard = new HashMap<>();
    HashMap<String, ClickableCommand> commands;

    public State(CalcController calcController) {
        this.calcController = calcController;

        commands = calcController.getAvailableCommands();

        //initialize here state keyboard in subclasses
    }

    public State doClick(String action) {
        System.out.println(this.getClass());
        ClickableCommand command = keyboard.get(action);
        if (command != null) {
            command.doClick();
            switch (action) {
                case "-":
                    return stateAfterMinusClicked();
                case ".":
                    return stateAfterDecimalClicked();
                case "+":
                    return stateAfterPlusClicked();
                case "*":
                    return stateAfterMultiplyClicked();
                case "/":
                    return stateAfterDivideClicked();
                case "=":
                    return stateAfterEqualClicked();
                case "Clear":
                    return stateAfterClearClicked();
                case "Delete":
                    return stateAfterDeleteClicked();
                default:
                    return stateAfterDigitClicked();
            }
        } else {
            //Aktualnie to jest nie osiagalne, musial bybyc blad w programie...
            return this;
        }
    }

    protected abstract State stateAfterMinusClicked();

    protected abstract State stateAfterDecimalClicked();

    protected abstract State stateAfterPlusClicked();

    protected abstract State stateAfterMultiplyClicked();

    protected abstract State stateAfterDivideClicked();

    protected abstract State stateAfterEqualClicked();

    protected abstract State stateAfterClearClicked();

    protected abstract State stateAfterDeleteClicked();

    protected abstract State stateAfterDigitClicked();
}
