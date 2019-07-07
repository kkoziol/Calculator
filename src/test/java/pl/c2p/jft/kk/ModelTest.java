package pl.c2p.jft.kk;

import org.junit.Test;
import pl.c2p.jft.kk.calc.memory.CalcModel;

import static org.assertj.core.api.Assertions.assertThat;


public class ModelTest
{
    @Test
    public void shouldStoreCorrectly() {
        CalcModel calcModel = new CalcModel();
    //No to głupie, ale narazie nic tam nie ma
        calcModel.a = 5;

        assertThat(calcModel.a).isEqualTo(5);
    }
}
