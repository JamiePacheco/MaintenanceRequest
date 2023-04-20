package com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.repos;

import com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.models.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE MaintenanceRequest mr SET mr.aptNumber = :aptNumber," +
            " mr.firstName = :firstName," +
            " mr.lastName = :lastName," +
            " mr.description = :description," +
            " mr.email = :email WHERE mr.id = :id")
    void updateRequest(@Param("aptNumber") String aptNumber,
                         @Param("firstName") String firstName,
                         @Param("lastName") String lastName,
                         @Param("description") String description,
                         @Param("email") String email,
                         @Param("id") Long id);


}
