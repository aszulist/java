import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Path shakespearePath = Paths.get("/home/adam/Repo/java/Streams-collectors-optionals/Using Collectors/src/files/words.shakespeare.txt");
        Path ospdPath = Paths.get("/home/adam/Repo/java/Streams-collectors-optionals/Using Collectors/src/files/ospd.txt");

        try (
                Stream<String> ospd = Files.lines(ospdPath);
                Stream<String> shakespeare = Files.lines(shakespearePath)
        ) {

            Set<String> scrabbleWords = ospd.collect(Collectors.toSet());
            Set<String> shakespeareWords = shakespeare.collect(Collectors.toSet());

            System.out.println("Scrabble: " + scrabbleWords.size());
            System.out.println("Shakespeare: " + shakespeareWords.size());

            // scores for letter from "a" to "z"
            int[] letterScores = {
                    1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
            };

            Function<String, Integer> score =
                    word -> word.toLowerCase().chars()
                            .map(letter -> letterScores[letter - 'a'])
                            .sum();

            Map<Integer, List<String>> histogramWordsByScore =
                    shakespeareWords.stream()
                            .filter(scrabbleWords::contains)
                            .collect(
                                    Collectors.groupingBy(score)
                            );

            System.out.println("# historyWordsByScore = " + histogramWordsByScore.size());

            histogramWordsByScore.entrySet()
                    .stream()
                    .sorted(
                            Comparator.comparing(entry -> -entry.getKey())
                    )
                    .limit(3)
                    .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

            // count of characters in scrabble from "a" to "z"
            int[] scrabbleENDistribution = {
                    9, 2, 2, 1, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1
            };

            Function<String, Map<Integer, Long>> histoWord =
                    word -> word.chars().boxed()
                            .collect(
                                    Collectors.groupingBy(
                                            letter -> letter,
                                            Collectors.counting()
                                    )
                            );

            Function<String, Long> nBlanks =
                    word -> histoWord.apply(word)
                            .entrySet()
                            .stream()
                            .mapToLong(
                                    entry ->
                                            Long.max(
                                                    entry.getValue() - (long) scrabbleENDistribution[entry.getKey() - 'a'],
                                                    0L
                                            )

                            )
                            .sum();

            System.out.println("# of blanks for whizzing: " + nBlanks.apply("whizzing"));

            Function<String, Integer> score2 =
                    word -> histoWord.apply(word)
                            .entrySet()
                            .stream()
                            .mapToInt(
                                    entry ->
                                            letterScores[entry.getKey() - 'a'] *
                                                    Integer.min(
                                                            entry.getValue().intValue(),
                                                            scrabbleENDistribution[entry.getKey() - 'a']
                                                    )
                            ).sum();

            System.out.println("# score for whizzing: " + score.apply("whizzing"));
            System.out.println("# score2 for whizzing: " + score2.apply("whizzing"));

            Map<Integer, List<String>> histoWordsByScore2 =
                    shakespeareWords.stream()
                            .filter(scrabbleWords::contains)
                            .filter(word -> nBlanks.apply(word) <= 2)
                            .collect(
                                    Collectors.groupingBy(
                                            score2
                                    )
                            );

            histoWordsByScore2.entrySet()
                    .stream()
                    .sorted(
                            Comparator.comparing(entry -> -entry.getKey())
                    )
                    .limit(3)
                    .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
