package am.gitc.ch4.profiles.highschool;

import am.gitc.ch4.profiles.Food;
import am.gitc.ch4.profiles.FoodProviderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("highschool")
@Component("foodProviderService")
public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet. add (new Food ( "Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));
        return lunchSet;
    }
}
