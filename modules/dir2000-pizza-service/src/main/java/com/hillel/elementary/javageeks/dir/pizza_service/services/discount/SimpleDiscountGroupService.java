package com.hillel.elementary.javageeks.dir.pizza_service.services.discount;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.annotations.PostCreate;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.services.resource.ResourceService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component("discountGroupService")
public class SimpleDiscountGroupService implements DiscountGroupService {
  private final List<DiscountService> discountServices = new LinkedList<>();
  ResourceService resourceService;

  public SimpleDiscountGroupService(ResourceService argResourceService) {
    resourceService = argResourceService;
  }

  @PostCreate
  private void initialFill() {
    DiscountService[] array = resourceService.readDiscountTerms();
    Arrays.stream(array)
            .forEach(discountService -> discountServices.add(discountService));
  }

  @Override
  public void giveDiscount(Map<Pizza, BigDecimal> costs) {
    discountServices.stream().forEach(discountService -> discountService.giveDiscount(costs));
  }
}
