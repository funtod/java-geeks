package Homework4;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlaneTest {

    @Test
    public void shouldReturnTrueIfQuantityOfWingsIsMoreThanOneAndNameisNotNull(){
    Wings wings = new Wings(2,"Wings");
    int actualQuantity = wings.getQuantity();
    String actualName = wings.getName();
    assertThat(actualQuantity).isEqualTo(2);
    assertThat(actualName).isEqualTo("Wings");
    }

    @Test
    public void shouldReturnTrueIfQuantityOfChassisIsMoreThanOne (){
    Chassis chassis = new Chassis(4);
    int actualQuantity = chassis.getQuantity();
    assertThat(actualQuantity).isEqualTo(4);
    }

    @Test
    public void shouldReturnTrueIfPowerOfEngineIsMoreThanZeroAndNameisNotNull (){
    Engine engine = new Engine(1000,"Engine");
    int actualPower = engine.getPower();
    String actualName = engine.getName();
    assertThat(actualPower).isEqualTo(1000);
    assertThat(actualName).isEqualTo("Engine");

    }
}