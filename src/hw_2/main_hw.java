package hw_2;
import java.util.Scanner;

public class main_hw {
    public static void main(String[] args) {
        int a;
        int b;

        System.out.println(within10and20(5, 6));
        System.out.println(within10and20(2, 3));
        System.out.println(within10and20(10, 20));


        isPositiveOrNegative(-2);
        isPositiveOrNegative(0);
        isPositiveOrNegative(4);


        System.out.println(isNegative(-5));
        System.out.println(isNegative(4));

        String word = "Hello word";
        printWordNTimes(word, 3);
///5///
        System.out.println(leapYear());
    }

    /**
     * метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно),
     * если да – вернуть true, в противном случае – false.
     */

    public static boolean within10and20(int x1, int x2) {
        int c = x1 + x2;
        return c >= 10 && c <= 20;
    }

    /**
     * метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
     * положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public static void isPositiveOrNegative(int x) {
        if (x < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Pozitive");
        }
    }

    /**
     * метод, которому в качестве параметра передается целое число.
     * Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    public static boolean isNegative(int x) {
        return x >= 0;
    }

    /*
     * метод, которому в качестве аргументов передается строка и число,
     * метод должен отпечатать в консоль указанную строку, указанное количество раз;
     * */
    public static void printWordNTimes(String word, int times) {
        for (int i = 1; i <= times; i++) {
            System.out.println(word);
        }
    }

    /**
     * метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static boolean leapYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год");
        int q = scanner.nextInt();

        if ((q % 4 == 0 && q % 100 != 0) || (q % 100 == 0 && q % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

}
