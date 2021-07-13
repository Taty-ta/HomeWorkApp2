package hw_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int command = addFood();
        while (command > 0) {

            Plate plate = new Plate(command);

            Cat[] cat = {
                    new Cat("Barsik", 5),
                    new Cat("Murzik", 6),
                    new Cat("Vaciliy", 7),
                    new Cat("Masha", 8),
                    new Cat("Henesy", 9),
            };
            for (int i = 0; i < cat.length; i++) {
                cat[i].eat(plate);

            }
            command = addFood();
        }

   }

    public static int addFood() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Положите еду на тарелку (введите число)");
        int command = scanner.nextInt();
        return command;
    }

}
