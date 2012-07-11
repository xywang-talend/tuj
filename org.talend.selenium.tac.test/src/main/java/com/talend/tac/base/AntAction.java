package com.talend.tac.base;

import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class AntAction {
	private File buildFile;
	private Project project = new Project();
	
	private void init(String file){
		buildFile = new File(file);
		
		Base base = new Base();
		String filePath = base.getAbsolutePath("org/talend/tac/folder/scripts/") + file;
		
		System.out.println("Path -- " + filePath);
		buildFile = new File(filePath);
		
//		System.out.println("Url -- " + this.getClass().getClassLoader().getResource(file).toString());
		project.setUserProperty("ant.file", buildFile.getAbsolutePath());
		DefaultLogger consoleLogger = new DefaultLogger();
		consoleLogger.setErrorPrintStream(System.err);
		consoleLogger.setOutputPrintStream(System.out);
		consoleLogger.setMessageOutputLevel(Project.MSG_INFO);
		project.addBuildListener(consoleLogger);
	}
	
	private void addProperties(Project project, Hashtable properties){
		Enumeration e = properties.keys();
		String key;
		while(e.hasMoreElements()) {
			key = (String)e.nextElement();
			project.setNewProperty(key, properties.get(key)+"");
//			System.out.println("------------" + key + ", " +(String)properties.get(key));
		}
		
	}
	
	private String getProperty(String propertyName){
		return project.getProperty(propertyName);
	}
	
	public void runTarget(String file, String target, Hashtable properties){
		this.init(file);
		try {
			project.fireBuildStarted();
			project.init();
			
			this.addProperties(project, properties);
			
			ProjectHelper helper = ProjectHelper.getProjectHelper();
			project.addReference("ant.projectHelper", helper);
			helper.parse(project, buildFile);
			
			if(target==null || "".equals(target)) {
				project.executeTarget(project.getDefaultTarget());
			} else {
				project.executeTarget(target);
			}
			
			project.fireBuildFinished(null);
		} catch (BuildException e) {
			project.fireBuildFinished(e);
		}
	}
	
	public void runTarget(String file, String target) {
		this.runTarget(file, target, new Hashtable());
	}
	
	public void runTarget(String file, Hashtable properties) {
		this.runTarget(file, null, properties);
	}
	
	public void runTarget(String file){
		this.runTarget(file, null, new Hashtable());
	}
	
	public String runTarget(String file, String target, Hashtable properties, String getPropertyName){
		this.runTarget(file, target, properties);
		return this.getProperty(getPropertyName);
	}

	public String runTarget(String file, String target, String getPropertyName ) {
		return this.runTarget(file, target, null, getPropertyName);
	}
	
	public String runTarget(String file, Hashtable properties, String getPropertyName) {
		return this.runTarget(file, null, properties, getPropertyName);
	}
}
