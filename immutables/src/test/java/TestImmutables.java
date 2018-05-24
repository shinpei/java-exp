import com.github.shinpei.javaexp.immutables.ImmutableOurs;
import com.github.shinpei.javaexp.immutables.Ours;
import org.junit.jupiter.api.Test;

public class TestImmutables {

    @Test
    void testImm() {
        Ours ours = ImmutableOurs.builder()
                .hoge(3)
                .fuga(4)
                .build();
        System.out.println(ours.hi());
        ours.bye();
    }


}
