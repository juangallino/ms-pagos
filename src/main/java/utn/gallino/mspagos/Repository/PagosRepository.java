package utn.gallino.mspagos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.gallino.mspagos.domain.Pago;

import java.util.List;

@Repository
public interface PagosRepository extends JpaRepository<Pago, Integer> {


    public List<Pago> findPagosByCliente_Id (Integer id);

}
