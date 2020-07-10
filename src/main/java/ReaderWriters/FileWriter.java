package ReaderWriters;

import Geographical.Countries;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileWriter
{
    static void write(String word, String output) throws IOException
    {
        Path outPath = Paths.get("src", "main","resources",output).toAbsolutePath();

        File temp = new File(outPath.toString());

        if(!temp.exists())
        {
            BufferedWriter bwr = Files.newBufferedWriter(outPath);

            JSONArray lists = new JSONArray(word.substring(word.indexOf('[')));

            for (Countries c : Countries.values()) {
                for (int i = 0; i < lists.length(); i++) {
                    JSONObject list = lists.getJSONObject(i);

                    if(output.equals("popFile.txt")) {
                        if (c.name().equals(list.getString("SpatialDim"))) {
                            bwr.write(list.getString("SpatialDim") + ",");
                            bwr.write(list.getString("Value").replaceAll("\\s+", ""));
                            bwr.newLine();
                        }
                    }
                    else
                    {
                        if (c.name().equals(list.getString("SpatialDim")))
                        {
                            bwr.write(list.getString("SpatialDim") + ",");
                            bwr.write(list.getString("Value").replaceAll("\\s+", "").replaceAll("<", "").substring(0, list.getString("Value").indexOf("[") - 1).replace("[", ""));
                            bwr.newLine();
                        }
                    }
                }
            }
            bwr.flush();
            bwr.close();
        }
    }
}
