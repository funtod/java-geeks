package com.hillel.elementary.javageeks.dir2000.homework3.paint_houses;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PaintHousesForCheapProcessorTest {
  @Test
  public void shouldReturnDefiniteCostsForTenHouses(){
    //given
    int [][] costs = {{900, 900, 600}, {400, 700, 500}, {900, 300, 100}, {200, 900, 100}, {800, 400, 800}, {900, 200, 800}, {100, 400, 100}, {800, 500, 300}, {800, 200, 400}, {900, 900, 600}};
    int housesCount = 10;

    //when
    int [][] result = PaintHousesForCheapProcessor.getCosts(housesCount);

    //then
    assertThat(result).isEqualTo(costs);
  }

  @Test
  public void shouldReturnDefiniteMinCostForTenHouses(){
    //given
    int minCost = 3500;
    int housesCount = 10;

    //when
    int result = new PaintHousesForCheapProcessor().minCost(PaintHousesForCheapProcessor.getCosts(housesCount));

    //then
    assertThat(result).isEqualTo(minCost);
  }

  @Test
  public void shouldReturnTheCheapestHouseCombinationForTenHouses(){
    //given
    int [] housesForCheap = {2, 0, 2, 0, 2, 1, 0, 2, 1, 2};
    int housesCount = 10;

    //when
    int [] result = new PaintHousesForCheapProcessor().calculateHouses(PaintHousesForCheapProcessor.getCosts(housesCount));

    //then
    assertThat(result).isEqualTo(housesForCheap);
  }

}
