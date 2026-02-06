package spring.ch03.methodreplacer;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementDemo {

    public static void main(String[] args) {
        var ctx = new GenericXmlApplicationContext("spring/ch03/method-replacer.xml");

        var replacementTarget = ctx.getBean("replacementTarget", ReplacementTarget.class);
        var standardTarget = ctx.getBean("standardTarget", ReplacementTarget.class);
        displayInfo(replacementTarget);
        displayInfo(standardTarget);

        ctx.close();
    }

    @SuppressWarnings("java:S106")
    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Thanks for playing, try again!"));

        var stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int x = 0; x < 1_000_000; x++) {
            // Сообщение не выводится в консоль, чтобы не забивать её
            target.formatMessage("No filter in my head");
        }
        stopWatch.stop();

        System.out.println("1 000 000 invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
