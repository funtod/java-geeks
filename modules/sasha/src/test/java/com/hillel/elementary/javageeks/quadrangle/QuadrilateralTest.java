package com.hillel.elementary.javageeks.quadrangle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.function.Supplier;

class QuadrilateralTest {
    @Test
     void shouldCalculateArea(){
        Shape quadrilateral = new Quadrilateral(1,3,2,4);
        double area = quadrilateral.getArea();
        assertEquals(4.898,quadrilateral.getArea(),0.1);

     }

    @Test
    void shouldCalculatePerimeter(){
        Quadrilateral quadrilateral = new Quadrilateral(1,3,2,4);
        int perimeter =  quadrilateral.getPerimeter();
        assertEquals(10,quadrilateral.getPerimeter());

    }


}