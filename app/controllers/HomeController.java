package controllers;

import integration.Integration;
import play.mvc.*;

import main.DeductiveDB;
import views.html.*;

import java.io.File;
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




    DeductiveDB deductiveDB;
    public Result index() {
             deductiveDB = new DeductiveDB();

        try {
            deductiveDB.consultKB();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ok(index.render("omar"));
      }
    }
