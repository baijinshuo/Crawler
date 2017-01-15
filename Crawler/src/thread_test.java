import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;


public class thread_test {
	public static void main(String[] args) {
		R r = new R();
		Thread t;
		 for(int i=0;i<100;i++){
		      t = new Thread(r);
		      t.start();
		    }
		 
	}

}

class R implements Runnable{
	  private int x = 0;
	  ArrayList<String> url_list = new ArrayList<String>();
	  File file = new File("urls.txt");
	  BufferedReader reader;
	  String string = "";
	  public R(){
		  
		  
			try {
				reader = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(true){
            	//System.out.println(reader.readLine());//url_list.get(x++));
        	   String str=null;
			try {
				str = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   if(str!=null){
        		   if(str.equalsIgnoreCase("http://www.cs.ucdavis#edu/~filkov/papers/ictai03.pdf"))//"http://www.cs.virginia.edu/~stankovic/psfiles/tracking.pdf"
	            		break;
        	   }
            	
            }
			/*do{
				
					try {
						string = reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (string != null){
					this.url_list.add(string);
				}
				
			}while(string != null);*/
		
	  }
	  public void  run(){
		  InputStream input = null;
			//OutputStream output = null;
			//File file = new File("urls.txt");
			String filePath = "";
			String dir = "D:\\IR_pdf\\";
			//BufferedReader reader = null;
	        try {
	            //System.out.println("Read the File by Line£º");
	            //reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int count = 0;
	           
	           do  {
	            
	            	int random = (int)(Math.random()*5)+1;
	            	for (int i = 0 ; i < random; i++){
	            		if (x < 100000)
	            		tempString = reader.readLine();//url_list.get(x++);
	            	}
	            	URL url ;
	            	try{
	            		url = new URL(tempString);
	            	}
	            	catch(Exception e){
	            		continue;
	            	}
	            	String fileName = tempString.substring(tempString.lastIndexOf("/")+1);
					String urlName = tempString.substring(0,tempString.lastIndexOf("/")+1);
					urlName = urlName.replace('/', '!');
					urlName = urlName.replace('.', '#');
					urlName = urlName.replace(':', '$');
					
					String name = urlName+fileName;
					InputStream inputStream =null;
	            	try{
	            		inputStream = url.openStream();
	            		System.out.println(name);
	            	}
	            	catch(Exception e){
	            		continue;
	            	}
	            	byte[] b = new byte[1024*1024];
					int len;
					OutputStream outputStream = null;
					try{
						outputStream = new FileOutputStream(new File(dir  +name));
					}
					catch(Exception e){
						continue;
					}
					try{
						while ((len = inputStream.read(b)) != -1) {
							outputStream.write(b, 0, len);
						}
					}
					catch(Exception e){
						continue;
					}
					
					b = tempString.getBytes();
					outputStream.write(b, 0, b.length);
					outputStream.flush();
					outputStream.close();
					inputStream.close();
	            	
	            	count++;
	                
	                
	            }while(tempString != null && count<10000);
	            //reader.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        
	        }
}
}