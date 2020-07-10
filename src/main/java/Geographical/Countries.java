package Geographical;

public enum Countries
{
    ARG("Argentina"),
    BHS("Bahamas"),
    BLZ("Belize"),
    BOL("Bolivia"),
    BRA("Brazil"),
    BRB("Barbados"),
    CHL("Chile"),
    COL("Colombia"),
    CRI("Costa Rica"),
    CUB("Cuba"),
    DOM("Dominican Republic"),
    ECU("Ecuador"),
    GTM("Guatemala"),
    GUY("Guyana"),
    HND("Honduras"),
    HTI("Haiti"),
    JAM("Jamaica"),
    MEX("Mexico"),
    NIC("Nicaragua"),
    PAN("Panama"),
    PER("Peru"),
    PRY("Paraguay"),
    SLV("El Salvador"),
    SUR("Suriname"),
    URY("Uruguay");

    private final String title;

    Countries(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return this.title;
    }

    @Override
    public String toString() {
        return title;
    }

}