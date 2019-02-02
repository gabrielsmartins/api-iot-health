package br.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.api.entity.MeasurementEntity;
import br.edu.api.entity.MeasurementEntityId;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, MeasurementEntityId> {

}
