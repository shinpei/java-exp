import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestMockito {

    public class Animal {
        private String kind;
        // public required for mocking
        public String kind() {
            return this.kind;
        }
    }

    private boolean isDear (Animal animal) {
        return  "dear".equals(animal.kind());
    }

    /**
     * When and thenReturn
     */
    @Test
    void basicWhen() {
        Animal animal = mock(Animal.class);
        when(animal.kind()).thenReturn("dear");

        assertTrue(isDear(animal));
    }

}
