package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.designer.mapper.MapperMain;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.mapper.MapperComponent;
import org.talend.designer.mapper.external.data.ExternalMapperData;
import org.talend.designer.mapper.external.data.ExternalMapperTable;
import org.talend.designer.mapper.external.data.ExternalMapperTableEntry;
import org.talend.core.model.process.IConnection;
import org.talend.designer.mapper.language.ILanguage;
import org.talend.designer.mapper.language.generation.GenerationManagerFactory;
import org.talend.designer.mapper.language.generation.JavaGenerationManager;
import org.talend.designer.mapper.language.LanguageProvider;
import org.talend.core.model.metadata.types.JavaTypesManager;

public class TMapBeginJava
{
  protected static String nl;
  public static synchronized TMapBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapBeginJava result = new TMapBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "// ###############################" + NL + "// # Lookup's keys initialization";
  protected final String TEXT_3 = NL + NL + "org.talend.designer.components.commons.AdvancedLookup<";
  protected final String TEXT_4 = "Struct> tHash_Lookup_";
  protected final String TEXT_5 = " = (org.talend.designer.components.commons.AdvancedLookup<";
  protected final String TEXT_6 = "Struct>) globalMap.get( \"tHash_Lookup_";
  protected final String TEXT_7 = "\" );";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = "HashKey = new ";
  protected final String TEXT_11 = "();";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = "Default = new ";
  protected final String TEXT_15 = "();";
  protected final String TEXT_16 = NL + "// ###############################        " + NL + "" + NL + "// ###############################" + NL + "// # Vars initialization";
  protected final String TEXT_17 = NL + "class  ";
  protected final String TEXT_18 = "  {" + NL;
  protected final String TEXT_19 = "\t";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = ";" + NL;
  protected final String TEXT_22 = "}";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = " ";
  protected final String TEXT_25 = " = new ";
  protected final String TEXT_26 = "();";
  protected final String TEXT_27 = NL + "// ###############################" + NL + "" + NL + "// ###############################" + NL + "// # Outputs initialization";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = " ";
  protected final String TEXT_30 = "_tmp = new ";
  protected final String TEXT_31 = "();";
  protected final String TEXT_32 = NL + "// ###############################";
  protected final String TEXT_33 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	MapperComponent node = (MapperComponent) codeGenArgument.getArgument();
	boolean stats = codeGenArgument.isStatistics();
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ExternalMapperData data = (ExternalMapperData) node.getExternalData();
        List<ExternalMapperTable> varsTables = data.getVarsTables();
        ILanguage currentLanguage = LanguageProvider.getJavaLanguage();
        JavaGenerationManager gm = (JavaGenerationManager) GenerationManagerFactory.getInstance().getGenerationManager(currentLanguage);


    stringBuffer.append(TEXT_2);
    

        List<IConnection> inputConnections = (List<IConnection>) node.getIncomingConnections();

        HashMap<String, IConnection> hNameToConnection = new HashMap<String, IConnection>();
        for (IConnection connection : inputConnections) {
            hNameToConnection.put(connection.getName(), connection);
        }

        List<ExternalMapperTable> inputTablesList = new ArrayList<ExternalMapperTable>(data.getInputTables());
        int lstSizeInputs = inputTablesList.size();
        for (int i = 1; i < lstSizeInputs; i++) {
            ExternalMapperTable inputTable = (ExternalMapperTable) inputTablesList.get(i);
            String tableName = inputTable.getName();
            IConnection connection = hNameToConnection.get(tableName);
            if (connection == null) {
                continue;
            }
            List<ExternalMapperTableEntry> tableEntries = inputTable.getMetadataTableEntries();
            if (tableEntries == null) {
                continue;
            }
            String className = tableName + "Struct";

    stringBuffer.append(TEXT_3);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_15);
    
        }

    stringBuffer.append(TEXT_16);
    

        /////////////////////////////////////////////////////////////////////////
        gm.setVarsTables(varsTables);

        List<ExternalMapperTable> varTablesList = new ArrayList<ExternalMapperTable>(varsTables);

        // constants
        for (ExternalMapperTable table : varTablesList) {
            List<ExternalMapperTableEntry> tableEntries = table.getMetadataTableEntries();
            if (tableEntries == null) {
                continue;
            }
            String tableName = table.getName();
            
            String instanceVarName = tableName + "__" + node.getUniqueName();
            String className = instanceVarName + "__Struct";
            

    stringBuffer.append(TEXT_17);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_18);
    
            int lstSize = tableEntries.size();
            for (int i = 0; i < lstSize; i++) {
                ExternalMapperTableEntry varTableEntry = (ExternalMapperTableEntry) tableEntries.get(i);
                String javaType = varTableEntry.getType();


    stringBuffer.append(TEXT_19);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(javaType, varTableEntry.isNullable()) );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( varTableEntry.getName() );
    stringBuffer.append(TEXT_21);
    
            }

    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( instanceVarName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_26);
    
        }

    stringBuffer.append(TEXT_27);
    

		  List<IConnection> outputConnections = (List<IConnection>) node.getOutgoingConnections();
		  Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
        for (IConnection connection : outputConnections) {
		  		nameToOutputConnection.put(connection.getName(), connection);
		  }

        List<ExternalMapperTable> outputTablesList = new ArrayList<ExternalMapperTable>(data.getOutputTables());
        // constants
        for (ExternalMapperTable table : outputTablesList) {
        
            List<ExternalMapperTableEntry> tableEntries = table.getMetadataTableEntries();
            if (tableEntries == null || nameToOutputConnection.get(table.getName()) == null) {
                continue;
            }
            String tableName = table.getName();
            
            String instanceVarName = tableName + "__" + node.getUniqueName();
            String className = tableName + "Struct";
            

    stringBuffer.append(TEXT_28);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_31);
    
        }

    stringBuffer.append(TEXT_32);
    


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
