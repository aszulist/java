class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Person [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id && (name != null ? name.equals(person.name) : person.name == null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person(5, "Bob");
        Person person2 = new Person(5, "Bob");

        System.out.println(person1.equals(person2));

        Double value1 = 7.2;
        Double value2 = 7.2;

        System.out.println(value1.equals(value2));

        Integer number1 = 6;
        Integer number2 = 6;

        System.out.println(number1.equals(number2));

        String text1 = "Hello";
        String text2 = "Hello";

        System.out.println(text1.equals(text2));

    }
}
