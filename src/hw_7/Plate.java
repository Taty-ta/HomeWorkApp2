package hw_7;

public class Plate {
   private  int food;
    private boolean satiety = false;

    public Plate(int food) {
        this.food = food;
    }


    public void decrease(String name, int amount){
    int f = food;
        if ((food-=amount) < 0){
            food=f;
            satiety =  false;
            System.out.printf("На тарелке количество еды %d, сытость %b %s не хватило еды", food, satiety, name);
        }else {
            satiety = true;
            System.out.printf("%s ест... На тарелке количество еды %d, сытость %b ", name, food, satiety);
        }
        System.out.println();
    }

}
