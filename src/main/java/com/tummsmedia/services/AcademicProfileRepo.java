package com.tummsmedia.services;

import com.tummsmedia.entities.AcademicProfile;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by john.tumminelli on 1/19/17.
 */
public interface AcademicProfileRepo extends CrudRepository<AcademicProfile, Integer> {
    AcademicProfile findBySchoolId(String schoolId);
}
