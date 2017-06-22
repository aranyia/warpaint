package org.aranyia.warpaint.app.service;

import org.aranyia.warpaint.data.DataRepository;
import org.aranyia.warpaint.data.model.PriceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DefaultPriceDataService implements PriceDataService {

    private final DataRepository dataRepository;

    @Autowired
    public DefaultPriceDataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public List<PriceRecord> getMonthEndClosePriceRecords() {
        final List<PriceRecord> allPriceRecords = dataRepository.getPriceRecords();

        final List<PriceRecord> filteredPriceRecords = new LinkedList<>();

        int lastMonth = 0;
        for (int i = 0; i < allPriceRecords.size()-1; i++) {
            final PriceRecord record1 = allPriceRecords.get(i);
            final PriceRecord record2 = allPriceRecords.get(i+1);

            if (record2.getDate().getMonthValue() > record1.getDate().getMonthValue() ||
                    record2.getDate().getYear() > record1.getDate().getYear()) {
                filteredPriceRecords.add(record1);
                lastMonth = record1.getDate().getMonthValue();
            }
            if (i == allPriceRecords.size()-2 && lastMonth < record2.getDate().getMonthValue()) {
                filteredPriceRecords.add(record2);
            }
        }
        return filteredPriceRecords;
    }
}
