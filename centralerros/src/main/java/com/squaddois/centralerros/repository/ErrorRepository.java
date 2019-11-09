package com.squaddois.centralerros.repository;

import com.squaddois.centralerros.model.Environment;
import com.squaddois.centralerros.model.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorRepository extends JpaRepository<Error,Long> {

    @Query("SELECT t.environment FROM Error t where t.environment = :environment")
    List<Error> findErrorByEnvironment(@Param("environment") Environment environment);

}
