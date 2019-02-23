# heater

Just a small Java program which loads an image over and over again until an OutOfMemory is reached.

The goal is to test the upper limit of the Java heap, combined with cgroup limits inside an container.

Notes:
- The JVM is AdoptOpenJDK 8, version 202
- All the output is in KB
- The JVM will take about 25% of the RAM as heap per default
- A JVM requires memory for heap, non heap and other thins like sockets

Documentation:
- [Runtime JavaDoc](https://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html)
- [Java Ergonomics](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/ergonomics.html)

## No limits

Command:

````
docker run ninckblokje/heater
````

Output:

````
Picked up JAVA_TOOL_OPTIONS: -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap
-- 1
free memory: 29812304
total memory: 30408704
max memory: 421527552
-- 2
free memory: 24655952
total memory: 30408704
max memory: 421527552
````

## 400 MB limit

Command:

````
docker run -m 400m ninckblokje/heater
````

Output:

````
Picked up JAVA_TOOL_OPTIONS: -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap
-- 1
free memory: 7781584
total memory: 8257536
max memory: 127729664
-- 2
free memory: 2793024
total memory: 8257536
max memory: 12772966
````

## Poster time!

![](src/main/resources/poster34.jpg)