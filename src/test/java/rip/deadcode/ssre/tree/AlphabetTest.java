package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class AlphabetTest {

    @Test
    void testCompile() {
        assertThat( Ssre.alphabet().regex() )
                .isEqualTo( "[a-zA-Z]" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.alphabet().compile();
        assertThat( p.matcher( "a" ).matches() ).isTrue();
        assertThat( p.matcher( "0" ).matches() ).isFalse();
        assertThat( p.matcher( "_" ).matches() ).isFalse();
    }
}
