package com.postcoder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "summaryline", "organisation", "buildingname", "premise", "street", "dependentlocality", "posttown", "county", "postcode" })
public class UkAddress extends IeAddress {

    private static final long serialVersionUID = -2897647240154914960L;

    private String buildingname;

    private String premise;

    private String dependentlocality;

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(final String buildingname) {
        this.buildingname = buildingname;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(final String premise) {
        this.premise = premise;
    }

    public String getDependentlocality() {
        return dependentlocality;
    }

    public void setDependentlocality(final String dependentlocality) {
        this.dependentlocality = dependentlocality;
    }

}
