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
		String s = "<html lang=en><head><meta charset=utf-8><title>jGallerize template</title><meta name=description content=HTML jGallerize><meta name=author content=Nando><link rel=stylesheet href=css/styles.css?v=1.0><!--[if lt IE 9]>  <script src=http://html5shiv.googlecode.com/svn/trunk/html5.js></script>  <![endif]--></head><body>  <script src=js/scripts.js></script></body></html>";
			byte data[] = s.getBytes();
		Path p = Paths.get("./logfile.html");
		try(OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND)))
		{
			out.write(data, 0, data.length);
		}
		catch (IOException x) {
			System.err.println(x);
		}

		}
	}
