package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

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


//        Files2Facts filesAMLInRDF = new Files2Facts();
//        try {
//
//            filesAMLInRDF.prologFilePath();
//            filesAMLInRDF.readFiles(ConfigManager.getFilePath(), ".aml");
//            filesAMLInRDF.convertRdf();
//            filesAMLInRDF.readFiles(ConfigManager.getFilePath(), ".ttl");
//            filesAMLInRDF.generateExtensionalDB(ConfigManager.getFilePath());
//
//            DeductiveDB deductiveDB = new DeductiveDB();
//            // formats the output.txt in java objects
//           deductiveDB.readWorkingDirectory();
//
//            deductiveDB.executeKB();
//            // formats the output.txt in java objects
//            deductiveDB.readOutput();
//            deductiveDB.consultKB();
//
//            Integration integ = new Integration();
//            integ.integrate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }

        return ok(index.render("Alligator Main Web"));

    }
}