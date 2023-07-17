import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println();
        System.out.println("First part");
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
        try(FileOutputStream fos = new FileOutputStream("C:\\Java\\file1.txt")){
            fos.write(str.getBytes());
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        try(FileInputStream fis = new FileInputStream("C:\\Java\\file1.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Java\\file2.txt")){
            byte[] buffer = new byte[fis.available()];
            int count;
            while((count = fis.read(buffer)) != -1){
                fos.write(buffer, 0, buffer.length);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(file1.delete() && file2.delete()){
            System.out.println("Files successfully deleted");
        }
        if(dir.delete()){
            System.out.println("Directory successfully deleted");
        }
        System.out.println();
        System.out.println("Second part");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cat.dat"))){
            Cat cat = new Cat("Aki", 5, 2.3);
            oos.writeObject(cat);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cat.dat"))){
            Cat c = (Cat) ois.readObject();
            System.out.println(c);
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}