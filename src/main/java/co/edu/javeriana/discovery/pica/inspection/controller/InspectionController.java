package co.edu.javeriana.discovery.pica.inspection.controller;

import co.edu.javeriana.discovery.pica.inspection.controller.model.ReqPostInspeccion;
import co.edu.javeriana.discovery.pica.inspection.controller.model.RespGetInspeccion;
import co.edu.javeriana.discovery.pica.inspection.service.IInspectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/c3p/v1/Portal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InspectionController {

    private static final String XRQUID = "X-RqUID";
    private static final String CODIGO = "Codigo";
    private static final String REQUEST = "Request";
    private static final String RESPONSE = "Response";
    private static final String RESPONSECODE = "ResponseCode";
    private static final String RQUID = "RqUID";

    private IInspectionService inspectionService;

    @Autowired
    private Tracer tracer;

    @Autowired
    public InspectionController(IInspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }


    @PostMapping("/Inspeccion")
        public ResponseEntity<Void> postInspeccion(@RequestBody ReqPostInspeccion reqPostInspeccion, @RequestHeader(value=XRQUID) String xRqUID ) throws JsonProcessingException {
        log.info("Creating Inspection for RqUID {}", xRqUID);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(reqPostInspeccion);
        InspectionController.this.tracer.currentSpan().tag(REQUEST,json);
        InspectionController.this.tracer.currentSpan().tag(RQUID,xRqUID);
        inspectionService.postInspeccion(reqPostInspeccion, xRqUID);
        InspectionController.this.tracer.currentSpan().tag(RESPONSECODE,HttpStatus.CREATED.toString());
        return new ResponseEntity<>(putRqUIDHeader(xRqUID),HttpStatus.CREATED);
    }

    @GetMapping("/Inspeccion/{Codigo}")
    public ResponseEntity<RespGetInspeccion> getInspecion(@RequestHeader(value=XRQUID) String xRqUID, @PathVariable(CODIGO) String codigo) throws JsonProcessingException {
        log.info("Get Employee for RqUID {}", xRqUID);
        InspectionController.this.tracer.currentSpan().tag(RQUID,xRqUID);
        RespGetInspeccion response = inspectionService.getInspecion(codigo, xRqUID);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(response);
        InspectionController.this.tracer.currentSpan().tag(RESPONSE,json);
        InspectionController.this.tracer.currentSpan().tag(RESPONSECODE,HttpStatus.OK.toString());
        return new ResponseEntity<>(response,putRqUIDHeader(xRqUID),HttpStatus.OK);
    }

    private HttpHeaders putRqUIDHeader(String rquid) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(RQUID,rquid);
        return headers;
    }
}
