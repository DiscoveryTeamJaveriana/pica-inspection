package co.edu.javeriana.discovery.pica.inspection.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import co.edu.javeriana.discovery.pica.inspection.controller.model.ReqPostInspeccion;
import co.edu.javeriana.discovery.pica.inspection.controller.model.RespGetInspeccion;
import co.edu.javeriana.discovery.pica.inspection.repository.model.Inspection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InspectionMapper {

    public static RespGetInspeccion mapInspectionToResptGetInspection(final Inspection inspection) {
        RespGetInspeccion respGetInspeccion = new RespGetInspeccion();
        respGetInspeccion.setCodigo(inspection.getId());
        respGetInspeccion.setCodigoSupervisor(inspection.getSupervisorId());
        respGetInspeccion.setCodigoLocacion(inspection.getLocationId());
        respGetInspeccion.setCodigoEmpleado(inspection.getEmployeeId());
        respGetInspeccion.setTipo(inspection.getType());
        respGetInspeccion.setFecha(inspection.getDate().toString());
        respGetInspeccion.setTitulo(inspection.getTitle());
        respGetInspeccion.setDescripcion(inspection.getDescription());
        respGetInspeccion.setAprobado(inspection.getApproved());
        respGetInspeccion.setNovedad(inspection.getNovelty());
        respGetInspeccion.setDescripcionNovedad(inspection.getNoveltyDescription());
        respGetInspeccion.setAccionMejora(inspection.getImprovementAction());
        respGetInspeccion.setDescripcionAccionMejora(inspection.getImprovementActionDescription());
        respGetInspeccion.setComentario(inspection.getComment());

        return respGetInspeccion;
    }

    public static Inspection mapReqPostInspectionToInspection(final ReqPostInspeccion reqPostInspeccion) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        return Inspection.builder()
                .supervisorId(reqPostInspeccion.getCodigoSupervisor())
                .locationId(reqPostInspeccion.getCodigoLocacion())
                .employeeId(reqPostInspeccion.getCodigoEmpleado())
                .type(reqPostInspeccion.getTipo())
                .date(LocalDateTime.parse(reqPostInspeccion.getFecha(),formatter))
                .title(reqPostInspeccion.getTitulo())
                .description(reqPostInspeccion.getDescripcion())
                .approved(reqPostInspeccion.getAprobado())
                .novelty(reqPostInspeccion.getNovedad())
                .noveltyDescription(reqPostInspeccion.getDescripcionNovedad())
                .improvementAction(reqPostInspeccion.getAccionMejora())
                .improvementActionDescription(reqPostInspeccion.getDescripcionAccionMejora())
                .comment(reqPostInspeccion.getComentario())
                .build();
    }
}
