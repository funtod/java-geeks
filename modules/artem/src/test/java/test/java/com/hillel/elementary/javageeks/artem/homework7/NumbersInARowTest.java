package test.java.com.hillel.elementary.javageeks.artem.homework7;

import com.hillel.elementary.javageeks.artem.homework7.NumbersInARow;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumbersInARowTest {

    @Test
    public void shouldReturnTrueIfResultQuantityIsCorrect() throws IOException {
        URL resources = NumbersInARow.class.getClassLoader().getResource("resources");
        String path = resources.getFile();
        int actual = NumbersInARow.findNumbersInARow(NumbersInARow.readFile(path));
        int expect = 6;
        assertThat(actual).isEqualTo(expect);
    }
}
