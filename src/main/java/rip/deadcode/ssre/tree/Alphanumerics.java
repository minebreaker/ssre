package rip.deadcode.ssre.tree;

public final class Alphanumerics implements Element.Isolated {

    private static final Alphanumerics SINGLETON = new Alphanumerics();

    private Alphanumerics() {}

    public static Alphanumerics getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "[a-zA-Z0-9]+";
    }
}
