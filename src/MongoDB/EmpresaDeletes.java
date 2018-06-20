package MongoDB;

import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class EmpresaDeletes {
	
	public void ferDelete(MongoClient mongo, DB db) {
		System.out.println("- DELETES -");
		//Recoge datos de la tabla
        DBCollection table = db.getCollection("Empresa");
		Scanner scanner = new Scanner(System.in);

        System.out.print("Digues el nom Empresa a eliminar: ");
        String empresaNom;
		empresaNom = scanner.nextLine();
		
		if(empresaNom.isEmpty()) {
			System.out.println("NO HO DEIXIS EN BLANC");
		}
		else {
			table.remove(new BasicDBObject().append("nom", empresaNom));
			System.out.println("- Delete fet: " + empresaNom);
		}
	}
}
