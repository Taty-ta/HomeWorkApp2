package hw_5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainHw {
    public static void main(String[] args) {
        Employee empl1  = new Employee("Ivanav I.I.", "driver", "123@gg.nn", "22-22-22", 300.50, 41);
        Employee empl2  = new Employee("Petrov P.P.", "driver", "321@gg.nn");
        empl1.info();
        System.out.println(empl1.toString());


        //System.out.println(empl1.getPost()); // sout
       // empl1.getPost();
        empl1.setAge(30);
        empl1.info(); //поменяли возраст
        // массив
        Employee[] empl = new Employee[5];
        empl[0] = new Employee("Ivanav I.I.", "driver", "123@gg.nn", "22-22-22", 300.50, 41);
        empl[1] = new Employee("Petrov P.P.", "driver", "321@gg.nn", "33-22-22", 600.50, 20);
        empl[2] = new Employee("Sidorov I.I.", "driver", "773@gg.nn", "44-22-22", 700.0, 45);
        empl[3] = new Employee("Rasseina E.I.", "driver", "883@gg.nn", "55-22-22", 300.50, 47);
        empl[4] = new Employee("Golod N.V.", "driver", "993@gg.nn", "22-66-22", 1000.0, 38);

        System.out.println(Arrays.toString(empl));

       /* Employee[] empl3 = {
                new Employee("Ivanav I.I.", "driver", "123@gg.nn", "22-22-22", 300.50, 45),
                new Employee("Petrov P.P.", "driver", "321@gg.nn", "33-22-22", 600.50, 20),
                new Employee("Sidorov I.I.", "driver", "773@gg.nn", "44-22-22", 700.0, 45),
                new Employee("Rasseina E.I.", "driver", "883@gg.nn", "55-22-22", 300.50, 55),
                 new Employee("Golod N.V.", "driver", "993@gg.nn", "22-66-22", 1000.0, 38)
        };
        System.out.println(empl3.toString());*/

        for (int i =0; i< empl.length; i++){
            if (empl[i].getAge() >= 40){
                 System.out.println(empl[i]);

            }
        }

    }
}
