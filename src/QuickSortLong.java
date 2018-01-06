import java.util.ArrayList;

/*This takes into account the alphabetical ordering of numbers and changes the position of words and numbers in the array.*/
public class QuickSortLong {
    
    ArrayList<Long>numbers;
    ArrayList<String> names;
    int length;
 
    public void sort(ArrayList<Long>inputArr,ArrayList<String>names) {
         
        if (inputArr == null || inputArr.size() == 0) {
            return;
        }
        this.numbers = inputArr;
        this.names=names;
        length = inputArr.size();
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        long pivot = numbers.get(lowerIndex+(higherIndex-lowerIndex)/2);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (numbers.get(i) > pivot) {
                i++;
            }
            while (numbers.get(j) < pivot) {
                j--;
            }
            if (i <= j) {
            	long temp = numbers.get(i);
                String tempname=names.get(i);
                numbers.set(i, numbers.get(j));
                names.set(i, names.get(j));
                numbers.set(j, temp);
                names.set(j, tempname);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
}