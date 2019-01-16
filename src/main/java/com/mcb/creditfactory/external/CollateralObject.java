package com.mcb.creditfactory.external;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CollateralObject {
    BigDecimal getValue();
    Short getYear();
    LocalDate getDate();
    CollateralType getType();
}
