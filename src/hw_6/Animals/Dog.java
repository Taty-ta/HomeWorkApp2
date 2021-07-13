package hw_6.Animals;

//import hw_6.Animals.Animal;

public  class Dog extends Animal {
    static int count;

    public Dog(String name, String color, int age) {
        super(name, color,age ); // вызывает конструктор родителя
        count++;
    }

    public Dog(String name,  int age) {
        super(name,  age);
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int dis) {
        super.run(dis);
        if (dis<= 500 ){
            System.out.println(name+ " пробежал " + dis);
        }else {
            System.out.println(name + " " + dis+ " отказался бежать");
        }
    }

    @Override
    public  void swim(int dis) {
        super.swim(dis);
        if (dis <= 10) {
            System.out.println(name + " проплыл " + dis);
        } else {
            System.out.println("Пожалейте собаку");
        }
    }
}
