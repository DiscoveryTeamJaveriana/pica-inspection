package co.edu.javeriana.discovery.pica.inspection.service.impl;

import co.edu.javeriana.discovery.pica.inspection.controller.model.ReqPostInspeccion;
import co.edu.javeriana.discovery.pica.inspection.controller.model.RespGetInspeccion;
import co.edu.javeriana.discovery.pica.inspection.service.IInspectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InspectionService implements IInspectionService {

    @Override
    public void postInspeccion(ReqPostInspeccion request, String rquid) {
        log.info("Panic implement me !");

    }

    @Override
    public RespGetInspeccion getInspecion(String codigo, String rquid) {
        log.info("Panic implement me !");
        RespGetInspeccion respGetInspeccion = new RespGetInspeccion();
        respGetInspeccion.setCodigo("123");
        respGetInspeccion.setCodigoSupervisor("123");
        respGetInspeccion.setCodigoLocacion("1234");
        respGetInspeccion.setCodigoEmpleado("1234");
        respGetInspeccion.setTipo("Tipo");
        respGetInspeccion.setFecha("11/11/21");
        respGetInspeccion.setTitulo("Titulo");
        respGetInspeccion.setDescripcion("Descripcion");
        respGetInspeccion.setAprobado(true);
        respGetInspeccion.setNovedad(true);
        respGetInspeccion.setDescripcionNovedad("Novedad");
        respGetInspeccion.setAccionMejora(true);
        respGetInspeccion.setDescripcionAccionMejora("Descripcion");
        respGetInspeccion.setComentario("Comentario");
        return respGetInspeccion;
    }
}
