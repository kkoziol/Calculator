package pl.c2p.jft.kk.calc.controler;

import pl.c2p.jft.kk.calc.controler.states.State;
import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

import java.util.HashMap;

public class CalcController {
    CalcModel calcModel;
    CalcWindow calcWindow;
    HashMap<String, ClickableCommand> commands = new HashMap<>();
    HashMap<String, State> states = new HashMap<>();
    State state;


    public CalcController(CalcModel calcModel, CalcWindow calcWindow) {
        this.calcModel = calcModel;
        this.calcWindow = calcWindow;

        commands.put("", new CommandDoNothing(this));
        commands.put("!", new CommandNegate(this));
        commands.put(".", new CommandDecimalPoint(this));
        commands.put("0", new CommandDigit(this, "0"));
        commands.put("1", new CommandDigit(this, "1"));
        commands.put("2", new CommandDigit(this, "2"));
        commands.put("3", new CommandDigit(this, "3"));
        commands.put("4", new CommandDigit(this, "4"));
        commands.put("5", new CommandDigit(this, "5"));
        commands.put("6", new CommandDigit(this, "6"));
        commands.put("7", new CommandDigit(this, "7"));
        commands.put("8", new CommandDigit(this, "8"));
        commands.put("9", new CommandDigit(this, "9"));
        commands.put("+", new CommandAdd(this));
        commands.put("-", new CommandSubstract(this));
        commands.put("*", new CommandMultiply(this));
        commands.put("/", new CommandDivide(this));
        commands.put("=", new CommandEquals(this));
        commands.put("Clear", new CommandClear(this));
        commands.put("Delete", new CommandDelete(this));

        state = States.FirstEmpty.getInstance(this);


    }

    public void buttonPressed(String action) {
        state = state.doClick(action);
    }

    public HashMap<String, ClickableCommand> getAvailableCommands() {
        return  commands;
    }

    public State getState(States state) {
        return state.getInstance(this);
    }
}