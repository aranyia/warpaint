package org.aranyia.warpaint.app.service;

import org.aranyia.warpaint.data.CsvDataRepository;
import org.aranyia.warpaint.data.DataRepository;
import org.aranyia.warpaint.data.model.PriceRecord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(JUnit4.class)
public class DefaultPriceDataServiceTest {

    private PriceDataService priceDataService;

    @Before
    public void init() {
        final DataRepository dataRepository = new CsvDataRepository();
        this.priceDataService = new DefaultPriceDataService(dataRepository);
    }

    @Test
    public void testMonthEndClosePriceRecords() {
        final List<PriceRecord> priceRecords = priceDataService.getMonthEndClosePriceRecords();

        Assert.assertThat(priceRecords, notNullValue());
    }
}
