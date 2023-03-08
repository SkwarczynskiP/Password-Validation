import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class ValidatePassword {
    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Please try again and input a valid password.");
            System.exit(1);
        }

        String password = args[0];
        System.out.println("Your password is: " + password);
        int len = password.length();

        if (len < 8 || len > 16) {
            System.out.println("Please try again and input a valid password of length between 8 and 16.");
            System.exit(0);
        }

        Set<Character> upperCaseLetters = new TreeSet<>();
        Set<Character> lowerCaseLetters = new TreeSet<>();
        Set<Character> numbers = new TreeSet<>();
        Set<Character> specialSymbols = new TreeSet<>();

        Map<String, Integer> count = new TreeMap<>();

        for (int i = (int)'A'; i <= (int)'Z'; i ++) {
            Character c = (char) i;
            upperCaseLetters.add((char) i);
            lowerCaseLetters.add(Character.toLowerCase(c));
        }

        for (int i = (int)'0'; i <= (int)'9'; i ++) {
            Character c = (char) i;
            numbers.add(c);
        }

        String str = "~!@$%^&*()-=+_";
        for (Character c: str.toCharArray()) {
            specialSymbols.add(c);
        }

        for(Character c: password.toCharArray()) {
            String key = "Lower Case Letters";
            if(lowerCaseLetters.contains(c)) {
                if (count.containsKey(key)) {
                    count.put(key, count.get(key) + 1);
                } else {
                    count.put(key, 1);
                }
            }

            key = "Upper Case Letters";
            if(upperCaseLetters.contains(c)) {
                if (count.containsKey(key)) {
                    count.put(key, count.get(key) + 1);
                } else {
                    count.put(key, 1);
                }
            }

            key = "Numbers";
            if(numbers.contains(c)) {
                if (count.containsKey(key)) {
                    count.put(key, count.get(key) + 1);
                } else {
                    count.put(key, 1);
                }
            }

            key = "Special Symbols";
            if(specialSymbols.contains(c)) {
                if (count.containsKey(key)) {
                    count.put(key, count.get(key) + 1);
                } else {
                    count.put(key, 1);
                }
            }
        }

        for (Entry<String, Integer> entry: count.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        if (count.size() < 3) {
            System.out.println("Please try again and input a valid password that meets a combination of at least 3 of the 4 requirements.");
            System.exit(0);
        }

        System.out.println("Great job! Your password statisfies all the requirements!");
    }   
}