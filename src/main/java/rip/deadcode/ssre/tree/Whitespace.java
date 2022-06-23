package rip.deadcode.ssre.tree;

public final class Whitespace implements Element.Isolated {

    private static final Whitespace SINGLETON = new Whitespace();

    private Whitespace() {}

    public static Whitespace getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return " ";
    }
}
