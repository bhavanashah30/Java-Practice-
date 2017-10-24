package imanage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class csvdataproject {
	public static void main(String[] args) throws IOException {
	
		String csvFile= "../imanage/exercise_data.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String[] entry = null;
		Scanner in= new Scanner(System.in);
        Pattern p  ;
        Matcher m, n;
        boolean flag = false;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            System.out.print("\nEntry");
            while ((line = br.readLine()) != null) {
            	
                // using comma as separator
                entry = line.split(cvsSplitBy);                
                for(int i=0;i<args.length;i++){
                	p=Pattern.compile(args[i]);
                	m=p.matcher(entry[1]);
                    n= p.matcher(entry[2]);
                    if(m.find()||n.find()){
                    	flag= true;
                    System.out.print("\n"+entry[0] + " ," + entry[1]);   }                 
                 }            
                
                }    
            if(flag == false)
            	System.out.print(" not Found\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    in.close();
                   // jar.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
	
}