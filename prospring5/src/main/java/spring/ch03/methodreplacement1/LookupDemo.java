package spring.ch03.methodreplacement1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

public class LookupDemo {

    @ComponentScan(basePackages = "spring.ch03.methodreplacement1")
    @Configuration
    public static class LookupConfig {
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(LookupConfig.class);

        var aBeanId = "abstractLookupDemoBean";
        var sBeanId = "standardLookupDemoBean";
        var abstractBean = ctx.getBean(aBeanId, DemoBean.class);
        var standardBean = ctx.getBean(sBeanId, DemoBean.class);
        displayInfo(aBeanId, abstractBean);
        displayInfo(sBeanId, standardBean);

        ctx.close();
    }

    @SuppressWarnings("java:S106")
    private static void displayInfo(String beanName, DemoBean bean) {
        Singer singer1 = bean.getMySinger();
        Singer singer2 = bean.getMySinger();
        System.out.printf("%s: Singer Instances the Same? %b%n", beanName, singer1 == singer2);

        var stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int x = 0; x < 100_000; x++) {
            var singer = bean.getMySinger();
            singer.sing();
        }
        stopWatch.stop();
        System.out.printf("100 000 gets took %d ms%n", stopWatch.getTotalTimeMillis());
    }
}
