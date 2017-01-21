package com.tummsmedia.entities;

import javax.persistence.*;

/**
 * Created by john.tumminelli on 1/19/17.
 */
@Entity
@Table(name = "financial_performances")
public class FinancialPerformance {
    @Id
    @GeneratedValue
    int financialPerformanceId;
    @Column(nullable = false)
    public String schoolId;
    @Column
    public String _6a;
    @Column
    public String _6b;
    @Column
    public String _6c;
    @Column
    public String _7a;
    @Column
    public String _7b;

    public FinancialPerformance() {
    }

    public FinancialPerformance(String schoolId, String _6a, String _6b, String _6c, String _7a, String _7b) {
        this.schoolId = schoolId;
        this._6a = _6a;
        this._6b = _6b;
        this._6c = _6c;
        this._7a = _7a;
        this._7b = _7b;
    }

    public int getFinancialPerformanceId() {
        return financialPerformanceId;
    }

    public void setFinancialPerformanceId(int financialPerformanceId) {
        this.financialPerformanceId = financialPerformanceId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String get_6a() {
        return _6a;
    }

    public void set_6a(String _6a) {
        this._6a = _6a;
    }

    public String get_6b() {
        return _6b;
    }

    public void set_6b(String _6b) {
        this._6b = _6b;
    }

    public String get_6c() {
        return _6c;
    }

    public void set_6c(String _6c) {
        this._6c = _6c;
    }

    public String get_7a() {
        return _7a;
    }

    public void set_7a(String _7a) {
        this._7a = _7a;
    }

    public String get_7b() {
        return _7b;
    }

    public void set_7b(String _7b) {
        this._7b = _7b;
    }
}
