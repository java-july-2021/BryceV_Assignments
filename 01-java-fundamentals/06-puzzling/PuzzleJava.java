import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class PuzzleJava {
    public Object[] sumAndGreaterThan(int[] arr, int num) {
        int sum = 0;
        ArrayList<Integer> returnArr = new ArrayList<Integer>();
        for (int i = 0; i<arr.length; i++) {
            if (arr[i]>num) {
                returnArr.add(arr[i]);
            }
            sum += arr[i];
        }
        System.out.println(sum);
        return returnArr.toArray();
    }

    public Object[] namesGreaterThan5(String[] arr) {
        System.out.println(Arrays.toString(arr));
        Collections.shuffle(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
        ArrayList<String> returnArr = new ArrayList<String>();
        for (int i = 0; i<arr.length; i++) {
            if (arr[i].length() > 5) {
                returnArr.add(arr[i]);
            }
        }
        return returnArr.toArray();
    }

    public void alphabetShuffle(String[] arr) {
        System.out.println(Arrays.toString(arr));
        Collections.shuffle(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
        System.out.println("Last letter is: " + arr[25]);
        System.out.println("First letter is: " + arr[0]);
        String[] vowels = {"a","e","i","o","u"};
        for (int i=0; i<vowels.length; i++) {
            if (vowels[i].equals(arr[0])) {
                System.out.println("First letter: " + arr[0] + " " + "is a vowel!");
            }
        }
    }

    public int[] randomArray() {
        Random r = new Random();
        int [] arr;
        arr = new int[10];
        for (int i=0; i<arr.length; i++) {
            arr[i] = r.nextInt(100-55)+55;
        }
        return arr;
    }

    public int[] randomArraySorted() {
        Random r = new Random();
        int [] arr;
        arr = new int[10];
        for (int i=0; i<arr.length; i++) {
            arr[i] = r.nextInt(100-55)+55;
        }
        // System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Minimum value: " + arr[0] + " " + "Maximum value: " + arr[9]);

        return arr;
    }

    public String randomString5() {
        ArrayList<Character> randomCharArr = new ArrayList<Character>();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (char i = 'a'; i <= 'z'; i++) {
            alphabet.add(i);
        }
        Collections.shuffle(alphabet);
        for (int i = 0; i<5; i++) {
            randomCharArr.add(alphabet.get(i));
        }
        // System.out.println(randomCharArr);
        StringBuilder randomStr = new StringBuilder();
        String test = "";
        String[] test2 = {"e", "r", "h", "y", "u"};
        // for (int i = 0; i<5; i++) {
        //     test = test.concat(test2[i]);
        // }
        for (double randomChar : randomCharArr) {
            randomStr.append(randomChar);
            test+=randomChar;
        }
        System.out.println(test);
        return randomStr.toString();
    }

    public String[] randomStringArr() {
        String[] stringArr = new String[10];
        for (int i=0; i<10; i++) {
            stringArr[i] = randomString5();
        }
        return stringArr;
    }
}
