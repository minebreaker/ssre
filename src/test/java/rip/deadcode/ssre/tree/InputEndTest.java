package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class InputEndTest {

    @Test
    void testCompile() {
        assertThat( Ssre.string( "foo" ).inputEnd().regex() )
                .isEqualTo( "foo\\z" );
        assertThat( Ssre.string( "foo" ).inputEndIgnoringLastLineBreak().regex() )
                .isEqualTo( "foo\\Z" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.string( "foo" ).inputEnd().compile();
        assertThat( p.matcher( "foo\nbar\n" ).find() ).isFalse();
        assertThat( p.matcher( "bar\nfoo\n" ).find() ).isFalse();
        assertThat( p.matcher( "bar\nfoo" ).find() ).isTrue();
        p = Ssre.string( "foo" ).inputEndIgnoringLastLineBreak().compile();
        assertThat( p.matcher( "foo\nbar\n" ).find() ).isFalse();
        assertThat( p.matcher( "bar\nfoo\n" ).find() ).isTrue();
        assertThat( p.matcher( "bar\nfoo" ).find() ).isTrue();
    }
}
