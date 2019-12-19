package hw2;

import java.util.Random;

public class HomeWork2 {
    private static Random rnd = new Random();
    private static final int SIZE = 100000;
    private static Integer[] arr = new Integer[SIZE];

    static void initArr (){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(SIZE + 1);
        }
    }

    static void switchArrElements(int ind1, int ind2){
        Integer temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    static void bubbleSort (){
        boolean isSwitched;
        for (int i = arr.length - 1; i > 0; i--) {
            isSwitched = false;
            for (int j = 0; j < i; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0){
                    switchArrElements(j, j + 1);
                    isSwitched = true;
                }
            }
            if(!isSwitched) break;
        }
    }

    static void selectionSort(){
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[indexOfMin]) < 0){
                    indexOfMin = j;
                }
            }
            switchArrElements(i, indexOfMin);
        }
    }

    static void insertionSort(){
        Integer num;
        for (int i = 1; i < arr.length; i++) {
            num = arr[i];
            int j = i;
            while (j > 0 && num.compareTo(arr[j - 1]) < 0){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = num;
        }
    }

    static long timer(String method){
        long startingTime = System.currentTimeMillis();
        switch (method){
            case "bubble":
                bubbleSort();
                return System.currentTimeMillis() - startingTime;
            case "selection":
                selectionSort();
                return System.currentTimeMillis() - startingTime;
            case "insertion":
                insertionSort();
                return System.currentTimeMillis() - startingTime;
        }
        return 0;
    }

    public static void main(String[] args) {
        initArr();
        System.out.println("bubbleSort() time of " + SIZE + " elements is: " + timer("bubble") + " mSec");
        initArr();
        System.out.println("selectionSort() time of " + SIZE + " elements is: " + timer("selection") + " mSec");
        initArr();
        System.out.println("insertionSort() time of " + SIZE + " elements is: " + timer("insertion") + " mSec");
    }
}
