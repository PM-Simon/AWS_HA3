package de.tub.ise.anwsys.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.ise.anwsys.models.Measurements;

public interface MeasurementRepository extends JpaRepository<Measurements,Long> {
	
}
