package com.popov.example.service.unit;

import com.popov.example.dto.CsvDTO;
import com.popov.example.service.CsvWriter;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class CsvWriterTest {

    private static String EXPECTED_FILENAME="Expected.csv";

    private static String ACTUAL_FILENAME="Actual.csv";

    private CsvWriter writer = new CsvWriter();

    private List<CsvDTO> data;

    @Before
    public void prepare() {
        data = new ArrayList<>();
        data.add(new CsvDTO("1522222200", "description", 270.1, 1056.1, 84.1));
        data.add(new CsvDTO("1522222210", "description2", 270.2, 1056.2, 84.2));
        data.add(new CsvDTO("1522222220", "description3", 270.3, 1056.3, 84.3));
    }

    @Test
    public void writeTestShouldCreateFile() throws Exception {
        writer.write(ACTUAL_FILENAME, data);
        File actual = new File(ACTUAL_FILENAME);
        assertTrue(actual.exists());
        File expected = new File(EXPECTED_FILENAME);
        Assert.assertEquals(FileUtils.readLines(actual, Charset.defaultCharset()),
                FileUtils.readLines(expected, Charset.defaultCharset()));
    }

    @After
    public void clear() {
        File file = new File(ACTUAL_FILENAME);
        file.delete();
    }

}
