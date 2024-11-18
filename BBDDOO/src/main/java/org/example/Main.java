package org.example;

import org.neodatis.odb.*;

public class NeoDatisExample {

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {
        // Crear base de datos
        ODB odb = ODBFactory.open("mydatabase.neodatis");

        // Insertar datos
        odb.store(new Person("Alice", 30));
        odb.store(new Person("Bob", 25));
        odb.store(new Person("Charlie", 35));
        odb.commit();

        // Consultar datos
        Objects<Person> people = odb.getObjects(Person.class);
        System.out.println("Datos en la base de datos:");
        for (Person person : people) {
            System.out.println(person);
        }

        // Modificar un objeto
        Person personToUpdate = people.getFirst();
        personToUpdate.setName("Alice Updated");
        odb.store(personToUpdate);
        odb.commit();

        // Eliminar un objeto
        odb.delete(personToUpdate);
        odb.commit();

        // Consultar datos después de las modificaciones
        System.out.println("Datos después de modificar y eliminar:");
        people = odb.getObjects(Person.class);
        for (Person person : people) {
            System.out.println(person);
        }

        // Cerrar base de datos
        odb.close();
    }
}
