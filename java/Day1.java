import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;

class Day1 {
    public static void main(String... args) {

        // Day1 - solution 1
        solvePart1();

    }

    private static void solvePart1() {
        String firstDigit = "";
        String lastDigit = "";
        int sum = 0;

        List<String> readAllLines;
        try {
            readAllLines = Files.readAllLines(Paths.get("input.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : readAllLines) {
            char[] charArray = line.toCharArray();

            for (char c : charArray) {
                if (Character.isDigit(c)) {
                    firstDigit = Character.toString(c);
                    break;
                }
            }

            for (int i = charArray.length - 1; i >= 0; i--) {
                if (Character.isDigit(charArray[i])) {
                    lastDigit = Character.toString(charArray[i]);
                    break;
                }
            }

            String twoDigit = firstDigit + lastDigit;
            sum += parseInt(twoDigit);
        }
        System.out.println(sum);
    }

}