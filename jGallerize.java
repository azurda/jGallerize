package jGallerize;

import static java.nio.file.StandardOpenOption.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Path;
/**
 * 
 * @author Fernando
 * @version 0.1
 */

public class Gallerize{
	public static void main(String[] args)
	{
		// Get the template string
		String s = "<html lang=en><head><meta charset=utf-8><title>"
				+ "jGallerize template</title>"
				+ "<meta name=description content=HTML jGallerize>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"template.css\">"
				+ "<meta name=author content=Nando>"
				+ "<!--[if lt IE 9]> "
				+ " <script src=http://html5shiv.googlecode.com/svn/trunk/html5.js></script> "
				+ " <![endif]--></head><body><center><hr><h1>GENERATED GALLERY</h1></hr> <br> $IMGCODE$ <hr></hr><script src=js/scripts.js></script></center></body></html>";
		
		// Create file
		Path p = Paths.get("./gallery.html");
		
		
		
		final String dir = System.getProperty("user.dir");
		File folder = new File(dir);
		File[] listOfFiles = folder.listFiles();
		int i = 0;
		String finalcode = "";
		for(File file : listOfFiles)
		{
			if(file.isFile())
			{
				final String code = "<img src=$FILENAME$ alt=$FILENAME$ height=42 width=100>";
				String codeToReplace = code;
				if(file.getName().contains(".jpg") || file.getName().contains(".png"))
				{
					String modStr = codeToReplace.replace("$FILENAME$", file.getName());
					finalcode += modStr;
					++i;
				}
				
				
				if(0 == i % 10)
				{
					finalcode += "<br>";
				}
			}
		}
		String FINAL = s.replace("$IMGCODE$",finalcode);
		
		byte data[] = FINAL.getBytes();
		try(OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND)))
		{
			out.write(data, 0, data.length);
		}
		catch (IOException x) {
			System.err.println(x);
		}
			
		}
	}
	
