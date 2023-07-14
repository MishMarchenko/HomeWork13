import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        /*
        *Создать с помощью класса File папку ( проверить что она создана), в ней создать 2 файла
        *(так же проверить что они созданы), записать в 1 из файлов фразу "Java world". Далее используя FileWriter/Reader или
        *FileInput/OutputStream ( на ваш выбор), считать с 1-го файла фразу Java World и результат записать в другой файл.
        *После удалить оба файла используя класс File и удалить директорию.
         */
        String str = "Java World";
        File dir = new File("C:\\Java");
        boolean createDir = dir.mkdir();
        if(createDir){
            System.out.println("Directory successfully created");
        }
        if(dir.exists()){
            System.out.println("Directory exist");
        }
        File file1 = new File("C:\\Java\\file1.txt");
        File file2 = new File("C:\\Java\\file2.txt");
        try{
            boolean createFile1 = file1.createNewFile();
            boolean createFile2 = file2.createNewFile();
            if(createFile1 && createFile2){
                System.out.println("Files successfully created");
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        if (file1.exists() && file2.exists()){
            System.out.println("Files exists");
        }

        try(FileWriter writeFirstFile = new FileWriter("C:\\Java\\file1.txt", false)){
            writeFirstFile.write(str);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        try(FileReader readFirstFile = new FileReader("C:\\Java\\file1.txt")){
            int i;
            while ((i = readFirstFile.read()) != -1){
                System.out.print((char) i);
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }



//        if(file1.delete() && file2.delete()){
//            System.out.println("Files successfully deleted");
//        }
//        if(dir.delete()){
//            System.out.println("Directory successfully deleted");
//        }
    }
}