package pl.c2p.jft.kk.calc;

import pl.c2p.jft.kk.calc.controler.CalcControler;
import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

public class Main {
    CalcModel calcModel = new CalcModel();
    CalcWindow calcWindow = new CalcWindow();
    CalcControler calcControler;

    public Main() {
        calcControler = new CalcControler(calcModel, calcWindow);

        initialize();
    }

    public Main(CalcModel calcModel, CalcWindow calcWindow, CalcControler calcControler) {
        this.calcModel = calcModel;
        this.calcWindow = calcWindow;
        this.calcControler = calcControler;

        initialize();
    }

    public static void main(String... s) {
        Main main = new Main();
    }

    void initialize() {
        calcWindow.registerObserver(calcControler);
    }
}