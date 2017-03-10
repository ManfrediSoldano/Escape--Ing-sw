package it.polimi.ingsw.cg_10.controller.logic;

import java.io.*;
import java.util.ArrayList;

public class ZoneFileReader {
	
	private ArrayList<String> fileStrings = new ArrayList<String>();
	private String uriPath;
	
	public ZoneFileReader(String uriPath)
	{
		this.uriPath = uriPath;
	}

	public int countLines(String filename) throws IOException {
		LineNumberReader reader  = new LineNumberReader(new FileReader(filename));
		int cnt = 0;
		while ((reader.readLine()) != null) {}
		cnt = reader.getLineNumber(); 
		reader.close();
		return cnt;
	}

	public void loadMapFile(){

		try {

			File mapFile = new File(uriPath);
			FileReader fr = new FileReader(mapFile);
			BufferedReader br = new BufferedReader(fr);
			int numOfLine= countLines(mapFile.getAbsolutePath());
			fileStrings.clear();
			for (int i=0;i<numOfLine;i++){		
				String line=br.readLine();
				fileStrings.add(line);		
			}
			br.close();
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: reading map file");
		}
	}
	
	public ArrayList<String> getFileStrings (){
		return fileStrings;
	}
	
}
