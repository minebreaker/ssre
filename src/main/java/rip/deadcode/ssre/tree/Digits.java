package rip.deadcode.ssre.tree;

public final class Digits implements Element.Isolated {

    private static final Digits SINGLETON = new Digits();

    public static Digits getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "\\d+";
    }
}
