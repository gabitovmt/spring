package spring.ch04.profilejava;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ch04.profile.Food;
import spring.ch04.profile.FoodProviderService;

import java.util.List;

/**
 * В IntelliJ IDEA необходимо указать vmoptions профиль, например:
 * -Dspring.profiles.active=kindergarten
 */
public class ProfileJavaConfigExample {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(KindergartenConfig.class, HighschoolConfig.class);

        var foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        lunchSet.forEach(System.out::println);

        ctx.close();
    }
}
