package pl.c2p.jft.kk.calc.controler;

import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

import java.util.HashMap;

public class CalcController {
    CalcModel calcModel;
    CalcWindow calcWindow;

    //    HashMap<String, ClickableCommand> commands = new HashMap<>();
    HashMap<String, ClickableCommand> keyboard = new HashMap<>();


    public CalcController(CalcModel calcModel, CalcWindow calcWindow) {
        this.calcModel = calcModel;
        this.calcWindow = calcWindow;

        keyboard.put("0", new CommandDigit(this,"0"));
        keyboard.put("1", new CommandDigit(this,"1"));
        keyboard.put("2", new CommandDigit(this,"2"));
        keyboard.put("3", new CommandDigit(this,"3"));
        keyboard.put("4", new CommandDigit(this,"4"));
        keyboard.put("5", new CommandDigit(this,"5"));
        keyboard.put("6", new CommandDigit(this,"6"));
        keyboard.put("7", new CommandDigit(this,"7"));
        keyboard.put("8", new CommandDigit(this,"8"));
        keyboard.put("9", new CommandDigit(this,"9"));
        keyboard.put("-", new CommandNegate(this));
        keyboard.put("Clear", new CommandClear(this));
        keyboard.put("Delete", new CommandDelete(this));

    }

    public void buttonPressed(String action) {
        ClickableCommand command = keyboard.get(action);
        if (command != null) {
            command.doClick();
            return;
        }
        if (action.equals(".")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("."));
        }
        if (action.equals("+")) {
            calcModel.a = Double.parseDouble(calcWindow.readDisplay());
            calcModel.operator = 1;
            calcWindow.setDisplay("");
        }

        if (action.equals("-")) {
            calcModel.a = Double.parseDouble(calcWindow.readDisplay());
            calcModel.operator = 2;
            calcWindow.setDisplay("");
        }

        if (action.equals("*")) {
            calcModel.a = Double.parseDouble(calcWindow.readDisplay());
            calcModel.operator = 3;
            calcWindow.setDisplay("");
        }

        if (action.equals("/")) {
            calcModel.a = Double.parseDouble(calcWindow.readDisplay());
            calcModel.operator = 4;
            calcWindow.setDisplay("");
        }

        if (action.equals("=")) {
            calcModel.b = Double.parseDouble(calcWindow.readDisplay());

            switch (calcModel.operator) {
                case 1:
                    calcModel.result = calcModel.a + calcModel.b;
                    break;

                case 2:
                    calcModel.result = calcModel.a - calcModel.b;
                    break;

                case 3:
                    calcModel.result = calcModel.a * calcModel.b;
                    break;

                case 4:
                    if (calcModel.b == 0) {
                        calcWindow.setDisplay("Error");
                        return;
                    }
                    calcModel.result = calcModel.a / calcModel.b;
                    break;

                default:
                    calcModel.result = 0;
            }
            calcWindow.setDisplay("" + calcModel.result);
        }
    }
}