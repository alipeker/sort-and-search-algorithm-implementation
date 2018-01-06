import java.util.ArrayList;

/*This takes into account the alphabetical ordering of words and changes the position of words and numbers in the array.*/
public class QuickSort {
	ArrayList<String> names;
	ArrayList<Long>numbers;
    int length;
	void sort(ArrayList<String> array,ArrayList<Long>numbers) {
        if (array == null || array.size() == 0) {
            return;
        }
        this.names = array;
        this.length = array.size();
        this.numbers=numbers;
        quickSort(0, length - 1);
    }

    void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.names.get(lowerIndex + (higherIndex - lowerIndex) / 2);

        while (i <= j) {
        	/**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (this.names.get(i).compareTo(pivot) < 0) {
                i++;
            }

            while (this.names.get(j).compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                String temp = this.names.get(i);
                long tempnumber=this.numbers.get(i);
                this.names.set(i, this.names.get(j));
                this.numbers.set(i, this.numbers.get(j));
                this.names.set(j, temp);
                this.numbers.set(j, tempnumber);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

}
