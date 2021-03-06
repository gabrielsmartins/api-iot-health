package br.edu.api.iot.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import br.edu.api.iot.entity.MeasurementEntity;
import br.edu.api.iot.entity.PatientEntity;
import br.edu.api.iot.enumeration.MeasurementTypeEnum;
import br.edu.api.iot.repository.custom.MeasurementRepositoryCustom;

public class MeasurementRepositoryImpl implements MeasurementRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<MeasurementEntity> findByPatientId(Long patientId) {
		TypedQuery<MeasurementEntity> query = entityManager.createQuery("SELECT m FROM MeasurementEntity m " +
	                             "JOIN FETCH m.measurementEntityId.patient p " +
				                  "WHERE p.id = :pPatientId",MeasurementEntity.class )
		 .setParameter("pPatientId", patientId);
		
		List<MeasurementEntity> measurements = query.getResultList();
		return measurements;
		
		/*EntityType<MeasurementEntity> measurementEntity_ = entityManager.getMetamodel().entity(MeasurementEntity.class);
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MeasurementEntity> criteriaQuery = criteriaBuilder.createQuery(MeasurementEntity.class);
		Root<MeasurementEntity> root = criteriaQuery.from(MeasurementEntity.class);
		Join<MeasurementEntity, PatientEntity> join = root
				.join(measurementEntity_.getSingularAttribute("measurementEntityId.patient", PatientEntity.class));
		criteriaQuery.select(root)
		             .where(criteriaBuilder.equal(join.get("id"),patientId));
		List<MeasurementEntity> measurements = entityManager.createQuery(criteriaQuery).getResultList();
		return measurements;*/
	}

	@Override
	public List<MeasurementEntity> findByPatientIdAndMeasurementType(Long patientId,
			MeasurementTypeEnum measurementType) {
		EntityType<MeasurementEntity> MeasurementEntity_ = entityManager.getMetamodel().entity(MeasurementEntity.class);
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MeasurementEntity> criteriaQuery = criteriaBuilder.createQuery(MeasurementEntity.class);
		Root<MeasurementEntity> root = criteriaQuery.from(MeasurementEntity.class);
		Join<MeasurementEntity, PatientEntity> join = root
				.join(MeasurementEntity_.getSingularAttribute("measurementEntityId.patient", PatientEntity.class));
		criteriaQuery.where(criteriaBuilder.equal(join.get("id"),patientId));
		criteriaQuery.select(root)
        .where(criteriaBuilder.equal(join.get("id"),patientId));
		criteriaBuilder.and(criteriaBuilder.equal(root.get("measurementType"),measurementType));
		List<MeasurementEntity> measurements = entityManager.createQuery(criteriaQuery).getResultList();
		return measurements;
	}

}
