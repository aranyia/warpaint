package org.aranyia.warpaint.app;

import org.aranyia.warpaint.data.CsvDataRepository;
import org.aranyia.warpaint.data.DataRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataRepositoryConfiguration {

    @Bean
    public DataRepository dataRepository() {
        return new CsvDataRepository();
    }
}
