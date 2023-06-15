import java.io.*;
import java.util.Scanner;

public class Main {
    //Метод "приветствия" и ввода строки, возвращающий массив из этой строки.
    public static String[] strInput() {
        for (int i = 0; i < 50; i++) {
            if (i == 49) {
                System.out.print("-\n");
            } else {
                System.out.print("-");
            }
        }

        System.out.println("Enter your data in format: \"Surname Name Patronymic_name Telephone_number\"\n" +
                "Note: Telephone number must not contain special symbols!");

        for (int i = 0; i < 50; i++) {
            if (i == 49) {
                System.out.print("-\nInput: ");
            } else {
                System.out.print("-");
            }
        }

        Scanner in = new Scanner(System.in);
        String inpStr = in.nextLine();
        return inpStr.split(" ", 4);
    }

    /*
    Решил не делать проверку на большее кол-во данных,
    т.к. по сути такой случай будет обработан при попытке распарсить номер телефона.
    Если бы оставляли в задании произвольный порядок, надо бы было делать и эту проверку тоже :).
    */
    public static String[] strArrLengthCheckLess(String[] strArr) {
        String[] checkedArr = new String[4];
        try {
            System.arraycopy(strArr, 0, checkedArr, 0, 4);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Wrong data input! Must be 4 arguments, but less (%d) were given!\n", strArr.length);
            String[] newStr = strInput();
            return strArrLengthCheckLess(newStr);
        }
        return checkedArr;
    }

    //Проверка возможности распарсить номер телефона.
    public static String[] strToIntCheck(String[] strArr) {
        try {
            Long.valueOf(strArr[3]);
        } catch (NumberFormatException e) {
            System.out.printf("Telephone number wrong format: %s.\nInput data once again!\n", strArr[3]);
            return strToIntCheck(strArrLengthCheckLess(strInput()));
        }
        return strArr;
    }

    //Метод? выбирающий создавать новый файл или дозаписывать в существующий.
    public static void exisitingOrNewFile(String[] dataToWrite) {
        try (FileReader fileReader = new FileReader(dataToWrite[0])) {
            fileWriter(dataToWrite[0], dataToWrite);
            try {
                fileReader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Creating new file.");
            new File(dataToWrite[0]);
            fileWriter(dataToWrite[0], dataToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод, записывающий в файл.
    public static void fileWriter(String fileName, String[] dataToWrite) {
        String text = "<" + dataToWrite[0] + ">" + "<" + dataToWrite[1] + ">" +
                "<" + dataToWrite[2] + ">" + "<" + dataToWrite[3] + ">\n";
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(text);
            System.out.println("Successfully written data to the file");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String[] inpData = strToIntCheck(strArrLengthCheckLess(strInput()));
        exisitingOrNewFile(inpData);
    }
}
