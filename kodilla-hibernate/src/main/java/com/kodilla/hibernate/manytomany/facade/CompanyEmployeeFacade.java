package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyEmployeeFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;


    public List<Company> findCompany(String partName) {
        String properPartName = "%" + partName + "%";
        return companyDao.retrieveCompaniesWithName(properPartName);
    }

    public List<Employee> findEmployee(String partName) {
        String properPartName = "%" + partName + "%";
        return employeeDao.retrieveEmployeeWithPartOfName(properPartName);
    }
}
