package Geographical;

public class Country
{
    private String code;
    private String title;
    private int population;
    private int hivNum;
    private double rate;

    public Country(String code, String title)
    {
        this.code = code;
        this.title = title;
    }

    public String getCode()
    {
        return this.code;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getPopulation()
    {
        return this.population;
    }

    public int getHivNum()
    {
        return hivNum;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public void setHIVNum(int hivNum)
    {
        this.hivNum = hivNum;
    }

    public void setRate()
    {
        this.rate = Math.round((((double) this.hivNum) / this.population * 100)*10000.0)/10000.0;
    }

    public double getRate()
    {
        return this.rate;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code +
                ", title='" + title +
                ", population=" + population +
                ", hivNum=" + hivNum +
                ", rate=" + rate +
                '}';
    }
}
