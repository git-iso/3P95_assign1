import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.DoubleStream;

public class itemfilter{

    public static ArrayList<String> filterData(double[] data, double limit, double[] exceptions){

        ArrayList<String> filtered_data = new ArrayList<String>();
        int index = 0;

        while (index < data.length){

            double item = data[index];
            String modified_item = "";

            if (DoubleStream.of(exceptions).anyMatch(x -> x == item)){

                modified_item = item + "_EXCEPTION";

            } else if (item > limit){

                modified_item = Double.toString(2 * item);

            } else {

                modified_item = Double.toString(item / limit);

            }

            filtered_data.add(modified_item);
            index += 1;

        }

        return filtered_data;

    }
    public static ArrayList<String> mutate1(double[] data, double limit, double[] exceptions){

        ArrayList<String> filtered_data = new ArrayList<String>();
        int index = 0;

        while (index < data.length){

            double item = data[index];
            String modified_item = "";

            if (!DoubleStream.of(exceptions).anyMatch(x -> x == item)){

                modified_item = item + "_EXCEPTION";

            } else if (item > limit){

                modified_item = Double.toString(2 * item);

            } else {

                modified_item = Double.toString(item / limit);

            }

            filtered_data.add(modified_item);
            index += 1;

        }

        return filtered_data;

    }

    public static ArrayList<String> mutate2(double[] data, double limit, double[] exceptions){

        ArrayList<String> filtered_data = new ArrayList<String>();
        int index = 0;

        while (index < data.length){

            double item = data[index];
            String modified_item = "";

            if (DoubleStream.of(exceptions).anyMatch(x -> x == item)){

                modified_item = item + "_EXCEPTION";

            } else if (item < limit){

                modified_item = Double.toString(2 * item);

            } else {

                modified_item = Double.toString(item / limit);

            }

            filtered_data.add(modified_item);
            index += 1;

        }

        return filtered_data;

    }

    public static ArrayList<String> mutate3(double[] data, double limit, double[] exceptions){

        ArrayList<String> filtered_data = new ArrayList<String>();
        int index = 0;

        while (index > data.length){

            double item = data[index];
            String modified_item = "";

            if (DoubleStream.of(exceptions).anyMatch(x -> x == item)){

                modified_item = item + "_EXCEPTION";

            } else if (item > limit){

                modified_item = Double.toString(2 * item);

            } else {

                modified_item = Double.toString(item / limit);

            }

            filtered_data.add(modified_item);
            index += 1;

        }

        return filtered_data;

    }

    public static ArrayList<String> mutate4(double[] data, double limit, double[] exceptions){

        ArrayList<String> filtered_data = new ArrayList<String>();
        int index = 0;

        while (index < data.length){

            double item = data[index];
            String modified_item = "";

            if (DoubleStream.of(exceptions).anyMatch(x -> x == item)){

                modified_item = item + "_EXCEPTION";

            } else if (item > limit){

                modified_item = Double.toString(2 * item);

            } else {

                modified_item = Double.toString(item / limit);

            }

            filtered_data.add(modified_item);
            index = data.length;

        }

        return filtered_data;

    }

    public static ArrayList<String> mutate5(double[] data, double limit, double[] exceptions){

        ArrayList<String> filtered_data = new ArrayList<String>();
        int index = 0;

        while (index < data.length){

            double item = data[index];
            String modified_item = "";

            if (DoubleStream.of(exceptions).anyMatch(x -> x == item)){

                modified_item = item + "_EXCEPTION";

            } else if (item > limit){

                modified_item = Double.toString(2 * item);

            } else {

                modified_item = Double.toString(item / limit);

            }

          
            index += 1;

        }

        return filtered_data;

    }

    public static ArrayList<String> mutate6(double[] data, double limit, double[] exceptions){

        ArrayList<String> filtered_data = new ArrayList<String>();
        int index = 0;

        while (index < data.length){

            double item = data[index];
            String modified_item = "";

            if (DoubleStream.of(exceptions).anyMatch(x -> x == item)){

                modified_item = item + "_EXCEPTION";

            } else if (item > limit){

                modified_item = Double.toString(2 * item);

            } 

            filtered_data.add(modified_item);
            index += 1;

        }

        return filtered_data;

    }


    public static void main(String[] args){

        ArrayList<Double> scores = new ArrayList<Double>();
        double[][]data = {

            {1, 2},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},

        };

        double[] limit = {3, 0, 5, 6};
        double[][] exceptions = {

            {1, 2},
            {},
            {},
            {2, 4, 6, 8, 10}

        };
    
        // Loop through test cases
        for (int i = 0; i < 4; i++){

            double mutation_score = 0;
            double killed = 0;
            double total = 6;

                // Check every mutation for fail
                if (!filterData(data[i], limit[i], exceptions[i]).equals(mutate1(data[i], limit[i], exceptions[i]))){

                    killed++;
                }
                if (!filterData(data[i], limit[i], exceptions[i]).equals(mutate2(data[i], limit[i], exceptions[i]))){

                    killed++;
                }
                if (!filterData(data[i], limit[i], exceptions[i]).equals(mutate3(data[i], limit[i], exceptions[i]))){

                    killed++;
                }
                if (!filterData(data[i], limit[i], exceptions[i]).equals(mutate4(data[i], limit[i], exceptions[i]))){

                    killed++;
                }
                if (!filterData(data[i], limit[i], exceptions[i]).equals(mutate5(data[i], limit[i], exceptions[i]))){

                    killed++;
                }
                if (!filterData(data[i], limit[i], exceptions[i]).equals(mutate6(data[i], limit[i], exceptions[i]))){

                    killed++;
                }

            mutation_score = killed / total;
            scores.add(mutation_score);

        }

        ArrayList<Double> original = new ArrayList<Double>(scores);

        int[] index = new int[scores.size()];

        Collections.sort(scores);
        final double min = Double.MIN_VALUE;

        // Sort values by lowest to higest mutation score
        for (int i = 0; i < scores.size(); i++){

            index[i] = original.indexOf(scores.get(i));
            original.set(original.indexOf(scores.get(i)), min);

        }

        System.out.println("ORDERED MUTATION SCORES:");
        
        for (int i = 0; i < scores.size(); i++){

            System.out.println("Mutation score of test case " + (index[i] + 1) + " is: " + scores.get(i));   

        }
    }

}