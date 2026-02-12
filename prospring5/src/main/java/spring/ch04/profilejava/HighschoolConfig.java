package spring.ch04.profilejava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import spring.ch04.profile.FoodProviderService;
import spring.ch04.profile.highschool.FoodProviderServiceImpl;

@Configuration
@Profile("highschool")
public class HighschoolConfig {

    @Bean
    public FoodProviderService foodProviderService() {
        return new FoodProviderServiceImpl();
    }
}
