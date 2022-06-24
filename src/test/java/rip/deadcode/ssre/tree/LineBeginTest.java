package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class LineBeginTest {

    @Test
    void testCompile() {
        assertThat( Ssre.lineBegin().string( "foo" ).regex() )
                .isEqualTo( "^foo" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.lineBegin().string( "foo" ).compile();
        assertThat( p.matcher( "foo bar" ).find() ).isTrue();
        assertThat( p.matcher( "bar foo" ).find() ).isFalse();
    }
}
