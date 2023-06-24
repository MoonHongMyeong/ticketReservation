package me.moon.ticketReservation.performance.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Seat {
    private Long id;
    private Long performanceId;
    private Performance performance;
    private String name;
    private String grade;
    private int cost;

    @Builder
    public Seat(Performance performance, String name, String grade, int cost){
        this.performanceId = performance.getId();
        this.performance = performance;
        this.name = name;
        this.grade = grade;
        this.cost = cost;
    }
}
