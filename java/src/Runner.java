import lab.ExtraTrial;
import lab.LiteTrial;
import lab.StrongTrial;
import lab.Trial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Trial> tests = new ArrayList<>(Arrays.asList(
                new Trial("Ivanov", 45, 93),
                new Trial("Petrov", 51, 35),
                new Trial("Sidorov", 90, 57),
                new LiteTrial("Antonov", 29, 95),
                new LiteTrial("Pavlov", 35, 68),
                new StrongTrial("Alekseev", 90, 57),
                new StrongTrial("Dudar", 51, 35),
                new ExtraTrial("Smirnov", 45, 93, 60),
                new ExtraTrial("Borovikov", 35, 68, 49)
        ));

        tests.forEach(System.out::println);
        System.out.println();

        System.out.println(tests.stream()
                .filter(Trial::isPassed)
                .count());

        tests.sort(Comparator.comparing(Trial::result));

        tests.stream()
                .map(Trial::result)
                .forEach(System.out::println);

        List<Trial> passedTests= tests.stream()
                .filter(trial -> !trial.isPassed())
                .map(Trial::clone)
                .peek(Trial::clear)
                .collect(Collectors.toList());
        passedTests.stream().forEach(System.out::println);

        int[] sum = tests.stream()
                .mapToInt(Trial::result)
                .toArray();
        System.out.println(Arrays.toString(sum));
    }
}
