package ima.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="adresse")
public class AdresseDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_ad;
	private String ville;
	private String pays;
	private String code_postal;
	
	
	
	
	
	
	public Long getId_ad() {
		return id_ad;
	}
	public void setId_ad(Long id_ad) {
		this.id_ad = id_ad;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	
	
	

}
