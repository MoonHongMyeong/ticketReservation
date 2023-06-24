package me.moon.ticketReservation.performance.repository;

import me.moon.ticketReservation.performance.entity.Seat;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeatMapper {
    void save(Seat seat);
}
