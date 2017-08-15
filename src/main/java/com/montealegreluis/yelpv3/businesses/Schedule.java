/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.montealegreluis.yelpv3.businesses;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Schedule {
    public final String hoursType;
    public final boolean isOpenNow;
    public final List<Hours> hours;

    public Schedule(boolean isOpenNow, List<Hours> hours) {
        this.hoursType = "REGULAR";
        this.isOpenNow = isOpenNow;
        this.hours = Collections.unmodifiableList(hours);
    }

    public List<Hours> hoursFor(DayOfWeek day) {
        return hours
            .stream()
            .filter(hour -> hour.day.equals(day))
            .collect(Collectors.toList())
        ;
    }
}
