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

    public static Builder anyChar() {
        return new Builder().anyChar();
    }

    public static Builder alphanumeric() {
        return new Builder().alphanumeric();
    }

    public static Builder alphanumerics() {
        return new Builder().alphanumerics();
    }

    public static Builder alphabet() {
        return new Builder().alphabet();
    }

    public static Builder alphabets() {
        return new Builder().alphabets();
    }

    public static Builder wordChar() {
        return new Builder().wordChar();
    }

    public static Builder word() {
        return new Builder().word();
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

    public static Builder lineBegin() {
        return new Builder().lineBegin();
    }

    public static Builder lineEnd() {
        return new Builder().lineEnd();
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
