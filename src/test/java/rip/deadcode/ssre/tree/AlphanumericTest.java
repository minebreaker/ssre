package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class AlphanumericTest {

    @Test
    void testCompile() {
        assertThat( Ssre.alphanumeric().regex() )
                .isEqualTo( "[a-zA-Z0-9]" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.alphanumeric().compile();
        assertThat( p.matcher( "a" ).matches() ).isTrue();
        assertThat( p.matcher( "0" ).matches() ).isTrue();
        assertThat( p.matcher( "_" ).matches() ).isFalse();
        assertThat( p.matcher( "." ).matches() ).isFalse();
    }
}
