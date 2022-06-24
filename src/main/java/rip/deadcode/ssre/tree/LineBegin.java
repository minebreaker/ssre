package rip.deadcode.ssre.tree;

public final class LineBegin implements Element.Isolated {

    private static final LineBegin SINGLETON = new LineBegin();

    private LineBegin() {}

    public static LineBegin getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "^";
    }
}
