package lesson5;

import java.util.Arrays;

public class ThreadTest {
    static final int size = 10_000_000;
    static final int h = size/2;
    public static void main(String[] args) {
        System.out.println("Without Thread: " + noThread());
        System.out.println("With Thread: " + withThread());

    }
    public static long noThread(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long start = System.currentTimeMillis();
        for (int i=0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        long end = System.currentTimeMillis() - start;
        return end;
    }
    public static long withThread(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long start = System.currentTimeMillis();
        System.arraycopy(arr,0,a1,0,h);
        System.arraycopy(arr,h,a2,0,h);
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i=0; i < a1.length; i++)
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5)
                                             * Math.cos(0.2f + i / 5)
                                             * Math.cos(0.4f + i / 2));
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i=0; i < a2.length; i++)
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5)
                            * Math.cos(0.2f + i / 5)
                            * Math.cos(0.4f + i / 2));
            }
        };
        t1.start();
        t2.start();
        System.arraycopy(a1,0,arr,0,h);
        System.arraycopy(a2,0,arr,h,h);
        long end = System.currentTimeMillis() - start;
        return end;
    }
}
