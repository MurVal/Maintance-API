package bg.murval.maintenanceapi.repository;

import bg.murval.maintenanceapi.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Murad Hamza on 25.3.2021 г.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
