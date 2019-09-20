package com.example.motoinventoryservice.controller;

import com.example.motoinventoryservice.exception.NotFoundException;
import com.example.motoinventoryservice.service.MotoInventoryService;
import com.example.motoinventoryservice.viewmodel.MotoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class MotoInventoryController {

    // service connections
    @Autowired
    MotoInventoryService motoInventoryService;

    // autowire a DiscoveryClient instance to contact Eureka and ask about connection details of vinLookup
    @Autowired
    private DiscoveryClient discoveryClient;

  // used to communicate with the Vin Lookup Service, serviceProtocol and servicePath properties in config file
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${vinLookUp}")
    private String vinLookUp;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    @RequestMapping(value = "/vehicle/{vin}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Map getVehicleByVin(@PathVariable String vin) {

        // use the DiscoveryClient to ask for the Vin Lookup by name
        List<ServiceInstance> instances = discoveryClient.getInstances(vinLookUp);

        // combine the serviceProtocol and servicePath from config file with the host and port of the vinlook up
        // from Eureka to create the URI for the Vin Lookup Service - the URI that talks to the service
        String vinLookUpServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath + vin;

        // use the restTemplate and theURI to call the Vin Lookup Service and get the Vehicle object, returning Map and path variable vin
        Map vehicle =restTemplate.getForObject(vinLookUpServiceUri, Map.class, vin);

        return vehicle;
    }

    @RequestMapping(value = "/motorcycles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public MotoViewModel createMotorcycle(@RequestBody @Valid MotoViewModel motoViewModel) {

        return motoInventoryService.saveMoto(motoViewModel);
    }

    @RequestMapping(value = "/motorcycles", method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<MotoViewModel> getAllMotorcycles(){

        return motoInventoryService.findAllMotos();
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public MotoViewModel getMotorcycle(@PathVariable int motoId) {

        MotoViewModel moto = motoInventoryService.findMotoById(motoId);
        if(moto == null)
            throw new NotFoundException("Requested motorcycle could not be found with id " + motoId);
        return moto;
    }

    @RequestMapping(value = "/motorcycle/{make}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<MotoViewModel> getMotorcyclesByMake(@PathVariable String make) {

        List<MotoViewModel> motorcycleList = motoInventoryService.findMotoByMake(make);

        if(motorcycleList != null && motorcycleList.size() == 0)
            throw new NotFoundException("No motorcycles in the inventory with " + make + " make");
        return motorcycleList;
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMotorcycle(@PathVariable("motoId") int motoId) {

        motoInventoryService.removeMoto(motoId);

    }

    @RequestMapping(value = "/motorcycles/{motoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMotorcycle(@RequestBody @Valid MotoViewModel motoViewModel, @PathVariable int motoId) {
        // make sure the motoId on the path matches the id of the motorcycle object
        if (motoId != motoViewModel.getId()) {
            throw new IllegalArgumentException("Motorcycle ID on path must match the ID in the Motorcycle object.");
        }

        motoInventoryService.updateMoto(motoViewModel);

    }


}
