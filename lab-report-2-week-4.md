# CSE15L Lab Report 2
## Code Change #1

> **code change diff from Github**
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-28%20at%207.11.40%20PM.png)

> **The link of failure-inducing input**
[image.md](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/image.md)

> **symptom of failure-inducing inputs after running main**
![symptom of main](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-28%20at%207.40.21%20PM.png)
```

xiaolongdeMBP:markdown-parse xiaolong$  java MarkdownParse image.md  
[https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-12%20at%2011.13.50%20PM.png]

```
> **symptom of failure-inducing inputs after running JUnit Test**
![symptom of Junit](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-28%20at%208.44.30%20PM.png)

```
xiaolongdeMBP:markdown-parse xiaolong$ javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java            xiaolongdeMBP:markdown-parse xiaolong$ java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
JUnit version 4.12
.E..
Time: 0.02
There was 1 failure:
1) testNew(MarkdownParseTest)
java.lang.AssertionError: expected:<[]> but was:<[https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-12%20at%2011.13.50%20PM.png]>
        at org.junit.Assert.fail(Assert.java:88)
        at org.junit.Assert.failNotEquals(Assert.java:834)
        at org.junit.Assert.assertEquals(Assert.java:118)
        at org.junit.Assert.assertEquals(Assert.java:144)
        at MarkdownParseTest.testNew(MarkdownParseTest.java:23)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
        at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
        at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
        at org.junit.runners.Suite.runChild(Suite.java:128)
        at org.junit.runners.Suite.runChild(Suite.java:27)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
        at org.junit.runner.JUnitCore.runMain(JUnitCore.java:77)
        at org.junit.runner.JUnitCore.main(JUnitCore.java:36)
```

> **relationship between the bug, the symptom, and the failure-inducing input**
> 
Before debugging the program, after running MarkdownParse.java with the failure inducing input of image.md, the terminal prints out the image link. However,since image link should not be added to the lists of links, the output is a symptom that shows the faulty program behavior. To ensure that the systme is flawed, I add a Junit test called testImagemd(). The assert method still throws error and falsely outputs the image link. The flaw in the program, i.e. the bug is caused by failing to check the "!" mark before the bracket, which marks a image type link. To debug, the condition of ** markdown.indexOf("!") != nextOpenBracket-1 ** is added before the program executes adding a substring of Markdown to the toReturn Arraylist,so that the program checks the type of links and avoids adding image link to Toreturn aaryalsit. 





## Code Change #2
> **code change diff from Github**
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-29%20at%2012.19.36%20AM.png)

> **The link of failure-inducing input**
[invalidlink.md](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/invalidlink.md)

> **symptom of failure-inducing inputs after running main**
![symptom of main](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-28%20at%2010.55.47%20PM.png)
```

xiaolongdeMBP:markdown-parse xiaolong$ javac MarkdownParse.java 
xiaolongdeMBP:markdown-parse xiaolong$  java MarkdownParse invalidlink.md
[https://something.png, https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-12%20at%2011.13.50%20PM.png]
xiaolongdeMBP:markdown-parse xiaolong$ 

```
> **symptom of failure-inducing inputs after running JUnit Test**
![symptom of Junit](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-28%20at%2010.48.44%20PM.png)

```
xiaolongdeMBP:markdown-parse xiaolong$ javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.javaxiaolongdeMBP:markdown-parse xiaolong$ java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
JUnit version 4.12
.E...
Time: 0.02
There was 1 failure:
1) testInvalidlink(MarkdownParseTest)
java.lang.AssertionError: expected:<[]> but was:<[https://something.png, https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-12%20at%2011.13.50%20PM.png]>
        at org.junit.Assert.fail(Assert.java:88)
        at org.junit.Assert.failNotEquals(Assert.java:834)
        at org.junit.Assert.assertEquals(Assert.java:118)
        at org.junit.Assert.assertEquals(Assert.java:144)
        at MarkdownParseTest.testInvalidlink(MarkdownParseTest.java:29)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
        at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
        at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
        at org.junit.runners.Suite.runChild(Suite.java:128)
        at org.junit.runners.Suite.runChild(Suite.java:27)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
        at org.junit.runner.JUnitCore.runMain(JUnitCore.java:77)
        at org.junit.runner.JUnitCore.main(JUnitCore.java:36)
```

> **relationship between the bug, the symptom, and the failure-inducing input**

Although the program is able to distinguih a image link by identifying the "!" before a openbracket, after running junit test testInvalidlink and main with failure-inducing input of inalidlink.md, the program shows symptoms of falsely adding image links to toReturn arraylist. The probelm of the system, or the bug is it fails to idenitity jpg,the raster image format abbreviarion at the end of the link. To debug, I add ** markdown.indexOf(".png",openParen) != closeParen-4 ** as the condition before the program's execution of adding a substring of Markdown to the toReturn Arraylist. 





## Code Change #3

> **code change diff from Github**
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-29%20at%2012.22.52%20AM.png)

> **The link of failure-inducing input**
[whatever.md](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/whatever.md)

> **symptom of failure-inducing inputs after running main**
![symptom of main](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-29%20at%2012.26.11%20AM.png)
```

xiaolongdeMBP:markdown-parse xiaolong$  java MarkdownParse whatever.md
[somehow.com, abc.com]

```
> **symptom of failure-inducing inputs after running JUnit Test**
![symptom of Junit](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-29%20at%2012.20.13%20AM.png)

```
xiaolongdeMBP:markdown-parse xiaolong$ javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.javaxiaolongdeMBP:markdown-parse xiaolong$ java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
JUnit version 4.12
.E....
Time: 0.023
There was 1 failure:
1) testWhatever(MarkdownParseTest)
java.lang.AssertionError: expected:<[abc.com]> but was:<[somehow.com, abc.com]>
        at org.junit.Assert.fail(Assert.java:88)
        at org.junit.Assert.failNotEquals(Assert.java:834)
        at org.junit.Assert.assertEquals(Assert.java:118)
        at org.junit.Assert.assertEquals(Assert.java:144)
        at MarkdownParseTest.testWhatever(MarkdownParseTest.java:35)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
        at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
        at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
        at org.junit.runners.Suite.runChild(Suite.java:128)
        at org.junit.runners.Suite.runChild(Suite.java:27)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
        at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
        at org.junit.runner.JUnitCore.runMain(JUnitCore.java:77)
        at org.junit.runner.JUnitCore.main(JUnitCore.java:36)

FAILURES!!!
Tests run: 5,  Failures: 1
```

> **relationship between the bug, the symptom, and the failure-inducing input**
The failure-indcuing input of the test is a file with an invalid link before a valid link. Specifically,the word "somehow " exists between the close bracket and the oepn parenthesis representing the same image link, thus means that this link of code shoudl not be read as a link. After running the junit testfile with  , the command line prints out both somehow and abc, instead of abc, the only valid link at the end of the file, showing clear symptoms. 
Because the file has an invalid link before a valid link, to debug, the condition of "nextCloseBracket +1 == openParen" is added before addding the substring to reTurnList, thus program can skip the invlaid link format text, and only pritns out the valid one.
