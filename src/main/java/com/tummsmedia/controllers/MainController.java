package com.tummsmedia.controllers;

import com.tummsmedia.entities.*;
import com.tummsmedia.services.*;
import jodd.json.JsonParser;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by john.tumminelli on 1/18/17.
 */
@RestController
public class MainController {
    @Autowired
    DemographicRepo demographics;
    @Autowired
    AcademicPerfRepo academicPerformances;
    @Autowired
    AcademicProfileRepo academicProfiles;
    @Autowired
    FinancialPerformanceRepo financialPerformances;
    @Autowired
    OrgPerformanceRepo orgPerformances;

    Server h2;


    @PostConstruct
    public void init() throws SQLException, IOException {
        h2 = Server.createWebServer().start();

        if (demographics.count() == 0 &&
                academicProfiles.count() == 0 &&
                academicPerformances.count() == 0 &&
                financialPerformances.count() == 0 &&
                orgPerformances.count() == 0) {

            loadInitialData();
        }
    }
    @PreDestroy
    public void destroy() {
        h2.stop();
    }

    public void loadInitialData() throws IOException {
        String[] jsonFiles = new String[5];
        jsonFiles[0] = "demographics.json";
        jsonFiles[1] = "academicPerformances.json";
        jsonFiles[2] = "academicProfiles.json";
        jsonFiles[3] = "financialPerformances.json";
        jsonFiles[4] = "orgPerformances.json";

        for (int i = 0 ; i < jsonFiles.length; i++) {
            File f = new File(jsonFiles[i]);
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();     //cast to int
            char[] contents = new char[fileSize];
            fr.read(contents, 0, fileSize);
            JsonParser parser = new JsonParser();
            switch (f.toString()) {
                case "demographics.json":
                    DemographicWrapper demographicWrapper = parser.parse(contents, DemographicWrapper.class);
                    demographics.save(demographicWrapper.demographics);
                    break;
                case "academicPerformances.json":
                    AcademicPerfWrapper academicPerfWrapper = parser.parse(contents, AcademicPerfWrapper.class);
                    academicPerformances.save(academicPerfWrapper.academicPerformances);
                    break;
                case "academicProfiles.json":
                    AcademicProfileWrapper academicProfileWrapper = parser.parse(contents, AcademicProfileWrapper.class);
                    academicProfiles.save(academicProfileWrapper.academicProfiles);
                    break;
                case "financialPerformances.json":
                    FinancialPerformanceWrapper financialPerformanceWrapper = parser.parse(contents, FinancialPerformanceWrapper.class);
                    financialPerformances.save(financialPerformanceWrapper.financialPerformances);
                    break;
                case "orgPerformances.json":
                    OrgPerformanceWrapper orgPerformanceWrapper = parser.parse(contents, OrgPerformanceWrapper.class);
                    orgPerformances.save(orgPerformanceWrapper.orgPerformances);
                    break;

            }
        }

    }
    @RequestMapping(value = "/school-data", method = RequestMethod.GET)
    public ResponseEntity<Object> getSomeData(@RequestParam("schoolId")String schoolId, @RequestParam("cat")String[] category) throws Exception {
        ArrayList<Object> compositeDataArray = new ArrayList<>();
        for (String element : category) {
            switch (element) {
                case "dem":
                    DemographicProfile demographicProfile = demographics.findBySchoolId(schoolId);
                    compositeDataArray.add(demographicProfile);
                    break;
                case "academicProf":
                    AcademicProfile academicProfile = academicProfiles.findBySchoolId(schoolId);
                    compositeDataArray.add(academicProfile);
                    break;
                case "academicPerf":
                    AcademicPerformance academicPerformance = academicPerformances.findBySchoolId(schoolId);
                    compositeDataArray.add(academicPerformance);
                    break;
                case "finPerf":
                    FinancialPerformance financialPerformance = financialPerformances.findBySchoolId(schoolId);
                    compositeDataArray.add(financialPerformance);
                    break;
                case "orgPerf":
                    OrgPerformance orgPerformance = orgPerformances.findBySchoolId(schoolId);
                    compositeDataArray.add(orgPerformance);
                    break;
                case "all":
                    demographicProfile = demographics.findBySchoolId(schoolId);
                    compositeDataArray.add(demographicProfile);
                    academicProfile = academicProfiles.findBySchoolId(schoolId);
                    compositeDataArray.add(academicProfile);
                    academicPerformance = academicPerformances.findBySchoolId(schoolId);
                    compositeDataArray.add(academicPerformance);
                    financialPerformance = financialPerformances.findBySchoolId(schoolId);
                    compositeDataArray.add(financialPerformance);
                    orgPerformance = orgPerformances.findBySchoolId(schoolId);
                    compositeDataArray.add(orgPerformance);

                    break;

            }

        }
        return new ResponseEntity<Object>(compositeDataArray, HttpStatus.OK);

    }

