package rip.deadcode.ssre.tree;

public final class Alphabet implements Element.Isolated {

    private static final Alphabet SINGLETON = new Alphabet();

    private Alphabet() {}

    public static Alphabet getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "[a-zA-Z]";
    }
}
