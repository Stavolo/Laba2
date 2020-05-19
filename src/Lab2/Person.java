package Lab2;

import com.google.gson.Gson;

public class Person {

    private String name;
    private int age;
    private static Gson gson = new Gson();

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String toJSON() {
        return gson.toJson(this);
    }

    public static Person fromJSON(String json) {
        return gson.fromJson(json, Person.class);
    }

    @Override
    public final boolean equals(Object obj)
    {
        if ((obj == null) || !(obj instanceof Person)) return false;
        Person person = (Person)obj;
        boolean checkedName = this.name == null ? person.name == null :  this.name.equals(person.name);
        return checkedName && this.age == person.age;
    }

    @Override
    public final int hashCode()
    {
        int result = 9;
        result += result * age;
        result += result * 9;
        try {
            result += result * name.hashCode();
        } catch (Exception e) {
            result += result * 9;
        }
        result += result * age;
        return result;
    }

    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
}

