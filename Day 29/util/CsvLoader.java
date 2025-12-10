package com.census.util;

import com.census.exception.CensusAnalyserException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvLoader {

    // very small validation helpers
    public static void ensureCsvFile(File f) throws CensusAnalyserException {
        if (!f.exists()) {
            throw new CensusAnalyserException("File not found: " + f.getPath(), CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        }
        if (!f.getName().toLowerCase().endsWith(".csv")) {
            throw new CensusAnalyserException("Invalid file type (expected .csv): " + f.getName(), CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
        }
    }

    public static void ensureDelimiterIsComma(File f) throws CensusAnalyserException {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String firstLine = br.readLine();
            if (firstLine == null) return; // empty file — let parsing handle it
            if (!firstLine.contains(",")) {
                throw new CensusAnalyserException("Invalid delimiter (expected comma).", CensusAnalyserException.ExceptionType.INVALID_DELIMITER);
            }
        } catch (IOException e) {
            throw new CensusAnalyserException("Unable to read file for delimiter check: " + e.getMessage(), CensusAnalyserException.ExceptionType.CSV_PARSE_ERROR);
        }
    }

    public static <T> List<T> loadCsvAsList(File file, Class<T> type, String[] expectedHeader) throws CensusAnalyserException {
        ensureCsvFile(file);
        ensureDelimiterIsComma(file);

        // header check (simple exact-match)
        if (expectedHeader != null && expectedHeader.length > 0) {
            try {
                String headerLine = Files.lines(file.toPath()).findFirst().orElse("");
                // trim whitespace and compare tokens
                String[] tokens = headerLine.split(",", -1);
                if (tokens.length < expectedHeader.length) {
                    throw new CensusAnalyserException("CSV header missing required columns", CensusAnalyserException.ExceptionType.INVALID_HEADER);
                }
                for (int i = 0; i < expectedHeader.length; i++) {
                    String got = tokens[i].trim();
                    String want = expectedHeader[i].trim();
                    if (!got.equalsIgnoreCase(want)) {
                        throw new CensusAnalyserException("CSV header mismatch. Expected '" + want + "' at position " + i + " but found '" + got + "'",
                                CensusAnalyserException.ExceptionType.INVALID_HEADER);
                    }
                }
            } catch (IOException e) {
                throw new CensusAnalyserException("Error reading header: " + e.getMessage(), CensusAnalyserException.ExceptionType.CSV_PARSE_ERROR);
            }
        }

        // Use OpenCSV to build CsvToBean and iterate
        try (Reader reader = new BufferedReader(new FileReader(file))) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(type)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withThrowExceptions(true) // propagate parse exceptions
                    .build();

            List<T> result = new ArrayList<>();
            Iterator<T> iterator = csvToBean.iterator(); // Iterator usage as required
            while (iterator.hasNext()) {
                result.add(iterator.next());
            }
            return result;
        } catch (RuntimeException re) {
            // OpenCSV throws runtime exceptions sometimes — map to our custom exception
            throw new CensusAnalyserException("CSV parsing error: " + re.getMessage(), CensusAnalyserException.ExceptionType.CSV_PARSE_ERROR);
        } catch (IOException ioe) {
            throw new CensusAnalyserException("I/O error while parsing CSV: " + ioe.getMessage(), CensusAnalyserException.ExceptionType.CSV_PARSE_ERROR);
        }
    }
}
