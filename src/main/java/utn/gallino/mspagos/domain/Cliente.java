package utn.gallino.mspagos.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "USR_CLIENTE", schema = "MS-USR")
public class Cliente {

	@Id
    private Integer id;
	@Column
    private String razonSocial;
	@Column
	private String cuit;
	@Column
	private String mail;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

    
}
