package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
        List<LocalDate> unsortedDates = List.of(
                LocalDate.of(2004, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3),
                LocalDate.of(2030, 5, 1),
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2000, 10, 1)
        );

        DateSorter dateSorter = new DateSorter();
        System.out.println(dateSorter.sortDates(unsortedDates));

    }
}
