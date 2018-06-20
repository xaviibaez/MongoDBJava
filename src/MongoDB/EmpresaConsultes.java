package MongoDB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class EmpresaConsultes {
	Producte  proA = null;
	ObjectId saveAccountOid = null;
	
	public void Consultes(MongoClient mongo, DB db) {
		System.out.println("- CONSULTES -");
		//Crea una tabla si no existe y agrega datos
        DBCollection table = db.getCollection("Empresa");
		Scanner scanner = new Scanner(System.in);
		
		// Busco todos los documentos de la colección y los imprimo
		DBCursor cursor = table.find();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toString());
			}
		} 
		finally {
			cursor.close();
		}
      
        System.out.println("Digues el camp per filtrar - O deixar-ho en blanc");
        String filtre;
		filtre = scanner.nextLine();
			
		
		if(filtre.isEmpty()) {
			ferConsulta(null, table, null);
		}
		else {
			System.out.println("Digues el valor");
	        String valor;
			valor = scanner.nextLine();
			
			ferConsulta(filtre, table, valor);
		}
	}
	
	public void ferConsulta(String filtre, DBCollection table, String valor) {
		DBCursor cursor = table.find();
	
		if(filtre == null) {
			try {
				while (cursor.hasNext()) {
					System.out.println(cursor.next().toString());
				}
			} 
			finally {
				cursor.close();
			}
		}
		else {
			//"READ" -> Hacemos una Query con condiciones y lo pasamos a un objeto Java
		    DBObject query = new BasicDBObject();
		    query.put(filtre, valor);
		    cursor = table.find(query);	    
		    
		    try {
		    	System.out.println("Resultats de la cerca: ");
		    	while (cursor.hasNext()) {		    	
		    		
		    		System.out.println(
		    				" - " + cursor.next().get("nom") 
		    				+ " - " + cursor.curr().get("camp") 
		    				+ " - " + cursor.curr().get("descripcio")
		    				+ "	- Edat:"
		    				+ " - " + cursor.curr().get("edat")		    		
		    				+ "	- Internacional:"
		    				+ " - " + cursor.curr().get("internacional")	
		    				+ "	- Productes:"
		    				+ " - " + cursor.curr().get("Productes")
		    				);
		    	}		    				    	
		    	//proA = readByType(valor, table);		    			    	
		    }
		    catch(NullPointerException e){
		    	e.printStackTrace();
		    } 
		    finally {
		    	cursor.close();
		    }
		}
	}
}
