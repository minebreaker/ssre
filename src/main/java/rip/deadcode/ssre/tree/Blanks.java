package rip.deadcode.ssre.tree;

public final class Blanks implements Element.Isolated {

    private static final Blanks SINGLETON = new Blanks();

    private Blanks() {}

    public static Blanks getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "\\s+";
    }
}
