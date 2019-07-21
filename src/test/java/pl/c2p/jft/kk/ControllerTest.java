package pl.c2p.jft.kk;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import pl.c2p.jft.kk.calc.controler.CalcController;
import pl.c2p.jft.kk.calc.memory.CalcModel;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControllerTest {

    CalcModel calcModel;
    CalcWindow calcWindow;
    CalcController calcController;


    @Before
    public void setup() {
        calcModel = spy(new CalcModel());
        calcWindow = spy(new CalcWindow());
        calcController = new CalcController(calcModel, calcWindow);
        calcWindow.registerObserver(calcController);
    }

    @Test
    public void shouldAdd() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("+");
        calcController.buttonPressed("2");
        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("3.0");
        assertThat(calcWindow.readDisplay()).isEqualTo("3.0");
    }

    @Test
    public void shouldAddWithIgnoreSecondPlusClick() {
        calcController.buttonPressed("1");
        calcController.buttonPressed(".");
        calcController.buttonPressed("1");
        calcController.buttonPressed("+");
        calcController.buttonPressed("+");
        calcController.buttonPressed("2");
        calcController.buttonPressed(".");
        calcController.buttonPressed("1");

        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("3.2");
        assertThat(calcWindow.readDisplay()).isEqualTo("3.2");
    }

    @Test
    public void shouldSubstract() {
        calcController.buttonPressed("4");
        calcController.buttonPressed("-");
        calcController.buttonPressed("3");
        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("1.0");

    }

    @Test
    public void shouldSubstractWithIgnoreSecondPlusClick() {
        calcController.buttonPressed("1");
        calcController.buttonPressed(".");
        calcController.buttonPressed("1");
        calcController.buttonPressed("-");
        calcController.buttonPressed("+");
        calcController.buttonPressed("-");
        calcController.buttonPressed("2");
        calcController.buttonPressed(".");
        calcController.buttonPressed("1");

        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("3.2");
        assertThat(calcWindow.readDisplay()).isEqualTo("3.2");
    }

    @Test
    public void shouldMultiply() {
        calcController.buttonPressed("5");
        calcController.buttonPressed("*");
        calcController.buttonPressed("6");
        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("30.0");

    }

    @Test
    public void shouldDivide() {
        calcController.buttonPressed("8");
        calcController.buttonPressed("/");
        calcController.buttonPressed("7");
        calcController.buttonPressed("=");

        //5 bo przed "7" jest dodatkowy clear
        verify(calcWindow, times(5)).setDisplay(anyString());
        verify(calcWindow, atLeast(1)).setDisplay("1.1428571428571428");
    }

    @Test
    public void shouldNotDivideByZero() {
        CalcModel calcModel = new CalcModel();
        CalcWindow calcWindow = spy(new CalcWindow());
        CalcController calcController = new CalcController(calcModel, calcWindow);

        calcController.buttonPressed("9");
        calcController.buttonPressed("/");
        calcController.buttonPressed("0");
        calcController.buttonPressed("=");

        verify(calcWindow).setDisplay("Error");
    }

    @Test
    public void shouldClearStateAndDisplay() {
        calcController.buttonPressed("8");
        calcController.buttonPressed("/");
        calcController.buttonPressed("8");

        assertThat(calcWindow.readDisplay()).isEqualTo("8");

        calcController.buttonPressed("Clear");

        //5 bo przed drugim "8" jest dodatkowy clear
        verify(calcWindow, times(5)).setDisplay(anyString());
        verify(calcWindow, atLeast(2)).setDisplay("8");
        verify(calcWindow, atLeast(2)).setDisplay("");

        assertThat(calcModel.getFirstOperand()).isEqualTo(0);
        assertThat(calcModel.getSecondOperand()).isEqualTo(0);
        assertThat(calcModel.result).isEqualTo(0);
        assertThat(calcModel.getOperator()).isEqualTo("");

    }

    @Test
    public void shouldDeleteLastCharacter() {
        calcController.buttonPressed("8");
        calcController.buttonPressed("7");
        calcController.buttonPressed("Delete");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("8");
        inOrder.verify(calcWindow).setDisplay("87");
        inOrder.verify(calcWindow).setDisplay("8");
    }

    @Test
    public void shouldBePossibleToUseNegativeNumbers() {
        calcController.buttonPressed("-");
        calcController.buttonPressed("7");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("-7");

    }

    @Test
    public void shouldChangeStateToIntegralAfterDeletion() {
        calcController.buttonPressed("7");
        calcController.buttonPressed(".");
        calcController.buttonPressed("7");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed(".");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("7");
        inOrder.verify(calcWindow).setDisplay("7.");
        inOrder.verify(calcWindow).setDisplay("7.7");
        inOrder.verify(calcWindow).setDisplay("7.");
        inOrder.verify(calcWindow).setDisplay("7");
        inOrder.verify(calcWindow).setDisplay("7.");

    }


    @Test
    public void shouldChangeStateToFirstEmptyAfterAllDeletions() {
        calcController.buttonPressed("-");
        calcController.buttonPressed("7");
        calcController.buttonPressed(".");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("-");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-7.");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("");
        inOrder.verify(calcWindow).setDisplay("-");

    }

    @Test
    public void shouldChangeStateToNegativeIntegralAfterDeletions() {
        calcController.buttonPressed("-");
        calcController.buttonPressed("7");
        calcController.buttonPressed(".");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed(".");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-7.");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-7.");

    }

    @Test
    public void shouldChangeStateToFirstNegativeEmptyAfterAllDeletions() {
        calcController.buttonPressed("-");
        calcController.buttonPressed("7");
        calcController.buttonPressed(".");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("-");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-7.");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow, times(0)).setDisplay("-");
    }


    // Tests for second number


    @Test
    public void shouldDeleteLastCharacterinSecondNumber() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("+");

        calcController.buttonPressed("8");
        calcController.buttonPressed("7");
        calcController.buttonPressed("Delete");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
