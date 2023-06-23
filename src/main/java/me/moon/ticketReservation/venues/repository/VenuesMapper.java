package me.moon.ticketReservation.venues.repository;

import me.moon.ticketReservation.venues.entity.Venues;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VenuesMapper {
    void save(Venues venues);

    boolean isExistsVenues(Venues venues);
}
