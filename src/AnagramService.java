import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AnagramService {

    public List<AnagramCounter> compute(String dictionaryLocation) throws IOException {

        List<String> words = FileUtils.readLines(new File(dictionaryLocation));

        List<String> sortedWords = new ArrayList<>();

        //Sort each word
        for(String word: words){
            sortedWords.add(sort(word));
        }

        ArrayList<AnagramCounter> anagramCounters = new ArrayList<>();


        for(String word: sortedWords) {
            //Count each word occurrence
            int count = Collections.frequency(sortedWords, word);

            //Excluding the given word
            anagramCounters.add(new AnagramCounter(word.length(), count - 1));
        }

        return anagramCounters;
    }

    private String sort(String word) {

        word = word.replaceAll("\\s", "").toLowerCase();
        char[] wordArray = word.toCharArray();
        Arrays.sort(wordArray);
        return arrayToString(wordArray);
    }

    private String arrayToString(char[] array){

        StringBuilder builder = new StringBuilder();

        for(char s : array) {
            builder.append(s);
        }

        return builder.toString();
    }

}

