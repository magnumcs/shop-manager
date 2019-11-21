package com.portifolio.magnum.eventregisterapi.repository;

import com.portifolio.magnum.eventregisterapi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
