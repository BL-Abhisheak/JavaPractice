package com.census.model;

import com.opencsv.bean.CsvBindByName;

public class StateCode {

    @CsvBindByName(column = "SrNo")
    private int srNo;

    @CsvBindByName(column = "StateName", required = true)
    private String stateName;

    @CsvBindByName(column = "StateCode", required = true)
    private String stateCode;

    public StateCode() {}

    public int getSrNo() { return srNo; }
    public void setSrNo(int srNo) { this.srNo = srNo; }

    public String getStateName() { return stateName; }
    public void setStateName(String stateName) { this.stateName = stateName; }

    public String getStateCode() { return stateCode; }
    public void setStateCode(String stateCode) { this.stateCode = stateCode; }

    @Override
    public String toString() {
        return "StateCode{" +
                "srNo=" + srNo +
                ", stateName='" + stateName + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
