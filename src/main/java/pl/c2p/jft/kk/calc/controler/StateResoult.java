package pl.c2p.jft.kk.calc.controler;

public class StateResoult extends State {

    public StateResoult(CalcController controller) {
        super(controller);
        keyboard.put(".", commands.get(""));
        keyboard.put("0", commands.get("c0"));
        keyboard.put("1", commands.get("c1"));
        keyboard.put("2", commands.get("c2"));
        keyboard.put("3", commands.get("c3"));
        keyboard.put("4", commands.get("c4"));
        keyboard.put("5", commands.get("c5"));
        keyboard.put("6", commands.get("c6"));
        keyboard.put("7", commands.get("c7"));
        keyboard.put("8", commands.get("c8"));
        keyboard.put("9", commands.get("c9"));
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
        return calcController.getState(States.FirstIntegral);
    }
}
