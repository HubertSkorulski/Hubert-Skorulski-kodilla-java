package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.CompanyEmployeeFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompanyEmployeesTestSuite {

    @Autowired
    private CompanyEmployeeFacade companyEmployeeFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testRetrieveCompaniesWithName() {
        //Given
            Company firstCompany = new Company("Yossy");
            Company secondCompany = new Company("Yossel");
            String partName = "sse";
            companyDao.save(firstCompany);
            companyDao.save(secondCompany);

        //When
            int companies = companyEmployeeFacade.findCompany(partName).size();
        //Then
            Assertions.assertEquals(1,companies);
        //CleanUp
            companyDao.deleteAll();
    }

    @Test
    void testRetrieveEmployeesWithName() {
        //Given
            Employee firstEmployee = new Employee("Jerzy", "Janowicz");
            Employee secondEmployee = new Employee("Hubert", "Hurkacz");
            String partName = "rka";
            employeeDao.save(firstEmployee);
            employeeDao.save(secondEmployee);

        //When
            int employees = companyEmployeeFacade.findEmployee(partName).size();
        //Then
            Assertions.assertEquals(1,employees);
        //CleanUp
            employeeDao.deleteAll();
    }
}
