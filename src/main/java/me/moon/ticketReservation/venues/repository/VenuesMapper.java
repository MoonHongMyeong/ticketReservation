package me.moon.ticketReservation.venues.repository;

import me.moon.ticketReservation.venues.entity.Venues;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface VenuesMapper {
    void save(Venues venues);

    boolean isExistsVenues(Venues venues);

    Venues findById(String venuesId);

    int deleteById(String venuesId);

    List<Venues> search(Map<String, String> searchKeyword);
}
