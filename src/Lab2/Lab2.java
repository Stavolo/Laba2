package Lab2;

public class Lab2 {
    public static void main(String[] args) {
        Person person1 = new Person("Steve", 20);
        String json = person1.toJSON();
        Person person2 = Person.fromJSON(json);
        System.out.println(person2.equals(person1));
    }

}
