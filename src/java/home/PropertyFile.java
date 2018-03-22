
package home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PropertyFile {
    Properties prop;
    FileInputStream f;
    FileOutputStream f1;
  
    public PropertyFile(){
 
        
       
    }
    public void Ipt(String a)
    {
       Properties prop = new Properties();

		try {
			// Store properties to property file
			prop.setProperty("algorithms", a);

			// Save property file to project folder
			prop.store(new FileOutputStream("C:\\Users\\Christos\\Documents\\NetBeansProjects\\ted\\PreAlgos.properties"), null);
		} catch (IOException ex) {
			System.err.println("IO Exception occured while saving property file");
		}
    }
    public String Algo()
    {
        Properties prop = new Properties();
        try {
            f = new FileInputStream("C:\\Users\\Christos\\Documents\\NetBeansProjects\\ted\\PreAlgos.properties");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            prop.load(f);
        } catch (IOException ex) {
            Logger.getLogger(PropertyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prop.getProperty("algorithms");
    
    }
    
    
}
