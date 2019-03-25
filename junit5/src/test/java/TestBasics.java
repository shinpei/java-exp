import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBasics {

    @Test
    void testWithoutPublic() {
        // test method doesn't need to be

    }

    @Test
    @DisplayName("This is a named test")
    void testNameTest() {

    }

    @Test
    void testExceptionThrow() {
        assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException();
        });
    }

    @Test
    @Disabled
    void testDisabled() {
        // this is disabled test
    }

    @Test
    void testSomething() {
        throw
    }
}
