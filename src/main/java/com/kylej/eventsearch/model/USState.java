package com.kylej.eventsearch.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum USState {

    AK("AK", "Alaska"),
    AL("AL", "Alabama"),
    AR("AR", "Arkansas"),
    AZ("AZ", "Arizona"),
    CA("CA", "California"),
    CO("CO", "Colorado"),
    CT("CT", "Connecticut"),
    DC("DC", "District of Columbia"),
    DE("DE", "Delaware"),
    FL("FL", "Florida"),
    GA("GA", "Georgia"),
    HI("HI", "Hawaii"),
    IA("IA", "Iowa"),
    ID("ID", "Idaho"),
    IL("IL", "Illinois"),
    IN("IN", "Indiana"),
    KS("KS", "Kansas"),
    KY("KY", "Kentucky"),
    LA("LA", "Louisiana"),
    MA("MA", "Massachusetts"),
    MD("MD", "Maryland"),
    ME("ME", "Maine"),
    MI("MI", "Michigan"),
    MN("MN", "Minnesota"),
    MO("MO", "Missouri"),
    MS("MS", "Mississippi"),
    MT("MT", "Montana"),
    NC("NC", "North Carolina"),
    ND("ND", "North Dakota"),
    NE("NE", "Nebraska"),
    NH("NH", "New Hampshire"),
    NJ("NJ", "New Jersey"),
    NM("NM", "New Mexico"),
    NV("NV", "Nevada"),
    NY("NY", "New York"),
    OH("OH", "Ohio"),
    OK("OK", "Oklahoma"),
    OR("OR", "Oregon"),
    PA("PA", "Pennsylvania"),
    PR("PR", "Puerto Rico"),
    RI("RI", "RhodeIsland"),
    SC("SC", "South Carolina"),
    SD("SD", "South Dakota"),
    TN("TN", "Tennessee"),
    TX("TX", "Texas"),
    UT("UT", "Utah"),
    VA("VA", "Virginia"),
    VT("VT", "Vermont"),
    WA("WA", "Washington"),
    WI("WI", "Wisconsin"),
    WV("WV", "West Virginia"),
    WY("WY", "Wyoming");

    private final String key;
    private final String value;
}
