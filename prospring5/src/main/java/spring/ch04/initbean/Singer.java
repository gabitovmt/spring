package spring.ch04.initbean;

public class Singer {
    public static final String DEFAULT_NAME = "Eric Clapton";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @SuppressWarnings("java:S106")
    public void init() {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "Age must set the age property of any beans of type " + Singer.class
            );
        }
    }

    @Override
    public String toString() {
        return "\tName: " + name + "\n\tAge: " + age;
    }
}
