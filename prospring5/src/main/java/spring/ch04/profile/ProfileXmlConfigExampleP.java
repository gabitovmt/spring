package spring.ch04.profile;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProfileXmlConfigExampleP {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("classpath*:spring/ch04/*-config.xml");
        ctx.getEnvironment().setActiveProfiles("kindergarten");
        ctx.refresh();

        var foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        lunchSet.forEach(System.out::println);

        ctx.close();
    }
}
