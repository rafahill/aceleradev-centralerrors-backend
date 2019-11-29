package com.squaddois.centralerros.repository;

import com.squaddois.centralerros.entity.Environment;
import com.squaddois.centralerros.entity.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorRepository extends JpaRepository<Error,Long> {

    List<Error> findErrorsByEnvironment(Environment environment);

    List<Error> findErrorsByArchived(Boolean archived);

    List<Error> findErrorsByEnvironmentAndArchived(Environment environment, Boolean archived);

}
