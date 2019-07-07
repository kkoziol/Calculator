package pl.c2p.jft.kk;

import org.junit.Test;
import pl.c2p.jft.kk.calc.controler.CalcControler;
import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

import static org.mockito.Mockito.*;

public class IntegrationTest
{
    @Test
    public void shouldDisplaycorrectly()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = mock(CalcWindow.class);
        //to jest troche lipne, ale to wina moka.
        // i ze nie uzywamy modelu do trzymania "wyswietlacza"
        when(calcWindow.readDisplay()).thenReturn("","1","12","12.","12.5");

        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("1");

        verify(calcWindow).setDisplay("1");

        calcControler.buttonPressed("2");

        verify(calcWindow).setDisplay("12");

        calcControler.buttonPressed(".");

        verify(calcWindow).setDisplay("12.");

        calcControler.buttonPressed("5");

        verify(calcWindow).setDisplay("12.5");

    }

    @Test
    public void shouldAdd()
    {
        CalcModel calcModel = new CalcModel();
        // ze spiegiem jedna linijka odpada...
        // ale jak by sie ten test odpala na jenkinsie? ;)
        CalcWindow calcWindow = spy(CalcWindow.class);
        //when(calcWindow.readDisplay()).thenReturn("","1","","2");

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

        calcControler.buttonPressed("1");
        calcControler.buttonPressed("-");
        calcControler.buttonPressed("2");
        calcControler.buttonPressed("=");

        verify(calcWindow).setDisplay("-1.0");

    }
    @Test
    public void shouldMultiply()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("2");
        calcControler.buttonPressed("*");
        calcControler.buttonPressed("2");
        calcControler.buttonPressed("=");

        verify(calcWindow).setDisplay("4.0");

    }
    @Test
    public void shouldDivide()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("5");
        calcControler.buttonPressed("/");
        calcControler.buttonPressed("2");
        calcControler.buttonPressed("=");

        verify(calcWindow).setDisplay("2.5");
    }
    @Test
    public void shouldNotDivideByZero()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcControler calcControler = new CalcControler(calcModel,calcWindow);

        calcControler.buttonPressed("5");
        calcControler.buttonPressed("/");
        calcControler.buttonPressed("0");
        calcControler.buttonPressed("=");

        verify(calcWindow).setDisplay("Error");
    }
}
