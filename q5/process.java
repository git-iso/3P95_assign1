import java.util.LinkedList;
import java.util.List;

public class process {

    public static String minInput(String input){

        int check = 0; // Limit of potential mininput
        String minimalInput = input;

        while (check <= input.length()) { // Not full input

            for (int i = 0; i <= input.length() - check; i++) { // Get region of input

                String testInput = input.substring(0, i) + input.substring(i + check);
                
                if (containsBug(testInput)) { // New min

                    minimalInput = testInput;

                }
            }

            check += 1;
        }

        return minimalInput;


    }

    public static String processString(String input){

        String output = "";

        for (char c: input.toCharArray()){

            if (Character.isUpperCase(c)){

                output += Character.toLowerCase(c);

            } else if (Character.isDigit(c)){

                output += c * 2;

            } else {

                output += Character.toUpperCase(c);

            }

        }

        return output;

    }

    // Fixed bug on digit character
    public static String processStringCorrect(String input){

        String output = "";

        for (char c: input.toCharArray()){

            if (Character.isUpperCase(c)){

                output += Character.toLowerCase(c);

            } else if (Character.isDigit(c)){

                output += c;

            } else {

                output += Character.toUpperCase(c);

            }

        }

        return output;

    }

    public static boolean containsBug(String input) {
        
        return !processString(input).equals(processStringCorrect(input));
    }

    public static void main(String[] args) {

        String[] inputs = {
        "abcdefG1",
        "CCDDEExy",
        "1234567b",
        "8665",
        };

        for (String input: inputs){

            System.out.println("Original Input: " + input);
            String mininput = minInput(input);
            System.out.println("Min Input: " + mininput);
           
        }

    }

}