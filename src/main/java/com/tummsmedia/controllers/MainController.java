package com.tummsmedia.controllers;

import com.tummsmedia.entities.*;
import com.tummsmedia.services.*;
import jodd.json.JsonParser;
import jodd.typeconverter.TypeConverter;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        ArrayList<HashMap> schoolSummaryList = new ArrayList<>();
        for (DemographicProfile dp : fullList) {
            AcademicPerformance ap = academicPerformances.findBySchoolId(dp.getSchoolId());
            FinancialPerformance fp = financialPerformances.findBySchoolId(dp.getSchoolId());
            OrgPerformance op = orgPerformances.findBySchoolId(dp.getSchoolId());
            HashMap<String, String> school = new HashMap<>();
            HashMap<String, Integer> year = new HashMap<>();
            HashMap<String, Integer> academicMet = new HashMap<>();
            HashMap<String, Integer> academicTot = new HashMap<>();
            HashMap<String, Integer> financialMet = new HashMap<>();
            HashMap<String, Integer> financialTot = new HashMap<>();
            HashMap<String, Integer> orgMet = new HashMap<>();
            HashMap<String, Integer> orgTot = new HashMap<>();
            HashMap<String, String> academicPercent = new HashMap<>();
            HashMap<String, String> financialPercent = new HashMap<>();
            HashMap<String, String > orgPercent = new HashMap<>();
            school.put("school", dp.getSchoolName());
            year.put("year", dp.getYearOpened());
            Class c1 = ap.getClass();
            ArrayList<Object> fieldValues = new ArrayList<>();
            Field[] fields = c1.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object object = fields[i].get(ap);
                fieldValues.add(object);
                int metCount = 0;
                int notMetCount = 0;
                for (Object o : fieldValues) {

                    if (o.toString().equals("Exceeds") || o.toString().equals("Meets")) {
                        metCount++;
                    } else if (o.toString().equals("Not Met") || o.toString().equals("Far Below")) {
                        notMetCount++;
                    }
                }
                academicMet.put("Met", metCount);
                academicTot.put("Total", metCount + notMetCount);
                DecimalFormat df = new DecimalFormat("#%");
                String acPer = df.format(metCount / (metCount + notMetCount));
                academicPercent.put("academic%", acPer);
            }
            Class c2 = fp.getClass();
            ArrayList<Object> financialValues = new ArrayList<>();
            Field[] fields2 = c2.getDeclaredFields();
            for (int i = 0; i < fields2.length; i++) {
                fields2[i].setAccessible(true);
                Object object2 = fields2[i].get(fp);
                financialValues.add(object2);
                int finMetCount = 0;
                int finNotMetCount = 0;
                for (Object o : financialValues) {

                    if (o.toString().equals("Meets Standard") || o.toString().equals("Exceeds")) {
                        finMetCount++;
                    } else if (o.toString().equals("Does Not Meet Standard") || o.toString().equals("Far Below")) {
                        finNotMetCount++;
                    }
                }
                financialMet.put("Met", finMetCount);
                financialTot.put("Total", finMetCount + finNotMetCount);
                DecimalFormat df = new DecimalFormat("#%");
                String finPer = df.format(finMetCount / (finMetCount + finNotMetCount));
                financialPercent.put("financial%", finPer);
            }
            Class c3 = op.getClass();
            ArrayList<Object> orgValues = new ArrayList<>();
            Field[] fields3 = c3.getDeclaredFields();
            for (int i = 0; i < fields2.length; i++) {
                fields2[i].setAccessible(true);
                Object object3 = fields2[i].get(op);
                orgValues.add(object3);
                int orgMetCount = 0;
                int orgNotMetCount = 0;
                for (Object o : orgValues) {

                    if (o.toString().equals("Meets Standard") || o.toString().equals("Exceeds")) {
                        orgMetCount++;
                    } else if (o.toString().equals("Does Not Meet Standard") || o.toString().equals("Far Below")) {
                        orgNotMetCount++;
                    }
                }
                orgMet.put("Met", orgMetCount);
                orgTot.put("Total", orgMetCount + orgNotMetCount);
                DecimalFormat df = new DecimalFormat("#%");
                String orgPer = df.format(orgMetCount / (orgMetCount + orgNotMetCount));
                orgPercent.put("org%", orgPer);
            }
            schoolSummaryList.add(school);
            schoolSummaryList.add(year);
            schoolSummaryList.add(academicMet);
            schoolSummaryList.add(academicTot);
            schoolSummaryList.add(financialMet);
            schoolSummaryList.add(financialTot);
            schoolSummaryList.add(orgMet);
            schoolSummaryList.add(orgTot);
            schoolSummaryList.add(academicPercent);
            schoolSummaryList.add(financialPercent);
            schoolSummaryList.add(orgPercent);
        }
        return new ResponseEntity<Object>(schoolSummaryList, HttpStatus.OK);
    }

}
