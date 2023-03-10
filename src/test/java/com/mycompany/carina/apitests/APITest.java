package com.mycompany.carina.apitests;

import com.mycompany.carina.mydemo.myapitest.DeleteEmployeeMethod;
import com.mycompany.carina.mydemo.myapitest.GetAllEmployeesMethod;
import com.mycompany.carina.mydemo.myapitest.GetEmployeeMethod;
import com.mycompany.carina.mydemo.myapitest.PostEmployeeMethod;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;

import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.zebrunner.agent.core.annotation.Priority;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "carina")
    public void testCreateEmployee(){
        PostEmployeeMethod postEmp = new PostEmployeeMethod();
        postEmp.setProperties("api/employees/employee.properties");

        AtomicInteger counter = new AtomicInteger(0);

        postEmp.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get()==1)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10,ChronoUnit.SECONDS)
                .execute();
        postEmp.validateResponse();
    }


    @Test()
    @MethodOwner(owner = "carina")
    public void testGetAllEmployees() {
        GetAllEmployeesMethod getAllEmployees = new GetAllEmployeesMethod();
        getAllEmployees.callAPIExpectSuccess();
        getAllEmployees.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAllEmployees.validateResponseAgainstSchema("api/employees/_getall/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "carina")
    public void testGetEmployee() {
        GetEmployeeMethod getEmployee = new GetEmployeeMethod();
        getEmployee.callAPIExpectSuccess();
        getEmployee.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getEmployee.validateResponseAgainstSchema("api/employees/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "carina")
    @Priority(Priority.P1)
    public void deleteEmployee(){
        DeleteEmployeeMethod deleteEmployee = new DeleteEmployeeMethod();
        deleteEmployee.setProperties("api/employees/employee.properties");
        deleteEmployee.callAPIExpectSuccess();
        deleteEmployee.validateResponse();
    }
}

