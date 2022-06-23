package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class AnyCharTest {

    @Test
    void testCompile() {
        assertThat( Ssre.string( "hello " ).anyChar().regex() )
                .isEqualTo( "hello ." );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.string( "hello " ).anyChar().compile();
        assertThat( p.matcher( "hello " ).matches() ).isFalse();
        assertThat( p.matcher( "hello w" ).matches() ).isTrue();
        assertThat( p.matcher( "hello wo" ).matches() ).isFalse();
    }
}
