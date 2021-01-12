import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.

public class OptionalTask3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("ot3//info.txt")));
        ArrayList<String> list = new ArrayList<>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            while (tokenizer.hasMoreTokens()){
                list.add(tokenizer.nextToken());
            }
        }
        bufferedReader.close();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > 2){
                list.add(i+1, list.get(i).toLowerCase());
                list.remove(i);
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("ot3//info2.txt")));
        for (int i = 0; i < list.size(); i++) {
            bufferedWriter.write(list.get(i) + " ");
        }
        bufferedWriter.close();
    }
}
