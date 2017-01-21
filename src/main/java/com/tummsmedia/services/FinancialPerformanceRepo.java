package com.tummsmedia.services;

import com.tummsmedia.entities.FinancialPerformance;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by john.tumminelli on 1/19/17.
 */
public interface FinancialPerformanceRepo extends CrudRepository<FinancialPerformance, Integer> {
    FinancialPerformance findBySchoolId(String schoolId);
}
