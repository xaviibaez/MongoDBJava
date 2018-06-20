package MongoDB;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Conexio {
	//No surti tot el vermell en la consola
	Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
	
	/**     
     * Clase para crear una conexión a MongoDB.* 
     * @return MongoClient conexión  
     */
    public static MongoClient crearConexion() throws UnknownHostException {
        // PASO 1: Conexión al Server de MongoDB Pasandole el host y el puerto
        MongoClient mongo = new MongoClient("localhost", 27017);
        
        return mongo;
    }
 
    /**
     * Clase que imprime por pantalla todas las bases de datos MongoDB.
     * @param mongo conexión a MongoDB
     */
    public static void printDatabases(MongoClient mongo) {
        List<String> dbs = mongo.getDatabaseNames();
        System.out.println("Llista de bases de dades: ");
        for (String db : dbs) {
            System.out.println("- " + db);
        }
        System.out.println();
    }
    
    public static void printCollection(MongoClient mongo, DB db) {
        DBCollection table = db.getCollection("Empresa");

    	//Listar las tablas de la base de datos actual
        System.out.println("Llista taula de la base de dades: ");
        Set<String> tables = db.getCollectionNames();
        for(String coleccion : tables){
            System.out.println(" - " + coleccion);
        }
        System.out.println();
    }
}
