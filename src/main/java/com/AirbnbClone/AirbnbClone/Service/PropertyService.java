package com.AirbnbClone.AirbnbClone.Service;


import com.AirbnbClone.AirbnbClone.Entity.Property;
import com.AirbnbClone.AirbnbClone.Entity.User;
import com.AirbnbClone.AirbnbClone.Repository.PropertyRepository;
import com.AirbnbClone.AirbnbClone.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    //check if the property is selected for the id. if not, create a new one.

    public Property createProperty(Property property, Long id)
    {
        User Owner = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User Not Found"));
        property.setOwner(Owner);

        return propertyRepository.save(property);
    }

    //get properties

    public List<Property> getProperties()
    {
        return propertyRepository.findAll();
    }

    //get property by id
    public Optional<Property> getPropertyById(Long id)
    {
        return propertyRepository.findById(id);
    }

}


