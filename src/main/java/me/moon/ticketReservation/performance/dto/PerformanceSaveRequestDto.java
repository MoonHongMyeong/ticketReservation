package me.moon.ticketReservation.performance.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.performance.entity.*;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.venues.entity.Venues;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class PerformanceSaveRequestDto {
    private String genre;
    private String name;
    private String phone;
    private int runtime;
    private int intermission;
    private String filmRating;
    private Date startDate;
    private Date endDate;
    private List<Seat> seats;

    public Performance toEntity(Supplier manager, Venues venues){
        return Performance.builder()
                .managerId(manager.getId())
                .venuesId(venues.getId())
                .genre(Genre.valueOf(this.genre))
                .name(this.name)
                .phone(this.phone)
                .runtime(this.runtime)
                .intermission(this.intermission)
                .filmRating(FilmRating.valueOf(filmRating))
                .startDate(this.startDate)
                .endDate(this.endDate)
                .seats(this.seats)
                .build();
    }
}
