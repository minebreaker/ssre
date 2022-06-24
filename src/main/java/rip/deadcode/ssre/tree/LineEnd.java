package rip.deadcode.ssre.tree;

public final class LineEnd implements Element.Isolated {

    private static final LineEnd SINGLETON = new LineEnd();

    private LineEnd() {}

    public static LineEnd getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "$";
    }
}
