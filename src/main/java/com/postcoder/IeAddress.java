package com.postcoder;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "summaryline", "organisation", "street", "posttown", "county", "postcode" })
public class IeAddress implements Serializable {

    private static final long serialVersionUID = 3812439164711716644L;

    private String summaryline;

    private String organisation;

    private String street;

    private String posttown;

    private String county;

    private String postcode;

    public String getSummaryline() {
        return summaryline;
    }

    public void setSummaryline(final String summaryline) {
        this.summaryline = summaryline;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(final String organisation) {
        this.organisation = organisation;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getPosttown() {
        return posttown;
    }

    public void setPosttown(final String posttown) {
        this.posttown = posttown;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(final String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }

}
