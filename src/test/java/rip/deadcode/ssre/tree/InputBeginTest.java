package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class InputBeginTest {

    @Test
    void testCompile() {
        assertThat( Ssre.inputBegin().string( "foo" ).regex() )
                .isEqualTo( "\\Afoo" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.inputBegin().string( "foo" ).compile();
        assertThat( p.matcher( "foo\nbar\n" ).find() ).isTrue();
        assertThat( p.matcher( "bar\nfoo\n" ).find() ).isFalse();
    }
}
