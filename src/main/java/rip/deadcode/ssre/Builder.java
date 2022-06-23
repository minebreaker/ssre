package rip.deadcode.ssre;

import rip.deadcode.ssre.internal.Utils;
import rip.deadcode.ssre.tree.Blank;
import rip.deadcode.ssre.tree.Blanks;
import rip.deadcode.ssre.tree.Digit;
import rip.deadcode.ssre.tree.Digits;
import rip.deadcode.ssre.tree.Element;
import rip.deadcode.ssre.tree.Repeat;
import rip.deadcode.ssre.tree.StringElement;
import rip.deadcode.ssre.tree.Whitespace;
import rip.deadcode.ssre.tree.Whitespaces;

import java.util.List;
import java.util.regex.Pattern;


public final class Builder {

    private final List<Element> tree;

    Builder() {
        this.tree = List.of();
    }

    private Builder( List<Element> tree ) {
        this.tree = tree;
    }

    private Builder add( Element e ) {
        return new Builder( Utils.add( this.tree, e ) );
    }

    public Builder string( String value ) {
        return add( new StringElement( value ) );
    }

    public Builder digit() {
        return add( Digit.getInstance() );
    }

    public Builder digits() {
        return add( Digits.getInstance() );
    }

    public Builder whitespace() {
        return add( Whitespace.getInstance() );
    }

    public Builder whitespaces() {
        return add( Whitespaces.getInstance() );
    }

    public Builder blank() {
        return add( Blank.getInstance() );
    }

    public Builder blanks() {
        return add( Blanks.getInstance() );
    }

    public Builder repeat( Builder builder ) {
        return add( new Repeat( builder, 1, -1, false ) );
    }

    public Builder repeat( Builder builder, int count ) {
        return add( new Repeat( builder, count, count, false ) );
    }

    public Builder repeat( Builder builder, int min, int max ) {
        return add( new Repeat( builder, min, max, false ) );
    }

    public String regex() {
        return compile( this.tree );
    }

    public static String compile( List<Element> elements ) {

        if ( elements.isEmpty() ) {
            return "";
        }

        var first = elements.get( 0 );
        var rest = elements.subList( 1, elements.size() );
        return first.compile( rest );
    }

    public Pattern compile() {
        return Pattern.compile( regex() );
    }
}
