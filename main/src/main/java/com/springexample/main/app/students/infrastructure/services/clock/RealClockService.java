package com.springexample.main.app.students.infrastructure.services.clock;

import com.springexample.main.app.shared.domain.ClockService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RealClockService implements ClockService {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
