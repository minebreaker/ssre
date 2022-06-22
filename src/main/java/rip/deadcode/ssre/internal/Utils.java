package rip.deadcode.ssre.internal;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toUnmodifiableList;


public final class Utils {

    private Utils() {
        throw new Error();
    }

    public static <T> List<T> add( List<T> list, T value ) {
        return Stream.concat( list.stream(), Stream.of( value ) ).collect( toUnmodifiableList() );
    }

    // https://stackoverflow.com/a/54376494
    public static String codepointToString( int cp ) {
        StringBuilder sb = new StringBuilder();
        if ( Character.isBmpCodePoint( cp ) ) {
            sb.append( (char) cp );
        } else if ( Character.isValidCodePoint( cp ) ) {
            sb.append( Character.highSurrogate( cp ) );
            sb.append( Character.lowSurrogate( cp ) );
        } else {
            throw new IllegalArgumentException( String.format( "Invalid code point: '%d'", cp ) );
        }
        return sb.toString();
    }
}
