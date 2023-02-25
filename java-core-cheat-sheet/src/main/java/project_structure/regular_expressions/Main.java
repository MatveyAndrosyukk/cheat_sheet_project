package project_structure.regular_expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean isStringMatches(){
        String input = "+12343454556";
        return input.matches("(\\+*)\\d{11}");
    }

    public static void findRegularExpressionInString(){
        String input = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("Java(\\w*)");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
            System.out.println(matcher.group());
    }

    public static void main(String[] args) {
        System.out.println(isStringMatches());
        findRegularExpressionInString();
    }
}
