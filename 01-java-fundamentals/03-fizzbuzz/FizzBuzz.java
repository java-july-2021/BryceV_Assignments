public class FizzBuzz {
    public String fizzBuzz (int number) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzbuzz = "FizzBuzz";
        if (number % 3 == 0) {
            if (number%5==0) {
                return fizzbuzz;
            }
            return fizz;
        }
        if (number%5==0) {
            return buzz;
        }
        else {
            String num = "'" + number + "'";
            return num;
        }
    }
}