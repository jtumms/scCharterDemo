package com.tummsmedia.entities;


import javax.persistence.*;

/**
 * Created by john.tumminelli on 1/18/17.
 */

@Entity
@Table(name = "demographics")
public class DemographicProfile {
    @Id
    @GeneratedValue
    int id;

    @Column
    String schoolName;
    @Column
    String schoolId;
    @Column
    String location;
    @Column
    int yearOpened;
    @Column
    int charterRenewalYear;
    @Column
    String grades;
    @Column
    int enrollment;
    @Column
    double percentPoverty;
    @Column
    double percentDisability;
    @Column
    double percentEngLangLearner;
    @Column
    double percentAfrAmerican;
    @Column
    double percentAmerIndian;
    @Column
    double percentAsiaPacIslander;
    @Column
    double percentHispanic;
    @Column
    double percentWhite;
    @Column
    double percentMultiRacial;
    @Column(length = 600)
    String schoolMission;

    public DemographicProfile() {
    }

    public DemographicProfile(String schoolName, String schoolId, String location, int yearOpened, int charterRenewalYear, String grades, int enrollment, long percentPoverty, long percentDisability, long percentEngLangLearner, long percentAfrAmerican, long percentAmerIndian, long percentAsiaPacIslander, long percentHispanic, long percentWhite, long percentMultiRacial, String schoolMission, AcademicPerformance academicPerformance) {
        this.schoolName = schoolName;
        this.schoolId = schoolId;
        this.location = location;
        this.yearOpened = yearOpened;
        this.charterRenewalYear = charterRenewalYear;
        this.grades = grades;
        this.enrollment = enrollment;
        this.percentPoverty = percentPoverty;
        this.percentDisability = percentDisability;
        this.percentEngLangLearner = percentEngLangLearner;
        this.percentAfrAmerican = percentAfrAmerican;
        this.percentAmerIndian = percentAmerIndian;
        this.percentAsiaPacIslander = percentAsiaPacIslander;
        this.percentHispanic = percentHispanic;
        this.percentWhite = percentWhite;
        this.percentMultiRacial = percentMultiRacial;
        this.schoolMission = schoolMission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYearOpened() {
        return yearOpened;
    }

    public void setYearOpened(int yearOpened) {
        this.yearOpened = yearOpened;
    }

    public int getCharterRenewalYear() {
        return charterRenewalYear;
    }

    public void setCharterRenewalYear(int charterRenewalYear) {
        this.charterRenewalYear = charterRenewalYear;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public double getPercentPoverty() {
        return percentPoverty;
    }

    public void setPercentPoverty(double percentPoverty) {
        this.percentPoverty = percentPoverty;
    }

    public double getPercentDisability() {
        return percentDisability;
    }

    public void setPercentDisability(double percentDisability) {
        this.percentDisability = percentDisability;
    }

    public double getPercentEngLangLearner() {
        return percentEngLangLearner;
    }

    public void setPercentEngLangLearner(double percentEngLangLearner) {
        this.percentEngLangLearner = percentEngLangLearner;
    }

    public double getPercentAfrAmerican() {
        return percentAfrAmerican;
    }

    public void setPercentAfrAmerican(double percentAfrAmerican) {
        this.percentAfrAmerican = percentAfrAmerican;
    }

    public double getPercentAmerIndian() {
        return percentAmerIndian;
    }

    public void setPercentAmerIndian(double percentAmerIndian) {
        this.percentAmerIndian = percentAmerIndian;
    }

    public double getPercentAsiaPacIslander() {
        return percentAsiaPacIslander;
    }

    public void setPercentAsiaPacIslander(double percentAsiaPacIslander) {
        this.percentAsiaPacIslander = percentAsiaPacIslander;
    }

    public double getPercentHispanic() {
        return percentHispanic;
    }

    public void setPercentHispanic(double percentHispanic) {
        this.percentHispanic = percentHispanic;
    }

    public double getPercentWhite() {
        return percentWhite;
    }

    public void setPercentWhite(double percentWhite) {
        this.percentWhite = percentWhite;
    }

    public double getPercentMultiRacial() {
        return percentMultiRacial;
    }

    public void setPercentMultiRacial(double percentMultiRacial) {
        this.percentMultiRacial = percentMultiRacial;
    }

    public String getSchoolMission() {
        return schoolMission;
    }

    public void setSchoolMission(String schoolMission) {
        this.schoolMission = schoolMission;
    }

}
