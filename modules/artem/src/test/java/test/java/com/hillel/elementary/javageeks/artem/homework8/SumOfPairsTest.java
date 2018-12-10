package test.java.com.hillel.elementary.javageeks.artem.homework8;

import com.hillel.elementary.javageeks.artem.homework8.SumOfPairs;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SumOfPairsTest {

    @Test
    public void shouldReturnTrueIfReturnedSumIsCorrect(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        int actual = SumOfPairs.sumofPairs(arrayList);
        int expected = 15;

        assertThat(actual).isEqualTo(expected);
    }
}
