import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Main {

    // modify this method
    public static long multiplySquaresOfNumbers(List<Integer> numbers) {
        BinaryOperator<Long> myBinaryOperator = (previouslyReturned,currentValueFromStream) -> previouslyReturned * currentValueFromStream;
        long squaredResult = numbers.stream().map(num -> (long)Math.pow(num, 2)).collect(Collectors.reducing(myBinaryOperator)).get();
        return squaredResult;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String val : values) {
            numbers.add(Integer.parseInt(val));
        }

        long val = multiplySquaresOfNumbers(numbers);

        System.out.println(val);

        scanner.close();
    }
}