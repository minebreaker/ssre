package rip.deadcode.ssre;

public final class Ssre {

    public static Builder string( String value ) {
        return new Builder().string( value );
    }

    public static Builder digit() {
        return new Builder().digit();
    }

    public static Builder digits() {
        return new Builder().digits();
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

    public Builder repeat( Builder builder, int count ) {
        return new Builder().repeat( builder, count, count );
    }

    public Builder repeat( Builder builder, int min, int max ) {
        return new Builder().repeat( builder, min, max );
    }
}
