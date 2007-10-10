package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.List;
import org.talend.designer.mapper.external.data.ExternalMapperData;
import org.talend.designer.mapper.external.data.ExternalMapperTable;
import org.talend.designer.mapper.external.data.ExternalMapperTableEntry;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.mapper.MapperComponent;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.INode;

public class TMapEndJava
{
  protected static String nl;
  public static synchronized TMapEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapEndJava result = new TMapEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "// ###############################" + NL + "// # Lookup hashes releasing";
  protected final String TEXT_3 = NL + "\tglobalMap.remove( \"tHash_";
  protected final String TEXT_4 = "\" );" + NL + "// ###############################        " + NL + "\t";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	MapperComponent node = (MapperComponent) codeGenArgument.getArgument();
	boolean stats = codeGenArgument.isStatistics();
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ExternalMapperData data = (ExternalMapperData) node.getExternalData();


		// Bug partially fixed, see bug:785	
        List<? extends INode> nodesOfType = node.getProcess().getNodesOfType("tFileList");
        boolean hasTFileList = nodesOfType.size() > 0;
        
        if(!hasTFileList) {

    stringBuffer.append(TEXT_2);
    

	        List<ExternalMapperTable> inputTablesList = new ArrayList<ExternalMapperTable>(data.getInputTables());
	        int lstSizeInputs = inputTablesList.size();
	        for (int i = 1; i < lstSizeInputs; i++) {
	            ExternalMapperTable inputTable = (ExternalMapperTable) inputTablesList.get(i);
	            List<ExternalMapperTableEntry> tableEntries = inputTable.getMetadataTableEntries();
	            if (tableEntries == null) {
	                continue;
	            }
	            String tableName = inputTable.getName();
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_4);
    
	        }
        }

    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
