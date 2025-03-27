package com.AirbnbClone.AirbnbClone.Controller;


import com.AirbnbClone.AirbnbClone.Entity.Property;
import com.AirbnbClone.AirbnbClone.Entity.User;
import com.AirbnbClone.AirbnbClone.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/properties")
public class PropertyController {


    @Autowired
    private PropertyService propertyService;


    // creating a POST mapping.

    @PostMapping
    public Property createProperty(@RequestBody Property property,
                                   @RequestParam Long UserId)
    {
        return propertyService.createProperty(property, UserId);
    }


    // get a property by Id
    @GetMapping("api/property/{id}")
    public ResponseEntity<Property> getPropertyById(@RequestParam Long id)
    {
        Optional<Property> property = propertyService.getPropertyById(id);
        return (ResponseEntity<Property>) ResponseEntity.ok();
    }

    // get all properties.

    @GetMapping
    public List<Property> getAllProperties()
    {
        return propertyService.getProperties();
    }
}


