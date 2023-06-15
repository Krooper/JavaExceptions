/*
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */

import java.util.Arrays;

public class Main {
    public static int[] ArrIdxExc(int[] arr) {
        for (int i = 0; i <= 5; i++) {
            try {
                arr[i] = i + 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of Array!");
            }
        }
        return arr;
    }

    public static int FormatExc(String myStr, int intVar) {
        try {
            intVar = new Integer(myStr);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input String! Var unchanged!");
        }
        return intVar;
    }

    public static int[] ArrSize(int arrSize) {
        try {
            return new int[arrSize];
        } catch (NegativeArraySizeException e) {
            System.out.println("Negative array size!");
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int[] newArr = new int[5];
        System.out.println(Arrays.toString(ArrIdxExc(newArr)));

        int newVar = 0;
        newVar = FormatExc("str", newVar);
        System.out.println(newVar);

        System.out.println(Arrays.toString(ArrSize(-1)));
    }
}