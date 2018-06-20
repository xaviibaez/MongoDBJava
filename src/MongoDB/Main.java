package MongoDB;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class Main {
	//Per conectarte a la base de dades (EN CLASSE);
	//D:
	//cd \MongoDB\Server\3.4\bin\mongod
	
	//Per conectarte a la base de dades (EN CASA);
	//C:
	//cd \Program Files\MongoDB\Server\3.4\bin\mongod
	
	//http://www.javahotchocolate.com/notes/mongodb-crud.html
	
	public static void main(String[] args) throws UnknownHostException{	
		//Conectar
		Conexio conexio = new Conexio();
        MongoClient mongo = conexio.crearConexion();     
        
        if (mongo != null) {
        	EmpresaInserts empresaacces = new EmpresaInserts();
			EmpresaConsultes empresaconsultes = new EmpresaConsultes();
			EmpresaUpdates empresaupdates = new EmpresaUpdates();
			EmpresaDeletes empresadeletes = new EmpresaDeletes();

			DB dbEmpresa = empresaacces.retornar(mongo);
			
    		System.out.println("Conexió correcta!");
    		
    		System.out.println("1 - Veure Bases de dades");
    		System.out.println("2 - Crear documents basics");
    		System.out.println("3 - Fer Consultes");
    		System.out.println("4 - Fer Updates");
    		System.out.println("5 - Fer Inserts");
    		System.out.println("6 - Fer Deletes");
    		System.out.println("8 - Eliminar DROP DATABASE");
    		System.out.println("9 - Sortir");
    		
        	Scanner scanner = new Scanner(System.in);

        	int opcio = 0;
        	while(opcio!=9) {
        		
        		opcio = scanner.nextInt();
	    		switch(opcio) {
		    		case 1:
		    			//Llita de bases de dades			
		    			conexio.printDatabases(mongo);
		    			conexio.printCollection(mongo, dbEmpresa); 	
		    			break;
		    		case 2:		    			
		    			empresaacces.insertDefault(mongo, dbEmpresa);
		    			break;
		    		case 3:		   
		    			empresaconsultes.Consultes(mongo, dbEmpresa);
		    			break;
		    		case 4:
		    			empresaupdates.UpdateEmpresa(mongo, dbEmpresa); 			
		    			break;
		    		case 5:
		    			empresaacces.comFerInsert(mongo, dbEmpresa);
		    			break;
		    		case 6:
		    			empresadeletes.ferDelete(mongo, dbEmpresa);
		    			break;
		    		case 8:
		                dbEmpresa.dropDatabase();
		                System.out.println("BASE DE DADES " + dbEmpresa.getName() + " ELIMINADA!");
		    			break;
		    		case 9:
		    			mongo.close();
		        		System.out.println("ADEU! - Conexió tancada.");
		    			break;
	    		}
        	}   		       	
        }
        else {
            System.out.println("Error: Conexió no establerta");
        }		
	}	  
}
