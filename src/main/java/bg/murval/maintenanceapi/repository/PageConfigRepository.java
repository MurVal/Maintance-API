package bg.murval.maintenanceapi.repository;

import bg.murval.maintenanceapi.models.PageConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Murad Hamza on 25.3.2021 г.
 */
@Repository
public interface PageConfigRepository extends JpaRepository<PageConfig, Long> {
}
