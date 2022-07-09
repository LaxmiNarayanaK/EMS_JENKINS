package com.acme.ems.repositories;

import com.acme.ems.models.Timesheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet,Integer> {
}
