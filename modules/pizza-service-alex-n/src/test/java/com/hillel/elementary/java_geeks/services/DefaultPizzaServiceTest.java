package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.domain.PizzaType;
import com.hillel.elementary.java_geeks.repositories.InMemPizzaRepo;
import com.hillel.elementary.java_geeks.repositories.PizzaRepo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultPizzaServiceTest {

    @Test
    void shouldReturnPizzaById() {

        //given
        PizzaRepo pizzaRepoMock = mock(InMemPizzaRepo.class);
        Pizza pizza = new Pizza(0, "pizza", PizzaType.MEAT, 200, new BigDecimal(200));
        when(pizzaRepoMock.findById(anyInt())).thenReturn(pizza);
        PizzaService pizzaService = new DefaultPizzaService(pizzaRepoMock);
        
        //when
        Pizza foundedPizza = pizzaService.getPizzaById(0);

        //than
        assertThat(foundedPizza).isEqualTo(pizza);
    }
}