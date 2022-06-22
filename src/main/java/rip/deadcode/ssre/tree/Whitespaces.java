package rip.deadcode.ssre.tree;

public final class Whitespaces implements Element.Isolated {

    private static final Whitespaces SINGLETON = new Whitespaces();

    public static Whitespaces getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return " +";
    }
}
