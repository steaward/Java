import java.io.*;
import java.util.*;

public class CountOccuranceOfWords {
	
	public static void main(String[] args) throws IOException {
		
		Map<String, Integer>map = new TreeMap<>();
		File filePath = new File(args[0]);
		Reader file = null;
		BufferedReader inFile = null;
		
		try {
			file = new FileReader(filePath);
			inFile = new BufferedReader(file);
			String inString;
			while((inString = inFile.readLine()) != null) {
				//split the words by any one or more non-word character, number, or non-white space
				String[] words = inString.split("[\\W+|^\\d]|\\t\\n\\r]");
				
				for(int i = 0; i < words.length; i++) {
					//System.out.println(words[i]);
					String key = words[i].toLowerCase();
						if(!map.containsKey(key)) {
							map.put(key, 1);
						}
						else {
							int value = map.get(key);
							value++;
							map.put(key, value);
						}
				}
			}
			//this prints in alphabetical order
			map.forEach((key,value) -> System.out.println(key + " " + value));
			file.close();
		
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		
		
		
	}
	

}

