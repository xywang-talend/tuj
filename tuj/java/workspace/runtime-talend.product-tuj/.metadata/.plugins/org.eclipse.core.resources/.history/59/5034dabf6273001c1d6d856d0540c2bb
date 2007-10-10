package org.talend.designer.codegen.translators.common;

import org.talend.designer.codegen.config.NodesSubTree;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import java.util.List;
import java.util.Iterator;

public class Subprocess_footerJava
{
  protected static String nl;
  public static synchronized Subprocess_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Subprocess_footerJava result = new Subprocess_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = "Process();";
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = "Process();";
  protected final String TEXT_6 = NL + NL + "\t" + NL + "\t} catch(Exception e) {";
  protected final String TEXT_7 = NL + "\tthrow new TalendException(this, e, currentComponent);";
  protected final String TEXT_8 = "\t" + NL + "\t\tthrow new TalendException(this, e);";
  protected final String TEXT_9 = "\t\t" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	NodesSubTree subTree = (NodesSubTree) codeGenArgument.getArgument();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();

    stringBuffer.append(TEXT_1);
    
	// Calls for RUN BEFORE links
	for (String before : subTree.getBeforeSubProcesses()) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(before );
    stringBuffer.append(TEXT_3);
    
	}
	
	if (subTree.getRootNode().getProcess().getNodesOfType("tFlowMeterCatcher").size() > 0 
		&& subTree.getRootNode().getProcess().getNodesOfType("tFlowMeter").size() >0 ) {
		List<INode> metterCatchers = (List<INode>)subTree.getRootNode().getProcess().getNodesOfType("tFlowMeterCatcher");
		List<INode> metters = (List<INode>)subTree.getRootNode().getProcess().getNodesOfType("tFlowMeter");
		List<INode> nodes = (List<INode>)subTree.getNodes();
		
		boolean hasMetterProcess = false;
		for(INode tmp : nodes)
		{
			for(INode metter : metters)
			{
				if(tmp.getUniqueName().equals(metter.getUniqueName()))
				{
					hasMetterProcess = true;
					break;
				}
			}
			if(hasMetterProcess)
			{
				break;
			}
		}
		if(hasMetterProcess)
		{
			for (INode metterCatcher : metterCatchers) {
				

    stringBuffer.append(TEXT_4);
    stringBuffer.append(metterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_5);
          

			}
		}
	}

    stringBuffer.append(TEXT_6);
    
	if(isRunInMultiThread){

    stringBuffer.append(TEXT_7);
    
	}else{

    stringBuffer.append(TEXT_8);
    
	}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
