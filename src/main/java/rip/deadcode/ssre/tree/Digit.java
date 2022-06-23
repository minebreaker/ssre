package rip.deadcode.ssre.tree;

public final class Digit implements Element.Isolated {

    private static final Digit SINGLETON = new Digit();

    public static Digit getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "\\d";
    }
}
