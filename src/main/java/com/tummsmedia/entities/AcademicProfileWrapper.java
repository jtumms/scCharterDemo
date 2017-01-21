package com.tummsmedia.entities;

import java.util.ArrayList;

/**
 * Created by john.tumminelli on 1/19/17.
 */
public class AcademicProfileWrapper {
    public ArrayList<AcademicProfile> academicProfiles;

    public AcademicProfileWrapper() {
    }

    public AcademicProfileWrapper(ArrayList<AcademicProfile> academicProfiles) {
        this.academicProfiles = academicProfiles;
    }

    public ArrayList<AcademicProfile> getAcademicProfiles() {
        return academicProfiles;
    }

    public void setAcademicProfiles(ArrayList<AcademicProfile> academicProfiles) {
        this.academicProfiles = academicProfiles;
    }
}
