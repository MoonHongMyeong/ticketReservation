package me.moon.ticketReservation.performance.repository;

import me.moon.ticketReservation.performance.entity.Performance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PerformanceMapper {
    void save(Performance performance);

    Performance findById(Long id);

    boolean isExistPerformance(Performance performance);

    int deleteById(Long id);
}
