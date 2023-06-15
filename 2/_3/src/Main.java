import java.util.Arrays;


/*
Дан следующий код, исправьте его там, где требуется
*/


/*
Убрал отлов исключений, которых не было в коде.
Разнес всё по отдельным методам.
*/
public class Main {
    public static void main(String[] args) {
        printDiv(90, 3);
        printSum(23, 234);
        ArrOp(new int[4]);
    }

    // Перенес catch в метод printSum() для улучшения читаемости.
    public static void printSum(Integer a, Integer b) {
        try {
            System.out.println(a + b);
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        }
    }

    // Добавил метод для деления со своей обработкой исключения.
    public static void printDiv(Integer a, Integer b) {
        try {
            System.out.println(a / b);
        } catch (ArithmeticException ex) {
            System.out.println("Деление на 0!");
        }
    }

    /*
    Добавил метод для операций с массивом.
    Исправил объявление массива, до этого ловилось исключение,
    массив изменился (можно было оставить как есть, если смысл исключительно в отлове исключения).
    */
    public static void ArrOp(int[] arr) {
        try {
            arr[0] = 1;
            arr[1] = 2;
            arr[3] = 9;
            System.out.println(Arrays.toString(arr));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }
}