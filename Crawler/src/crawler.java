import java.util.*;
import java.net.*;
import java.io.*;
import java.util.regex.*;
//import javax.servlet.ServletResponse;
import java.lang.NoClassDefFoundError;

public class crawler {
	public static void main(String[] args){
		InputStream input = null;
		//OutputStream output = null;
		File file = new File("urls.txt");
		String filePath = "";
		String dir = "d:/temp/";
		BufferedReader reader = null;
        try {
            //System.out.println("Read the File by Line£º");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int count = 0;
            int state = -1;
            do  {
            	int random = (int)(Math.random()*5)+1;
            	for (int i = 0 ; i < random; i++){
            		tempString = reader.readLine();
            	}
            	//tempString = "http://www.kyriakides.net/CBCL/references/Papers/freundscsiwa97.pdf";
            	URL url = new URL(tempString);
            	
            	
				String fileName = tempString.substring(tempString.lastIndexOf("/")+1);
				String urlName = tempString.substring(0,tempString.lastIndexOf("/")+1);
				urlName = urlName.replace('/', '!');
				urlName = urlName.replace('.', '#');
				urlName = urlName.replace(':', '$');
				System.out.println(urlName + fileName);
				String name = urlName+fileName;
				InputStream inputStream =null;
            	try{
            		inputStream = url.openStream();
            	}
            	catch(Exception e){
            		continue;
            	}
            	
            	byte[] b = new byte[1024*1024];
				int len;
				
				
				
				OutputStream outputStream = new FileOutputStream(new File(dir  +name));
				while ((len = inputStream.read(b)) != -1) {
					outputStream.write(b, 0, len);
				}
				b = tempString.getBytes();
				outputStream.write(b, 0, b.length);
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				
            	count++;
                System.out.println(tempString);
                
            }while(tempString != null && count<10);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		try {
			//BufferedInputStream input = new BufferedInputStream(new FileInputStream(filePath));
			//OutputStream os = response.getOutputStream();
		}
		catch(Exception e){
			
		}
	}
	
}
