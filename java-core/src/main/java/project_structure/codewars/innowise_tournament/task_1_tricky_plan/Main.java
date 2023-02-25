package project_structure.codewars.innowise_tournament.task_1_tricky_plan;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static String word = "welcometoinnowisecontestelimination";
    private final static String favouriteWord = "innowise";

    public static void main(String[] args) {
        System.out.println(counter());
    }
    private static int counter() {
        int result = 0;
        HashMap<String, Integer> lettersInFavouriteWord = fillLettersMap(favouriteWord);


        for (int i = 0; i < word.length(); i++) {
            for (int j = i + favouriteWord.length(); j < word.length() + 1; j++) {
                String cutWord = word.substring(i, j);
                HashMap<String, Integer> lettersInCutWord = fillLettersMap(cutWord);

                boolean isNeedToAdd = true;
                for (Map.Entry<String, Integer> entry :
                        lettersInFavouriteWord.entrySet()) {
                    Integer amountOfLettersInCutWord = lettersInCutWord.get(entry.getKey());
                    if (amountOfLettersInCutWord == null || amountOfLettersInCutWord < entry.getValue()){
                        isNeedToAdd = false;
                        break;
                    }
                }
                if (isNeedToAdd){
                    result++;
                }
            }
        }

        return result;
    }

    private static HashMap<String, Integer> fillLettersMap(String word){
        HashMap<String, Integer> wordLetters = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            String letter = String.valueOf(word.charAt(i));
            wordLetters.merge(letter, 1, Integer::sum);
        }
        return wordLetters;
    }
}
