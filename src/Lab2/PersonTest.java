package Lab2;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void testEquals()
    {
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    void testBeforeSerializableAndAfter()
    {
        Person person = new Person("Aniki", 16);
        String serialized = person.toJSON();
        Person unSerialized = Person.fromJSON(serialized);
        boolean expected = true;
        boolean actual = person.equals(unSerialized);
        Assertions.assertEquals(expected, actual);
    }
}