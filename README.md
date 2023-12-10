# sorting-algorithms

**Authors:** Ryan Majd & Maulik Durani  
**Emails:** [rm97798@uga.edu](mailto:rm97798@uga.edu) & [md00211@uga.edu](mailto:md00211@uga.edu)

## Overview

This repository contains the implementation of Algoithms covered in-class in Java. The project is part of the CS2720 (Data Structures) course, taught by Dr. Jin Lu.

### Programming Report 2 Graph

Located in the `programming-assignment-4-report.pdf` file.

## How To Compile

### The Program

To compile the Java program, you can use the following command:

```bash
java -cp bin src/cs2720/p4/Driver.java resources/"fileName.txt"
```

Where `fileName.txt` refers to whichever input file you choose!
Additionally, you can also use the provided `compile.sh` and `run.sh` script for compilation and running.
_Keep in mind that run.sh automatically uses the `random.txt` from the resources folder_

```
./compile.sh
./run.sh
```

### The Data from Report 2: `SortingExperiment.java`

To compile the Java program, you can use the following command:

```bash
java -cp bin src/cs2720/p4/SortingExperiment.java
```

When run, the program asks for the number of input size and simulates everything needed in the table for report question 2 as well as the amount for the n number of size. **_Input is a random number between (0,9999) inclusive._**

Make sure to have the necessary Java environment set up on your machine.

## Available Commands

```The program supports the following commands:
selection-sort (s)
merge-sort (m)
heap-sort (h)
quick-sort-fp (q)
quick-sort-rp (r)
```

## Contributions

Ryan Majd: Implemented scafolded template of the program, the second half of the report, Algo-efficiency Graph, `readme.md`, `SortingExperiment.java`.

Maulik Durani: Implemented the Algorithms structure, `Sorting.java` and completed first half of the report.
