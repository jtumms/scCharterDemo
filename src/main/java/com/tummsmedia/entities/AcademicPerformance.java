package com.tummsmedia.entities;

import javax.persistence.*;

/**
 * Created by john.tumminelli on 1/19/17.
 */
@Entity
@Table(name = "academic_performances")
public class AcademicPerformance {
    @Id
    @GeneratedValue
    int academicPerformanceId;
    @Column(name = "SCHOOL_ID", nullable = false)
    public String schoolId;
    @Column
    public String _1aElem;
    @Column
    public String _1aMid;
    @Column
    public String _1aHigh;
    @Column
    public String _1bElem;
    @Column
    public String _1bMid;
    @Column
    public String _1bHigh;
    @Column
    public String _2elem;
    @Column
    public String _2mid;
    @Column
    public String _2high;
    @Column
    public String _3elem;
    @Column
    public String _3mid;
    @Column
    public String _3high;
    @Column
    public String _4a;
    @Column
    public String _4b;
    @Column
    public String _4c;
    @Column
    public String _4d;
    @Column
    public String _5elem;
    @Column
    public String _5mid;
    @Column
    public String _5high;

    public AcademicPerformance() {
    }

    public AcademicPerformance(String schoolId, String _1aElem, String _1aMid, String _1aHigh, String _1bElem, String _1bMid, String _1bHigh, String _2elem, String _2mid, String _2high, String _3elem, String _3mid, String _3high, String _4a, String _4b, String _4c, String _4d, String _5elem, String _5mid, String _5high) {
        this.schoolId = schoolId;
        this._1aElem = _1aElem;
        this._1aMid = _1aMid;
        this._1aHigh = _1aHigh;
        this._1bElem = _1bElem;
        this._1bMid = _1bMid;
        this._1bHigh = _1bHigh;
        this._2elem = _2elem;
        this._2mid = _2mid;
        this._2high = _2high;
        this._3elem = _3elem;
        this._3mid = _3mid;
        this._3high = _3high;
        this._4a = _4a;
        this._4b = _4b;
        this._4c = _4c;
        this._4d = _4d;
        this._5elem = _5elem;
        this._5mid = _5mid;
        this._5high = _5high;
    }
}
