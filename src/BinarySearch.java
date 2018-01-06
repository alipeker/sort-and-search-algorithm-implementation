import java.util.ArrayList;

public class BinarySearch {
	ArrayList<String> array;
	ArrayList<Long> numbers;
	ArrayList<String> searcharray;
	ArrayList<Long> searchnumbers;
	int size;
	
	public BinarySearch(ArrayList<String> inputarray,ArrayList<Long> numbers,ArrayList<String> searcharray,ArrayList<Long> searchnumbers){
		this.array=inputarray;
		this.size=inputarray.size();
		this.numbers=numbers;
		this.searcharray=searcharray;
		this.searchnumbers=searchnumbers;
	}
	
	/*With binary search, the place in the array move forward. And at the beginning, words with these words are added to the array.*/
	public void RightControlAll(int where,String key){
		String word="";
		while(where<size-1){
			where++;
			/*Merge the characters inside the array for control.*/
			if(array.get(where).length()>=key.length()){
			    for(int i=0; i<key.length();i++){
				    word=word.concat(array.get(where).charAt(i)+"");
			    }
		    }
			else{
		    	for(int y=0;y<array.get(where).length();y++){
		    		word=word.concat(array.get(where).charAt(y)+"");
		    	}
		    }
			if(key.compareTo(word)==0){
		    	searcharray.add(array.get(where));
		    	searchnumbers.add(numbers.get(where));
			}
			else{
				return;
			}
			word="";
		}
	}
	
	/*With binary search, the place in the array move backward. And at the beginning, words with these words are added to the array.*/
	public void LeftControlAll(int where,String key){
		String word="";
		while(where>0){
			where--;
			/*Merge the characters inside the array for control.*/
			if(array.get(where).length()>=key.length()){
			    for(int i=0; i<key.length();i++){
				    word=word.concat(array.get(where).charAt(i)+"");
			    }
		    }
			else{
		    	for(int y=0;y<array.get(where).length();y++){
		    		word=word.concat(array.get(where).charAt(y)+"");
		    	}
		    }
			if(key.compareTo(word)==0){
		    	searcharray.add(array.get(where));
		    	searchnumbers.add(numbers.get(where));
			}
			else{
				return;
			}
			word="";
		}
	}
	
	/*Binary search finds a word that starts with the word given in the array.*/
	public void binarySearch(String key) 
	{
		int low = 0;
	    int high = size - 1;
	    int lengthkey=key.length();
	    String control="";
	    while(high >= low) {
		    int middle = (low + high) / 2;
		    /*Merge the characters inside the array for control.*/
		    if(array.get(middle).length()>=key.length()){
			    for(int i=0;i<lengthkey;i++){
				    control=control.concat(array.get(middle).charAt(i)+"");
			    }
		    }
		    else{
		    	for(int y=0;y<array.get(middle).length();y++){
		    		control=control.concat(array.get(middle).charAt(y)+"");
		    	}
		    }
		    
		    if(key.compareTo(control)==0){
		    	searcharray.add(array.get(middle));
		    	searchnumbers.add(numbers.get(middle));
		    	LeftControlAll(middle,control);
		    	RightControlAll(middle,control);
		    	return;
			}
		    
		    if(key.compareTo(control)<0){
		    	high = middle - 1;
		    }
		    
		    if(key.compareTo(control)>0){
		    	low = middle + 1;
		    }
		    
		    control="";
		    
	    }
	}
}
