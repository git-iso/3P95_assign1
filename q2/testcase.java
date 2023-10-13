import java.util.Random;
import java.util.Arrays;

public class testcase {

    public static int[] rantest(int[] sort) {

        for (int i = 0; i < sort.length; i++){ // Sorting current and next value

            for (int j = i + 1 ; j  < sort.length; j++){ // Get next value

                int temp = 0;

                if (sort[i] > sort[j]){ // If next value is smaller, swap values

                    temp = sort[i];
                    sort[i] = sort[j];
                    sort[j] = temp;

                }

            }

       }
       
        return sort;

    }

    public static void random_test(int num){

        for (int i = 0; i < num; i++){ //  # of test cases to run
            
            Random rand = new Random();

            int length = rand.nextInt(10) + 1; // # of values from 1 to 10
            int[] arr = new int[length];

            for (int j = 0; j < length; j++) { // Values from 1 to 100

                arr[j] = rand.nextInt(100) + 1;
            }

            int[] input = arr.clone();
            Arrays.sort(arr);
            int[] expected_output = arr.clone(); // Gte expected output of test case
            int[] output = rantest(input.clone()); // Run function to be tested with test case input
             
            if (!Arrays.equals(output, expected_output)){ // Test output matches with function

                System.out.println("Test case FAILED: input was: " + Arrays.toString(input) +"\nExpected output was: " + Arrays.toString(expected_output) +  "\nAnd got: " + Arrays.toString(output));

            } else {

                System.out.println("Test case PASSED: input was: " + Arrays.toString(input) +"\nExpected output was: " + Arrays.toString(expected_output) +  "\nAnd got: " + Arrays.toString(output));


            }


        }


    }
    
    public static void main(String[] args) {

        random_test(10); // Run random testing for # of test cases
        
    }

}