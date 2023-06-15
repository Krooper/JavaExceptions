import java.util.InputMismatchException;
import java.util.Scanner;


/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
необходимо повторно запросить у пользователя ввод данных.
 */


public class Main {
    public static float NumRequest() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        try {
            float num = in.nextFloat();
            in.close();
            return num;
        } catch (InputMismatchException e) {
            System.out.print("Not a number!\n");
            return NumRequest();
        }
    }

    public static void main(String[] args) {
        System.out.println(NumRequest());
    }
}