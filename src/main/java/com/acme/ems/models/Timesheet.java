package com.acme.ems.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "timesheet")
@Data
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheetid")
    int timesheetId;

    String empName;

    int timeTotalHours;

    Date timeDate;

    String timeTask;

    String timeDescription;

    @ManyToOne
    @JoinColumn(name = "empid")
    private Employee employee;
}
