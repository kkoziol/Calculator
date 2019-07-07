package pl.c2p.jft.kk;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import pl.c2p.jft.kk.calc.controler.CalcController;
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

        CalcController calcController = new CalcController(calcModel,calcWindow);

        calcController.buttonPressed("1");
        calcController.buttonPressed("+");
        calcController.buttonPressed("2");
        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("3.0");

    }
    @Test
    public void shouldSubstract()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcController calcController = new CalcController(calcModel,calcWindow);

        calcController.buttonPressed("4");
        calcController.buttonPressed("-");
        calcController.buttonPressed("3");
        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("1.0");

    }
    @Test
    public void shouldMultiply()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcController calcController = new CalcController(calcModel,calcWindow);

        calcController.buttonPressed("5");
        calcController.buttonPressed("*");
        calcController.buttonPressed("6");
        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("30.0");

    }
    @Test
    public void shouldDivide()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcController calcController = new CalcController(calcModel,calcWindow);

        calcController.buttonPressed("8");
        calcController.buttonPressed("/");
        calcController.buttonPressed("7");
        calcController.buttonPressed("=");

        verify(calcWindow,times(4)).setDisplay(anyString());
        verify(calcWindow,atLeast(1)).setDisplay("1.1428571428571428");
    }
    @Test
    public void shouldNotDivideByZero()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcController calcController = new CalcController(calcModel,calcWindow);

        calcController.buttonPressed("9");
        calcController.buttonPressed("/");
        calcController.buttonPressed("0");
        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("Error");
    }
    @Test
    public void shouldClearStateAndDisplay()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcController calcController = new CalcController(calcModel,calcWindow);

        calcController.buttonPressed("8");
        calcController.buttonPressed("/");
        calcController.buttonPressed("8");
        calcController.buttonPressed("Clear");

        verify(calcWindow,times(4)).setDisplay(anyString());
        verify(calcWindow,atLeast(2)).setDisplay("");

        assertThat(calcModel.a).isEqualTo(0);
        assertThat(calcModel.b).isEqualTo(0);
        assertThat(calcModel.result).isEqualTo(0);
        assertThat(calcModel.operator).isEqualTo(0);
    }

    @Test
    public void shouldDeleteLastCharacter()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcController calcController = new CalcController(calcModel,calcWindow);

        calcController.buttonPressed("8");
        calcController.buttonPressed("7");
        calcController.buttonPressed("Delete");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("8");
        inOrder.verify(calcWindow).setDisplay("87");
        inOrder.verify(calcWindow).setDisplay("8");

    }

    @Test
    public void shouldBePossibleToUseNegativeNumbers ()
    {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(CalcWindow.class);
        CalcController calcController = new CalcController(calcModel,calcWindow);

        calcController.buttonPressed("-");
        calcController.buttonPressed("7");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("7");

    }

}
