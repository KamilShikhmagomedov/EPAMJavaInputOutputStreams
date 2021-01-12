import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

public class OptionalTask2 {
    public static void main(String[] args) throws IOException {
        File file = new File("ot2//info.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList<String> arrayList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null ){
            arrayList.add(line);
        }
        bufferedReader.close();
        for (String builder : arrayList){
            System.out.println(new StringBuilder(builder).reverse().toString());
        }
    }
}
