package me.moon.ticketReservation.performance.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.performance.repository.PerformanceMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerformanceFindDao {
    private final PerformanceMapper performanceMapper;
}
