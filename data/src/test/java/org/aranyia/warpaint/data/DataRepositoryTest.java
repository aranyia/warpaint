package org.aranyia.warpaint.data;

import org.aranyia.warpaint.data.model.PriceRecord;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(JUnit4.class)
public class DataRepositoryTest {

    private DataRepository dataRepository;

    @Test
    public void testCsvRepository() {
        this.dataRepository = new CsvDataRepository();

        final List<PriceRecord> priceRecords = dataRepository.getPriceRecords();

        Assert.assertThat(priceRecords, notNullValue());
    }
}
