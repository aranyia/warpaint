package org.aranyia.warpaint.data.csv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Date", "Open", "High", "Low", "Close", "Adj Close", "Volume"})
public final class CsvPriceRecord {

    @JsonProperty("Date")
    public String date;

    @JsonProperty("Open")
    public Double open;

    @JsonProperty("High")
    public Double high;

    @JsonProperty("Low")
    public Double low;

    @JsonProperty("Close")
    public Double close;

    @JsonProperty("Adj Close")
    public Double adjClose;

    @JsonProperty("Volume")
    public Integer volume;

}
