package saveLoad;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;

import main.Start;
import vBrain.Person;


/**InOutObj serialisiert die ihr uebergebenen Objekte um diese dann zu Speichern bzw. zu Laden
 * (mittels Interface SaveLoad).
 * Die zu Speichernden Objekte muessen das Interface Seriazible implementiert haben (Flag-Interface ohne Methoden)
 * 
 *
 */
public class InOutObj{

	public boolean loadPersons(String inFilepath, Start S) {
		File f = new File(inFilepath);
		if(f==null || !f.exists() || f.isDirectory()) { 
		    System.out.println("No personList-File found");
		    return false;
		}
		          
		    try {
		      // FileInputStream repraesentiert einen strom von bytes. ObjectInputStream 
		      // deserialisiert die vorab mittels der klasse ObjectOutputStream geschriebenen 
		      // objekte.
		      ObjectInputStream oIS= new ObjectInputStream( new FileInputStream( f ) );
		      
		      Object obj= null;
		      // lese ein objekt nach dem anderen aus dem inputstream. das letzte 
		      // object, welches gelesen wird, ist null. dieses muss allerdings explizit
		      // geschrieben worden sein; andernfalls wird eine EOFException geworfen.
		      while ( (obj= oIS.readObject()) != null ){
		        // da das geschriebene objekt ein Vektor-objekt war, wird dieses auf die 
		        // klasse Vektor gecastet und in den Command Vektor geschrieben.
		        S.getPersonList().addPerson((Person)obj, S);
		      }
		      oIS.close();
		    } catch (Exception e) {
		      return false;
		    }
		    
		    return true;
	}

	public boolean save(String inFilepath, Start S) { 
	            
	      try {
	    	  File f = new File(inFilepath);
	    	  
	    	  if ( f == null )
	  	        return false;
	    	  
	    	  // FileOutputStream repraesentiert einen strom von bytes. ObjectOutputStream 
	    	  // serialisiert objekte und schreibt diese in den outputstream.
	    	  ObjectOutputStream oOS= new ObjectOutputStream( new FileOutputStream( f ) );
	        
	        // der zu schreibende Vektor wird aus Zentralverwaltung gelesen und 
	        // als Vektor<Command> obj in eine Datei geschrieben (Boxing).
	    	for(int i = 0; i < S.getPersonList().getLengthOfList(); i++){
					//oos.writeObject(p);
				}
	        
	        // als letztes objekt wird "null" geschrieben, damit beim einlesen das
	        // dateiende erkannt wird. 
	        oOS.writeObject( null );
	      
	        // schreibe eventuell noch gepufferte daten. 
	        oOS.flush();
	        oOS.close();
	      } catch (Exception e){
	        return false;
	      }
	      
	      return true;
	}

	
	
	
	
}
