package utn.gallino.mspagos.Service;

import jdk.dynalink.linker.LinkerServices;
import utn.gallino.mspagos.domain.Pago;

import java.util.List;

public interface PagosService {
    void crearPago(Pago pago) throws Exception;

    void bajaPago(Integer id) throws Exception;

    Pago actualizarPago(Pago pagoNuevo, Integer id) throws Exception;

    List<Pago> listarPagos();

    Pago buscarPagoPorId(Integer id) throws Exception;

    public Double calcularPagosDeClientePorId(Integer id_cliente);
    public List<Pago> listarPagosDeClientePorId(Integer id_cliente);
}
