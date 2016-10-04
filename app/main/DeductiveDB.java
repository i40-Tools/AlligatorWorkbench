package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jpl7.Query;
import org.jpl7.Term;

import util.ConfigManager;

/**
 * 
 * @author Irlan
 *
 */
public class DeductiveDB {

	private String extractedAttr;
	private String orignalText;
	public List<String> baseClass;
	public List<String> attrName;

	public DeductiveDB() {

	}

	/**
	 * Querying the knowledge base.
	 * 
	 * @throws Throwable
	 */
	public void consultKB() {

		// Queries prolog

		// Queries evalAMl.pl
		String evalAML = "consult('evalAML.pl')";
		System.out.println(evalAML + " " + (Query.hasSolution(evalAML) ? "succeeded" : "failed"));

		// Queries eval.
		String eval = "eval";
		Query.hasSolution(eval);

		// Queries writePredicates.
		String writeFiles = "writePredicates";
		Query.hasSolution(writeFiles);


	}

}
