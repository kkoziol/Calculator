package pl.c2p.jft.kk.calc.controler;

import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

public class CalcController {
    private CalcModel calcModel;
    private CalcWindow calcWindow;

    public CalcController(CalcModel calcModel, CalcWindow calcWindow) {

        this.calcModel = calcModel;
        this.calcWindow = calcWindow;
    }

    public void buttonPressed(String action) {

        if (action.equals("1")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("1"));
        }
        if (action.equals("2")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("2"));
        }
        if (action.equals("3")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("3"));
        }
        if (action.equals("4")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("4"));
        }
        if (action.equals("5")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("5"));
        }
        if (action.equals("6")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("6"));
        }
        if (action.equals("7")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("7"));
        }
        if (action.equals("8")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("8"));
        }
        if (action.equals("9")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("9"));
        }
        if (action.equals("0")) {
            calcWindow.setDisplay(calcWindow.readDisplay().concat("0"));
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

        if (action.equals("Clear")) {
            calcWindow.setDisplay("");
            calcModel.reset();
        }
        if (action.equals("Delete")) {
            String s = calcWindow.readDisplay();
            calcWindow.setDisplay("");
            for (int i = 0; i < s.length() - 1; i++)
                calcWindow.setDisplay(calcWindow.readDisplay() + s.charAt(i));
        }
    }
}