//        inOrder.verify(calcWindow,times(2)).setDisplay("");
        inOrder.verify(calcWindow).setDisplay("8");
        inOrder.verify(calcWindow).setDisplay("87");
        inOrder.verify(calcWindow).setDisplay("8");
    }

    @Test
    public void shouldBePossibleToUseNegativeDigitsInSecondNumber() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("-");

        calcController.buttonPressed("-");
        calcController.buttonPressed("7");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
        inOrder.verify(calcWindow).setDisplay("");
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("-7");

    }

    @Test
    public void shouldChangeStateToSecondIntegralAfterDeletion() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("*");

        calcController.buttonPressed("7");
        calcController.buttonPressed(".");
        calcController.buttonPressed("7");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed(".");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
//        inOrder.verify(calcWindow,times(2)).setDisplay("");

        inOrder.verify(calcWindow).setDisplay("7");
        inOrder.verify(calcWindow).setDisplay("7.");
        inOrder.verify(calcWindow).setDisplay("7.7");
        inOrder.verify(calcWindow).setDisplay("7.");
        inOrder.verify(calcWindow).setDisplay("7");
        inOrder.verify(calcWindow).setDisplay("7.");

    }

    @Test
    public void shouldChangeStateToSecondEmptyAfterAllDeletions() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("/");

        calcController.buttonPressed("-");
        calcController.buttonPressed("7");
        calcController.buttonPressed(".");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("-");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
        inOrder.verify(calcWindow).setDisplay("");

        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-7.");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("");
        inOrder.verify(calcWindow).setDisplay("-");

    }

    @Test
    public void shouldChangeStateToSecondNegativeIntegralAfterDeletions() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("*");

        calcController.buttonPressed("-");
        calcController.buttonPressed("7");
        calcController.buttonPressed(".");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed(".");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
        inOrder.verify(calcWindow).setDisplay("");

        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-7.");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-7.");

    }

    @Test
    public void shouldChangeStateToSecondNegativeEmptyAfterAllDeletions() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("+");

        calcController.buttonPressed("-");
        calcController.buttonPressed("7");
        calcController.buttonPressed(".");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("Delete");
        calcController.buttonPressed("-");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
        inOrder.verify(calcWindow).setDisplay("");

        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-7.");
        inOrder.verify(calcWindow).setDisplay("-7");
        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow, times(0)).setDisplay("-");
    }


    // Behavior after result displayed

    @Test
    public void shouldAddAgain() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("+");

        calcController.buttonPressed("-");
        calcController.buttonPressed("7");
        calcController.buttonPressed("=");
        calcController.buttonPressed("+");
        calcController.buttonPressed("1");
        calcController.buttonPressed("=");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
//        inOrder.verify(calcWindow,times(2)).setDisplay("");

        inOrder.verify(calcWindow).setDisplay("-");
        inOrder.verify(calcWindow).setDisplay("-7");

        inOrder.verify(calcWindow).setDisplay("-6.0");
//        inOrder.verify(calcWindow,times(2)).setDisplay("");
        inOrder.verify(calcWindow).setDisplay("1");

        inOrder.verify(calcWindow).setDisplay("-5.0");
    }

    @Test
    public void shouldAddAndAddAgain() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("+");

        calcController.buttonPressed("1");
        calcController.buttonPressed("+");

        calcController.buttonPressed("1");
        calcController.buttonPressed("=");

        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
//        inOrder.verify(calcWindow,times(2)).setDisplay("");

        inOrder.verify(calcWindow).setDisplay("1");
        inOrder.verify(calcWindow).setDisplay("2.0");

//        inOrder.verify(calcWindow,times(2)).setDisplay("");
        inOrder.verify(calcWindow).setDisplay("1");
        inOrder.verify(calcWindow).setDisplay("3.0");
    }
    @Test
    public void shouldStartFromBeginingAfterDigitClicked() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("+");

        calcController.buttonPressed("1");
        calcController.buttonPressed("=");

        calcController.buttonPressed("2");
        calcController.buttonPressed("+");

        calcController.buttonPressed("2");
        calcController.buttonPressed("=");


        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
//        inOrder.verify(calcWindow,times(2)).setDisplay("");

        inOrder.verify(calcWindow).setDisplay("1");
        inOrder.verify(calcWindow).setDisplay("2.0");

        inOrder.verify(calcWindow).setDisplay("");
        inOrder.verify(calcWindow).setDisplay("2");
//        inOrder.verify(calcWindow,times(2)).setDisplay("");

        inOrder.verify(calcWindow).setDisplay("2");
        inOrder.verify(calcWindow).setDisplay("4.0");

    }
    @Test
    public void shouldClearAfterDeleteClicked() {
        calcController.buttonPressed("1");
        calcController.buttonPressed("+");
        calcController.buttonPressed("1");
        calcController.buttonPressed("=");
        calcController.buttonPressed("Delete");


        InOrder inOrder = Mockito.inOrder(calcWindow);
        inOrder.verify(calcWindow).setDisplay("1");
//        inOrder.verify(calcWindow,times(2)).setDisplay("");
        inOrder.verify(calcWindow).setDisplay("1");
        inOrder.verify(calcWindow).setDisplay("2.0");

        inOrder.verify(calcWindow).setDisplay("");
    }
}
