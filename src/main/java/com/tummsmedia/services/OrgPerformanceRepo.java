package com.tummsmedia.services;

import com.tummsmedia.entities.OrgPerformance;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by john.tumminelli on 1/19/17.
 */
public interface OrgPerformanceRepo extends CrudRepository<OrgPerformance,Integer> {
    OrgPerformance findBySchoolId(String schoolId);
}
