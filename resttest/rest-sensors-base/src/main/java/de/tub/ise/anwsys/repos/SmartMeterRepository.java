
package de.tub.ise.anwsys.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import de.tub.ise.anwsys.models.SmartMeter;

public interface SmartMeterRepository extends JpaRepository<SmartMeter, String> {

	List<SmartMeter> findByName(String smId);

	List<SmartMeter> findAll();
}
