package rip.deadcode.ssre.tree;

import rip.deadcode.ssre.Builder;

import java.util.List;


public interface Element {

    public String compile( int i, List<Element> rest );

    public static interface Isolated extends Element {
        @Override public default String compile( int i, List<Element> elements ) {

            var result = this.compile();
            var restResult = Builder.compile( i + 1, elements );

            return result + restResult;
        }

        public String compile();
    }
}
