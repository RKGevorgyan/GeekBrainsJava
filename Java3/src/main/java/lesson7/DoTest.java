package lesson7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class DoTest {
    private static int countBefore = 0;
    private static int countAfter = 0;
    final static int MIN_PRIORITY = 1;
    final static int MAX_PRIORITY = 10;
        public static void start(Class<?> className) {

            Map<Integer, Method> map = new TreeMap<>();

            for (Method method : className.getDeclaredMethods()) {
                method.setAccessible(true);
                if (method.getAnnotation(BeforeSuite.class) != null) {
                    countBefore++;
                    if (countBefore > 1) throw new RuntimeException("2 or more @BeforeSuite detected");
                    map.put(MIN_PRIORITY - 1, method);
                }
                if (method.getAnnotation(AfterSuite.class) != null) {
                    countAfter++;
                    if (countAfter > 1) throw new RuntimeException("2 or more AfterSuite detected");
                    map.put(MAX_PRIORITY + 1, method);
                }
                if (method.getAnnotation(Test.class) != null) {
                    Test test = method.getAnnotation(Test.class);
                    map.put(test.priority(), method);
                }
            }

            try {
                Object testCase = className.getDeclaredConstructor().newInstance();
                for (Integer key : map.keySet()) {
                    map.get(key).invoke(testCase);
                }
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }

        }

        public static void main(String[] args) {
            start(TestClass.class);

        }
}
