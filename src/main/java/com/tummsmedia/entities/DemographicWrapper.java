package com.tummsmedia.entities;

import java.util.ArrayList;

/**
 * Created by john.tumminelli on 1/19/17.
 */
public class DemographicWrapper {
    public ArrayList<DemographicProfile> demographics;

    public DemographicWrapper() {
    }

    public DemographicWrapper(ArrayList<DemographicProfile> demographics) {
        this.demographics = demographics;
    }

    public ArrayList<DemographicProfile> getDemographics() {
        return demographics;
    }

    public void setDemographics(ArrayList<DemographicProfile> demographics) {
        this.demographics = demographics;
    }
}
