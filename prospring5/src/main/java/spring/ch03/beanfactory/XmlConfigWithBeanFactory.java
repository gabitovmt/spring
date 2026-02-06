package spring.ch03.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import spring.ch03.ex02.Oracle;

public class XmlConfigWithBeanFactory {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var factory = new DefaultListableBeanFactory();
        var rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(new ClassPathResource("spring/ch03/xml-bean-factory-config.xml"));

        var oracle = (Oracle) factory.getBean("oracle");
        System.out.println(oracle.defineMeaningOfLife());
    }
}
