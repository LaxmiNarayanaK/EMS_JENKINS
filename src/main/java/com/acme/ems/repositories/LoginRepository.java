package com.acme.ems.repositories;

import com.acme.ems.models.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login,Integer> {
}
