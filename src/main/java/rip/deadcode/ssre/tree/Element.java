package rip.deadcode.ssre.tree;

import rip.deadcode.ssre.Builder;

import java.util.List;


public interface Element {

    public String compile( List<Element> rest );

    public static interface Isolated extends Element {
        public default String compile( List<Element> rest ) {
            var result = this.compile();
            var restCompiled = Builder.compile( rest );
            return result + restCompiled;
        }

        public String compile();
    }
}
