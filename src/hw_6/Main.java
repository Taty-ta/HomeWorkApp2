package hw_6;

import hw_6.Animals.*;
///import hw_6.Animals.Cow;
//import hw_6.Animals.Dog;

public class Main {
        public static void main(String[] args) {
       Animal cat = new Cat("Barsic", "red", 5);
       Animal cat2 = new Cat("Murzic", "red", 5);

       Animal dog = new Dog("Tuzik", "black", 6);
        int disRun = 100;
        int disSwim = 9;
        /*cat.run(disRun);
        dog.run(disRun);
        cat.swim(disSwim);
        dog.swim(disSwim);*/
            // полиморфизм - когда пользуемся родительской ссылкой для вызова переопределенных методов
        Animal[] animals = {
            new Cat("Murka", "red", 5),
            new Dog("Tuzik", "black", 6),
                new Hunter_dog("Dark","gray",5)
        };
         for (int i = 0; i< animals.length; i++){
        animals[1].run(disRun);
        animals[i].swim(disSwim);
         }
         // * Добавить подсчет созданных котов, собак и животных.

            System.out.println("Создано котов - " + Cat.getCount());
            System.out.println("Создано собак - " + Dog.getCount() );
            System.out.println("Создано диких собак - " + Hunter_dog.getCount() );
            System.out.println("Создано всего животных - " + (Cat.getCount() + Dog.getCount()+  Hunter_dog.getCount()));
        }

    }
