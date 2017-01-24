package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.libs.*;

import point.DeductiveDB;
import point.Files2Facts;
import util.ConfigManager;
import views.html.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by omar on 1/24/2017.
 */
public class IntegrateController extends Controller {

    public Result index() {

        return ok("<Caex><Dummy>This is dummy xml from backend</Dummy></Caex>");

    }

}
