package com.popov.example.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.popov.example.dto.CsvDTO;
import lombok.Cleanup;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.invoke.MethodHandles;
import java.util.List;

@Component
public class CsvWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private CsvMapper csvMapper = new CsvMapper();
    private CsvSchema csvSchema = csvMapper
            .schemaFor(CsvDTO.class)
            .withHeader()
            .sortedBy("date","description","temp","pressure","humidity");

    public void write(@NonNull String fileName, @NonNull List<CsvDTO> data) {
        try {
            @Cleanup Writer writer = new PrintWriter(new FileWriter(fileName));
            doWrite(writer, data);
            LOGGER.debug("Successful write to .csv-file");
        } catch (IOException e) {
            LOGGER.error("Failed to write to .csv-file", e);
            throw new RuntimeException(e);
        }
    }

    private void doWrite(@NonNull Writer writer, @NonNull List<CsvDTO> data) throws IOException {
        csvMapper.writer().with(csvSchema).writeValues(writer).writeAll(data);
    }
}
