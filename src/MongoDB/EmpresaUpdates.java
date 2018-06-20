package MongoDB;

import java.util.List;
import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class EmpresaUpdates {
	public void UpdateEmpresa(MongoClient mongo, DB db) {
		System.out.println("- UPDATES -");
		//Crea una tabla si no existe y agrega datos
        DBCollection table = db.getCollection("Empresa");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Empresa | Producte ");
		String queActualitzar;
		queActualitzar = scanner.nextLine();
		
		if(queActualitzar.equals("Empresa")) {
			System.out.println("Digues quina empresa vols actualitzar: ");
			String empresaNom;
			empresaNom = scanner.nextLine();
			
			if(empresaNom.isEmpty()) {
				System.out.println("NO HO DEIXIS EN BLANC");
			}
			else {
				System.out.println("Digues quin camp vols actualitzar: ");	
				String camp;
				camp = scanner.nextLine();
				
				if(camp.isEmpty()) {
					System.out.println("NO HO DEIXIS EN BLANC");
				}
				else {
					System.out.println("Digues el valor: ");	
					String valor = null;
					valor = scanner.nextLine();
					
					if(valor.isEmpty()) {
						System.out.println("NO HO DEIXIS EN BLANC");
					}
					else {
						ferUpdate("Empresa", empresaNom, camp, valor, table);
					}
				}
			}
		}
		else {
			System.out.println("Digues el nom de l'empresa del producte actualitzar: ");
			String empresaNom;
			empresaNom = scanner.nextLine();
			
			if(empresaNom.isEmpty()) {
				System.out.println("NO HO DEIXIS EN BLANC");
			}
			else {
				System.out.println("Digues quin camp vols actualitzar: ");	
				String camp;
				camp = scanner.nextLine();
				
				if(camp.isEmpty()) {
					System.out.println("NO HO DEIXIS EN BLANC");
				}
				else {
					System.out.println("Digues el valor: ");	
					String valor = null;
					valor = scanner.nextLine();
					
					if(valor.isEmpty()) {
						System.out.println("NO HO DEIXIS EN BLANC");
					}
					else {
						ferUpdate("Producte", empresaNom, camp, valor, table);
					}
				}
			}
			
		}
								
	}
	
	public void ferUpdate(String elQue, String empresaNom, String camp, String valor, DBCollection table) {	
		BasicDBObject searchById = new BasicDBObject();
		
		if(elQue.equals("Empresa")) {
			searchById.append("nom", String.valueOf(empresaNom));	
	        
	        BasicDBObject update = new BasicDBObject();
	        update.append("$set", new BasicDBObject().append(camp, valor));

	        table.updateMulti(searchById, update);
	        
	        System.out.println("UPDATE FET! - Empresa: " + String.valueOf(empresaNom) + " - Camp: " + String.valueOf(camp) + " - Valor: "  + String.valueOf(valor));
		}
		else {
			searchById.append("Producte.nom", String.valueOf(empresaNom));	
	        
	        BasicDBObject update = new BasicDBObject();
	        update.append("$set", new BasicDBObject().append(camp, valor));

	        table.updateMulti(searchById, update);
	        
	        System.out.println("UPDATE FET! - Producte - Empresa: " + String.valueOf(empresaNom) + " - Camp: " + String.valueOf(camp) + " - Valor: "  + String.valueOf(valor));
		}
        
	}
}
