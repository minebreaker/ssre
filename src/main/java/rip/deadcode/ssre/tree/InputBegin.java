package rip.deadcode.ssre.tree;

public final class InputBegin implements Element.Isolated {

    private static final InputBegin SINGLETON = new InputBegin();

    private InputBegin() {}

    public static InputBegin getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "\\A";
    }
}
