package MongoDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class EmpresaInserts {
	public DB retornar(MongoClient mongo) {
		//Si no existe la base de datos la crea
    	DB db = mongo.getDB("EmpresaAcces");     
        return db;
	}
    
    public void insertDefault(MongoClient mongo, DB db) {
    	retornar(mongo);
    	
    	//Crea una tabla si no existe y agrega datos
        DBCollection table = db.getCollection("Empresa");    
        
        //Crea los objectos básicos
        BasicDBObject document0 = new BasicDBObject();
        document0.put("nom", "XaviHTML");
        document0.put("camp", "Informàtica");
        document0.put("descripcio", "Crea aplicacions web");
        document0.put("edat", 2);               
        Producte producte00 = new Producte("Plantilla HTML", "HTML", "Plantilla HTML sense completar", "XaviHTML", 12);
        //Producte producte01 = new Producte("Plantilla HTML Millorada", "HTML", "Plantilla HTML completada", "XaviHTML", 20); 
        producte00.generateId();   
        //producte01.generateId();  
        DBObject dbo0;
        ArrayList<DBObject> arrayDBO0 = new ArrayList<DBObject>(); 
        dbo0 = producte00.bsonFromPojo(); arrayDBO0.add(dbo0);
        //dbo0 = producte01.bsonFromPojo(); arrayDBO0.add(dbo0);       
        document0.put("Productes", arrayDBO0);
        document0.put("internacional", true);
        table.insert(document0);   
        
        BasicDBObject document1 = new BasicDBObject();
        document1.put("nom", "Hibernate Company");
        document1.put("camp", "Informatica");
        document1.put("descripcio", "Hibernate en Java");
        document1.put("edat", 3);         
        Producte producte10 = new Producte("Hibernate", "Hibernate", "Programa Hibernate", "Hibernate Company", 50);      
        producte10.generateId();         
        DBObject dbo1;
        ArrayList<DBObject> arrayDBO1 = new ArrayList<DBObject>(); 
        dbo1 = producte10.bsonFromPojo(); arrayDBO1.add(dbo1);
        document1.put("Productes", arrayDBO1);
        document1.put("internacional", false);
        table.insert(document1);        
        
        BasicDBObject document2 = new BasicDBObject();
        document2.put("nom", "Hola");
        document2.put("camp", "Informatica");
        document2.put("descripcio", "Hibernate en Java");
        document2.put("edat", 3);         
        Producte producte20 = new Producte("Hibernate 2", "Hibernate 2", "Programa Hibernate 2", "Hibernate Company 2", 100);      
        producte20.generateId();          
        DBObject dbo2;
        ArrayList<DBObject> arrayDBO2 = new ArrayList<DBObject>(); 
        dbo2 = producte20.bsonFromPojo(); arrayDBO2.add(dbo2);
        document2.put("Productes", arrayDBO2);
        document2.put("internacional", false);
        table.insert(document2); 
/*
        BasicDBObject document3 = new BasicDBObject();
        document3.put("nom", "CSS3 Company");
        document3.put("camp", "Informatica i Disseny");
        document3.put("descripcio", "CSS· Plantillas");
        document3.put("edat", 3);      
        List<BasicDBObject> productes3 = new ArrayList<>();
        productes3.add(new BasicDBObject("producte 0", "Plantilla CSS3 responsive"));
        productes3.add(new BasicDBObject("producte 1", "Plantilla CSS3 no responsive"));
        document3.put("productes", productes3);
        document3.put("internacional", true);
        table.insert(document3);
*/
        System.out.println("INSERTS CORECTES EN " + db.getName() + " - Registres: " + table.count());
    } 
    
    public void comFerInsert(MongoClient mongo, DB db) {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Empresa | Producte");
    	String opcio;
    	opcio = scanner.nextLine();
    	
    	if(opcio.isEmpty()) {
    		
    	}
    	else {
    		if(opcio.equals("Empresa")) {
    			insertTotal(mongo, db);
    		}
    		if(opcio.equals("Producte")) {
    	    	System.out.println("Digues el nom de Empresa per introduir el seu producte");
    	    	String nomEM;
    	    	nomEM = scanner.nextLine();
    	    	
    	    	if(nomEM.isEmpty()) {
        	    	insertParcial(mongo, db, null);
    	    	}
    	    	else {
        	    	insertParcial(mongo, db, nomEM);
    	    	}
    		}
    	} 	
    }
    
    public void insertTotal(MongoClient mongo, DB db) {
    	Scanner scanner = new Scanner(System.in);
    	BasicDBObject document = new BasicDBObject();
    	//Crea una tabla si no existe y agrega datos
        DBCollection table = db.getCollection("Empresa");
    	
    	System.out.println("- INSERTS - Introdueix les dades EMPRESA: ");	
    	
    	System.out.println("- Nom Empresa: ");	
    	String nomE;
    	nomE = scanner.nextLine();
    	
    	System.out.println("- Camp Empresa: ");	
    	String campE;
    	campE = scanner.nextLine();
    	
    	System.out.println("- Descripcio Empresa: ");	
    	String descripcioE;
    	descripcioE = scanner.nextLine();
    	
    	System.out.println("- Edat Empresa: ");	
    	int edatE;
    	edatE = scanner.nextInt();
    	
    	System.out.println("- Internacional (true | false) Empresa: ");	
    	Boolean internacionalE;
    	internacionalE = scanner.nextBoolean();
    	
    	document.put("nom", nomE);
        document.put("camp", campE);
        document.put("descripcio", descripcioE);
        document.put("edat", edatE); 
        document.put("internacional", internacionalE);
        
    	System.out.println("Insert Manual, introdueix les dades PRODUCTE: ");	
    	
    	System.out.println("- Nom Producte: ");
    	String nomP;
    	nomP = scanner.nextLine();
    	
    	System.out.println("- Tipus Producte: ");
    	String tipusP;
    	tipusP = scanner.nextLine();
    	
    	System.out.println("- Descripcio Producte: ");
    	String descripcioP;
    	descripcioP = scanner.nextLine();
    	
    	System.out.println("- Preu Producte: ");
    	float preuP;
    	preuP = scanner.nextFloat();
    	
    	Producte producte = new Producte(nomP, tipusP, descripcioP, nomE, preuP);
        DBObject dbO;
        ArrayList<DBObject> arrayDBO = new ArrayList<DBObject>(); 
        dbO = producte.bsonFromPojo(); arrayDBO.add(dbO);
        document.put("Productes", arrayDBO);
    	
        table.insert(document);
        
        System.out.print("Insert completat: " + nomE + " - Taula: " + table);
    }
    
    public void insertParcial(MongoClient mongo, DB db, String nomE) {
    	Scanner scanner = new Scanner(System.in);
    	//BasicDBObject document = new BasicDBObject();
    	
    	
        DBCollection table = db.getCollection("Empresa");
		DBCursor cursor = table.find();

        DBObject query = new BasicDBObject();
	    query.put("nom", nomE);
	    cursor = table.find(query);	 
	    
    	//document = query;

    	if(nomE == null) {//Fer insert PRODUCTE a tots els documents
    		System.out.println("ERES MALA PERSONA - NULL NO");
    	}
    	else {          
    		System.out.println("- Nom Producte: ");
        	String nomP;
        	nomP = scanner.nextLine();
        	
        	System.out.println("- Tipus Producte: ");
        	String tipusP;
        	tipusP = scanner.nextLine();
        	
        	System.out.println("- Descripcio Producte: ");
        	String descripcioP;
        	descripcioP = scanner.nextLine();
        	
        	System.out.println("- Preu Producte: ");
        	float preuP;
        	preuP = scanner.nextFloat();
        	
        	Producte producte = new Producte(nomP, tipusP, descripcioP, nomE, preuP);
            DBObject dbO;
            ArrayList<DBObject> arrayDBO = new ArrayList<DBObject>(); 
            dbO = producte.bsonFromPojo(); arrayDBO.add(dbO);
            //document.put("Productes", arrayDBO);
           // table.insert(document);
            
            System.out.print("Insert completat PRODUCTE: " + nomP + " - Taula: " + table);
    	}
    }
}
