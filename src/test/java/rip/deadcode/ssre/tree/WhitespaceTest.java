package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class WhitespaceTest {

    @Test
    void testCompile() {
        assertThat( Ssre.string( "hello" ).whitespace().string( "world" ).regex() )
                .isEqualTo( "hello world" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.string( "hello" ).whitespace().string( "world" ).compile();
        assertThat( p.matcher( "helloworld" ).matches() ).isFalse();
        assertThat( p.matcher( "hello world" ).matches() ).isTrue();
        assertThat( p.matcher( "hello  world" ).matches() ).isFalse();
        assertThat( p.matcher( "hello\tworld" ).matches() ).isFalse();
    }
}
