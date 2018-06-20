package MongoDB;

import java.util.ArrayList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

public class Empresa {
	private String nom;
	private String camp;
	private String descripcio;
	private Integer edat;
	private ArrayList<Producte> productes;
	private Boolean internacional;

	public Empresa() {
	}

	public Empresa(String nom, String camp, String descripcio, Integer edad, ArrayList<Producte> productes,
			Boolean internacional) {
		super();
		this.nom = nom;
		this.camp = camp;
		this.descripcio = descripcio;
		this.edat = edad;
		this.productes = productes;
		this.internacional = internacional;
	}

	// Transformem un objecte de  MongoDB a un Objecte Java
	public Empresa(BasicDBObject dBObjectEmpresa) {
		this.nom = dBObjectEmpresa.getString("nom");
		this.camp = dBObjectEmpresa.getString("camp");
		this.descripcio = dBObjectEmpresa.getString("descripcio");
		this.edat = dBObjectEmpresa.getInt("edat");
		
		// Treballar amb Arrays o Listas
		BasicDBList listProductes = (BasicDBList) dBObjectEmpresa.get("productes");
		this.productes = new ArrayList<Producte>();	
		for (Object producte : listProductes) {
			this.productes.add((Producte) producte);
		}
		
		this.internacional = dBObjectEmpresa.getBoolean("internacional");
	}

	public BasicDBObject toDBObjectEmpresa() {
		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectEmpresa = new BasicDBObject();
		
		dBObjectEmpresa.append("nom", this.getNom());
		dBObjectEmpresa.append("camp", this.getCamp());
		dBObjectEmpresa.append("descripcio", this.getDescripcio());
		dBObjectEmpresa.append("edat", this.getEdat());
		dBObjectEmpresa.append("productes", this.getProductes());
		dBObjectEmpresa.append("internacional", this.getInternacional());
		
		return dBObjectEmpresa;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public Integer getEdat() {
		return edat;
	}

	public void setEdat(Integer edad) {
		this.edat = edad;
	}

	public ArrayList<Producte> getProductes() {
		return productes;
	}

	public void setProductes(ArrayList<Producte> productes) {
		this.productes = productes;
	}

	public Boolean getInternacional() {
		return internacional;
	}

	public void setInternacional(Boolean internacional) {
		this.internacional = internacional;
	}
	
}
