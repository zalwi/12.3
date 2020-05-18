package logic;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class SumOfPositiveNumbers {
    public static void runNumbersReader() {
        List<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("Podaj liczbę dodatnią:");
            String numberString = scanner.nextLine();
            if (NumberUtils.isParsable(numberString)) {
                double tmpNumber = Double.parseDouble(numberString);
                if (tmpNumber > 0) {
                    numbers.add(tmpNumber);
                } else {
                    loop = false;
                }
            }
        } while (loop);
        createSummary(numbers);
    }

    private static void createSummary(List<Double> numbers) {
        System.out.println("--- Podsumowanie ---");
        System.out.println("Suma wszystkich wartości:\n" + createSumString(numbers));
        showMinMaxOfList(numbers);
        System.out.println("--------------------");
    }

    private static void showMinMaxOfList(List<Double> numbers){
        System.out.println("Minimum: " + Collections.min(numbers));
        System.out.println("Maximum: " + Collections.max(numbers));
    }

    private static String createSumString(List<Double> numbers) {
        String tmpString = "";
        for (int i = 0; i < numbers.size() ; i++) {
            if (i == 0) tmpString += numbers.get(i);
            else tmpString += "+" + numbers.get(i);
        }
        tmpString += "=" + numbers.stream().mapToDouble(Double::doubleValue).sum();;
        return tmpString;
    }
}
