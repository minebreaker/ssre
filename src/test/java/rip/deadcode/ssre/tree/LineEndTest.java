package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class LineEndTest {

    @Test
    void testCompile() {
        assertThat( Ssre.string( "foo" ).lineEnd().regex() )
                .isEqualTo( "foo$" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.string( "foo" ).lineEnd().compile();
        assertThat( p.matcher( "foo bar" ).find() ).isFalse();
        assertThat( p.matcher( "bar foo" ).find() ).isTrue();
    }
}
