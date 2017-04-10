import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class ReaderFile {
	
	private String secretWord;
	
	//LICZ ILE LINII W PLIKU+
	public int countFilesLines(String pathFile) {
		int lineNumber = 0;
		try {
			File myFile = new File(pathFile);
			FileReader fileReader = new FileReader(myFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
					
			while ((line = bufferedReader.readLine()) != null) {

					lineNumber++;
			}
			bufferedReader.close();
			
		} catch (Exception event) {
			event.printStackTrace();
		}
		return lineNumber;
	}
	
	//LOSUJ WYRAZ Z PLIKU
	public String readFile (String pathFile) {
		
		int lineNumberBufferReader=1;
		Random number = new Random();
		int numberRandomLine = number.nextInt(countFilesLines(pathFile))+1;
		
		try {
			File myFile = new File(pathFile);
			FileReader fileReader = new FileReader(myFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
					
			while ((line = bufferedReader.readLine()) != null) {
				
				if (lineNumberBufferReader == numberRandomLine)
					secretWord = line;
					lineNumberBufferReader++;
			}

			bufferedReader.close();
			
		} catch (Exception event) {
			event.printStackTrace();
		}
		return secretWord.toUpperCase();
}	
//	public static void main(String[] args) {
////		
//		CategoryPath cp =  CategoryPath.EMPTY_NO_PATH;
//		
//		ReaderFile rf = new ReaderFile();
//		System.out.println(rf.readFile(cp.toString()));
//	}

}
