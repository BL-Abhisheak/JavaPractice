package com.census.analyser;

import com.census.exception.CensusAnalyserException;
import com.census.model.StateCensus;
import com.census.model.StateCode;
import com.census.util.CsvLoader;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class StateCensusAnalyser {

    // store loaded census records and state codes
    private List<StateCensus> censusList = new ArrayList<>();
    private List<StateCode> stateCodes = new ArrayList<>();

    // expected headers for validation (order matters in this simple check)
    private static final String[] CENSUS_HEADER = {"State","Population","AreaInSqKm","DensityPerSqKm"};
    private static final String[] STATECODE_HEADER = {"SrNo","StateName","StateCode"};

    // UC1: load State Census CSV file
    public int  loadStateCensusData(String csvFilePath) throws CensusAnalyserException {
        File f = new File(csvFilePath);
        List<StateCensus> loaded = CsvLoader.loadCsvAsList(f, StateCensus.class, CENSUS_HEADER);
        if (loaded == null || loaded.isEmpty()) {
            throw new CensusAnalyserException("No census data loaded", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        // replace internal list
        this.censusList = loaded;
        return censusList.size();
    }

    // UC2: load State Code CSV file
    public int loadStateCodes(String csvFilePath) throws CensusAnalyserException {
        File f = new File(csvFilePath);
        List<StateCode> loaded = CsvLoader.loadCsvAsList(f, StateCode.class, STATECODE_HEADER);
        if (loaded == null || loaded.isEmpty()) {
            throw new CensusAnalyserException("No state code data loaded", CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        this.stateCodes = loaded;
        return stateCodes.size();
    }

    // utility: get loaded count
    public int getCensusRecordCount() {
        return censusList.size();
    }

    public int getStateCodeRecordCount() {
        return stateCodes.size();
    }

    // sort by comparator (generics)
    public <T> List<T> sortRecords(List<T> list, Comparator<? super T> comparator) {
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }

    // example specific sorts for census: sort by state name
    public List<StateCensus> getCensusSortedByStateName() {
        return sortRecords(censusList, Comparator.comparing(StateCensus::getState, String.CASE_INSENSITIVE_ORDER));
    }

    public List<StateCensus> getCensusSortedByPopulationDesc() {
        return sortRecords(censusList, Comparator.comparingLong(StateCensus::getPopulation).reversed());
    }

    // search by state name (case-insensitive)
    public Optional<StateCensus> searchStateCensusByName(String stateName) {
        if (stateName == null) return Optional.empty();
        return censusList.stream()
                .filter(c -> c.getState().equalsIgnoreCase(stateName.trim()))
                .findFirst();
    }

    // search in codes
    public Optional<StateCode> searchStateCodeByName(String stateName) {
        if (stateName == null) return Optional.empty();
        return stateCodes.stream()
                .filter(s -> s.getStateName().equalsIgnoreCase(stateName.trim()))
                .findFirst();
    }
}
