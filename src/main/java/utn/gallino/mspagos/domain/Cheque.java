package utn.gallino.mspagos.domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "PGS_CHEQUE", schema = "MS-PGS")
@DiscriminatorValue("C")
public class Cheque extends MedioPago {


	private Integer nroCheque;
	@Column(columnDefinition = "TIMESTAMP")
	private Instant fechaCobro;
	@Column
	private String banco;
	
	public Integer getNroCheque() {
		return nroCheque;
	}
	public void setNroCheque(Integer nroCheque) {
		this.nroCheque = nroCheque;
	}
	public Instant getFechaCobro() {
		return fechaCobro;
	}
	public void setFechaCobro(Instant fechaCobro) {
		this.fechaCobro = fechaCobro;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	
}
