package rip.deadcode.ssre.tree;

public final class Word implements Element.Isolated {

    private static final Word SINGLETON = new Word();

    private Word() {}

    public static Word getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "\\w+";
    }
}
