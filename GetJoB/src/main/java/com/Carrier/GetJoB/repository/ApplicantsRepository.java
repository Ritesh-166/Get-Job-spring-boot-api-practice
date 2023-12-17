package com.Carrier.GetJoB.repository;

import com.Carrier.GetJoB.model.ApplicantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ApplicantsRepository extends JpaRepository<ApplicantModel, Long> {

    boolean existsByEmail(String email);


}
