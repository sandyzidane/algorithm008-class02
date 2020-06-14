# Week08学习笔记

## 排序
1. 选择排序
    ```java
        void sort(int arr[]) 
        { 
            int n = arr.length; 

            // One by one move boundary of unsorted subarray 
            for (int i = 0; i < n-1; i++) 
            { 
                // Find the minimum element in unsorted array 
                int min_idx = i; 
                for (int j = i+1; j < n; j++) 
                    if (arr[j] < arr[min_idx]) 
                        min_idx = j; 

                // Swap the found minimum element with the first 
                // element 
                int temp = arr[min_idx]; 
                arr[min_idx] = arr[i]; 
                arr[i] = temp; 
            } 
        }
    ```
1. 插入排序
    ```java
        { 
            int n = arr.length; 
            for (int i = 1; i < n; ++i) { 
                int key = arr[i]; 
                int j = i - 1; 

                while (j >= 0 && arr[j] > key) { 
                    arr[j + 1] = arr[j]; 
                    j = j - 1; 
                } 
                arr[j + 1] = key; 
            } 
        }
    ```
1. 冒泡排序
    ```java
        void bubbleSort(int arr[]) 
        { 
            int n = arr.length; 
            for (int i = 0; i < n-1; i++) 
                for (int j = 0; j < n-i-1; j++) 
                    if (arr[j] > arr[j+1]) 
                    { 
                        // swap arr[j+1] and arr[i] 
                        int temp = arr[j]; 
                        arr[j] = arr[j+1]; 
                        arr[j+1] = temp; 
                    } 
        }
    ```
1. 快排
    ```java
    quickSort(arr[], low, high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is now
               at right place */
            pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Before pi
            quickSort(arr, pi + 1, high); // After pi
        }
    }

    partition (arr[], low, high)
    {
        // pivot (Element to be placed at right position)
        pivot = arr[high];  

        i = (low - 1)  // Index of smaller element

        for (j = low; j <= high- 1; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;    // increment index of smaller element
                swap arr[i] and arr[j]
            }
        }
        swap arr[i + 1] and arr[high])
        return (i + 1)
    }
    ```
1. 归并排序
    ```java
        void sort(int arr[], int l, int r) 
        {
            if (l < r) { 
                // Find the middle point 
                int m = (l + r) / 2; 

                // Sort first and second halves 
                sort(arr, l, m); 
                sort(arr, m + 1, r); 

                // Merge the sorted halves 
                merge(arr, l, m, r); 
            } 
        }

        void merge(int arr[], int l, int m, int r) 
        { 
            // Find sizes of two subarrays to be merged 
            int n1 = m - l + 1; 
            int n2 = r - m; 

            /* Create temp arrays */
            int L[] = new int[n1]; 
            int R[] = new int[n2]; 

            /*Copy data to temp arrays*/
            for (int i = 0; i < n1; ++i) 
                L[i] = arr[l + i]; 
            for (int j = 0; j < n2; ++j) 
                R[j] = arr[m + 1 + j]; 

            int i = 0, j = 0; 

            // Initial index of merged subarry array 
            int k = l; 
            while (i < n1 && j < n2) 
                arr[k++] = L[i] < R[j] ? L[i++] : R[j++];

            while (i < n1) arr[k++] = L[i++]; 
            while (j < n2) arr[k++] = R[j++]; 
        }
    ```
1. 堆排序
    ```java
    // 借助堆数据结构来实现
        void sort(int[] arr) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int n : arr) {
                pq.offer(n);
            }

            int index = 0;
            while (!pq.isEmpty()) {
                arr[index++] = pq.poll();
            }
        }
    ```
1. 计数排序
    ```java
        count = array of k+1 zeros
        for x in input do
            count[key(x)] += 1

        total = 0
        for i in 0, 1, ... k do
            count[i], total = total, count[i] + total

        output = array of the same length as input
        for x in input do
            output[count[key(x)]] = x
            count[key(x)] += 1 

        return output
    ```
1. 桶排序
    ```java
        function bucketSort(array, k) is
            buckets ← new array of k empty lists
            M ← the maximum key value in the array
            for i = 1 to length(array) do
                insert array[i] into buckets[floor(k × array[i] / M)]
            for i = 1 to k do
                nextSort(buckets[i])
            return the concatenation of buckets[1], ...., buckets[k]
    ```
1. 基数排序
    ```java
        static void radixsort(int arr[], int n) 
        {
            int m = getMax(arr, n); 

            // Do counting sort for every digit. Note that instead 
            // of passing digit number, exp is passed. exp is 10^i 
            // where i is current digit number 
            for (int exp = 1; m/exp > 0; exp *= 10) 
                countSort(arr, n, exp); 
        }
        
        static int getMax(int arr[], int n) 
        { 
            int mx = arr[0]; 
            for (int i = 1; i < n; i++) 
                if (arr[i] > mx) 
                    mx = arr[i]; 
            return mx; 
        }
        
        static void countSort(int arr[], int n, int exp) 
        {
            int output[] = new int[n]; // output array 
            int i; 
            int count[] = new int[10]; 
            Arrays.fill(count,0); 

            // Store count of occurrences in count[] 
            for (i = 0; i < n; i++) 
                count[ (arr[i]/exp)%10 ]++; 

            // Change count[i] so that count[i] now contains 
            // actual position of this digit in output[] 
            for (i = 1; i < 10; i++) 
                count[i] += count[i - 1]; 

            // Build the output array 
            for (i = n - 1; i >= 0; i--) 
            { 
                output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
                count[ (arr[i]/exp)%10 ]--; 
            } 

            // Copy the output array to arr[], so that arr[] now 
            // contains sorted numbers according to curent digit 
            for (i = 0; i < n; i++) 
                arr[i] = output[i]; 
        }
    ```
