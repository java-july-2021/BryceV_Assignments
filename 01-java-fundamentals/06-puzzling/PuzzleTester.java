import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class PuzzleTester {
    public static void main (String[] args) {
        PuzzleJava puzzle = new PuzzleJava();

        int[] testArr = {3,5,1,2,7,9,8,13,25,32};
        // System.out.println(Arrays.toString(puzzle.sumAndGreaterThan(testArr, 10)));

        String[] names = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        // System.out.println(Arrays.toString(puzzle.namesGreaterThan5(names)));

        String[] alph = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        // puzzle.alphabetShuffle(alph);

        // System.out.println(Arrays.toString(puzzle.randomArray()));

        // puzzle.randomArraySorted();

        // System.out.println(puzzle.randomString5());

        // System.out.println(Arrays.toString(puzzle.randomStringArr()));

        puzzle.randomString5();
    }
}