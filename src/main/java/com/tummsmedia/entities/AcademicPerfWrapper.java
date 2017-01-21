package com.tummsmedia.entities;

import java.util.ArrayList;

/**
 * Created by john.tumminelli on 1/19/17.
 */
public class AcademicPerfWrapper {
    public ArrayList<AcademicPerformance> academicPerformances;

    public AcademicPerfWrapper() {
    }

    public AcademicPerfWrapper(ArrayList<AcademicPerformance> academicPerformances) {
        this.academicPerformances = academicPerformances;
    }

    public ArrayList<AcademicPerformance> getAcademicPerformances() {
        return academicPerformances;
    }

    public void setAcademicPerformances(ArrayList<AcademicPerformance> academicPerformances) {
        this.academicPerformances = academicPerformances;
    }
}
