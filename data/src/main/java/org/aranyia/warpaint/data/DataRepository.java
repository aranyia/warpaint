package org.aranyia.warpaint.data;

import org.aranyia.warpaint.data.model.PriceRecord;

import java.util.List;

public interface DataRepository {

    List<PriceRecord> getPriceRecords();
}
