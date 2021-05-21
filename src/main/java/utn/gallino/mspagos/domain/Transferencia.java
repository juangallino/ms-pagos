package utn.gallino.mspagos.domain;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PGS_TRANSFERENCIA", schema = "MS-PGS")
@DiscriminatorValue("T")
public class Transferencia extends MedioPago {

	@Column
	private String cbuOrigen;
	@Column
	private String cbuDestino;
	@Column
	private Long codigoTransferencia;
	
	public Long getCodigoTransferencia() {
		return codigoTransferencia;
	}
	public void setCodigoTransferencia(Long codigoTransferencia) {
		this.codigoTransferencia = codigoTransferencia;
	}
	public String getCbuOrigen() {
		return cbuOrigen;
	}
	public void setCbuOrigen(String cbuOrigen) {
		this.cbuOrigen = cbuOrigen;
	}
	public String getCbuDestino() {
		return cbuDestino;
	}
	public void setCbuDestino(String cbuDestino) {
		this.cbuDestino = cbuDestino;
	}
	
	
}
