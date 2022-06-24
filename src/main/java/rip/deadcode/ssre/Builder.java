package rip.deadcode.ssre;

import rip.deadcode.ssre.internal.Utils;
import rip.deadcode.ssre.tree.Alphabet;
import rip.deadcode.ssre.tree.Alphabets;
import rip.deadcode.ssre.tree.Alphanumeric;
import rip.deadcode.ssre.tree.Alphanumerics;
import rip.deadcode.ssre.tree.AnyChar;
import rip.deadcode.ssre.tree.Blank;
import rip.deadcode.ssre.tree.Blanks;
import rip.deadcode.ssre.tree.Digit;
import rip.deadcode.ssre.tree.Digits;
import rip.deadcode.ssre.tree.Element;
import rip.deadcode.ssre.tree.InputEnd;
import rip.deadcode.ssre.tree.LineEnd;
import rip.deadcode.ssre.tree.Repeat;
import rip.deadcode.ssre.tree.StringElement;
import rip.deadcode.ssre.tree.Whitespace;
import rip.deadcode.ssre.tree.Whitespaces;
import rip.deadcode.ssre.tree.Word;
import rip.deadcode.ssre.tree.WordChar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public final class Builder {

    private final List<Element> tree;

    Builder() {
        this.tree = List.of();
    }

    private Builder( List<Element> tree ) {
        this.tree = tree;
    }

    Builder add( Element e ) {
        return new Builder( Utils.add( this.tree, e ) );
    }

    /**
     * Matches to exact given string.
     * <code>.^$*+?()[{\|</code> will be escaped.
     */
    public Builder string( String value ) {
        return add( new StringElement( value ) );
    }

    /**
     * Matches to any digit i.e. <code>0123456789</code>.
     * Will not match to other Unicode number characters.
     *
     * <p>Compiled to <code>\d</code> (Note that Java digit character class is equivalent to <code>[0-9]</code>)
     */
    public Builder digit() {
        return add( Digit.getInstance() );
    }

    /**
     * Matches to one or more {@link Builder#digit}s.
     */
    public Builder digits() {
        return add( Digits.getInstance() );
    }

    /**
     * Matches to any character.
     * Note that this will not match to line breaks when {@link Pattern#DOTALL} mode is disabled.
     *
     * <p>Compiled to <code>.</code>
     */
    public Builder anyChar() {
        return add( AnyChar.getInstance() );
    }

    /**
     * Matches to a word character i.e. alphanumeric and underscore(<code>_</code>).
     *
     * <p>Compiled to <code>\w</code></p>
     */
    public Builder wordChar() {
        return add( WordChar.getInstance() );
    }

    /**
     * Compiled to <code>[a-zA-Z0-9]</code>.
     */
    public Builder alphanumeric() {
        return add( Alphanumeric.getInstance() );
    }

    /**
     * Compiled to <code>[a-zA-Z0-9]+</code>.
     */
    public Builder alphanumerics() {
        return add( Alphanumerics.getInstance() );
    }

    /**
     * Compiled to <code>[a-zA-Z]</code>.
     */
    public Builder alphabet() {
        return add( Alphabet.getInstance() );
    }

    /**
     * Compiled to <code>[a-zA-Z]+</code>
     */
    public Builder alphabets() {
        return add( Alphabets.getInstance() );
    }

    /**
     * Matches to a word i.e. one or more alphanumerics and underscores.
     *
     * <p>Compiled to <code>\w+</code></p>
     */
    public Builder word() {
        return add( Word.getInstance() );
    }

    /**
     * Matches to whitespace <code>U+0020</code>.
     */
    public Builder whitespace() {
        return add( Whitespace.getInstance() );
    }

    /**
     * Matches to one or more {@link Builder#whitespace()}s.
     */
    public Builder whitespaces() {
        return add( Whitespaces.getInstance() );
    }

    /**
     * Matches to whitespace, tab, linebreak, and other whitespace characters.
     *
     * <p>Compiled to <code>\s</code>
     */
    public Builder blank() {
        return add( Blank.getInstance() );
    }

    /**
     * Matches to one or more whitespace characters.
     * Compiled to <code>\s+</code>
     */
    public Builder blanks() {
        return add( Blanks.getInstance() );
    }

    public Builder lineEnd() {
        return add( LineEnd.getInstance() );
    }

    public Builder inputEnd() {
        return add( InputEnd.getInstance( false ) );
    }

    public Builder inputEndIgnoringLastLineBreak() {
        return add( InputEnd.getInstance( true ) );
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

    /**
     * Returns the compiled regular expression string.
     * @return Compiled regular expression
     */
    public String regex() {
        return compile( 0, this.tree );
    }

    public static String compile( int i, List<Element> elements ) {

        if ( i < 0 ) {
            throw new IndexOutOfBoundsException( i );
        }

        if ( i >= elements.size() ) {
            return "";
        }

        var next = elements.get( i );

        return next.compile( i, elements );
    }

    /**
     * Returns the compiled regular expression {@link Pattern}.
     * This is a convenience method of <code>Pattern.compile(regex())</code>.
     *
     * @return Compiled {@link Pattern}
     */
    public Pattern compile() {
        return Pattern.compile( regex() );
    }

    public Pattern compile( Flag flag, Flag... rest ) {
        //noinspection MagicConstant
        return Pattern.compile(
                regex(),
                Stream.concat(
                              Stream.of( flag ),
                              Arrays.stream( rest )
                      )
                      .mapToInt( Flag::getFlag )
                      .reduce( 0, ( x, y ) -> x | y )
        );
    }
}
