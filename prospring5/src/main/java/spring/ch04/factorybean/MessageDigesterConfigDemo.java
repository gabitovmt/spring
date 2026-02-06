package spring.ch04.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MessageDigesterConfigDemo {

    @Configuration
    static class MessageDigesterConfig {

        @Bean
        public MessageDigestFactoryBean shaDigest() {
            var factoryOne = new MessageDigestFactoryBean();
            factoryOne.setAlgorithmName("SHA1");

            return factoryOne;
        }

        @Bean
        public MessageDigestFactoryBean defaultDigest() {
            return new MessageDigestFactoryBean();
        }

        @Bean
        public MessageDigester digester() {
            var messageDigester = new MessageDigester();
            messageDigester.setDigest1(shaDigest().getObject());
            messageDigester.setDigest2(defaultDigest().getObject());

            return messageDigester;
        }
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(MessageDigesterConfig.class);

        var digester = ctx.getBean(MessageDigester.class);
        digester.digest("Hello World!");

        ctx.close();
    }
}
