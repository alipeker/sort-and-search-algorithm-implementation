import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadFile {
	
	/*This function reads the file. And the numbers transfer the numbers array and the words to linearray.*/
	public void read(String args, ArrayList<String> linearray,ArrayList<Long> numbers){
		File fileDir = new File(args);

		   try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir),"ISO-8859-9"))) {
				   
			   String line;
			   int count=0;
			   while ((line = br.readLine()) != null) {
				   if(count!=0){
				    		numbers.add(Long.parseLong(line.split("\t")[0].trim()));
				    		linearray.add(line.split("\t")[1]);
				    }
				    count++;
			   }
		   }
		   catch (IOException e) {
			   System.err.println("Error: " + e);
		   }
	}
}
