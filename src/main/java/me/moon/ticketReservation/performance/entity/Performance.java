package me.moon.ticketReservation.performance.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.venues.entity.Venues;

import java.util.Date;

@Getter
@NoArgsConstructor
public class Performance {
    private Long id;
    private Long managerId;
    private Supplier manager;
    private Long venuesId;
    private Venues venues;
    private Genre genre;
    private String name;
    private String phone;
    private int runtime;
    private int intermission;
    private FilmRating filmRating;
    private Date startDate;
    private Date endDate;

    @Builder
    public Performance(Long managerId, Long venuesId, Genre genre, String name, String phone, int runtime, int intermission, FilmRating filmRating, Date startDate, Date endDate){
        this.managerId = managerId;
        this.venuesId = venuesId;
        this.genre = genre;
        this.name = name;
        this.phone = phone;
        this.runtime = runtime;
        this.intermission = intermission;
        this.filmRating = filmRating;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
