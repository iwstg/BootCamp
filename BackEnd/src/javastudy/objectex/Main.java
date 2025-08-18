package javastudy.objectex;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return this.name.equals(person.name);
    }
}


public class Main {
    public static void main(String[] args) {
        Person p1 = new  Person("Alice");
        Person p2 = new  Person("Alice");

        System.out.println(p1.equals(p2));
    }
}
