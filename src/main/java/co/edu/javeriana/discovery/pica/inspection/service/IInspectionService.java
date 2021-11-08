package co.edu.javeriana.discovery.pica.inspection.service;

import co.edu.javeriana.discovery.pica.inspection.controller.model.ReqPostInspeccion;
import co.edu.javeriana.discovery.pica.inspection.controller.model.RespGetInspeccion;

public interface IInspectionService {
   void  postInspeccion (ReqPostInspeccion request, String rquid);
    RespGetInspeccion getInspecion (String codigo, String rquid);
}