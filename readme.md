# About repo

Repo is a showcase of Java 11 API novelties.

###### demo package

In demo package you can find examples that were used on Silesia JUG flashtalk 22th February 2019

They are focused to show API details as clear as possible during talk, so neither static imports nor local type inference is used there

###### example package

Examples package contains more examples that were not intended for a quick meet up demo - there are more cases presented there

# More about Java 11 novelties

## Files

###### static String readString​(Path path)
###### static String readString​(Path path, Charset cs)
###### static Path writeString​(Path path, CharSequence csq, OpenOption... options)
###### static Path writeString​(Path path, CharSequence csq, Charset cs,  OpenOption... options)
###### static boolean isSameFile(Path path, Path path2)

JDK Issue: https://bugs.openjdk.java.net/browse/JDK-8201276

Read more: https://dzone.com/articles/new-jdk-11-files-methods-for-readingwriting-string


## String

Read more: https://dzone.com/articles/new-methods-on-java-strings-with-jdk-11 

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



