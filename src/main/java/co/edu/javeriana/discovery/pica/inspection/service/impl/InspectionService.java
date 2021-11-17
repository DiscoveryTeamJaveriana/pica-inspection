package co.edu.javeriana.discovery.pica.inspection.service.impl;

import co.edu.javeriana.discovery.pica.inspection.controller.model.ReqPostInspeccion;
import co.edu.javeriana.discovery.pica.inspection.controller.model.RespGetInspeccion;
import co.edu.javeriana.discovery.pica.inspection.mapper.InspectionMapper;
import co.edu.javeriana.discovery.pica.inspection.repository.InspectionRepository;
import co.edu.javeriana.discovery.pica.inspection.repository.model.Inspection;
import co.edu.javeriana.discovery.pica.inspection.service.IInspectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InspectionService implements IInspectionService {

    private final InspectionRepository inspectionRepository;

    @Override
    public void postInspeccion(ReqPostInspeccion request, String rquid) {

        Inspection inspection = InspectionMapper.mapReqPostInspectionToInspection(request);
        inspectionRepository.save(inspection);

    }

    @Override
    public RespGetInspeccion getInspeccion(String codigo, String rquid) {

        return InspectionMapper
                .mapInspectionToResptGetInspection(inspectionRepository.findById(codigo)
                        .orElseThrow(() -> new RuntimeException("No Inspection")));
        //TODO: Add ControllerAdvice for exception control
    }
}
