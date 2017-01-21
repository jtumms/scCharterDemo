package com.tummsmedia.entities;

import javax.persistence.*;

/**
 * Created by john.tumminelli on 1/19/17.
 */
@Entity
@Table(name = "organizational_performances")
public class OrgPerformance {
    @Id
    @GeneratedValue
    int orgPerformanceId;
    @Column(nullable = false)
    public String schoolId;
    @Column
    public String _8a;
    @Column
    public String _8b;
    @Column
    public String _9a;
    @Column
    public String _9b;
    @Column
    public String _10a;
    @Column
    public String _10b;
    @Column
    public String _11a;

    public OrgPerformance() {
    }

    public OrgPerformance(String schoolId, String _8a, String _8b, String _9a, String _9b, String _10a, String _10b, String _11a) {
        this.schoolId = schoolId;
        this._8a = _8a;
        this._8b = _8b;
        this._9a = _9a;
        this._9b = _9b;
        this._10a = _10a;
        this._10b = _10b;
        this._11a = _11a;
    }

    public int getOrgPerformanceId() {
        return orgPerformanceId;
    }

    public void setOrgPerformanceId(int orgPerformanceId) {
        this.orgPerformanceId = orgPerformanceId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String get_8a() {
        return _8a;
    }

    public void set_8a(String _8a) {
        this._8a = _8a;
    }

    public String get_8b() {
        return _8b;
    }

    public void set_8b(String _8b) {
        this._8b = _8b;
    }

    public String get_9a() {
        return _9a;
    }

    public void set_9a(String _9a) {
        this._9a = _9a;
    }

    public String get_9b() {
        return _9b;
    }

    public void set_9b(String _9b) {
        this._9b = _9b;
    }

    public String get_10a() {
        return _10a;
    }

    public void set_10a(String _10a) {
        this._10a = _10a;
    }

    public String get_10b() {
        return _10b;
    }

    public void set_10b(String _10b) {
        this._10b = _10b;
    }

    public String get_11a() {
        return _11a;
    }

    public void set_11a(String _11a) {
        this._11a = _11a;
    }
}
