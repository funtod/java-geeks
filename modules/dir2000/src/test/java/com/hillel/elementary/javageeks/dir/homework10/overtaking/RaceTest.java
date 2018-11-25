package com.hillel.elementary.javageeks.dir.homework10.overtaking;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Random;

class RaceTest {

    @Test
    void getOvertakingsTest() {
        //given
        final int trackLength = 500;
        final int carsCount = 20;
        final int maxSpeed = 250;
        final int numberOfFirst = 3;
        final int seed = 1984;
        Random random = new Random(seed);

        Track track = new Track(trackLength);
        Car[] cars = new Car[carsCount];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(i, random.nextDouble() * trackLength, random.nextInt(maxSpeed));
        }
        Race race = new Race(track, cars);

        Overtaking one = new Overtaking(0.05908122746896153, 4, 6);
        Overtaking two = new Overtaking(0.07540972995876466, 3, 16);
        Overtaking three = new Overtaking(0.09489472429697084, 0, 17);
        Overtaking[] expected = new Overtaking[]{one, two, three};

        //when
        Overtaking[] result = race.getOvertakings(numberOfFirst);

        //then
        assertThat(result).isEqualTo(expected);
    }
}