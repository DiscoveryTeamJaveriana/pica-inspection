package co.edu.javeriana.discovery.pica.inspection.controller;

import co.edu.javeriana.discovery.pica.inspection.controller.model.ReqPostInspeccion;
import co.edu.javeriana.discovery.pica.inspection.controller.model.RespGetInspeccion;
import co.edu.javeriana.discovery.pica.inspection.service.IInspectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/c3p/v1/Portal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InspectionController {

    private static final String RQUID = "X-RqUID";
    private static final String CODIGO = "Codigo";

    private IInspectionService inspectionService;

    @Autowired
    public InspectionController(IInspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }


    @PostMapping("/Inspeccion")
        public ResponseEntity<Void> postInspeccion(@RequestBody ReqPostInspeccion reqPostInspeccion, @RequestHeader(value=RQUID) String xRqUID ) {
        log.info("Creating Inspection for RqUID {}", xRqUID);
        inspectionService.postInspeccion(reqPostInspeccion, xRqUID);
        return new ResponseEntity<>(putRqUIDHeader(xRqUID),HttpStatus.CREATED);
    }

    @GetMapping("/Inspeccion/{Codigo}")
    public ResponseEntity<RespGetInspeccion> getInspecion(@RequestHeader(value=RQUID) String xRqUID, @PathVariable(CODIGO) String codigo) {
        log.info("Get Employee for RqUID {}", xRqUID);
        RespGetInspeccion response = inspectionService.getInspecion(codigo, xRqUID);
        return new ResponseEntity<>(response,putRqUIDHeader(xRqUID),HttpStatus.OK);
    }

    private HttpHeaders putRqUIDHeader(String rquid) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(RQUID,rquid);
        return headers;
    }
}
