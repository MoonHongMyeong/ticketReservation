package me.moon.ticketReservation.performance.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Cost {
    private Long id;
    private Long performanceId;
    private Performance performance;
    private String grade;
    private int price;

    @Builder
    public Cost(Performance performance, String grade, int price){
        this.performanceId = performance.getId();
        this.performance = performance;
        this.grade = grade;
        this.price = price;
    }
}
