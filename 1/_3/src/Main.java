import java.util.Arrays;

/*
Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */
class SizeException extends RuntimeException {
    public SizeException(String message) {
        super(message);
    }
}

public class Main {
    public static Double[] ArrElDiff(int[] firstArr, int[] secArr) throws SizeException {
        if (firstArr.length != secArr.length) {
            throw new SizeException("Arrays have different sizes!");
        }

        Double[] newArr = new Double[firstArr.length];
        for (int i = 0; i < firstArr.length; i++) {
            try {
                newArr[i] = (double) (firstArr[i] / secArr[i]);
            } catch (ArithmeticException e) {
                System.out.printf("Dividing by Zero at index: %d\n", i);
                if (firstArr[i] >= 0) {
                    newArr[i] = Double.POSITIVE_INFINITY;
                } else {
                    newArr[i] = Double.NEGATIVE_INFINITY;
                }
            }
        }
        return newArr;
    }

    public static void main(String[] args) throws SizeException {
        int[] Arr1 = {5, 4, 3, 2, 1, -6};
        int[] Arr2 = {1, 2, 3, 4, 5, 0, 321};

        System.out.println(Arrays.toString(ArrElDiff(Arr1, Arr2)));
    }
}