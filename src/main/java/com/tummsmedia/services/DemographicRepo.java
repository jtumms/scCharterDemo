package com.tummsmedia.services;

import com.tummsmedia.entities.DemographicProfile;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by john.tumminelli on 1/18/17.
 */
public interface DemographicRepo extends CrudRepository<DemographicProfile, Integer> {
    DemographicProfile findBySchoolId(String schoolId);

}
