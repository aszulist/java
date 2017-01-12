import java.io.*;
import java.util.ArrayList;

public class ReadObjects {

    public static void main(String[] args) {
        System.out.println("Reading objects...");


        try (ObjectInputStream os = new ObjectInputStream(new FileInputStream("people.bin"))) {

            Person person = (Person) os.readObject();
            System.out.println(person);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
