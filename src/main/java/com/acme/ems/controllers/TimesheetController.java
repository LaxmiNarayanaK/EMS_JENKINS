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
        return timesheetService.listTimesheet();
    }

    @PostMapping("/timesheet")
    public Timesheet create(@RequestBody Timesheet timesheet) {

        timesheetService.addTimesheet(timesheet);
        return timesheet;
    }

    @PutMapping("/timesheet")
    Timesheet updateTimesheet(@RequestBody Timesheet timesheet)
    {
        timesheetService.updateTimesheet(timesheet);
        return timesheet;
    }

    @DeleteMapping("/timesheet/{timesheedid}")
    public void deleteTimesheet(@PathVariable int timesheedid)
    {
            timesheetService.deleteTimesheet(timesheedid);
    }
}
