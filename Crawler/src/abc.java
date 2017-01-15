import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class abc {
	public static void main(String[] args){
		A a = new A(); 
		for(int i=0;i<2;i++){
		      Thread t = new Thread(a);
		      t.start();
		      
		    }
	}

}
class A implements Runnable{
	int n = 0;
	ArrayList<String> url_list = new ArrayList<String>();
	  File file = new File("urls.txt");
	  BufferedReader reader = null;
	  String string = "";
	public A(){
		n=10;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		do{
			
				try {
					string = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (string != null){
				this.url_list.add(string);
			}
			
		}while(string != null);
	}
	public void run(){
		for(int i = 0 ; i< 2;i++){
			System.out.println(n--);
		}
	}
}
