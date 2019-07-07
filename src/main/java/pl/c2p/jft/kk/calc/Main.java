package pl.c2p.jft.kk.calc;

import pl.c2p.jft.kk.calc.controler.CalcController;
import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

public class Main {
    CalcModel calcModel = new CalcModel();
    CalcWindow calcWindow = new CalcWindow();
    CalcController calcController;

    public Main() {
        calcController = new CalcController(calcModel, calcWindow);

        initialize();
    }

    public Main(CalcModel calcModel, CalcWindow calcWindow, CalcController calcController) {
        this.calcModel = calcModel;
        this.calcWindow = calcWindow;
        this.calcController = calcController;

        initialize();
    }

    public static void main(String... s) {
        Main main = new Main();
    }

    void initialize() {
        calcWindow.registerObserver(calcController);
    }
}