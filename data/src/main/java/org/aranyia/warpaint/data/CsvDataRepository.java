package org.aranyia.warpaint.data;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.aranyia.warpaint.data.csv.CsvPriceRecord;
import org.aranyia.warpaint.data.model.PriceRecord;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvDataRepository implements DataRepository {

    private static final String CSV_FILE = "SPY.csv";

    private final ObjectReader csvReader;

    public CsvDataRepository() {
        final CsvMapper mapper = new CsvMapper();
        final CsvSchema schema = mapper.schemaFor(CsvPriceRecord.class).withHeader().withStrictHeaders(true);
        csvReader = mapper.readerFor(CsvPriceRecord.class).with(schema);
    }

    public List<PriceRecord> getPriceRecords() {
        final ClassLoader classLoader = getClass().getClassLoader();

        try {
            final List<PriceRecord> records = new ArrayList<>();

            final MappingIterator<CsvPriceRecord> iterator = csvReader.readValues(classLoader.getResource(CSV_FILE));

            while (iterator.hasNext()) {
                records.add(csvToPriceRecord(iterator.next()));
            }
            return records;
        } catch (IOException ioException) {
            return Collections.emptyList();
        }
    }

    private PriceRecord csvToPriceRecord(final CsvPriceRecord csvRecord) {
        if (csvRecord == null) {
            return null;
        }

        final PriceRecord priceRecord = new PriceRecord();
        priceRecord.setDate(LocalDate.parse(csvRecord.date));
        priceRecord.setClose(csvRecord.close);

        return priceRecord;
    }
}
