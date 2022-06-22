package rip.deadcode.ssre.tree;

import rip.deadcode.ssre.Builder;

import static java.util.Objects.requireNonNull;


public final class Repeat implements Element.Isolated {

    private final Builder builder;
    private final int min;
    private final int max;
    private final boolean lazy;

    /**
     * @param builder
     * @param min inclusive.
     * @param max inclusive. -1 for infinite.
     */
    public Repeat( Builder builder, int min, int max, boolean lazy ) {
        this.builder = requireNonNull( builder );
        this.min = min;
        this.max = max;
        this.lazy = lazy;

        if ( min <= -1 ) {
            throw new IllegalArgumentException();
        }
        if ( max < -1 ) {
            throw new IllegalArgumentException();
        }
        if ( max != -1 && min > max ) {
            throw new IllegalArgumentException();
        }
    }

    @Override public String compile() {
        String pattern = this.builder.regex();

        String repetition =
                ( this.min == 0 && this.max == -1 ) ? "*" :
                ( this.min == 1 && this.max == -1 ) ? "+" :
                ( this.min == 0 && this.max == 1 ) ? "?" :
                ( this.min == this.max ) ? "{" + this.min + "}" :
                "{" + this.min + "," + this.max + "}";

        String laziness = this.lazy ? "?" : "";

        if ( pattern.length() == 1 ) {
            return pattern + repetition + laziness;
        } else {
            return "(?:" + pattern + ")" + repetition + laziness;
        }
    }
}
