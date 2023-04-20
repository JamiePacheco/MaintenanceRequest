package com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.controllers;

import com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.CodeDifferently.apartmentmgrserver.domain.maintenanceRequest.services.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/maintenance-request")
public class MaintenanceRequestController {

    private MaintenanceRequestService maintenanceRequestService;

    @Autowired
    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MaintenanceRequest>> getAll() {
        List<MaintenanceRequest> requests = maintenanceRequestService.getAll();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MaintenanceRequest> getRequest(@PathVariable("id") Long id) {
        MaintenanceRequest request = maintenanceRequestService.getRequest(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<MaintenanceRequest> saveRequest(@RequestBody MaintenanceRequest maintenanceRequest) {
        maintenanceRequest = maintenanceRequestService.createRequest(maintenanceRequest);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MaintenanceRequest> updateRequest(@RequestBody MaintenanceRequest maintenanceRequest, @RequestParam("id") Long id) {
        maintenanceRequest = maintenanceRequestService.updateRequest(id, maintenanceRequest);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteRequest(@RequestParam("id") Long id) {
        maintenanceRequestService.deleteRequest(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}