# Lab 4
## links 

 The link of MarkdownParse Repos
 
[my repository](https://github.com/Maryamkusman/markdown-parse) 

[the other group](https://github.com/AnniePhan02/CSE15L-Panther.git)

## Snippet 1:
```
`[a link`](url.com)

[another link](`google.com)`

[`cod[e`](google.com)

[`code]`](ucsd.edu)
```

<kbd>![Image](Screen%20Shot%202022-02-26%20at%205.10.42%20PM.png)<kbd>

backticks are wrong for link 1
expect: **[`google.com, google.com, ucsd.edu]**

Turing the snippet into a test case, and saved as `Snippet1.md`
```
 @Test
    public void testSnippet1() throws IOException{
        Path fileName = Path.of("Snippet 1.md");
	    String contents = Files.readString(fileName);
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }
```
My implementation of `MarkdownParse.java` fails the test, picking up every link as a valid link:
```
Time: 0.023
There were 3 failures:
1) testSnippet1(MarkdownParseTest)
java.lang.AssertionError: expected:<[`google.com, google.com, ucsd.edu]> but was:<[url.com, `google.com, google.com]>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at MarkdownParseTest.testSnippet1(MarkdownParseTest.java:40)
```
Implementation of `MarkdwonParse.java` from other group also fails test:
```
Time: 0.021
There were 3 failures:
1) testSnippet1(MarkdownParseTest)
java.lang.AssertionError: expected:<[`google.com, google.com, ucsd.edu]> but was:<[url.com, `google.com, google.com, ucsd.edu]>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at MarkdownParseTest.testSnippet1(MarkdownParseTest.java:18)
```
*Do you think there is a small (<10 lines) code change that will make your program work for snippet 2 and all related cases that nest parentheses, brackets, and escaped brackets? If yes, describe the code change. If not, describe why it would be a more involved change.*

Yes. the backticks need to come together in the outermost bracket.What i did was set a variable as the value of number of backticks of the content in the out brackets. thsi was done witha forloop . this compares the chatacters in the outside brackets with ```, if it is equal, increments the value. 


## Snippet 2:
```
[a [nested link](a.com)](b.com)

[a nested parenthesized url](a.com(()))

[some escaped \[ brackets \]](example.com)
```

<kbd>![Image](Screen%20Shot%202022-02-26%20at%205.12.38%20PM.png)<kbd>

expect: **[a.com, a.com(()), example.com]**

Turing the snippet into a test case, and saved as `Snippet2.md`
```
@Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("Snippet2.md");
        String contents = Files.readString(fileName);
        List<String> expected = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }
```
My implementation of `MarkdownParse.java` fails the test, picking up every link as a valid link:
```
2) testSnippet2(MarkdownParseTest)
java.lang.AssertionError: expected:<[a.com, a.com(()), example.com]> but was:<[a.com((]>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at MarkdownParseTest.testSnippet2(MarkdownParseTest.java:48)

```

Implementation of `MarkdwonParse.java` from other hroup also fails the test:
```
2) testSnippet2(MarkdownParseTest)
java.lang.AssertionError: expected:<[a.com, a.com(()), example.com]> but was:<[a.com, a.com((, example.com]>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at MarkdownParseTest.testSnippet2(MarkdownParseTest.java:25)
```

*Do you think there is a small (<10 lines) code change that will make your program work for snippet 2 and all related cases that nest parentheses, brackets, and escaped brackets? If yes, describe the code change. If not, describe why it would be a more involved change.*

check if there are nested brackets and nested parenthesis in link. The algorhthm requires multple if else statements.

## Snippet 3:

```
[this title text is really long and takes up more than 
one line

and has some line breaks](
    https://www.twitter.com
)

[this title text is really long and takes up more than 
one line](
    https://ucsd-cse15l-w22.github.io/
)


[this link doesn't have a closing parenthesis](github.com

And there's still some more text after that.

[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/



)

And then there's more text
```
output generated by the CommonMark demo site:

![Image](Screen%20Shot%202022-02-26%20at%205.13.15%20PM.png)
Becasue there can not be an line in [] and (), 
expect: **[https://ucsd-cse15l-w22.github.io/]**

Turing the snippet into a test case, and saved as `Snippet3.md`
```
@Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("Snippet3.md");
        String contents = Files.readString(fileName);
        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }
```
My implementation of `MarkdownParse.java` fails the test, picking up every link as a valid link:
```
3) testSnippet3(MarkdownParseTest)
java.lang.AssertionError: expected:<[https://ucsd-cse15l-w22.github.io/]> but was:<[
    https://ucsd-cse15l-w22.github.io/
, github.com

And there's still some more text after that.

[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/



]>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at MarkdownParseTest.testSnippet3(MarkdownParseTest.java:56)

FAILURES!!!
Tests run: 7,  Failures: 3
```

Implementation of `MarkdwonParse.java` from other hroup also fails the test:
```
3) testSnippet3(MarkdownParseTest)
java.lang.AssertionError: expected:<[https://ucsd-cse15l-w22.github.io/]> but was:<[
    https://www.twitter.com
, 
    https://ucsd-cse15l-w22.github.io/
, github.com

And there's still some more text after that.

[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/



]>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at MarkdownParseTest.testSnippet3(MarkdownParseTest.java:32)

FAILURES!!!
Tests run: 3,  Failures: 3
```
*Do you think there is a small (<10 lines) code change that will make your program work for snippet 2 and all related cases that nest parentheses, brackets, and escaped brackets? If yes, describe the code change. If not, describe why it would be a more involved change.*

No. links are not active when there is empty lines in parenthesis or bracker. or if stuff in bracket is in more than 1 line. The program has to check all the conditions, which would probably take more than 10 lines of code.
