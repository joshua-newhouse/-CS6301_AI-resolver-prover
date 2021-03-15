# Joshua Newhouse and Vamsi Somepalli
# CS6301_AI

## List of source files
View the java-doc overview-summary.html page with a web browser.

## Development Environment
- Linux 5.4.0-66-generic #74~18.04.2-Ubuntu SMP x86_64 GNU/Linux
- Java 1.8

## Build Program
For convenience, we have provided the jar pre-built but if you want to build it from scratch then use the following
instructions.

This is a Maven project and so to build it, from the top level directory, execute:

```$ mvn clean package```

The program will be a Java jar archive called resolution-prover-1.0-SNAPSHOT.jar located in the target directory.

## Run Program
For convenience, we have provided a Bash script called prove which wraps the jar.  Execute it as follows:

```./prove <INPUT_FILE>```

To run the java jar directly, on the command line and in the directory where the jar is located, execute:

```java -jar resolution-prover-1.0-SNAPSHOT.jar <input-file-path>```

For example:

```java -jar resolution-prover-1.0-SNAPSHOT.jar /home/user/prover/task1.in```

```
Usage: prove <INPUT_FILE>
```

## Input and Output
The input files are located in the input directory.
The output files are located in the output directory.
