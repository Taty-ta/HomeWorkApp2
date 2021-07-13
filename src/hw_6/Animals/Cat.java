package hw_6.Animals;

//import hw_6.Animals.Animal;

public class Cat extends Animal {
 static int count;

    public Cat(String name, String color, int age) {

        super(name, color,age ); // вызывает конструктор родителя
        count++;

    }

    public static int getCount() {
        return count;
    }


    @Override
    public void run(int dis) {
        super.run(dis);
        if (dis <= 200) {
            System.out.println(name + " пробежал " + dis);
        }else {
            System.out.println(name + " "+ dis+ " отказался бежать");

        }
    }

    @Override
    public void swim(int dis) {
        super.swim(dis);
        if (dis > 0) {
            System.out.println(name + " не умеет плавать!");
        }
    }
}
