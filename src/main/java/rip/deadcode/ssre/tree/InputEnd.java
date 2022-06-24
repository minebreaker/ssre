package rip.deadcode.ssre.tree;

public abstract class InputEnd implements Element.Isolated {

    private static final InputEnd SINGLETON = new InputEnd() {
        @Override public String compile() {
            return "\\z";
        }
    };

    private static final InputEnd SINGLETON_IGNORING_LAST_LINE_BREAK = new InputEnd() {
        @Override public String compile() {
            return "\\Z";
        }
    };

    private InputEnd() {}

    public static InputEnd getInstance() {
        return SINGLETON_IGNORING_LAST_LINE_BREAK;
    }

    public static InputEnd getInstance( boolean ignoringLastLineBreak ) {
        return ignoringLastLineBreak ? SINGLETON_IGNORING_LAST_LINE_BREAK : SINGLETON;
    }
}
