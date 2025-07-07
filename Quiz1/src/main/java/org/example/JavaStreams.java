package org.example;

import java.util.*;
import java.util.function.Predicate;

public class JavaStreams {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> oddNumbers = numbers.stream()
            .filter(number -> number % 2 != 0)
            .toList();

        System.out.println("Odd numbers: " + oddNumbers);

        //==========

        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");

        List<String> startsWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .toList();

        System.out.println("Names starting with A: " + startsWithA);

        //==========

        List<Integer> baseNumbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squaredNumbers = baseNumbers.stream()
                .map(base -> base * base)
                .toList();

        System.out.println("Squared numbers: " + squaredNumbers);

        //===========

        List<Integer> numbersTwo = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> isEven = n -> n % 2 == 0;

        Predicate<Integer> greaterThanFive = n -> n > 5;

        Predicate<Integer> combined = isEven.and(greaterThanFive);

        List<Integer> evenAndGreaterThanFive = numbersTwo.stream()
                .filter(combined)
                .toList();

        System.out.println("Even and >5: " + evenAndGreaterThanFive);

        //===========

        List <Person> personList = new ArrayList<>();

        Person rom = new Person ("Rom", 24);
        Person tricia = new Person ("Tricia", 24);
        Person ralph = new Person ("Ralph", 27);
        Person tyrell = new Person ("Tyrell", 24);
        Person gen = new Person ("Gen", 22);

        personList.add(rom);
        personList.add(tricia);
        personList.add(ralph);
        personList.add(tyrell);
        personList.add(gen);

        Comparator<Person> byAge = Comparator.comparingInt(Person::getAge);

        Comparator<Person> byName = Comparator.comparing(Person::getName);

        List<Person> ageSort = personList.stream()
                .sorted(byAge)
                .toList();

        List<Person> nameSort = personList.stream()
                .sorted(byName)
                .toList();

        List<Person> ageSortReverse = personList.stream()
                .sorted(byAge)
                .toList().reversed();

        System.out.println(ageSort);
        System.out.println(nameSort);
        System.out.println(ageSortReverse);
    }
}

class Person{

    private String Name;
    private int age;

    public Person(String name, int age) {
        Name = name;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return Name + " - " + age + "\n";
    }
}