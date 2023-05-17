package com.springexample.main.app.students.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public record Student(UUID id, String name, String lastName, java.time.LocalDateTime birthDate) {
    private static final int AGE_TO_BECOME_ADULT = 18;

    public boolean isAdult(LocalDateTime now) {
        long age = this.birthDate.until(now, ChronoUnit.YEARS);
        System.out.println(age);
        return age >= AGE_TO_BECOME_ADULT;
    }
}

