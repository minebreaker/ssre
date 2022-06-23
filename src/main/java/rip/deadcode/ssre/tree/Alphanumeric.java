package rip.deadcode.ssre.tree;

public final class Alphanumeric implements Element.Isolated {

    private static final Alphanumeric SINGLETON = new Alphanumeric();

    private Alphanumeric() {}

    public static Alphanumeric getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "[a-zA-Z0-9]";
    }
}
