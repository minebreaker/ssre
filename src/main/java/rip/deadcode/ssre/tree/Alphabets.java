package rip.deadcode.ssre.tree;

public final class Alphabets implements Element.Isolated {

    private static final Alphabets SINGLETON = new Alphabets();

    private Alphabets() {}

    public static Alphabets getInstance() {
        return SINGLETON;
    }

    @Override public String compile() {
        return "[a-zA-Z]+";
    }
}
