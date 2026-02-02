Problem: Most Common Element in a Subsegment
Problem Statement

You are given an array a of size n and an integer k.

A subsegment of a is a consecutive sequence of elements from the array.

We say that an integer x is the most common element in a subsegment if it occurs more times than any other integer in that subsegment.

Determine if there exists a non-empty subsegment of the array where k is the most common element.

Input

The first line contains a single integer t — the number of test cases.

Each test case consists of two lines:

Two integers n and k — the number of elements in the array and the target integer.

n integers a1, a2, ..., an — the elements of the array.

Constraints

1
≤
𝑡
≤
1000
1≤t≤1000

1
≤
𝑛
≤
100
1≤n≤100

1
≤
𝑎
𝑖
,
𝑘
≤
100
1≤a
i
	​

,k≤100

Output

For each test case, print "YES" if there exists a non-empty subsegment where k is the most common element, and "NO" otherwise.

Note: Output is case-insensitive.

Example

Input:

7
5 4
1 4 3 4 1
4 1
2 3 4 4
5 6
43 5 60 4 2
2 5
1 5
4 1
5 3 3 1
1 3
3
5 3
3 4 1 5 5


Output:

YES
NO
NO
YES
YES
YES
YES

Explanation

In the first test case, the subsegment [4] or [4,3,4,1] has 4 as the most common element → "YES".

In the second test case, 1 does not appear in the array → "NO".

In the fourth test case, the subsegment [5] contains 5 → "YES".

💡 Hint:
Since subsegments of length 1 are allowed, if k exists in the array, the answer is always "YES".


SOLUTION:
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0){
		    int n=s.nextInt();
		    int k=s.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=s.nextInt();
		    }
		    boolean isv=false;
		    for(int i=0;i<n;i++){
		        if(a[i]==k){
		            isv=true;
		            break;
		        }
		    }
		    if(isv){
		        System.out.println("Yes");
		    }
		    else{
		        System.out.println("No");
		    }
		    
		}
	}
}
