package com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.services;

import com.CodeDifferently.apartmentmgrserver.domain.core.exceptions.ResourceCreationException;
import com.CodeDifferently.apartmentmgrserver.domain.core.exceptions.ResourceNotFoundException;
import com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.models.MaintenanceRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaintenanceRequestService {

    MaintenanceRequest createRequest(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;

    MaintenanceRequest updateRequest(Long id, MaintenanceRequest maintenanceRequest) throws ResourceNotFoundException;

    MaintenanceRequest getRequest(Long id) throws ResourceNotFoundException;

    void deleteRequest(Long id) throws  ResourceNotFoundException;

    List<MaintenanceRequest> getAll();

}