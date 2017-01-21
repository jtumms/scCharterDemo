package com.tummsmedia.services;

import com.tummsmedia.entities.AcademicPerformance;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by john.tumminelli on 1/19/17.
 */
public interface AcademicPerfRepo extends CrudRepository<AcademicPerformance, Integer> {
    AcademicPerformance findBySchoolId(String schoolId);
}
