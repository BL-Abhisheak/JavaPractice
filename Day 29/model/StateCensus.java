package com.census.model;

import com.opencsv.bean.CsvBindByName;

public class StateCensus {

    @CsvBindByName(column = "State", required = true)
    private String state;

    @CsvBindByName(column = "Population", required = true)
    private long population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    private double areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    private double densityPerSqKm;

    public StateCensus() {}

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public long getPopulation() { return population; }
    public void setPopulation(long population) { this.population = population; }

    public double getAreaInSqKm() { return areaInSqKm; }
    public void setAreaInSqKm(double areaInSqKm) { this.areaInSqKm = areaInSqKm; }

    public double getDensityPerSqKm() { return densityPerSqKm; }
    public void setDensityPerSqKm(double densityPerSqKm) { this.densityPerSqKm = densityPerSqKm; }

    @Override
    public String toString() {
        return "StateCensus{" +
                "state='" + state + '\'' +
                ", population=" + population +
                ", areaInSqKm=" + areaInSqKm +
                ", densityPerSqKm=" + densityPerSqKm +
                '}';
    }
}
