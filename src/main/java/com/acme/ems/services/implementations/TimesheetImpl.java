package com.acme.ems.services.implementations;

import com.acme.ems.models.Timesheet;
import com.acme.ems.repositories.TimesheetRepository;
import com.acme.ems.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetImpl implements TimesheetService {

    @Autowired
    TimesheetRepository timesheetRepository;

    @Override
    public List<Timesheet> listTimesheet() {
//        Optional<Timesheet> timesheets = timesheetRepository.findById(empId);
        return (List<Timesheet>)timesheetRepository.findAll();
    }

    @Override
    public Timesheet getTimesheet(int timesheetId) {
        return null;
    }

    @Override
    public void addTimesheet(Timesheet timesheet) {

        timesheetRepository.save(timesheet);
    }

    @Override
    public void deleteTimesheet(int timesheetId) {

    }

    @Override
    public void updateTimesheet(Timesheet timesheet) {

    }
}
