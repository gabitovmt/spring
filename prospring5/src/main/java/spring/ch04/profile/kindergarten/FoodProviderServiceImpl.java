package spring.ch04.profile.kindergarten;

import spring.ch04.profile.Food;
import spring.ch04.profile.FoodProviderService;

import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {

    @Override
    public List<Food> provideLunchSet() {
        return List.of(new Food("Milk"), new Food("Biscuits"));
    }
}
