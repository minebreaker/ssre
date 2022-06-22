# Simple Stupid Regular Expression

```
// hello +(?:world|ssre)
Pattern p = string("hello")
            .whitespaces()
            .or(string("world"), string("ssre"))
            .compile();
// ^ +| +$|\b +\b
Pattern p = or(
                beginLine().whitespaces(),
                whitespaces().endLine(),
                beginWord().whitespaces().endWord()
              );
// (?:hello){1,5}(?:world)*?
Pattern p = repeat(string("hello"), 1, 5)
            .repeat(string("world"), Lazy);
// (\s)(?<named>.)\2
Pattern p = capture(space())
            .capture("named", anyChar())
            .group("named");
// (?<=foo|bar)(?!foo|bar)
// 0|1[0-9]{0,2}|2(?:[0-4][0-9]?|5[0-5]?|[6-9])?|[3-9][0-9]?
Pattern p = intRange(0, 255);

// \p{Nd}+\+\p{Nd}+
Tree x = repeat(digit(), 1);
Pattern p = x.string("+").then(x);
```
