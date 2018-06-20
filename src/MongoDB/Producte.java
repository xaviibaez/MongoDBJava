package MongoDB;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Producte {
	private ObjectId _id;
	private String nom;
	private String tipus;
	private String descripcio;
	private String fabricant;
	private float preu;
	
	public Producte() {
	}
	
	public Producte(String nom, String tipus, String descripcio, String fabricant, float preu) {
		super();
		this.nom = nom;
		this.tipus = tipus;
		this.descripcio = descripcio;
		this.fabricant = fabricant;
		this.preu = preu;
	}
	
	// Transformem un objecte de  MongoDB a un Objecte Java
	public Producte(BasicDBObject dBObjectProducte) {
		this.nom = dBObjectProducte.getString("nom");
		this.tipus = dBObjectProducte.getString("tipus");
		this.descripcio = dBObjectProducte.getString("descripcio");
		this.fabricant = dBObjectProducte.getString("fabricant");
		this.preu = dBObjectProducte.getInt("preu");
	}
	
	public BasicDBObject toDBObjectProducte() {
		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectEmpresa = new BasicDBObject();
		
		dBObjectEmpresa.append("nom", this.getNom());
		dBObjectEmpresa.append("tipus", this.getTipus());
		dBObjectEmpresa.append("descripcio", this.getDescripcio());
		dBObjectEmpresa.append("productes", this.getFabricant());
		dBObjectEmpresa.append("preu", this.getPreu());
		
		return dBObjectEmpresa;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public String getFabricant() {
		return fabricant;
	}
	public void setFabricant(String fabricant) {
		this.fabricant = fabricant;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}	
	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public void generateId() { 
		if( this._id == null ) {
			this._id = new ObjectId(); 
		}
	}

	public DBObject bsonFromPojo(){
		BasicDBObject document = new BasicDBObject();
		
		document.put( "_id",    this._id );
		document.put( "nom", this.nom );
		document.put( "tipus", this.tipus );
		document.put( "descripcio", this.descripcio );	
		document.put( "fabricant", this.fabricant );	
		document.put( "preu",  this.preu );
	
		return document;
	}

	public void makePojoFromBson( DBObject bson )	{
		BasicDBObject b = ( BasicDBObject ) bson;
	
		this._id = (ObjectId) b.get( "_id" );
		this.nom = (String) b.get("nom");
		this.tipus  = (String) b.get("tipus");
		this.descripcio = (String) b.get("descripcio");
		this.fabricant = (String) b.get("fabricant");
		//this.preu = (float) b.get("preu");

	}
	
}
