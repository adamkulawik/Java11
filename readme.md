# About repo

Repo is a showcase of Java 11, 12 and 13 syntax and API novelties.

#### benchmark package

In benchmark package I tried to compare new `lines()` and `repeat()` method in `String` class with simpler and more naive approaches. 

**IMPORTANT** Be aware, that this is sample for my learning/fun purpose, not full, professional benchmark of those features. Don't rely on it for any performance-critical low-latency applications; and I don't take any responsibility for that. If you need such a benchmark for significant technical decision consider preparing something better on your own.
 
#### demo package

In java11.demo package you can find examples that were used on Silesia JUG flashtalk 22th February 2019.

They are focused to show API details as clear as possible during talk, so neither static imports nor local type inference is used there

In java12.demo and java13.demo there are samples for Java 12 and 13 novelties respectively. 

I used all this packages while preparing my talk on JDD 2019 about Java 11, 12 and 13 new stuff. 

#### example package

Package java11.examples contains more examples that were not intended for a quick meet up demo - there are more cases presented there.

#### known issues

Despite setting `--enable-preview` flag in maven pom.xml file IntelliJ Idea tends not to set this setting properly in project SDK setup, so this has to be done manually. If you come up a solution, consider submitting a PR, please :)

# More about Java 11 novelties

## Files

###### static String readString​(Path path)
###### static String readString​(Path path, Charset cs)
###### static Path writeString​(Path path, CharSequence csq, OpenOption... options)
###### static Path writeString​(Path path, CharSequence csq, Charset cs,  OpenOption... options)

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8201276

Read more: https://dzone.com/articles/new-jdk-11-files-methods-for-readingwriting-string

## String

Read more: https://dzone.com/articles/new-methods-on-java-strings-with-jdk-11 

Also worth reading: https://4comprehension.com/java-11-string-api-updates/

Regarding Unicode - related issue you **HAVE TO** and **WANT TO** watch this amazing talk (available in Polish, but you may try to look for English version) https://youtu.be/QIEpZ0MGoBc

###### boolean isBlank()

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8200437

###### String strip()
###### String stripLeading()
###### String stripTrailing()

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8200378

###### Stream<String> lines()

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8200425

###### String repeat(int count)

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8198296

To get more details you must read the excellent in-depth explanation 
https://medium.com/@ggajos/java-11-how-string-repeat-was-implemented-and-why-d93796b7abba

## Optional
###### boolean isEmpty()

Read more: https://dzone.com/articles/optionalisempty-available-in-jdk-11-ea-builds
https://www.javacodegeeks.com/2018/04/optional-isempty-coming-to-java.html

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8184693

## Predicate
###### static <T> Predicate<T> not​(Predicate<? super T> target)

Read more: https://dzone.com/articles/predicatenot-coming-to-java

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8203428

## Pattern

###### Predicate<String> asMatchPredicate()

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8201308

## TimeUnit

###### long convert​(Duration duration)

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8204375

You might also want to get some background of that change in this interesting mail thread: 
https://openjdk.markmail.org/thread/ndcwjnmbpwhkvkwe#query:+page:1+mid:syazdg3cfd6bbxbk+state:results

## JEP 323: Local-Variable Syntax for Lambda Parameters

JEP: http://openjdk.java.net/jeps/323

## JEP 321: HTTP Client (Standard)

JEP: https://openjdk.java.net/jeps/321

Read more: https://openjdk.java.net/groups/net/httpclient/intro.html

You might want to see excellent example of usage of this client: https://github.com/jgprogram/sjug-httpclient

When using async mode, please be aware of that issue: https://www.javaspecialists.eu/archive/Issue271.html

# More about Java 12 novelties

## JEP 326 - Raw String Literals (preview)

JEP description: http://openjdk.java.net/jeps/326

Brian Goetz's mail explaining why the feature had been dropped in favour of Text Blocks:
https://mail.openjdk.java.net/pipermail/jdk-dev/2018-December/002402.html

## JEP 325 - Switch expressions (preview)

JEP description: https://openjdk.java.net/jeps/325

Note: in this repo only Switch expressions compliant with Java 13 is presented, as it's been changed in Java 13, therefore 12's and 13's switchs are not backward compatible.

## Collector
###### public static <T, R1, R2, R> Collector<T, ?, R> teeing(Collector<? super T, ?, R1> downstream1, Collector<? super T, ?, R2> downstream2, BiFunction<? super R1, ? super R2, R> merger)

Seems terrryfing, huh? In fact it is not.

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8209685

You might also want to read great explantation there: https://4comprehension.com/a-new-jdk12-stream-api-collector-collectorsteeing/

and there: https://dzone.com/articles/java-12-the-teeing-collector

## String

###### public String indent(int count)

JDK issue: https://bugs.openjdk.java.net/browse/JDK-8200435

Internally indent uses `lines()` and `repeat()` from Java 11

# More about Java 13 novelties

## JEP 354 - Switch Expressions (Preview)

JEP: https://openjdk.java.net/jeps/354
 
## JEP 355 - Text Blocks (Preview)

JEP: https://openjdk.java.net/jeps/355