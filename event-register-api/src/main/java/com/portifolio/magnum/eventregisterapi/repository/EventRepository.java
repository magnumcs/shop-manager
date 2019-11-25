package com.portifolio.magnum.eventregisterapi.repository;

import com.portifolio.magnum.eventregisterapi.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
}
