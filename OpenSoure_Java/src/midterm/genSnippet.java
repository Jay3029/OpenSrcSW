package midterm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class genSnippet {
	public static void main(String[] args) {
		
	
    Path path = Paths.get("C:\\Users\\이재현\\Desktop\\2021 1학기\\오픈소스\\input.txt");

    List<String> list = new ArrayList<String>();
    
    try{
        list = Files.readAllLines(path);
    }catch(IOException e){
        e.printStackTrace();
    }
    for(int i=0; i<list.size();i++) {
    	if(i==0) {
    		List<String> line0 = list.get(0);
    	}else {
        	String line1 = list.get(i);
        	line0.
    	}

    }
    
    
	}
}
	
	


