package test.java.com.hillel.elementary.javageeks.artem.homework5;

import com.hillel.elementary.javageeks.artem.homework5.Convertation;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConvertationTest {

    @Test
    public void shouldReturnConvertResultIfNotException(){
        Convertation convertation = new Convertation();
        String str = convertation.convertation(5);
        assertThat(str).isEqualTo("5.0");
    }

    @Test
    public void shouldReturnNaNIfException(){
        Convertation convertation = new Convertation();
        double number = Math.sqrt(-1);
        String str = convertation.convertation(number);
        assertThat(str).isEqualTo("NaN");
    }
}