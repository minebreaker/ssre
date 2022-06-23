package rip.deadcode.ssre.tree;

import org.junit.jupiter.api.Test;
import rip.deadcode.ssre.Ssre;

import static com.google.common.truth.Truth.assertThat;


public final class StringElementTest {

    @Test
    void testCompile() {
        assertThat( Ssre.string( "hello world" ).regex() )
                .isEqualTo( "hello world" );
        assertThat( Ssre.string( "hello" ).string( " world" ).regex() )
                .isEqualTo( "hello world" );
        assertThat( Ssre.string( "hello.world" ).regex() )
                .isEqualTo( "hello\\.world" );
    }

    @Test
    void testMatching() {
        assertThat( Ssre.string( "hello world" )
                        .compile().matcher( "hello world" ).matches() ).isTrue();
        assertThat( Ssre.string( "hello.world" )
                        .compile().matcher( "hello.world" ).matches() ).isTrue();
    }
}
