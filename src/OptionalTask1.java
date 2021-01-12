import java.io.*;
import java.util.Arrays;

//  Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

public class OptionalTask1 {
    public static void main(String[] args) throws IOException {
        int [] array = {(int) (Math.random()*49), (int) (Math.random()*100), (int) (Math.random()*49), (int) (Math.random()*49), (int) (Math.random()*49)};
        System.out.println(Arrays.toString(array));
        FileInputStream fileInputStream = new FileInputStream("ot1//info.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("ot1//info.txt");
        for (int i = 0; i < array.length; i++) {
            fileOutputStream.write(array[i]);
        }
        fileOutputStream.close();
        int [] arrayDecode = new int[fileInputStream.available()];
        while (fileInputStream.available() != 0){
            for (int i = 0; i < arrayDecode.length; i++) {
                arrayDecode[i] = fileInputStream.read();
            }
        }
        fileInputStream.close();
        int tmp = 0;
        for (int i = 0; i < arrayDecode.length; i++) {
            for (int j = 0; j < arrayDecode.length-1; j++) {
                if (arrayDecode[j] > arrayDecode[j+1]){
                    tmp = arrayDecode[j];
                    arrayDecode[j] = arrayDecode[j+1];
                    arrayDecode[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arrayDecode));
    }
}