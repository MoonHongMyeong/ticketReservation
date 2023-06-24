package me.moon.ticketReservation.performance.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Seat {
    private Long id;
    private Long performance_id;
    private Performance performance;
    private String name;

    @Builder
    public Seat(Performance performance, String name){
        this.performance_id = performance.getId();
        this.performance = performance;
        this.name = name;
    }
}
