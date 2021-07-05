package hw_5;

public class Employee {
    private String name; // private -поле доступно в классе Employee
    private String post; // private static - хранится в классе на все объекты одно и то же
    private String email;
    private String telephone;
    Double salary;
    private int age;

    public Employee(String name, String post, String email, String telephone, Double salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;

    }

    // конструктор Alt+ins

    public Employee(String name, String post, String email) {
        this.name = name;
        this.post = post;
        this.email = email;
        System.out.printf("Employee %s %s %s  \n",name, post, email);
    }


       // получить закрытое поле
    public String getPost() {
        return post;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0 || age > 200 ){
            System.out.println("Проверьте введенный возраст");
            return;
        }
        this.age = age;
        System.out.println(age);
    }

        // для вывода на печать
    @Override
    public String toString() {
        return "Employee (toString){" +
                "name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public void info(){
        System.out.printf("Employee (info) %s %s %s %s %f %d \n", name, post, email,telephone,salary, age);

}

}
