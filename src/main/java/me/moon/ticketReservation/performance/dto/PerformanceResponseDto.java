package me.moon.ticketReservation.performance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.performance.entity.FilmRating;
import me.moon.ticketReservation.performance.entity.Genre;
import me.moon.ticketReservation.performance.entity.Performance;
import me.moon.ticketReservation.performance.entity.Seat;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.venues.entity.Venues;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class PerformanceResponseDto {
    private Long id;
    private Supplier manager;
    private Venues venues;
    private Genre genre;
    private String name;
    private String phone;
    private int runtime;
    private int intermission;
    private FilmRating filmRating;
    private Date startDate;
    private Date endDate;
    private List<Seat> seats;

    @Builder
    public PerformanceResponseDto(Long id, Supplier manager, Venues venues, Genre genre, String name, String phone, int runtime, int intermission, FilmRating filmRating, Date startDate, Date endDate, List<Seat> seats){
        this.id = id;
        this.manager = manager;
        this.venues = venues;
        this.genre = genre;
        this.name = name;
        this.phone = phone;
        this.runtime = runtime;
        this.intermission = intermission;
        this.filmRating = filmRating;
        this.startDate = startDate;
        this.endDate = endDate;
        this.seats = seats;
    }

    public static PerformanceResponseDto of(Performance performance){
        return PerformanceResponseDto.builder()
                .id(performance.getId())
                .manager(performance.getManager())
                .venues(performance.getVenues())
                .genre(performance.getGenre())
                .name(performance.getName())
                .phone(performance.getPhone())
                .runtime(performance.getRuntime())
                .intermission(performance.getIntermission())
                .filmRating(performance.getFilmRating())
                .startDate(performance.getStartDate())
                .endDate(performance.getEndDate())
                .seats(performance.getSeats())
                .build();
    }

}
