package controllers;

import integration.Integration;
import play.mvc.*;

import start.DeductiveDB;
import start.Files2Facts;
import util.ConfigManager;
import views.html.*;

import java.io.FileNotFoundException;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {



    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        Files2Facts filesAMLInRDF = new Files2Facts();
        try {
            filesAMLInRDF.prologFilePath();
            filesAMLInRDF.readFiles(ConfigManager.getFilePath(), ".aml");
            filesAMLInRDF.convertRdf();
            filesAMLInRDF.readFiles(ConfigManager.getFilePath(), ".ttl");
            filesAMLInRDF.generateExtensionalDB(ConfigManager.getFilePath());

            DeductiveDB db = new DeductiveDB();
            Integration integ = new Integration();
            try {
                integ.integrate();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok(index.render(ConfigManager.getFilePath()));
    }
    }
