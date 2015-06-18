package google;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class Google_10_Links {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		System.out.println("Entry");
		System.out.println("ENTER THE KEYWORD FOR GOOGLE SEARCH");
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		List<String> links=new ArrayList();
		links=retrieve(s);
		for(String l:links){
			System.out.println(l+"\n");
		}

	}
	
	@SuppressWarnings("rawtypes")
	public static List retrieve(String entry){
    List entryList = new ArrayList();

      try {  
             // string new entry is making the keywords into query that can be known by google
             String newEntry = (java.net.URLEncoder.encode(entry, "UTF-8").replace("+", "%20"));

             // inputing the keywords to google search engine
             URL url = new URL("http://www.google.co.id/search?q=" + newEntry + "&hl=en&num=10&lr=&ft=i&cr=&safe=images&tbs=");  
             // makking connection to the internet
             URLConnection urlConn = url.openConnection();  
             urlConn.setUseCaches(false);  
             urlConn.setRequestProperty("User-Agent", "User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 ( .NET CLR 3.5.30729)");  

             // getting the input stream of page html into bufferedreader
             BufferedReader buffReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));  
             String line;  
             StringBuffer buffer = new StringBuffer();  

       // getting the input stream of html into stringbuffer       
       while ((line = buffReader.readLine()) != null) {  
        buffer.append(line);  
       }  

       // finding the links
        Pattern p = Pattern.compile(GOOGLE);
        Matcher m = p.matcher(buffer.toString().toLowerCase());
        while (m.find()) {
            String link = m.group(0);
            // putting the links of google search into list
            entryList.add(link);
        }
           } catch (Exception e) {  
            System.out.println(e.getMessage());  
           } 

    return entryList;
}	
}
