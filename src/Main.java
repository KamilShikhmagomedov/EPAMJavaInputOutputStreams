import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            return;
        } else if (args[0].equals("movies//")){
            File file = new File(args[0]);
            createFileDir(file);
        } else if (args[0].equals("movies//info.txt")){
            int countFolder = countFolder();
            int countFiles = countFiles();
            int absFilesInFolder = absFilesInFolder();
            int absFileLength = absFileLength();
            System.out.println("Количество папок - " + countFolder + ", " + "количество файлов - " + countFiles + ", " + "среднее количество файлов - " + absFilesInFolder + ", " + "средняя длинна названия файла - " + absFileLength + ".");
        }
    }

    public static void createFileDir(File rootFile){
        try (PrintWriter printWriter = new PrintWriter(new File("movies//info.txt"))) {
            if (rootFile.isDirectory()){
                File[] files = rootFile.listFiles();
                if (files != null){
                    for (File searchFiles : files){
                        if (searchFiles.isDirectory()){
                            printWriter.println("|---"+searchFiles.getName());
                            File [] listFiles = searchFiles.listFiles();
                            for (File searchFileInListFiles : listFiles){
                                if (searchFileInListFiles.isFile()){
                                    printWriter.println("|   " + searchFileInListFiles.getName());
                                }
                            }
                            createFileDir(searchFiles);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int countFolder(){
        int countFolder = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("movies//info.txt"))){
            while (bufferedReader.ready()){
                String b = bufferedReader.readLine();
                if (b.startsWith("|---")){
                    countFolder++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countFolder;
    }

    public static int countFiles(){
        int countFiles = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("movies//info.txt"))){
            while (bufferedReader.ready()){
                String b = bufferedReader.readLine();
                if (b.startsWith("|   ")){
                    countFiles++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countFiles;
    }

    public static int absFilesInFolder(){
        int allLenght = 0;
        int countFiles = 0;
        int absFiles = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("movies//info.txt"))){
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                if (line.endsWith(".mp3")){
                    StringTokenizer tokenizer = new StringTokenizer(line.substring(8));
                    countFiles = tokenizer.countTokens();
                    allLenght++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        absFiles = allLenght/countFiles;
        return absFiles;
    }

    public static int absFileLength(){
        int countElements = 0;
        int fileLength = 0;
        int absFilesLength = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("movies//info.txt"))){
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                if (line.endsWith(".mp3")){
                    countElements++;
                    fileLength += line.substring(8).length()-4; // -4 это .mp3
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        absFilesLength = fileLength/countElements;
        return absFilesLength;
    }
}