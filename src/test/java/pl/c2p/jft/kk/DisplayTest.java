package pl.c2p.jft.kk;

import org.junit.Test;
import pl.c2p.jft.kk.calc.controler.CalcController;
import pl.c2p.jft.kk.calc.ui.CalcWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class DisplayTest
{
    @Test
    public void shouldDisplaycorrectly()
    {
        CalcWindow calcWindow = new CalcWindow();

        calcWindow.setDisplay("2.76");

        assertThat(calcWindow.readDisplay()).isEqualTo("2.76");
    }

    @Test
    public void shouldPropagateClicks()
    {
        ActionEvent event = mock(ActionEvent.class);
        when(event.getSource()).thenReturn(new JButton("1"));

        CalcController calcController = mock(CalcController.class);
        CalcWindow calcWindow = new CalcWindow();
        calcWindow.registerObserver(calcController);

        calcWindow.actionPerformed(event);

        verify(calcController).buttonPressed("1");
    }


}
