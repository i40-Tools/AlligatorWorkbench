package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by omar on 1/24/2017.
 */
public class DataController extends Controller {

    public Result index() {

        return ok("<Caex><Dummy>changess from backend and backend and backend</Dummy></Caex>");

    }

}
