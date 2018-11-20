package test.java.com.hillel.elementary.javageeks.artem.homework7;

import com.hillel.elementary.javageeks.artem.homework7.NumbersInARow;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumbersInARowTest {

    @Test
    public void shouldReturnTrueIfResultQuantityIsCorrect() throws IOException {
    String path = "C:\\Users\\Owner\\IdeaProjects\\java-geeks\\modules\\artem\\" +
            "src\\main\\java\\com\\hillel\\elementary\\javageeks\\artem\\homework7\\resource";
    int actual = NumbersInARow.findNumbersInARow(NumbersInARow.readFile(path));
    int expect = 6;
    assertThat(actual).isEqualTo(expect);
    }
}
