package hw_6.Animals;

public class Hunter_dog extends Dog{
    static int count;
    public Hunter_dog(String name, String color, int age) {
        super(name,  age); // конструктор родителя dog
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void swim(int dis) {
        super.swim(dis);
    }
}

