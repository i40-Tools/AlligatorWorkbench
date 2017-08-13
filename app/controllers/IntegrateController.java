package controllers;

import org.apache.commons.io.IOUtils;
import play.mvc.Controller;
import play.mvc.Result;
import play.libs.*;

import util.ConfigManager;
import views.html.*;
import main.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static play.data.Form.form;

/**
 * Created by omar on 1/24/2017.
 */
public class IntegrateController extends Controller {

    public Result index() {

        return ok("<Caex><Dummy>changess from backend and backend and backend</Dummy></Caex>");

    }


    public Result index2(String id) throws Exception {

        String file1 = form().bindFromRequest().get("file1");
        String file2 = form().bindFromRequest().get("file2");
        String file3 = form().bindFromRequest().get("file3");
        String file4 = form().bindFromRequest().get("file4");

        File theDir = new File("c://Result");

// if the directory does not exist, create it
        if (!theDir.exists()) {
                theDir.mkdir();
        }
        else{
            PrintWriter writer = new PrintWriter("c:\\Result\\seed-0.aml", "UTF-8");
            writer.println(file1);
            writer.close();

            writer = new PrintWriter("c:\\Result\\seed-1.aml", "UTF-8");
            writer.println(file2);
            writer.close();
            writer.close();

            writer = new PrintWriter("c:\\Result\\PSL\\test\\GoldStandard.txt", "UTF-8");
            writer.println(file3);
            writer.close();
            writer.close();

        }



       Files2Facts standardFiles = new Files2Facts();
        Similar similar = new Similar();
        AlligatorMain main = new AlligatorMain();
        ConfigManager.filePath = "c://Result/";
        main.readConvertStandardFiles();
        main.generatePSLDataModel();
        main.executePSLAproach();

        String everything;
        try(FileInputStream inputStream = new FileInputStream("c://Result/PSL/test/graph.txt")) {
            everything = IOUtils.toString(inputStream);
            // do something with everything string
        }

        String everything2="<Accuracy>";
String line;

        BufferedReader br ;

        br = new BufferedReader(
                new FileReader(new File("c://Result/PSL/test/Precision/F1NoTraining.txt")));
        while ((line = br.readLine()) != null) {
            if (line.contains("Precision :")) {
                everything2+="<Precison>"+line.replace("Precision :", "")+"</Precison>";
            }
            if (line.contains("Recall:")) {
                everything2+="<Recall>"+line.replace("Recall:", "")+"</Recall>";;
            }
            if (line.contains("Fmeasure:")) {
                everything2+="<Fmeasure>"+line.replace("Fmeasure:", "")+"</Fmeasure>";;
            }

        }

        return ok(everything.replaceAll(" ","")+everything2+"</Accuracy></Result>");

    //    return ok(file2);
        // return ok("<Caex><Dummy>changess from backend and backendsssssss and backend"+receivedText+"</Dummy></Caex>");

    }


}
