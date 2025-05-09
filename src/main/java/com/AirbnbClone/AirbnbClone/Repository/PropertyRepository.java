package com.AirbnbClone.AirbnbClone.Repository;

import com.AirbnbClone.AirbnbClone.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
