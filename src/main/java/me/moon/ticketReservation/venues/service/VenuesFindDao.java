package me.moon.ticketReservation.venues.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.venues.dto.VenuesSaveRequestDto;
import me.moon.ticketReservation.venues.entity.Venues;
import me.moon.ticketReservation.venues.repository.VenuesMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VenuesFindDao {
    private final VenuesMapper venuesMapper;

    public boolean isDuplicateVenues(Venues venues) {
        return venuesMapper.isExistsVenues(venues);
    }
}
