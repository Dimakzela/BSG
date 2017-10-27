import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnagramService {

    public List<AnagramCounter> compute(String dictionaryLocation) throws IOException {

        List<String> words = FileUtils.readLines(new File(dictionaryLocation));

        ArrayList<AnagramCounter> anagramCounters = new ArrayList<>();

        for (String word : words) {

            int wordLength = word.length();

            /*
            this also count the given word, if you wanna exclude it minus 1 from
            the result returned by factorial.
            e.g 'abc' has 6 anagram including 'abc' and 5 excluding 'abc'
            */
            int count = factorial(wordLength);

            anagramCounters.add(new AnagramCounter(wordLength, count));

        }

        return anagramCounters;
    }


    private static int factorial(int number){

        if (number == 1) return 1;
        return number * factorial(number-1);
    }

}

