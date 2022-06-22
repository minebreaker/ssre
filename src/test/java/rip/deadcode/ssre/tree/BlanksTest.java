package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class BlanksTest {

    @Test
    void testCompile() {
        assertThat( Ssre.string( "hello" ).blanks().string( "world" ).regex() )
                .isEqualTo( "hello\\s+world" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.string( "hello" ).blanks().string( "world" ).compile();
        assertThat( p.matcher( "helloworld" ).matches() ).isFalse();
        assertThat( p.matcher( "hello world" ).matches() ).isTrue();
        assertThat( p.matcher( "hello  world" ).matches() ).isTrue();
        assertThat( p.matcher( "hello\tworld" ).matches() ).isTrue();
        assertThat( p.matcher( "hello \tworld" ).matches() ).isTrue();
    }
}
