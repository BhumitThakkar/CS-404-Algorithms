//////////////////////////////////////////////////////////////////////
// Problem 1

int [] twoElementSum(int n, int [] A, int g)
{
	i = 1
	j = n
	sum = A[i] + A[j]

	while (i < j and sum != g)
	{
		if (sum > g)
			j = j – 1
		else
			i = i + 1

		sum = A[i] + A[j]
	}

	if (i >= j)
		return {-1}
	else
		return {i, j]
}

//////////////////////////////////////////////////////////////////////
// Problem 2

int [] threeElementSum(int n, int [] A, int g)  
{
	for (k = 1 to n-1)
	{
		i = k+1
		j = n
		sum = A[k] + A[i] + A[j]

		while (i < j and sum != g)
		{
			if (sum > g)
				j = j – 1
			else
				i = i + 1

			sum = A[k] + A[i] + A[j]
		}

		if (sum == g)
			return {k, i, j}
	}

	return {-1}
}

//////////////////////////////////////////////////////////////////////
// Problem 3

int numValuesInBoth(int n, int [] A, int [] B)  
{
	answer = 0
	i = 1
	j = 1

	while (i <= n and j <= n)
   {
      if (A[i] < B[j])
         i = i + 1
      else if (B[j] < A[i])
         j = j + 1
      else
      {
         answer = answer + 1
         i = i + 1
         j = j + 1
      }
   
   return answer
}
      
//////////////////////////////////////////////////////////////////////
// Problem 4

int howManyEntries(int n, int [] A)  
{
   count = 0
   new boolean B[1..n]
   
   while (someFalse(n, B))
   {
      print("Enter an integer: ")
      i = getInput()
      count = count + 1
      
      if (1 <= i <= n)
         B[i] = true
   }

   return count
}

boolean someFalse(int n, boolean [] B)
{
   for (i = 1 to n)
      if (B[i] == false)
         return true
         
   return false
}
   
//////////////////////////////////////////////////////////////////////
// Problem 5

int indexOf(int n, int [] A, int x)  
{
   low = 1
   high = n
   
   while (low <= high)
   {
      mid = (low + high)/2
      
      if (x < A[mid])
         high = mid - 1
      else if (x > A[mid])
         low = low + 1
      else
         return mid
   }

   return -1
}
          
//////////////////////////////////////////////////////////////////////
// Problem 6

int [] twoIdenticalRows(int n, int [][] A)  
{
   for (i = 1 to n-1)
      for (j = i+1 to n)
      {
         count = 0
         for (k = 1 to n)
            if (A[i][k] == A[j][k])
               count = count + 1
         
         if (count == n)
            return {i, j}
      }
   
   return {-1}
}

//////////////////////////////////////////////////////////////////////
// Problem 7

boolean totallySortedTwoD(int n, int [][] A)  
{
   for (i = 1 to n)
      for (j = 1 to n-1)
         if (A[i][j] > A[i][j+1])
            return false
   
   for (i = 1 to n-1)
      if (A[i][n] > A[i+1][1]
         return false
   
   return true
}

//////////////////////////////////////////////////////////////////////
// Problem 8

int [] coordinatesOf(int n, int [][] A, int x)  
{
   low = 0
   high = n*n - 1
   
   while (low <= high)
   {
      mid = (low + high)/2
      r = mid / n;
      c = mid % n;
      
      if (x < A[r][c])
         high = mid - 1
      else if (x > A[r][c])
         low = mid + 1
      else
         return {r, c}
   }
   
   return {-1}
}
   
//////////////////////////////////////////////////////////////////////
// Problem 9

int missing(int n, int [] A, int k)  
{
   new int B[1..k]
   
   for (i = 1 to n)
      if (1 <= A[i] <= k)
         B[A[i]]++
   
   for (i = 1 to k)
      if (B[i] == 0)
         return i
   
   return -1
}
      
//////////////////////////////////////////////////////////////////////
// Problem 10

int [] twoIdenticalRows(int n, int [][] A)  
{
   new int B[n][3];  // B holds copy of A as well as index of each row.
   
   for (i = 1 to n)
   {
      B[i][1] = A[i][1]
      B[i][2] = A[i][2]
      B[i][3] = i
   }
   
   mergeSort2D(B, 1, n, 1, 2)  // sorts rows 1 to n of B by values in column 1, and there are 2 columns in A.
   
   i = 1
   
   while (i <= n)
   {
      j = i+1
      while (A[i][2] == A[j][2])
         j = j+1
      
      mergeSort2D(B, i, j-1, 2, 2)  // sorts rows i to j-1 of B by values in column 2, and there are 2 columns in A.
      
      i = j 
   }
   
   for (i = 1 to n-1)
      if (B[i][1] == B[i+1][1]  and  B[i][2] == B[i+1][2])
         return {B[i][3], B[i+1][3]}
   
   return {-1}
}

// Prove that this runs in time theta(n lg n).


//////////////////////////////////////////////////////////////////////
// mergeSort2D
//
// Sorts rows of A between indices low and high, by the 
// value in column c.  The number of columns in A is numCols
// Runs in time theta( n(lg n)(numCols) ) where n = # rows between low and high.
//      

void mergeSort2D(int [][] A, int low, int high, int c, int numCols)
{
   if (low < high)
   {
      int m = (low + high)/2;
      mergeSort2D(A, low, m, c, numCols);
      mergeSort2D(A, m+1, high, c, numCols);
      merge2D(A, low, m, high, c, numCols);
   }
}


void merge2D(int [][] A, int low, int m, int high, int c, int numCols)
{
   int [][] temp = new int[low..high][1..numCols];
   
   int i = low, j = m+1, k = low;
   
   while (i <= m && j <= high)
   {
      if (A[i][c] < A[j][c])
      {
         copyRow(A, i, temp, k, numCols)  // copies row i of A into row k of temp
         i++;
         k++;
      }
      else
      {
         copyRow(A, j, temp, k, numCols);  // copies row j of A into row k of temp
         j++;
         k++;
      }
   }
     
   while (i <= m)
   {
      copyRow(A, i, temp, k, numCols);  // copies row i of A into row k of temp
      i++;
      k++;
   }
   
   while (j <= high)
   {
      copyRow(A, j, temp, k, numCols);  // copies row j of A into row k of temp
      j++;
      k++;
   }
   
   for (i = low; i <= high; i++)
      copyRow(temp, i, A, i, numCols);   // copies row i of temp into row i of A

}
      

void copyRow(int [][] E, int i, int [][] F, int j, int numCols)  // copies row i of E into row j of F
{
   for (int t = 1; t <= numCols; t++)
      F[j][t] = E[i][t];
}

  



   










