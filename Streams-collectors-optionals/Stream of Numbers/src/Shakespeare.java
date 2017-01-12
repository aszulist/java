import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Shakespeare {

    public static void main(String[] args) throws IOException {
        Set<String> shakespeareWords =
                Files.lines(Paths.get("/home/adam/Repo/java/Streams-collectors-optionals/Stream of Numbers/src/files/words.shakespeare.txt"))
                        .map(String::toLowerCase)
                        .collect(Collectors.toSet());

        Set<String> scrabbleWords =
                Files.lines(Paths.get("/home/adam/Repo/java/Streams-collectors-optionals/Stream of Numbers/src/files/ospd.txt"))
                        .map(String::toLowerCase)
                        .collect(Collectors.toSet());

        System.out.println("# words of Shakespeare: " + shakespeareWords.size());
        System.out.println("# words of Scrabble: " + scrabbleWords.size());

        // Scrabble points for each letter - a, b, c, etc.
        final int [] scrabbleENScore = {
                1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
        };

        Function<String, Integer> score = word -> word.chars()
                .map(letter -> scrabbleENScore[letter - 'a'])
                .sum();

        ToIntFunction<String> intScore = word -> word.chars()
                .map(letter -> scrabbleENScore[letter - 'a'])
                .sum();

        System.out.println("Score of hello: " + intScore.applyAsInt("hello"));

        String bestWord =
        shakespeareWords.stream()
                .filter(scrabbleWords::contains)
                .max(Comparator.comparing(score))
                .get();

        System.out.println("Best word: " + bestWord);

        IntSummaryStatistics summaryStatistics = shakespeareWords.stream().parallel()
                .filter(scrabbleWords::contains)
                .mapToInt(intScore)
                .summaryStatistics();

        System.out.println("Stats: " + summaryStatistics);
    }

}
