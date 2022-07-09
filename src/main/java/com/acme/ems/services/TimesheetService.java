package com.acme.ems.services;


import com.acme.ems.models.Timesheet;

import java.util.List;

public interface TimesheetService  {

    List<Timesheet> listTimesheet();

    Timesheet getTimesheet(int timesheetId);

    void addTimesheet(Timesheet timesheet);

    void deleteTimesheet(int timesheetId);

    void updateTimesheet(Timesheet timesheet);


}
