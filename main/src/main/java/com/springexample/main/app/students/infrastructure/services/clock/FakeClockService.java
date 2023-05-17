package com.springexample.main.app.students.infrastructure.services.clock;

import com.springexample.main.app.shared.domain.ClockService;

import java.time.LocalDateTime;
import java.time.Month;

public class FakeClockService implements ClockService {

    public static final LocalDateTime MOCKED_DATE = LocalDateTime.of(2023, Month.APRIL, 1, 1, 1, 1);

    @Override
    public LocalDateTime now() {
        return MOCKED_DATE;
    }
}
