package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;


public final class WordCharTest {

    @Test
    void testCompile() {
        assertThat( Ssre.wordChar().regex() )
                .isEqualTo( "\\w" );
    }

    @Test
    void testMatching() {
        Pattern p = Ssre.word().compile();
        assertThat( p.matcher( "a" ).matches() ).isTrue();
        assertThat( p.matcher( "_" ).matches() ).isTrue();
        assertThat( p.matcher( "." ).matches() ).isFalse();
    }
}
