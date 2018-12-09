/*JG-105*
/На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость.
 Вывести первые K обгонов.
 */

package com.hillel.elementary.javageeks.dir.homework10.overtaking;

import java.util.Arrays;
import java.util.TreeSet;

public class Race {
    private final Track track;
    private final Car[] cars;

    public Race(Track argTrack, Car[] argCars) {
        this.track = argTrack;
        this.cars = argCars;
    }

    public final Overtaking[] getOvertakings(int numberOfFirst) {
        TreeSet<Overtaking> set = new TreeSet<>(new OvertakingComparator());
        for (int i = 0; i < cars.length - 1; i++) {
            for (int j = i + 1; j < cars.length; j++) {
                Car carOne = cars[i];
                Car carTwo = cars[j];

                double speedOfOne = carOne.getSpeed();
                double speedOfTwo = carTwo.getSpeed();
                if (speedOfOne == speedOfTwo) {
                    continue;
                }

                double overtakingTime = (carOne.getInitialPosition() - carTwo.getInitialPosition())
                        / (speedOfOne - speedOfTwo);
                if (overtakingTime < 0) {
                    continue;
                }

                double position = carOne.getPosition(overtakingTime);
                if (position > track.getLength()) {
                    continue;
                }

                Overtaking overtaking = new Overtaking(overtakingTime, carOne.getId(), carTwo.getId());
                set.add(overtaking);
            }
        }
        int arraySize = Math.min(numberOfFirst, set.size());
        Overtaking[] array = new Overtaking[arraySize];
        return Arrays.copyOfRange(set.toArray(array), 0, arraySize);
    }
}
