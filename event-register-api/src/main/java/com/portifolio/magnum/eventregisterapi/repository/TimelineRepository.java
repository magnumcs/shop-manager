package com.portifolio.magnum.eventregisterapi.repository;

import com.portifolio.magnum.eventregisterapi.model.TimeLine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineRepository extends MongoRepository<TimeLine, String> {
}
