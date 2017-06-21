package org.aranyia.warpaint.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DataRepositoryTest {

    @Test
    public void testCsvRepository() {
        final CsvDataRepository dataRepsitory = new CsvDataRepository();

        dataRepsitory.getPriceRecords();
    }
}
