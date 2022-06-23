package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class DigitTest {


    @Test
    void testCompile() {
        assertThat( Ssre.string( "n" ).digit().string( "n" ).regex() )
                .isEqualTo( "n\\dn" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.string( "n" ).digit().string( "n" ).compile();
        assertThat( p.matcher( "n0n" ).matches() ).isTrue();
        assertThat( p.matcher( "nnn" ).matches() ).isFalse();
        assertThat( p.matcher( "n零n" ).matches() ).isFalse();
    }
}
