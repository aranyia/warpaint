package org.aranyia.warpaint.app.web;

import org.aranyia.warpaint.api.PriceApi;
import org.aranyia.warpaint.api.model.Price;
import org.aranyia.warpaint.app.service.PriceDataService;
import org.aranyia.warpaint.data.model.PriceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@RestController
public class PriceController implements PriceApi {

    private final PriceDataService priceDataService;

    @Autowired
    public PriceController(PriceDataService priceDataService) {
        this.priceDataService = priceDataService;
    }

    @Override
    public ResponseEntity<List<Price>> prices() {
        final List<Price> prices =
                priceDataService.getMonthEndClosePriceRecords().stream()
                        .map(new PriceMapperFunction()).collect(toList());

        return ResponseEntity.ok(prices);
    }

    private static class PriceMapperFunction implements Function<PriceRecord, Price> {

        private static DateTimeFormatter priceDateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");

        @Override
        public Price apply(final PriceRecord priceRecord) {
            if (priceRecord == null) {
                return null;
            }
            final Price price = new Price();
            price.setClose(priceRecord.getClose());
            price.setDate(priceRecord.getDate().format(priceDateTimeFormatter));

            return price;
        }
    }
}
