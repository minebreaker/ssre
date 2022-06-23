package rip.deadcode.ssre.tree;

public final class WordChar implements Element.Isolated {

    private static final WordChar SINGLETON = new WordChar();

    private WordChar() {}

    public static WordChar getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "\\w";
    }
}
