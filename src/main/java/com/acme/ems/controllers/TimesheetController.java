package com.acme.ems.controllers;

import com.acme.ems.models.Employee;
import com.acme.ems.models.Timesheet;
import com.acme.ems.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping("/timesheet")
    public List<Timesheet> listAllTimesheet() {
//        System.out.println("******************"+timesheetService.listTimesheet().toString());
        return timesheetService.listTimesheet();
//        return
    }

    @PostMapping("/timesheet")
    public Timesheet create(@RequestBody Timesheet timesheet) {
//        if(!isValid(employee))
//            throw new ValidationException("Fill out the form with Valid Data");
//        else
            timesheetService.addTimesheet(timesheet);
        return timesheet;
    }
}
