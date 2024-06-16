package fiveyearscodinginterview;

import java.text.SimpleDateFormat;
import java.util.*;

public class CarRental {
    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {
        List<RentalTime> sortedRentalTimes = new ArrayList<>(rentalTimes);
        sortedRentalTimes.sort(Comparator.comparing(RentalTime::getStart));

        Date previousEndTime = new Date(Long.MIN_VALUE);
        for (RentalTime rentalTime : sortedRentalTimes) {
            if (rentalTime.getStart().before(previousEndTime)) {
                return false;
            }
            previousEndTime = rentalTime.getEnd();
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

class RentalTime {
    private final Date start;
    private final Date end;

    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}