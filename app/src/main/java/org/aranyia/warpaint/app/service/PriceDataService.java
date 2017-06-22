package org.aranyia.warpaint.app.service;

import org.aranyia.warpaint.data.model.PriceRecord;

import java.util.List;

public interface PriceDataService {

    List<PriceRecord> getMonthEndClosePriceRecords();

}
