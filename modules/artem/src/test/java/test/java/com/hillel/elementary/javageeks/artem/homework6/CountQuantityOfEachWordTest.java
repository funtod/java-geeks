package test.java.com.hillel.elementary.javageeks.artem.homework6;

import com.hillel.elementary.javageeks.artem.homework6.CountQuantityOfEachWord;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountQuantityOfEachWordTest {

    @Test
    public void shouldReturnTrueIfQuantityOfEachWordIsCorrect(){
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> testList = CountQuantityOfEachWord.returnQuantityOfEachWord("Hello, my name Hello is Artem Artem");
        for (int i = 0; i < testList.size(); i++) {
        stringBuilder.append(testList.get(i)+" ");
        }
        String expect = "Hello met 2 times my met 1 times name met 1 times is met 1 times Artem met 2 times";
        String actual = stringBuilder.toString();
        assertThat(expect.equals(actual));

    }

}