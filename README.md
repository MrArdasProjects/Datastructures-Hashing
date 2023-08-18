# Datastructures-Hashing
This project pertains to the implementation of important methods related to Hashing in the context of the Data Structures and Advanced Algorithms course within the Computer Engineering department.

The following instructions have been implemented in the project.

1)You need to implement a simple HashTable for this assignment. You need to use 
quadratic probing as the underlying method. The hash function you will use for the 
quadratic probing is h(x) = h(x) + f(i) (mod size) and the quadratic 
function f(i) = i2.
Firstly, you need to use an array or ArrayList to hold 1000 integer values in your 
hash table. A random number generator is already given to you in the Main class. You 
will hash this data by using your implementation. You need to implement five essential 
methods of hashing: hashFunction, rehash, insert, contains and printTable. 

2) Secondly, you need to use Java implementation of Hashtable for hashing operation of 
another array of integer values that is also given in Main class. You have a different data 
type class implemented, called MyInteger, which hashes the integers wrapped in it 
with using the hashing method of Java.

4) Now, you need to compare the two approaches according to their execution times. You 
can use the given template method to measure the running time of different hashing 
implementations. 

long startTime = System.nanoTime();
// The operation
long endTime = System.nanoTime();
long elapsedTime = endTime - startTime;

4)What do you think about the time complexities of these two methods? Which one 
performed better? Which one performed worse? Why do you think there is a difference 
between them? If you have a data of 10 thousand integers, do you think there will be a 
difference between the running times of these methods? Discuss and write your 
thoughts as comments in your codes.
