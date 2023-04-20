package com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.services;

import com.CodeDifferently.apartmentmgrserver.domain.core.exceptions.ResourceCreationException;
import com.CodeDifferently.apartmentmgrserver.domain.core.exceptions.ResourceNotFoundException;
import com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.repos.MaintenanceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService{

    private MaintenanceRequestRepository maintenanceRequestRepository;

    @Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepository maintenanceRequestRepository){
        this.maintenanceRequestRepository = maintenanceRequestRepository;
    }

    @Override
    public MaintenanceRequest createRequest(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        maintenanceRequest.setCreatedAt(OffsetDateTime.now());
        return this.maintenanceRequestRepository.save(maintenanceRequest);
    }

    @Override
    public MaintenanceRequest updateRequest(Long id, MaintenanceRequest maintenanceRequest) throws ResourceNotFoundException {
        maintenanceRequestRepository.updateRequest(
                maintenanceRequest.getAptNumber(),
                maintenanceRequest.getFirstName(),
                maintenanceRequest.getLastName(),
                maintenanceRequest.getDescription(),
                maintenanceRequest.getEmail(),
                id
        );
        maintenanceRequest = this.getRequest(id);
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getRequest(Long id) throws ResourceNotFoundException {
        return maintenanceRequestRepository.findById(id).orElseThrow(
                () ->  new ResourceNotFoundException("No Maintenance Request with id: " + id)
        );
    }

    @Override
    public void deleteRequest(Long id) throws ResourceNotFoundException {

        MaintenanceRequest maintenanceRequest = getRequest(id);

        maintenanceRequestRepository.delete(maintenanceRequest);
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenanceRequestRepository.findAll();
    }
}