package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.newhtsystem.CompanySalaryProcessor;
import com.kodilla.patterns2.adapter.company.newhtsystem.Employee;
import com.kodilla.patterns2.adapter.company.newhtsystem.SalaryProcessor;

import java.math.BigDecimal;
import java.util.List;

public class SalaryAdaptee implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        CompanySalaryProcessor theProcessor = new CompanySalaryProcessor();
        return theProcessor.calculateSalaries(employees);
    }
}
