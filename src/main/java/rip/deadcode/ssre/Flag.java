package rip.deadcode.ssre;

import java.util.regex.Pattern;


public enum Flag {

    CASE_INSENSITIVE( Pattern.CASE_INSENSITIVE ),
    MULTILINE( Pattern.MULTILINE ),
    DOTALL( Pattern.DOTALL ),
    UNICODE_CASE( Pattern.UNICODE_CASE ),
    CANON_EQ( Pattern.CANON_EQ ),
    UNIX_LINES( Pattern.UNIX_LINES ),
    LITERAL( Pattern.LITERAL ),
    UNICODE_CHARACTER_CLASS( Pattern.UNICODE_CHARACTER_CLASS ),
    COMMENTS( Pattern.COMMENTS );

    private final int flag;

    private Flag( int flag ) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }
}
