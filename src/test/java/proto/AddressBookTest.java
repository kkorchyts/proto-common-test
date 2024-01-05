package proto;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.kkorchyts.grpc.addressbook.AddressBook;
import com.kkorchyts.grpc.addressbook.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressBookTest {

    @Mock
    private Person person;

    @Test
    void addPersonTest() {
        AddressBook addressBook = AddressBook.newBuilder().addPeople(person).build();
        assertEquals(1, addressBook.getPeopleCount());
    }
}
