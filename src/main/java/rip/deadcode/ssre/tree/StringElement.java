package rip.deadcode.ssre.tree;

import static java.util.stream.Collectors.joining;
import static rip.deadcode.ssre.internal.Utils.codepointToString;


public final class StringElement implements Element.Isolated {

    private final String value;

    public StringElement( String value ) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override public String compile() {
        return value.codePoints()
                    .mapToObj( cp -> {
                        if ( cp == '.' ||
                             cp == '^' ||
                             cp == '$' ||
                             cp == '*' ||
                             cp == '+' ||
                             cp == '?' ||
                             cp == '(' ||
                             cp == ')' ||
                             cp == '[' ||
                             cp == '{' ||
                             cp == '\\' ||
                             cp == '|' ) {
                            return "\\" + (char) cp;
                        } else {
                            return codepointToString( cp );
                        }
                    } )
                    .collect( joining() );
    }
}
