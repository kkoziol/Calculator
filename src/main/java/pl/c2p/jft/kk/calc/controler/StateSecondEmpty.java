package pl.c2p.jft.kk.calc.controler;

public class StateSecondEmpty extends State {
    public StateSecondEmpty(CalcController controller) {
        super(controller);
        keyboard.put(".", commands.get(""));
        keyboard.put("0", commands.get("r0"));
        keyboard.put("1", commands.get("r1"));
        keyboard.put("2", commands.get("r2"));
        keyboard.put("3", commands.get("r3"));
        keyboard.put("4", commands.get("r4"));
        keyboard.put("5", commands.get("r5"));
        keyboard.put("6", commands.get("r6"));
        keyboard.put("7", commands.get("r7"));
        keyboard.put("8", commands.get("r8"));
        keyboard.put("9", commands.get("r9"));
        keyboard.put("+", commands.get(""));
        keyboard.put("-", commands.get("!"));
        keyboard.put("*", commands.get(""));
        keyboard.put("/", commands.get(""));
        keyboard.put("=", commands.get(""));
        keyboard.put("Clear", commands.get("Clear"));
        keyboard.put("Delete", commands.get(""));
    }

    @Override
    protected State stateAfterMinusClicked() {
        return calcController.getState(States.SecondNegativeEmpty);
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
        return this;
    }

    @Override
    protected State stateAfterDigitClicked() {
        return calcController.getState(States.SecondIntegral);
    }
}
