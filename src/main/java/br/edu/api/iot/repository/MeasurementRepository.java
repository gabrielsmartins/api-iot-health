package br.edu.api.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.entity.MeasurementEntityId;
import br.edu.api.iot.repository.custom.MeasurementRepositoryCustom;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, MeasurementEntityId>, MeasurementRepositoryCustom {

}
