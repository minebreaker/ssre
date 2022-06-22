package rip.deadcode.ssre;

public final class Ssre {

    public static Builder string( String value ) {
        return new Builder().string( value );
    }

    public static Builder whitespace() {
        return new Builder().whitespace();
    }

    public static Builder whitespaces() {
        return new Builder().whitespaces();
    }

    public static Builder blank() {
        return new Builder().blank();
    }

    public static Builder blanks() {
        return new Builder().blanks();
    }

    public static Builder repeat( Builder builder ) {
        return new Builder().repeat( builder );
    }
}
