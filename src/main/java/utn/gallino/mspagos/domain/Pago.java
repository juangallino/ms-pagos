package utn.gallino.mspagos.domain;

import javax.persistence.*;
import java.time.Instant;




@Entity
@Table(name = "PGS_PAGO", schema = "MS-PGS")
public class Pago {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;

	@Column(columnDefinition = "TIMESTAMP")
	private Instant fechaPago;

	@Column
	Double montoPagado;

	@OneToOne
	@JoinColumn(name = "ID_MEDIO_PAGO")
	private MedioPago medioPago;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Instant getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Instant fechaPago) {
		this.fechaPago = fechaPago;
	}
	public MedioPago getMedio() {
		return medioPago;
	}
	public void setMedio(MedioPago medio) {
		this.medioPago = medio;
	}

	public Double getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(Double montoPagado) {
		this.montoPagado = montoPagado;
	}
}
