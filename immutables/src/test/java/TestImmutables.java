
import com.github.shinpei.javaexp.immutables.ImmutableBook;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestImmutables {

    /**
     * @Param fields are required when it's build
     */
    @Test
    void testBuildWithoutRequiredParamThrows()  {
        assertThrows(IllegalStateException.class, () ->
                ImmutableBook.builder()
                        .build()
        );
    }

    @Test
    void testBuildWithRequiredParamOK()  {
        ImmutableBook.builder()
                .price(100)
                .weight(10)
                .build();

    }


}
