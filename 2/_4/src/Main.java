import java.util.Objects;
import java.util.Scanner;

/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/
class EmptyInputException extends RuntimeException {
    public EmptyInputException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) throws EmptyInputException {
        Scanner in = new Scanner(System.in);
        String inpStr = in.nextLine();
        in.close();
        if (Objects.equals(inpStr, "")) {
            throw new EmptyInputException("Empty string entered!");
        } else {
            System.out.println("String entered: " + inpStr);
        }
    }
}