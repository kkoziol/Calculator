package pl.c2p.jft.kk.calc;

import pl.c2p.jft.kk.calc.controler.CalcControler;
import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

public class Main {

    public static void main(String... s) {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = new CalcWindow();
        CalcControler calcControler = new CalcControler(calcModel,calcWindow);
        calcWindow.registerObserver(calcControler);
    }
}