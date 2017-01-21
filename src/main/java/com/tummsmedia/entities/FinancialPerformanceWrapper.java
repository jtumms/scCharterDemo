package com.tummsmedia.entities;

import java.util.ArrayList;

/**
 * Created by john.tumminelli on 1/19/17.
 */
public class FinancialPerformanceWrapper {
    public ArrayList<FinancialPerformance> financialPerformances;

    public FinancialPerformanceWrapper() {
    }

    public FinancialPerformanceWrapper(ArrayList<FinancialPerformance> financialPerformances) {
        this.financialPerformances = financialPerformances;
    }

    public ArrayList<FinancialPerformance> getFinancialPerformances() {
        return financialPerformances;
    }

    public void setFinancialPerformances(ArrayList<FinancialPerformance> financialPerformances) {
        this.financialPerformances = financialPerformances;
    }
}
