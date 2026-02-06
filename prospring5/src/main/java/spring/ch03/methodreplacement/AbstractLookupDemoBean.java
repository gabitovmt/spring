package spring.ch03.methodreplacement;

public abstract class AbstractLookupDemoBean implements DemoBean {

    // Метод объявлен в учебных целей. Можно пропустить его объявление, приложение будет работать
    @SuppressWarnings("java:S3038")
    @Override
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
