package utn.gallino.mspagos.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.gallino.mspagos.Service.PagosService;
import utn.gallino.mspagos.domain.Pago;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@Api(value = "Pagos-Rest", description = "Permite gestionar los pagos de la empresa")
public class PagosRest {


    @Autowired
    PagosService pagosService;



    @PostMapping
    @ApiOperation(value = "Genera un Pago")
    public ResponseEntity<String> generarPago(@RequestBody Pago pago)  {
        try{
            pagosService.crearPago(pago);                                                                                   // si quiero retorna la entidad al crearla ResponseEntity.ok(nuevo);
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        }catch (Exception e){return ResponseEntity.status(HttpStatus.CONFLICT).build();}
    }



    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un pago por id")
    public ResponseEntity<Pago> pagoPorId(@PathVariable Integer id){

        try{
            // si quiero retorna la entidad al crearla ResponseEntity.ok(nuevo);
            Pago ms= pagosService.buscarPagoPorId(id);
            return ResponseEntity.ok(ms);
        }catch (Exception e){return ResponseEntity.status(HttpStatus.CONFLICT).build();}


    }

    @GetMapping(path = "/")
    @ApiOperation(value = "Busca todos los Pago ")
    public ResponseEntity<List<Pago>> listarPagos(){
        try{
            return ResponseEntity.ok(pagosService.listarPagos());
        }catch (Exception e){return ResponseEntity.status(HttpStatus.CONFLICT).build();}


    }




    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualiza un pago")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Actualizado correctamente"),
            @ApiResponse(code = 401, message = "No autorizado"),
            @ApiResponse(code = 403, message = "Prohibido"),
            @ApiResponse(code = 404, message = "El ID no existe")})
    public ResponseEntity<Pago> actualizar(@RequestBody Pago PagoNuevo,  @PathVariable Integer id) {
        try {
            Pago ms= pagosService.actualizarPago(PagoNuevo, id);
            return ResponseEntity.ok(ms);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }



    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Elimina un Pago x id")
    public ResponseEntity<String> borrar(@PathVariable Integer id)  {


        try {
            pagosService.bajaPago(id);
            String respuesta = "ok "+id;
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(respuesta );

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


                                                        //EXTRA API
//***************************************************----------------------------------********************************************************************

//. Retorna el estado de cuenta corriente de un cliente con un detalle de
//                  i. Pagos
//                  ii. Facturas (pedidos enviados) probanod un push desde vscode


    @GetMapping(path = "/pagos/{id_cliente}")
    @ApiOperation(value = "Busca todos los Pago ")
    public ResponseEntity<List<Pago>> listarPagosDeCliente(@PathVariable  Integer id_cliente){
        try{
            return ResponseEntity.ok(pagosService.listarPagosDeClientePorId(id_cliente));
        }catch (Exception e){return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}


    }

    @GetMapping(path = "/calcular-pagos/{id_cliente}")
    @ApiOperation(value = "Calcula la suma de todos los pagos realizados por un cliente ")
    public ResponseEntity<Double> calcularPagosDeCliente(@PathVariable  Integer id_cliente){
        try{
            return ResponseEntity.ok(pagosService.calcularPagosDeClientePorId(id_cliente));
        }catch (Exception e){return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}


    }











}
