import java.util.Arrays;

/*
Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */
class SizeException extends RuntimeException {
    public SizeException(String message) {
        super(message);
    }
}


public class Main {
    public static int[] ArrElDiff(int[] firstArr, int[] secArr) throws SizeException {
        if (firstArr.length != secArr.length) {
            throw new SizeException("Arrays have different sizes!");
        }

        int[] newArr = new int[firstArr.length];
        for (int i = 0; i < firstArr.length; i++) {
            newArr[i] = firstArr[i] - secArr[i];
        }
        return newArr;
    }

    public static void main(String[] args) throws SizeException {
        int[] Arr1 = {5, 4, 3, 2, 1};
        int[] Arr2 = {1, 2, 3, 4, 5, 0};

        System.out.println(Arrays.toString(ArrElDiff(Arr1, Arr2)));
    }
}