package utn.gallino.mspagos.domain;

import javax.persistence.*;



@Entity
@Table(name = "PGS_EFECTIVO", schema = "MS-PGS")
@DiscriminatorValue("E")
public class Efectivo extends MedioPago {

	@Column
	private Integer nroRecibo;



	public Integer getNroRecibo() {
		return nroRecibo;
	}

	public void setNroRecibo(Integer nroRecibo) {
		this.nroRecibo = nroRecibo;
	}
}
