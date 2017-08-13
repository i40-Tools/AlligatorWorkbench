	package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;

import javax.script.ScriptException;

import groovy.lang.Script;
import util.ConfigManager;

/**
 * Main class of the Alligator project
 * 
 * @author Irlan
 * @author Omar
 * 
 */
public class AlligatorMain {

	private Files2Facts standardFiles = new Files2Facts();
	private Similar similar = new Similar();

	public static void main(String[] args) throws Throwable {
 
//	getresults("C:/Users/omar/Desktop/examples/run -6/");
//     	getresults2("C:/HeterogeneityExampleData/AutomationML/Single-Heterogeneity/"); 
//	getsize("C:/Users/omar/Desktop/examples/run -6/");
//		System.exit(0);

  //	getReport("C:/Users/omar/Desktop/examples/run -6/");
  //     System.exit(0);
		AlligatorMain main = new AlligatorMain();
		main.readConvertStandardFiles();
		main.generatePSLDataModel();
		main.executePSLAproach();

		// main.executeDatalogApproach();
		// main.integrate();
		// main.executePSLAproach();
		// main.integrate();

	}


	
	/**
	 * Models similar.txt in to GoldStandard format.
	 * @throws Exception 
	 */
	public void modelSimilar() throws Exception {
		similar.readFiles(ConfigManager.getFilePath(), ".ttl", ".rdf", ".owl");
		similar.convertSimilar();
	}

	/**
	 * Method that read standard files and convert then to RDF
	 * 
	 * @throws Exception
	 *             TODO create more specific exceptions
	 */
	public void readConvertStandardFiles() throws Exception {
		standardFiles.readFiles(ConfigManager.getFilePath(), ".aml", ".opcua", ".xml");
		standardFiles.convert2RDF();
		standardFiles = new Files2Facts();
		standardFiles.improveRDFOutputFormat();
		similar.readFiles(ConfigManager.getFilePath(), ".ttl", ".rdf", ".owl");
	}

	/**
	 * Generate the PSL datamodel out of the existing standard documents
	 * 
	 * @throws Exception
	 */
	public void generatePSLDataModel() throws Exception {
		ConfigManager.createDataPath();// creates folders if not there
		similar.generatePSLPredicates(ConfigManager.getFilePath());
	}



	public void executePSLAproach() throws IOException, ScriptException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, InstantiationException,
			groovy.util.ScriptException{
		// Needed to run the PSL rules part
		Script script = new Script() {
			@Override
			public Object run() {
				return null;
			}
		};
		try {
			script.evaluate(new File("app/pslApproach/KGAlignment.groovy"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}