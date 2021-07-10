import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    public void printOneToTwoFiveFive() {
        ArrayList<Integer> arrayTwoFiveFive = new ArrayList<Integer>();
        for (int i = 1; i < 256; i++) {
            arrayTwoFiveFive.add(i);
        }
        System.out.println(arrayTwoFiveFive);
    }

    public void printOdd255() {
        ArrayList<Integer> oddArray = new ArrayList<Integer>();
        for (int i = 1; i < 256; i++) {
            if (i%2 != 0) {
                oddArray.add(i);
            }
        }
        System.out.println(oddArray);
    }

    public void sum255() {
        int sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += i;
            System.out.println("New number: " + i + " " + "Sum: " + sum);
        }
    }

    public void iterateArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public Integer maxArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public double getAverage(int[] arr) {
        double avg = 0;
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        avg = sum/arr.length;
        return avg;
    }

    public void oddArray() {
        ArrayList<Integer> oddArray1 = new ArrayList<Integer>();
        for (int i = 1; i<256; i++) {
            if (i%2 != 0) {
                oddArray1.add(i);
            }
        }
        System.out.println(oddArray1);
    }

    public Integer greaterThanY(int[] arr, int y) {
        int total = 0;
        for (int i = 0; i<arr.length; i++) {
            if (arr[i]>y) {
                total += 1;
            }
        }
        return total;
    }

    public void square(int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    public void noNegatives(int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            if (arr[i]<0){
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public double[] maxMinAverage(int[] arr) {
        double max = arr[0];
        double min = arr[0];
        double sum = 0;
        double avg = 0;
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            sum += arr[i];
        }
        avg = sum/arr.length;
        double[] maxMinAvg = {max, min, avg};
        return maxMinAvg;
    }

    public void arrayShift(int[] arr) {
        for (int i = 1; i<arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = 0;
        System.out.println(Arrays.toString(arr));
    }
}