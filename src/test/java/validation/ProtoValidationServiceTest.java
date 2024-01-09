package validation;

import com.kkorchyts.grpc.addressbook.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProtoValidationServiceTest {
    @Test
    void validateDoesntThrowExceptionTest(){
        ProtoValidationService protoValidationService = new ProtoValidationService();
        Person person = Person.newBuilder().setId(1).setName("Test").setEmail("test@gmail.com").build();

        assertDoesNotThrow(
                () -> protoValidationService.validate(person)
        );
    }

    @Test
    void validateThrowExceptionTest(){
        ProtoValidationService protoValidationService = new ProtoValidationService();
        Person person = Person.newBuilder().setId(1).setName("Test").setEmail("gmail.com").build();

        assertThrows(
                ProtoValidationException.class,
                () -> protoValidationService.validate(person)
        );
    }

    @Test
    void validateDoesntThrowExceptionImEmailAbsentTest(){
        ProtoValidationService protoValidationService = new ProtoValidationService();
        Person person = Person.newBuilder().setId(1).setName("Test").build();

        assertDoesNotThrow(
                () -> protoValidationService.validate(person)
        );
    }
}
