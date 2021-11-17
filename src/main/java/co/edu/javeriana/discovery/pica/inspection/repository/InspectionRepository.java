package co.edu.javeriana.discovery.pica.inspection.repository;

import co.edu.javeriana.discovery.pica.inspection.repository.model.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<Inspection, String> {
}
