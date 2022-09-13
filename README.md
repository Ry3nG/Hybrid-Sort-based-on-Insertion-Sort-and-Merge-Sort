# Hybrid Sort : Integration of Mergesort & Insertion Sort
> this is a example-class project for NTU SC2001
In Mergesort, when the sizes of subarrays are small, the overhead of many recursive
calls makes the algorithm inefficient. Therefore, in real use, we often combine
Mergesort with Insertion Sort to come up with a hybrid sorting algorithm for better
efficiency. The idea is to set a small integer S as a threshold for the size of subarrays.
Once the size of a subarray in a recursive call of Mergesort is less than or equal to S,
the algorithm will switch to Insertion Sort, which is efficient for small-sized input.

Essential Components:

- [x] **Algorithm Implementation**: Implement the above hybrid algorithm.
- [x] **Generate Input Data**: Generate arrays of increasing sizes, in a range from
1,000 to 10 million. For each of the sizes, generate a random dataset of integers
in the range of [1, …, x], where x is the largest number you allow for your
datasets.
- [ ] **Analyze time complexity**: 
   Run your program of the hybrid algorithm on the
datasets generated in Step (b). Record the number of key comparisons
performed in each case.
   * With the value of S fixed, plot the number of key comparisons over
different sizes of the input list n. Compare your empirical results with
your theoretical analysis of the time complexity.
   *  With the input size n fixed, plot the number of key comparisons over
different values of S. Compare your empirical results with your
theoretical analysis of the time complexity.
   *  Using different sizes of input datasets, study how to determine an
optimal value of S for the best performance of this hybrid algorithm.
- [ ] **Compare with original Mergesort**:Implement the original version of
Mergesort (as learnt in lecture). Compare its performance against the above
hybrid algorithm in terms of the number of key comparisons and CPU times on
the dataset with 10 million integers. You can use the optimal value of S obtained
in (c) for this task.



## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.


## Time Complexity Analysis

