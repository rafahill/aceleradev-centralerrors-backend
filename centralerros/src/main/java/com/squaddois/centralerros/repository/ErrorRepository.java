package com.squaddois.centralerros.repository;

import com.squaddois.centralerros.model.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorRepository extends JpaRepository<Error,Long> {
}
