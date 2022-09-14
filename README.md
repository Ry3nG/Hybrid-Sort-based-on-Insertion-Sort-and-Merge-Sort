# Hybrid Sort : Integration of Mergesort & Insertion Sort
> this is a example-class project for NTU SC2001

## Introduction

In Mergesort, when the sizes of subarrays are small, the overhead of many recursive calls makes the algorithm inefficient.

Therefore, we want to design a Hybrid Sort algorithm to optimize the performance of normal Merge Sort by combining Insertion Sort with it.

The idea is to set a small integer S as a threshold for the size of subarrays.
Once the size of a subarray in a recursive call of Mergesort is less than or equal to S,
the algorithm will switch to Insertion Sort, which is efficient for small-sized input.

----
## Folder Structure

The workspace contains two folders by default, where:

- `assets`: the folder to maintain our presentation slides.
- `bin`: the folder to maintain compiler outputs
- `lib`: the folder to maintain dependencies
- `output`: the folder to maintain test output csv files.
- `src`: the folder to maintain sources

---
## Contents
1. Algorithm Design and Implementation
2. Algorithm Analysis (Theoretical)
3. Algorithm Analysis (Empirical)
4. Comparing Hybrid Sort and the original Merge Sort algorithm

----


### Algorithm Design and Implementation
The pseudocode for Hybrid Sort is as follows
```
hybridsort(list){
   split list into two evenly sized lists
   hybridsort(leftList);
   hybridsort(rightList);
   hybridMerge(leftList, rightList);
}
hybridMerge(left, right){
   if(list.length<=S){
      InsertionSort(list)
   }else{
      same as the rest of merge() from original mergeSort
   }
}
```
An example is shown below:
![HybridSort example](.\assets\Slide4.png)

Our implementation of Hybrid Sort can be found [here](./src/HybridSort.java)

### Algorithm Analysis (Theoretical)
* Best Case: $O(n+nlog(\frac{n}{s}))$
* Worst Case: $O(nS+nlog(\frac{n}{s}))$
* Average Case: $O(nS+nlog(\frac{n}{s}))$

### Algorithm Analysis (Empirical)

We carried out 3 Empirical analysis to see whether our findings are consistent with our theoretical analysis.

#### 1. Number of key comparisons Vs. input size
![Empirical Experiment 1](.\assets\Slide12.png)
#### 2. Number of key comparisons Vs. S value
![Empirical Experiment 2](.\assets\Slide13.png)
#### 3. Determining the optimal value for S

Note: we figured out there's essentially two ways of carrying out this experiement. The first way is to run our implemented Hybrid Sort algorithm with a large input array. Adjust the S value and plot the run time against it. But it may be very time consuming to do so as we need to take averages to even out outliers. 

So instead, we recognized that the S value is merely a threholde under which Insertion Sort should be quicker than Merge Sort. So we carried out the experiement at a much smaller scale. By comparing the runtime between Insertion Sort and Merge Sort. The S value should be the intersection of their runtime curve.

![Empirical Experiment 3](.\assets\Slide14.png)

### Comparing Hybrid Sort and the original Merge Sort algorithm
Our Hybrid Sort algorithm is about 4.2% faster than the original Merge Sort algorithm under our implementation and tests.

![Comparing Hybrid Sort and the original Merge Sort algorithm](.\assets\Slide16.png)


