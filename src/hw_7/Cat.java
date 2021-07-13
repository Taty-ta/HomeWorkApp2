package hw_7;

public class Cat {
    private String name;
    public int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }


    public void eat(Plate plate){
        plate.decrease(name, appetite);
    }
}
