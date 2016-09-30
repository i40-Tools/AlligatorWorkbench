package main;

import integration.Integration;
import start.DeductiveDB;
import start.Files2Facts;
import util.ConfigManager;

/**
 * Created by omar on 9/30/2016.
 */
public class AlligatorMain {

    public static void loadAll() {
        Files2Facts filesAMLInRDF = new Files2Facts();
        try {

            filesAMLInRDF.prologFilePath();
            filesAMLInRDF.readFiles(ConfigManager.getFilePath(), ".aml");
            filesAMLInRDF.convertRdf();
            filesAMLInRDF.readFiles(ConfigManager.getFilePath(), ".ttl");
            filesAMLInRDF.generateExtensionalDB(ConfigManager.getFilePath());
            DeductiveDB deductiveDB = new DeductiveDB();
            deductiveDB.consultKB();
            Integration integ = new Integration();
            integ.integrate();

        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}
