package pl.c2p.jft.kk.calc.controler;

public class StateTemporaryResoult extends State {

    public StateTemporaryResoult(CalcController controller) {
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
        keyboard.put("+", commands.get("+"));
        keyboard.put("-", commands.get("-"));
        keyboard.put("*", commands.get("*"));
        keyboard.put("/", commands.get("/"));
        keyboard.put("=", commands.get(""));
        keyboard.put("Clear", commands.get("Clear"));
        keyboard.put("Delete", commands.get("Clear"));
    }

    @Override
    protected State stateAfterMinusClicked() {
        return calcController.getState(States.SecondEmpty);
    }

    @Override
    protected State stateAfterDecimalClicked() {
        return this;
    }

    @Override
    protected State stateAfterPlusClicked() {
        return calcController.getState(States.SecondEmpty);
    }

    @Override
    protected State stateAfterMultiplyClicked() {
        return calcController.getState(States.SecondEmpty);
    }

    @Override
    protected State stateAfterDivideClicked() {
        return calcController.getState(States.SecondEmpty);
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
        return calcController.getState(States.FirstEmpty);
    }

    @Override
    protected State stateAfterDigitClicked() {
            return calcController.getState(States.SecondIntegral);
    }
}
