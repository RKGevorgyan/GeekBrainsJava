package lesson3;



public class Test {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Smirnov",89176165421L);
        phoneBook.add("Zhutin",89176165422L);
        phoneBook.add("Bondarev",89176165423L);
        phoneBook.add("Krasnova",89176165424L);
        phoneBook.add("Zhutin",89176165425L);
        phoneBook.add("Smirnov",89998887766L);

        System.out.println(phoneBook.get("Smirnov"));
        System.out.println(phoneBook.get("Zhutin"));
        System.out.println(phoneBook.get("Bondarev"));
    }
}
