import java.io.*;
import java.util.ArrayList;

public class ReadObjects {

    public static void main(String[] args) {
        System.out.println("Reading objects...");


        try (FileInputStream fi = new FileInputStream("people.bin")) {

            try (ObjectInputStream os = new ObjectInputStream(fi)) {

                Person[] people = (Person[]) os.readObject();

                @SuppressWarnings({"unchecked"})
                ArrayList<Person> peopleList = (ArrayList<Person>) os.readObject();

                for (Person person : people) {
                    System.out.println(person);
                }

                for (Person person : peopleList) {
                    System.out.println(person);
                }

                int num = os.readInt();

                for (int i = 0; i < num; i++) {
                    Person person = (Person) os.readObject();
                    System.out.println(person);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
