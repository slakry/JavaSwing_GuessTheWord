import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class ReaderFile {
	
	private String secretWord;
	
	//LICZ ILE LINII W PLIKU+
	public int countFilesLines(String pathFile) {
		int lineNumber = 0;
		try {
			InputStream inputStream = getClass().getResourceAsStream(pathFile);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
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
			InputStream inputStream = getClass().getResourceAsStream(pathFile);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			String line = null;
					
			while ((line = bufferedReader.readLine()) != null) {
				
				//System.out.println(line);
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
}
