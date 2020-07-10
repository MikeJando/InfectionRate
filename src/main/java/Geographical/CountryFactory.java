package Geographical;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CountryFactory implements ReaderWriters.FileReader
{
    public static List<Country> create()
    {
        List<Country> cList = new ArrayList<>();

        Stream.of(Countries.values())
                .forEach(c -> cList.add(new Country(c.name(),c.getTitle())));

        return cList;
    }

    public static void addPop(List<Country> countries, List<String[]> strings)
    {
        countries.stream().forEach(c -> {
            strings.stream().forEach(s -> {
                if (c.getCode().equals(s[0]))
                    c.setPopulation(Integer.parseInt(s[1] )* 1000);
            });
        });
    }

    public static void addHivNum(List<Country> countries, List<String[]> strings)
    {
        countries.stream().forEach(c -> {
            strings.stream().forEach(s -> {
                if (c.getCode().equals(s[0]))
                    c.setHIVNum(Integer.parseInt(s[1]));
                c.setRate();

            });
        });
    }
}
