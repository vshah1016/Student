package main;

import dataClass.Person;
import exceptions.MaximumPeople;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Data {
    ArrayList<Person> people = new ArrayList<>();

    public Stream<Person> stream() {
        return people.stream();
    }

    public void addPerson(Person person) throws MaximumPeople {
        if (people.size() == 10) throw new MaximumPeople();
        else people.add(person);
    }

    public void removePerson(String nameToDelete) {
        int size = people.size();
        people.removeIf(p -> p.name.equals(nameToDelete));
        if (size == people.size()) System.out.println("Person not found.");
        else System.out.println("All " + nameToDelete + "(s) removed.");
    }
}
