import java.util.*;

public class SortORama
{
    public static void main(String[] args)
    {
        int size = 131072;
        int min = 1;
        int max = 1000000;
        long start = 0;
        long end = 0;
        
        int[] array = makeRandomArray(size, min, max);
        int[] arr = copyArray(array);
        int[] arr1 = copyArray(array);
        int[] arr2 = copyArray(array);
        
        start = System.currentTimeMillis();       
        bubbleSort(array);
        end = System.currentTimeMillis();
        System.out.println("The Bubble Sort took: " + (end-start) + " milliseconds");
        
        selectionSort(arr);
        long time = System.currentTimeMillis();
        System.out.println("The Selection Sort took: " + (time - end)  + " milliseconds");
        
        insertionSort(arr1);
        long time1 = System.currentTimeMillis();
        System.out.println("The Insertion Sort took: " + (time1 - time)  + " milliseconds");

        quickSort(arr2, 0, arr2.length-1);
        long time2 = System.currentTimeMillis();
        System.out.println("The QuickSort took: " + (time2 - time1)  + " milliseconds");
    }
    
    static int[] makeRandomArray(int size, int min, int max)
    {
        Random rdm = new Random();
        int[] rdmArr = new int[size];
        
        for(int a = 0; a < rdmArr.length; a++)
        {
            rdmArr[a] = rdm.nextInt(max)+min;
        }
        
        return rdmArr;
    }
    
    static int[] copyArray(int[] original)
    {
        int length = original.length;
        int[] newArr = new int[length];
        for(int i = 0; i < length; i++)
        {
            newArr[i] = original[i];
        }
        return newArr;
    }
    
    static void bubbleSort(int[] array)
    {
        boolean done = true;
        int b = 0;
        int c;
        while(done)
        {
            done = false;
            b++;

            for(int a = 0; a < array.length - b; a++)
            {
                if(array[a] > array[a+1])
                {
                    c = array[a];
                    array[a] = array[a+1];
                    array[a+1] = c;
                }
                done = true;
            }
        }
    }
    
    static void selectionSort(int[] array)
    {
        boolean done = true;
        int b = 0;
        while(done)
        {
            done = false;
            for(int a = 0; a < array.length; a++)
            {
                int min = array[a];
                int minIndex = a;
                
                for(int c = a + 1; c < array.length; c++)
                {
                    if(array[c] < min)
                    {
                        min = array[c];
                        minIndex = c;
                    }
                }
                
                array[minIndex] = array[a];
                array[a] = min;
            }
        }
    }
    
    static void insertionSort(int[] array)
    {
        int toInsert, j;
        boolean keepGoing;
        
        for(int a = 1; a<array.length; a++)
        {
            toInsert = array[a];
            j = a-1;
            keepGoing = true;
            
            while((j>=0)&& keepGoing)
            {
                if(toInsert<array[j])
                {
                    array[j+1] = array[j];
                    j--;
                    if(j==-1)
                        array[0] = toInsert;
                }
                else
                {
                    keepGoing = false;
                    array[j+1] = toInsert;
                }
            }
        }
    }
    
    static int partition(int[] array, int left, int right)
    {
        int l = left;
        int r = right;
        int pivot = array[(left + right)/2];
        
        while(l<r)
        {
            while(array[l] < pivot)
            {
                l++;
            }
            while(pivot < array[r])
            {
                r--;
            }
            if(l<=r)
            {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
                r--;
            }
        }
        return l;
    }
    
    static void quickSort(int[] array, int left, int right)
    {
        int index = partition(array, left, right);
        if(left<index-1)
        {
            quickSort(array, left, index-1);
        }
        if(index<right)
        {
            quickSort(array, index, right);
        }
    }
}
