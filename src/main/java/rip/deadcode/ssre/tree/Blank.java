package rip.deadcode.ssre.tree;

public final class Blank implements Element.Isolated {

    private static final Blank SINGLETON = new Blank();

    private Blank() {}

    public static Blank getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "\\s";
    }
}
