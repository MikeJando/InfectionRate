package GUI;

import Geographical.Country;
import Geographical.Countries;
import Geographical.CountryFactory;
import ReaderWriters.ApiReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class JavaFXDemo extends Application {

    Stage window;
    Scene scene;
    Button button;
    Text message;
    Text title;
    Text pop;
    Text hivNum;
    Text rate;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try
        {
            String URL = "https://ghoapi.azureedge.net/api/WHS9_86";
            String URL2 = "https://ghoapi.azureedge.net/api/HIV_0000000026?filter=Value%20ne%20null";
            String outFile1 = "popFile.txt";
            String outFile2 = "hivFile.txt";

            ApiReader api = new ApiReader();
            api.ApiRead(URL, outFile1); //Reads from API and creates the popFile.txt
            api.ApiRead(URL2, outFile2); //Reads from API and creates the hivFile.txt

            java.util.List<String[]> popList = ReaderWriters.FileReader.read(outFile1);
            java.util.List<String[]> numList = ReaderWriters.FileReader.read(outFile2);
            List<Country> cList = CountryFactory.create();

            CountryFactory.addPop(cList,popList);
            CountryFactory.addHivNum(cList,numList);

        window = primaryStage;
        window.setTitle("Percentage of New HIV Rates in the Americas");
        message = new Text("Please select a country from the menu below:");
        button = new Button("Calculate the chosen country's percentage of new HIV cases");
        title = new Text();
        pop = new Text();
        hivNum = new Text();
        rate = new Text();

        ChoiceBox<Countries> choiceBox = new ChoiceBox<>();

        choiceBox.getItems().setAll(Countries.values());

        button.setOnAction(e -> getChoice(choiceBox, cList));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(25,25, 25, 25));
        layout.getChildren().addAll(message, choiceBox, button, title, pop, hivNum, rate);

        scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

   private void getChoice(ChoiceBox<Countries> choiceBox, List<Country> cList)
   {
       int p = 0;
       int h = 0;
       double r = 0;

       for(int i = 0; i<cList.size();i++)
       {
           if(choiceBox.getValue().toString().equals(cList.get(i).getTitle()))
           {
               p = cList.get(i).getPopulation();
               h = cList.get(i).getHivNum();
               r = cList.get(i).getRate();
           }
       }
        title.setText("Country Name: " + choiceBox.getValue());
        pop.setText("Total Population: " + p);
        hivNum.setText("Number of new HIV cases: " + h);
        rate.setText("Percentage of new HIV cases: " +r +"%");
    }
}