package lesson5;

public class PersonDemo {
    public static void main(String[] args) {
        Person persons[] = new Person[5];
        persons[0] = new Person("Ivanov Ivan Ivanovich","Engineer","ivanovE@mail.ru",
                89378745341L,150000,26);
        persons[1] = new Person("Petrov Petr Petrovich","Programmer","PetrovP@mail.ru",
                89378745341L,150000,46);
        persons[2] = new Person("Sidorov Ivan Vladimirovich","Scientist","SidorovE@mail.ru",
                89378745341L,150000,58);
        persons[3] = new Person("Valeev Ivan Ivanovich","Pilot","ValeevI@mail.ru",
                89378745341L,150000,35);
        persons[4] = new Person("Ivanov Michael Ivanovich","Lawyer","ivanovMichael@mail.ru",
                89378745341L,150000,42);

        for (Person person : persons){
            if (person.getAge() > 40) {
                person.printEmployeeInfo();
                System.out.println("######################################");
            }
        }
    }
}
