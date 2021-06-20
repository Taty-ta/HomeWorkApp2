package hw_1;

public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }
    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 222;
        int b = -333;

        if ((a+b) >= 0){
            System.out.println("Сумма положительная");
        }else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        // если в задаче указано value, то надо было с типом long создавать?
        // Или int value  = 1000 ? И дальше вместо d value
        long d = 555L;
        if (d <= 0){
            System.out.println("Красный");
        }else if (d > 0 && d <= 100){
            System.out.println("Желтый");
        }else{
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 11;
        int b = 9;
        if ( a  >= b){
            System.out.println(a + " >= " + b);
        }else {
            System.out.println(a + " < " + b);
        }
    }
}