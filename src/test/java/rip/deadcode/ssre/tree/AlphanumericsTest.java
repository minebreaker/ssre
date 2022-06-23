package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class AlphanumericsTest {

    @Test
    void testCompile() {
        assertThat( Ssre.alphanumerics().regex() )
                .isEqualTo( "[a-zA-Z0-9]+" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.string( "hello, " ).alphanumerics().compile();
        assertThat( p.matcher( "hello, " ).matches() ).isFalse();
        assertThat( p.matcher( "hello, world" ).matches() ).isTrue();
        assertThat( p.matcher( "hello, _" ).matches() ).isFalse();
    }
}
