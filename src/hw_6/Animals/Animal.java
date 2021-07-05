package hw_6.Animals;

public  class Animal {
    //private  - доступно тольк внутри класса Animal(ни наследникам, никому)
    // package private - доступно всем классам внутри пакета
    //protected   - доступни внутри красса, а такжем классам которые не внутри пакета protected    String name;
    //pablic - доступно всем классам
        String name;
       String color;
       int age;
       int dis;


    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Animal(String name, int age) {
        this.name = name;
    }

    public  void run(int dis){

    }
    public  void swim(int dis){
        //System.out.printf("%s %s %d \n", name, color, age);
    }

}
