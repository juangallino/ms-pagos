package utn.gallino.mspagos.domain;


import javax.persistence.*;

@Entity
@Table(name = "PGS_MEDIO_PAGO", schema = "MS-PGS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public abstract class MedioPago {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@Column
	protected String observacion;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
}
