package utn.gallino.mspagos.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.gallino.mspagos.Repository.PagosRepository;
import utn.gallino.mspagos.Service.PagosService;
import utn.gallino.mspagos.domain.Pago;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagosServiceImpl implements PagosService {


    @Autowired
    PagosRepository pagosRepository;


    @Override
    public void crearPago(Pago pago) throws Exception {

           guardarPago(pago);

    }

    @Override
    public void bajaPago(Integer id) throws Exception {
        try {
            pagosRepository.deleteById(id);
        }catch (Exception e ){throw new Exception("not found");}

    }

    @Override
    public Pago actualizarPago(Pago pagoNuevo, Integer id) throws Exception {
        pagoNuevo.setId(id);
        guardarPago(pagoNuevo);
        return pagoNuevo;
    }

    @Override
    public List<Pago> listarPagos() {
       List<Pago> result = new ArrayList<>();
        pagosRepository.findAll().forEach(pago -> result.add(pago));
        return result;
    }

    @Override
    public Pago buscarPagoPorId(Integer id) throws Exception {
        try {
            return pagosRepository.findById(id).get();
        }catch (Exception e ){throw new Exception("not found");}

    }

    public void guardarPago(Pago p) throws Exception {

        try {
            pagosRepository.save(p);
        }catch (Exception e ){throw new Exception("not found");}

    }


    @Override
    public Double calcularPagosDeClientePorId(Integer id_cliente){

       return pagosRepository.findPagosByCliente_Id(id_cliente).stream().mapToDouble(p->p.getMontoPagado()).sum();

    }

    @Override
    public List<Pago> listarPagosDeClientePorId(Integer id_cliente){

        return pagosRepository.findPagosByCliente_Id(id_cliente);

    }
}
