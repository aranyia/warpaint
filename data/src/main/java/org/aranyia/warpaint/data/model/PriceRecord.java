package org.aranyia.warpaint.data.model;

import java.time.LocalDate;

public class PriceRecord {

    private LocalDate date;

    private double close;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }
}
