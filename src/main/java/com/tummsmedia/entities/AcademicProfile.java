package com.tummsmedia.entities;

import javax.persistence.*;

/**
 * Created by john.tumminelli on 1/19/17.
 */
@Entity
@Table(name = "academic_profiles")
public class AcademicProfile {
    @Id
    @GeneratedValue
    int academicProfileId;
    @Column
    public String schoolId;
    @Column
    public String scReadyElEng;
    @Column
    public String scReadyElMath;
    @Column
    public String scReadyMideng;
    @Column
    public String scReadyMidmath;
    @Column
    public String hsActAvgActEng;
    @Column
    public String hsActAvgActRead;
    @Column
    public String hsActAvgActSci;
    @Column
    public String hsActAvgActMath;
    @Column
    public String hsActAvgActComp;
    @Column
    public String hsKeyCertReading;
    @Column
    public String hsKeyCertLocating;
    @Column
    public String hsKeyCertMath;
    @Column
    public String hsKeyCertBronze;
    @Column
    public String gradFourYear;
    @Column
    public String gradFiveYear;
    @Column
    public String eocEng;
    @Column
    public String eocAlg;

    public AcademicProfile() {
    }

    public AcademicProfile(String schoolId, String scReadyElEng, String scReadyElMath, String scReadyMideng, String scReadyMidmath, String hsActAvgActEng, String hsActAvgActRead, String hsActAvgActSci, String hsActAvgActMath, String hsActAvgActComp, String hsKeyCertReading, String hsKeyCertLocating, String hsKeyCertMath, String hsKeyCertBronze, String gradFourYear, String gradFiveYear, String eocEng, String eocAlg) {
        this.schoolId = schoolId;
        this.scReadyElEng = scReadyElEng;
        this.scReadyElMath = scReadyElMath;
        this.scReadyMideng = scReadyMideng;
        this.scReadyMidmath = scReadyMidmath;
        this.hsActAvgActEng = hsActAvgActEng;
        this.hsActAvgActRead = hsActAvgActRead;
        this.hsActAvgActSci = hsActAvgActSci;
        this.hsActAvgActMath = hsActAvgActMath;
        this.hsActAvgActComp = hsActAvgActComp;
        this.hsKeyCertReading = hsKeyCertReading;
        this.hsKeyCertLocating = hsKeyCertLocating;
        this.hsKeyCertMath = hsKeyCertMath;
        this.hsKeyCertBronze = hsKeyCertBronze;
        this.gradFourYear = gradFourYear;
        this.gradFiveYear = gradFiveYear;
        this.eocEng = eocEng;
        this.eocAlg = eocAlg;
    }

    public int getAcademicProfileId() {
        return academicProfileId;
    }

    public void setAcademicProfileId(int academicProfileId) {
        this.academicProfileId = academicProfileId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getScReadyElEng() {
        return scReadyElEng;
    }

    public void setScReadyElEng(String scReadyElEng) {
        this.scReadyElEng = scReadyElEng;
    }

    public String getScReadyMideng() {
        return scReadyMideng;
    }

    public void setScReadyMideng(String scReadyMideng) {
        this.scReadyMideng = scReadyMideng;
    }

    public String getScReadyMidmath() {
        return scReadyMidmath;
    }

    public void setScReadyMidmath(String scReadyMidmath) {
        this.scReadyMidmath = scReadyMidmath;
    }

    public String getHsActAvgActEng() {
        return hsActAvgActEng;
    }

    public void setHsActAvgActEng(String hsActAvgActEng) {
        this.hsActAvgActEng = hsActAvgActEng;
    }

    public String getHsActAvgActRead() {
        return hsActAvgActRead;
    }

    public void setHsActAvgActRead(String hsActAvgActRead) {
        this.hsActAvgActRead = hsActAvgActRead;
    }

    public String getHsActAvgActSci() {
        return hsActAvgActSci;
    }

    public void setHsActAvgActSci(String hsActAvgActSci) {
        this.hsActAvgActSci = hsActAvgActSci;
    }

    public String getHsActAvgActMath() {
        return hsActAvgActMath;
    }

    public void setHsActAvgActMath(String hsActAvgActMath) {
        this.hsActAvgActMath = hsActAvgActMath;
    }

    public String getHsActAvgActComp() {
        return hsActAvgActComp;
    }

    public void setHsActAvgActComp(String hsActAvgActComp) {
        this.hsActAvgActComp = hsActAvgActComp;
    }

    public String getHsKeyCertReading() {
        return hsKeyCertReading;
    }

    public void setHsKeyCertReading(String hsKeyCertReading) {
        this.hsKeyCertReading = hsKeyCertReading;
    }

    public String getHsKeyCertLocating() {
        return hsKeyCertLocating;
    }

    public void setHsKeyCertLocating(String hsKeyCertLocating) {
        this.hsKeyCertLocating = hsKeyCertLocating;
    }

    public String getHsKeyCertMath() {
        return hsKeyCertMath;
    }

    public void setHsKeyCertMath(String hsKeyCertMath) {
        this.hsKeyCertMath = hsKeyCertMath;
    }

    public String getHsKeyCertBronze() {
        return hsKeyCertBronze;
    }

    public void setHsKeyCertBronze(String hsKeyCertBronze) {
        this.hsKeyCertBronze = hsKeyCertBronze;
    }

    public String getGradFourYear() {
        return gradFourYear;
    }

    public void setGradFourYear(String gradFourYear) {
        this.gradFourYear = gradFourYear;
    }

    public String getGradFiveYear() {
        return gradFiveYear;
    }

    public void setGradFiveYear(String gradFiveYear) {
        this.gradFiveYear = gradFiveYear;
    }

    public String getEocEng() {
        return eocEng;
    }

    public void setEocEng(String eocEng) {
        this.eocEng = eocEng;
    }

    public String getEocAlg() {
        return eocAlg;
    }

    public void setEocAlg(String eocAlg) {
        this.eocAlg = eocAlg;
    }

    public String getScReadyElMath() {
        return scReadyElMath;
    }

    public void setScReadyElMath(String scReadyElMath) {
        this.scReadyElMath = scReadyElMath;
    }
}
