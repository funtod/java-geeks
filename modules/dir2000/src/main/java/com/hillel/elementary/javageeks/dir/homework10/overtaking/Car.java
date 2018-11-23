/*JG-105*
/На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость.
 Вывести первые K обгонов.
 */

package com.hillel.elementary.javageeks.dir.homework10.overtaking;

public class Car {
  private static int counter;
  private int id;
  private double initialPosition;
  private int speed;

  @Override
  public String toString() {
    return "Car{"
            + id
            + '}';
  }

  public Car(double initialPosition, int speed) {
    id = ++counter;
    this.initialPosition = initialPosition;
    this.speed = speed;
  }

  public double getInitialPosition() {
    return initialPosition;
  }

  public int getSpeed() {
    return speed;
  }

  public double getPosition(double time){
    return initialPosition + speed * time;
  }
}
