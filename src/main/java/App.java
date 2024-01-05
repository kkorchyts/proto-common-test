import com.kkorchyts.grpc.addressbook.AddressBook;
import com.kkorchyts.grpc.addressbook.Person;

public class App {
    public static void main(String[] args) {
        Person personMike = Person.newBuilder()
                .setId(1)
                .setName("Mike")
                .setEmail("mike@google.com")
                .build();
        AddressBook addressBook = AddressBook.newBuilder()
                .addPeople(personMike).build();
        System.out.println(personMike);
        System.out.println(addressBook);
    }
}
