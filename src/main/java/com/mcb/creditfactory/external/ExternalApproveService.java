package com.mcb.creditfactory.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
@Slf4j
public class ExternalApproveService {
    private static final LocalDate MIN_ASSESS_DATE = LocalDate.of(2017, Month.OCTOBER, 1);
    private static final int MIN_CAR_YEAR = 2000;
    private static final BigDecimal MIN_CAR_VALUE = BigDecimal.valueOf(1000000);
    private static final int MIN_PLANE_YEAR = 1991;
    private static final BigDecimal MIN_PLANE_VALUE = BigDecimal.valueOf(230000000);


    public int approve(CollateralObject object) {
        if (object.getDate() == null ||object.getYear() == null || object.getValue() == null || object.getType() == null) {
            return -1;
        }

        int code;
        switch (object.getType()) {
            case CAR: code = approveCar(object); break;
            case AIRPLANE: code = approvePlane(object); break;
            default: code = -100;
        }

        return code;
    }

    private int approveCar(CollateralObject object) {
        if (object.getYear() < MIN_CAR_YEAR) {
            return -10;
        }
        if (object.getDate().isBefore(MIN_ASSESS_DATE)) {
            return -11;
        }
        if (object.getValue().compareTo(MIN_CAR_VALUE) < 0) {
            return -12;
        }

        return 0;
    }

    private int approvePlane(CollateralObject object) {
        if (object.getYear() < MIN_PLANE_YEAR) {
            return -20;
        }
        if (object.getDate().isBefore(MIN_ASSESS_DATE)) {
            return -21;
        }
        if (object.getValue().compareTo(MIN_PLANE_VALUE) < 0) {
            return -22;
        }

        return 0;
    }
}
