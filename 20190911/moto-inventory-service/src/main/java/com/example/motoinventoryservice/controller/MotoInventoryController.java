package com.example.motoinventoryservice.controller;

import com.example.motoinventoryservice.model.Motorcycle;
import com.example.motoinventoryservice.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RefreshScope
public class MotoInventoryController {
@Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

@Value("${vinServiceName}")
private String vinServiceName;

@Value("${serviceProtocol}")
private String serviceProtocol;

@Value("${servicePath}")
private String servicePath;


    @RequestMapping(value = "/motorcycles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Motorcycle createMotorcycle(@RequestBody @Valid Motorcycle motorcycle) {
        Random rnd = new Random();

        motorcycle.setId(rnd.nextInt(9999));

        return motorcycle;
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Motorcycle getMotorcycle(@PathVariable int motoId) {
        if (motoId < 1) {
           throw new IllegalArgumentException("MotoId must be greater than 0.");
        }

        Motorcycle moto = new Motorcycle();
        moto.setId(motoId);
        moto.setVin("54321");
        moto.setMake("Ducati");
        moto.setModel("Multistrada Enduro");
        moto.setYear("2018");
        moto.setColor("Red");

        return moto;
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteMotorcycle(@PathVariable("motoId") int motoId) {
        // do nothing here - in a real application we would delete the entry from
        // the backing data store.
    }

    @RequestMapping(value = "/motorcycles/{motoId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateMotorcycle(@RequestBody @Valid Motorcycle motorcycle, @PathVariable int motoId) {
        // make sure the motoId on the path matches the id of the motorcycle object
        if (motoId != motorcycle.getId()) {
            throw new IllegalArgumentException("Motorcycle ID on path must match the ID in the Motorcycle object.");
        }

        // do nothing here - in a real application we would update the entry in the backing data store

    }

    @RequestMapping(value="/vehicle/{vin}")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, String> getVehicleInformation(@PathVariable String vin){
        List<ServiceInstance> instances = discoveryClient.getInstances(vinServiceName);

        String vinServiceUri = serviceProtocol+ instances.get(0).getHost()+":"+instances.get(0).getPort()+servicePath+"/"+vin;
        Vehicle vehicle = restTemplate.getForObject(vinServiceUri, Vehicle.class);

        Map<String, String> vehicleMap = new HashMap<String, String>();
       vehicleMap.put("Vehicle Type", vehicle.getType() );
       vehicleMap.put("Vehicle Make", vehicle.getMake());
       vehicleMap.put("Vehicle Model", vehicle.getModel());
       vehicleMap.put("Vehicle Year", vehicle.getYear());
       vehicleMap.put("Vehicle Color", vehicle.getColor());

        return  vehicleMap;

    }
}
