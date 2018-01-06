import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   
   public static void main(String[] args) throws Exception {
	   Scanner scanner = new Scanner(System.in);
	   String command="";
	   ArrayList<String> linearray=new ArrayList<String>();/*The array containing the words read from the file.*/
	   ArrayList<Long> numbers=new ArrayList<Long>();/*The array containing the numbers read from the file.*/
	   
	   ReadFile read=new ReadFile();
	   read.read(args[0], linearray, numbers);
	  
	   while(command.compareTo("Exit")!=0){
		   
		   try{
			   if (Integer.parseInt(args[1])<0)
		        {
		            throw new IllegalArgumentException
		            ("N must be non-negative!");
		        }
			   	System.out.print("Please enter the word : ");
			   	command=scanner.nextLine();
			   	
			   	if (command.length() ==0 )
		        {
		            throw new NullPointerException
		            ("Word must be non-empty!");
		        }
		   }
		   catch(IllegalArgumentException i){
		       System.out.println(i);
		       System.out.println("Program is stopped.");
		       System.exit(0);
		   }
		   catch(NullPointerException a){
			   System.out.println(a);
		       System.out.print("Please enter the word : ");
			   command=scanner.nextLine();
		   }
		   
		   QuickSort qsort=new QuickSort();
		   qsort.sort(linearray,numbers);
			   
		   ArrayList<String> searcharray=new ArrayList<String>();/*This is the array in which the words found with the binary search are found.*/
		   ArrayList<Long> searchnumbers=new ArrayList<Long>();/*This is the array in which the numbers found with the binary search are found.*/
			   
		   BinarySearch search=new BinarySearch(linearray,numbers,searcharray,searchnumbers);
		   search.binarySearch(command);
			   
	       QuickSortLong qsortlong=new QuickSortLong();
		   qsortlong.sort(searchnumbers,searcharray);
		   Main use=new Main();
		   use.Print(Integer.parseInt(args[1]),searcharray,searchnumbers);
	   }
	   System.out.println("Program is stopped!");
	   scanner.close();
   }
   
   /*Prints the sorted words as many as the entered number.*/
   public  void Print(int size,ArrayList<String> searcharray,ArrayList<Long> searchnumbers){
	   if(size<=searcharray.size()){
		   for(int k=0;k<size;k++){
			   System.out.println(searcharray.get(k)+" "+searchnumbers.get(k));
		   }
	   }
	   else{
		   for(int k=0;k<searcharray.size();k++){
			   System.out.println(searcharray.get(k)+" "+searchnumbers.get(k));
		   }
	   }
   }
}

