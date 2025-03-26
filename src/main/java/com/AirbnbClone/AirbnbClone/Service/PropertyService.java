package com.AirbnbClone.AirbnbClone.Service;


import com.AirbnbClone.AirbnbClone.Entity.Property;
import com.AirbnbClone.AirbnbClone.Entity.User;
import com.AirbnbClone.AirbnbClone.Repository.PropertyRepository;
import com.AirbnbClone.AirbnbClone.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Property> getProperty()
    {
        return propertyRepository.findAll();
    }
}


