import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        Stream<Person> adult = persons.stream();
        System.out.println(adult.filter(x -> x.getAge() > 18).count());
        Stream<Person> recruit = persons.stream();
        recruit.filter(x->x.getAge() > 18).filter(x->x.getAge() < 27).map(x->x.getFamily()).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("worker!!!");
        Stream<Person> worker = persons.stream();
        worker.filter(x -> x.getEducation().equals(Education.HIGHER));

    }
}