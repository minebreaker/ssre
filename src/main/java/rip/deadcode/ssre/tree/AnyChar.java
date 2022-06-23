package rip.deadcode.ssre.tree;

public final class AnyChar implements Element.Isolated {

    private static final AnyChar SINGLETON = new AnyChar();

    private AnyChar() {}

    public static AnyChar getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return ".";
    }
}
