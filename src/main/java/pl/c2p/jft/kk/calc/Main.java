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

//            double aa = 0x0.5P1;
//            double ss = (double)((5d/16d)*2d);
//            System.out.println(""+ss);
//            System.out.printf("->"+aa);

        Main main = new Main();
    }

    void initialize() {
        calcWindow.registerObserver(calcController);
    }
}