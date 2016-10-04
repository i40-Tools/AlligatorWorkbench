package controllers;

import main.DeductiveDB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.foo;

/**
 * Created by omar on 10/3/2016.
 */
public class OtheController extends Controller {


    public Result foo() {
       DeductiveDB deductiveDB = new DeductiveDB();

        try {
            deductiveDB.consultKB();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ok(foo.render("omar"));
    }
}
