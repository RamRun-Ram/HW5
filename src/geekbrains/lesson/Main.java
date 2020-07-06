package geekbrains.lesson;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long t =System.currentTimeMillis();
        solidArrayInput(10000000);
        System.out.println(System.currentTimeMillis()-t + "ms - один поток");
        long s =System.currentTimeMillis();
        splitArrayInput(10000000);
        System.out.println(System.currentTimeMillis()-s+"ms - два потока");
        System.out.println(System.currentTimeMillis()-t+"ms - итого");
    }
    public static void solidArrayInput(int size){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        for(int i=0;i<arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
    }
    public static void splitArrayInput(int size){
        float[] arr = new float[size];
        int halfArr = size / 2;
        Arrays.fill(arr, 1);
        float[]arr1half= new  float[halfArr];
        float[]arr2half= new  float[halfArr];
        System.arraycopy(arr, 0, arr1half, 0, halfArr);
        System.arraycopy(arr, halfArr, arr2half, 0, halfArr);
        for(int i=0;i<arr1half.length;i++){
            arr1half[i] = (float)(arr1half[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            arr2half[i] = (float)(arr2half[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(arr1half,0, arr, 0, halfArr);
        System.arraycopy(arr2half, 0, arr, halfArr, halfArr);
    }
}


