package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * package sample;
 * <p>
 * import java.time.LocalDate;
 * import java.util.Collection;
 * import java.util.List;
 * <p>
 * /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        Map<Boolean, List<LocalDate>> listMap = getFilteredListMap(unsortedDates);
        return getSortedLocalDates(listMap);
    }

    private Map<Boolean, List<LocalDate>> getFilteredListMap(List<LocalDate> unsortedDates) {
        return unsortedDates.stream()
                .collect(Collectors.partitioningBy(getLocalDatePredicate()));
    }

    private static Predicate<LocalDate> getLocalDatePredicate() {
        return localDate -> localDate.getMonth().toString().toLowerCase().contains("r");
    }

    private Collection<LocalDate> getSortedLocalDates(Map<Boolean, List<LocalDate>> listMap) {
        return Stream.concat(
                        sortedListDateByKey(true, listMap.get(true)).stream(),
                        sortedListDateByKey(false, listMap.get(false)).stream()
                )
                .collect(Collectors.toList());
    }

    private Collection<LocalDate> sortedListDateByKey(Boolean key, List<LocalDate> unsortedDates) {
        return unsortedDates.stream()
                .sorted(key ? Comparator.naturalOrder() : Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}