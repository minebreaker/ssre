package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class WordTest {

    @Test
    void testCompile() {
        assertThat( Ssre.word().regex() )
                .isEqualTo( "\\w+" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.string( "hello, " ).word().compile();
        assertThat( p.matcher( "hello, " ).matches() ).isFalse();
        assertThat( p.matcher( "hello, world" ).matches() ).isTrue();
        assertThat( p.matcher( "hello, _" ).matches() ).isTrue();
        assertThat( p.matcher( "hello, ." ).matches() ).isFalse();
    }
}
