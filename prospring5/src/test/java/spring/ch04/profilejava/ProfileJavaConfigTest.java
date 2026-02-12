package spring.ch04.profilejava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.ch04.profile.FoodProviderService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {KindergartenConfig.class, HighschoolConfig.class})
@ActiveProfiles("kindergarten")
class ProfileJavaConfigTest {

    @Autowired
    FoodProviderService foodProviderService;

    @Test
    void testProvider() {
        assertNotNull(foodProviderService.provideLunchSet());
        assertFalse(foodProviderService.provideLunchSet().isEmpty());
        assertEquals(2, foodProviderService.provideLunchSet().size());
    }
}