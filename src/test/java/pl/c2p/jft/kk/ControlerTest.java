package pl.c2p.jft.kk;

import org.junit.Test;
import org.mockito.verification.VerificationMode;
import pl.c2p.jft.kk.calc.controler.CalcControler;
import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControlerTest
{
    @Test
    public void shouldAdd()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);

        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("1");
        calcControler.buttonPressed("+");
        calcControler.buttonPressed("2");
        calcControler.buttonPressed("=");

        verify(calcWindow).setDisplay("3.0");

    }
    @Test
    public void shouldSubstract()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("4");
        calcControler.buttonPressed("-");
        calcControler.buttonPressed("3");
        calcControler.buttonPressed("=");

        verify(calcWindow).setDisplay("1.0");

    }
    @Test
    public void shouldMultiply()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("5");
        calcControler.buttonPressed("*");
        calcControler.buttonPressed("6");
        calcControler.buttonPressed("=");

        verify(calcWindow).setDisplay("30.0");

    }
    @Test
    public void shouldDivide()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("8");
        calcControler.buttonPressed("/");
        calcControler.buttonPressed("7");
        calcControler.buttonPressed("=");

        verify(calcWindow,times(4)).setDisplay(anyString());
        verify(calcWindow,atLeast(1)).setDisplay("1.1428571428571428");
    }
    @Test
    public void shouldNotDivideByZero()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("9");
        calcControler.buttonPressed("/");
        calcControler.buttonPressed("0");
        calcControler.buttonPressed("=");

        verify(calcWindow).setDisplay("Error");
    }
    @Test
    public void shouldClearStateAndDisplay()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("8");
        calcControler.buttonPressed("/");
        calcControler.buttonPressed("8");
        calcControler.buttonPressed("Clear");

        verify(calcWindow,times(4)).setDisplay(anyString());
        verify(calcWindow,atLeast(2)).setDisplay("");

        assertThat(calcModel.a).isEqualTo(0);
        assertThat(calcModel.b).isEqualTo(0);
        assertThat(calcModel.result).isEqualTo(0);
        assertThat(calcModel.operator).isEqualTo(0);
    }

}
