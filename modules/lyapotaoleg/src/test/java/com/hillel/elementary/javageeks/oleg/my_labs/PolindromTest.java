package com.hillel.elementary.javageeks.oleg.my_labs;

import com.hillel.elementary.javageeks.oleg.my_labs.lab_2.Polindrom;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class PolindromTest {
    @Test
    public void shouldResultLineSplite(){
        String number="121,32,45,434";

        String[] result={"121","32","45","434"};

        Assertions.assertThat(Polindrom.lineSplit (number)).isEqualTo (result);
    }

    @Test
    public void shouldResultIsPolindromTrue(){
        int number=11211;

        Boolean result=true;


        Assertions.assertThat (Polindrom.isPolindrom (number)).isEqualTo (result);

    }

    @Test
    public void shouldResultIsPolindromFalse(){
        int number=15214;

        Boolean result=false;

        Assertions.assertThat (Polindrom.isPolindrom (number)).isEqualTo (result);

    }
}