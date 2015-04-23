package Q;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


public class Runner 
{
	 public static void main(String[] args) throws Exception 
	    {
	    	
		    String name_list_file = "/home/matthias/Workbench/SUTD/nytimes_corpus/NYTimesCorpus/2005/01/02/test/people.txt";
	    	
		    String single_name;
		    
		    try (   
	    			// read in the original file, list of names, w/e
	    	        InputStream stream_for_name_list_file = new FileInputStream( name_list_file );
	    	        InputStreamReader stream_reader = new InputStreamReader( stream_for_name_list_file , Charset.forName("UTF-8"));
	    	        BufferedReader line_reader = new BufferedReader( stream_reader );
	    	    ) 
	    	{
			    while (( single_name = line_reader.readLine() ) != null) 
			    {

			    	String single_name_nospace = single_name.replace(' ', '+');
			    	
			    	Wikidata_Q_Reader.getQ( single_name_nospace );
			    }
	    	}
	    }
}