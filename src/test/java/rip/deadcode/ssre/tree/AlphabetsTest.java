package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class AlphabetsTest {

    @Test
    void testCompile() {
        assertThat( Ssre.alphabets().regex() )
                .isEqualTo( "[a-zA-Z]+" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.string( "hello, " ).alphabets().compile();
        assertThat( p.matcher( "hello, " ).matches() ).isFalse();
        assertThat( p.matcher( "hello, world" ).matches() ).isTrue();
        assertThat( p.matcher( "hello, 123" ).matches() ).isFalse();
        assertThat( p.matcher( "hello, _" ).matches() ).isFalse();
    }
}
