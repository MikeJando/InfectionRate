package ReaderWriters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface FileReader
{
    static List<String[]> read(String input) throws IOException
    {
        Path inPath = Paths.get("src", "main","resources",input).toAbsolutePath();

        Stream<String> countries = Files.lines(inPath);

        List<String[]> varList = countries.map(x -> x.split(","))
                .collect(Collectors.toList());
        return varList;
    }
}