    @RequestMapping(value = "/all-data", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllData(@RequestParam("schoolId")String schoolId) throws Exception {
        ArrayList<Object> allDataArrayList = new ArrayList<>();
        DemographicProfile demographicProfile = demographics.findBySchoolId(schoolId);
        AcademicPerformance academicPerformance = academicPerformances.findBySchoolId(schoolId);
        AcademicProfile academicProfile = academicProfiles.findBySchoolId(schoolId);
        allDataArrayList.add(demographicProfile);
        allDataArrayList.add(academicProfile);
        allDataArrayList.add(academicPerformance);
        return new ResponseEntity<Object>(allDataArrayList, HttpStatus.OK);
    }

    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public ResponseEntity<Object> getSummary() throws Exception {
        Iterable<DemographicProfile> fullList = demographics.findAll();
        ArrayList<ArrayList> schoolSummaryList = new ArrayList<>();
        for (DemographicProfile dp : fullList) {
            ArrayList<Object> individualSchool = new ArrayList<>();
            AcademicPerformance ap = academicPerformances.findBySchoolId(dp.getSchoolId());
            FinancialPerformance fp = financialPerformances.findBySchoolId(dp.getSchoolId());
            OrgPerformance op = orgPerformances.findBySchoolId(dp.getSchoolId());
            individualSchool.add(dp.getSchoolName());
            individualSchool.add(dp.getYearOpened());
            Class c1 = ap.getClass();
            ArrayList<Object> fieldValues = new ArrayList<>();
            Field[] fields = c1.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object object = fields[i].get(ap);
                fieldValues.add(object);
            }
            int metCount = 0;
            int notMetCount = 0;
            for (Object o : fieldValues) {

                if (o.toString().contains("Exceeds") || o.toString().contains("Meets")) {
                    metCount++;
                } else if (o.toString().contains("Not Met") || o.toString().contains("Far Below")) {
                    notMetCount++;
                }
            }
            individualSchool.add(metCount);
            individualSchool.add(metCount + notMetCount);



            Class c2 = fp.getClass();
            ArrayList<Object> financialValues = new ArrayList<>();
            Field[] fields2 = c2.getDeclaredFields();
            for (int i = 0; i < fields2.length; i++) {
                fields2[i].setAccessible(true);
                Object object2 = fields2[i].get(fp);
                financialValues.add(object2);
            }
            int finMetCount = 0;
            int finNotMetCount = 0;
            for (Object o : financialValues) {

                if (o.toString().contains("Meets Standard") || o.toString().contains("Exceeds")) {
                    finMetCount++;
                } else if (o.toString().contains("Does Not Meet Standard") || o.toString().contains("Far Below")) {
                    finNotMetCount++;
                }
            }
            individualSchool.add(finMetCount);
            individualSchool.add(finMetCount + finNotMetCount);


            Class c3 = op.getClass();
            ArrayList<Object> orgValues = new ArrayList<>();
            Field[] fields3 = c3.getDeclaredFields();
            for (int i = 0; i < fields3.length; i++) {
                fields3[i].setAccessible(true);
                Object object3 = fields3[i].get(op);
                orgValues.add(object3);
            }
            int orgMetCount = 0;
            int orgNotMetCount = 0;
            for (Object o : orgValues) {

                if (o.toString().contains("Meets Standard") || o.toString().contains("Exceeds")) {
                    orgMetCount++;
                } else if (o.toString().contains("Does Not Meet Standard") || o.toString().contains("Far Below")) {
                    orgNotMetCount++;
                }
            }
            individualSchool.add(orgMetCount);
            individualSchool.add(orgMetCount + orgNotMetCount);
            float academicPercentMet = ((float) metCount / (metCount + notMetCount));
            float financialPercentMet = ((float) finMetCount / (finMetCount + finNotMetCount));
            float orgPercentMet = ((float) orgMetCount / (orgMetCount + orgNotMetCount));
            individualSchool.add(academicPercentMet * 100);
            individualSchool.add(financialPercentMet * 100);
            individualSchool.add(orgPercentMet * 100);

            schoolSummaryList.add(individualSchool);

        }
        return new ResponseEntity<Object>(schoolSummaryList, HttpStatus.OK);
    }
}
