package pl.c2p.jft.kk.calc.controler;

public class StateSecondNegativeEmpty extends State {
    public StateSecondNegativeEmpty(CalcController controller) {
        super(controller);
        keyboard.put(".", commands.get(""));
        keyboard.put("0", commands.get("0"));
        keyboard.put("1", commands.get("1"));
        keyboard.put("2", commands.get("2"));
        keyboard.put("3", commands.get("3"));
        keyboard.put("4", commands.get("4"));
        keyboard.put("5", commands.get("5"));
        keyboard.put("6", commands.get("6"));
        keyboard.put("7", commands.get("7"));
        keyboard.put("8", commands.get("8"));
        keyboard.put("9", commands.get("9"));
        keyboard.put("+", commands.get(""));
        keyboard.put("-", commands.get(""));
        keyboard.put("*", commands.get(""));
        keyboard.put("/", commands.get(""));
        keyboard.put("=", commands.get(""));
        keyboard.put("Clear", commands.get("Clear"));
        keyboard.put("Delete", commands.get("Delete"));
    }

    @Override
    protected State stateAfterMinusClicked() {
        return this;
    }

    @Override
    protected State stateAfterDecimalClicked() {
        return this;
    }

    @Override
    protected State stateAfterPlusClicked() {
        return this;
    }

    @Override
    protected State stateAfterMultiplyClicked() {
        return this;
    }

    @Override
    protected State stateAfterDivideClicked() {
        return this;
    }

    @Override
    protected State stateAfterEqualClicked() {
        return this;
    }

    @Override
    protected State stateAfterClearClicked() {
        return calcController.getState(States.FirstEmpty);
    }

    @Override
    protected State stateAfterDeleteClicked() {
        return calcController.getState(States.SecondEmpty);
    }

    @Override
    protected State stateAfterDigitClicked() {
        return calcController.getState(States.SecondNegativeIntegral);
    }
}
