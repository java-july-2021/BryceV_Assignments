import java.util.ArrayList;
import java.util.Arrays;

public class BasicsTester {
    public static void main (String[] args) {
        BasicJava basic = new BasicJava();
        // basic.printOneToTwoFiveFive();

        // basic.printOdd255();

        // basic.sum255();

        int[] testArray = {1,3,5,7,9,13};
        // basic.iterateArray(testArray);

        int[] testArray1 = {-3,-5,-7};
        int[] testArray2 = {2,8,-1,15,-7};
        // System.out.println(basic.maxArray(testArray1));

        int[] testArray3 = {2,10,3};
        // System.out.println(basic.getAverage(testArray2));

        // basic.oddArray();

        int[] testArray4 = {1,3,5,7};
        // System.out.println(basic.greaterThanY(testArray4, 3));

        int[] testArray5 = {1,5,10,-2};
        // basic.square(testArray5);

        // basic.noNegatives(testArray5);

        // System.out.println(Arrays.toString(basic.maxMinAverage(testArray5)));

        int[] testArray6 = {1,5,10,7,-2};
        basic.arrayShift(testArray6);
    }
}