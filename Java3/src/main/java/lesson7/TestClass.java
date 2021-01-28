package lesson7;

public class TestClass {
    @BeforeSuite
    public void fo1(){
        System.out.println("Its method fo1 with @BeforeSuite");
    }

    @AfterSuite
    public void fo2(){
        System.out.println("Its method fo2 with @AfterSuite");
    }
    @Test(priority = 3)
    public void fo3(){
        System.out.println("Its method fo3 with @Test, priority = 3");
    }
    @Test(priority = 9)
    public void fo4(){
        System.out.println("Its method fo4 with @Test, priority = 9");
    }
    @Test(priority = 2)
    public void fo5(){
        System.out.println("Its method fo5 with @Test, priority = 2");
    }

//    @BeforeSuite
//    public void fo6(){
//        System.out.println("Its method fo6 with @BeforeSuite");
//    }
//    @AfterSuite
//    public void fo7(){
//        System.out.println("Its method fo7 with @AfterSuite");
//    }
}
