package lesson5;

public class Person {
    private String fullNAme;
    private String position;
    private String email;
    private long phone;
    private int salary;
    private int age;

    public Person(String fullNAme, String position,
                  String email, long phone,
                  int salary, int age) {
        this.fullNAme = fullNAme;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployeeInfo(){
        System.out.printf("Full name: %s\nPosition: %s\n" +
                          "Email: %s\nPhone number: %d\n" +
                          "Salary: %d\nAge: %d\n",
                fullNAme,position,email,phone,salary,age);
    }

    public int getAge() {
        return age;
    }
}
