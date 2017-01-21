package com.tummsmedia.entities;

import java.util.ArrayList;

/**
 * Created by john.tumminelli on 1/19/17.
 */
public class OrgPerformanceWrapper {
    public ArrayList<OrgPerformance> orgPerformances;

    public OrgPerformanceWrapper() {
    }

    public OrgPerformanceWrapper(ArrayList<OrgPerformance> orgPerformances) {
        this.orgPerformances = orgPerformances;
    }

    public ArrayList<OrgPerformance> getOrgPerformances() {
        return orgPerformances;
    }

    public void setOrgPerformances(ArrayList<OrgPerformance> orgPerformances) {
        this.orgPerformances = orgPerformances;
    }
}
