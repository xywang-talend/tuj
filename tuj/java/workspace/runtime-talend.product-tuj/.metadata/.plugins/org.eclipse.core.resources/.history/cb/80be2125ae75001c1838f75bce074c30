package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.commons.utils.generation.CodeGenerationUtils;
import org.talend.designer.mapper.MapperMain;
import org.talend.designer.mapper.MapperComponent;
import org.talend.designer.mapper.external.data.ExternalMapperData;
import org.talend.designer.mapper.external.data.ExternalMapperTable;
import org.talend.designer.mapper.external.data.ExternalMapperTableEntry;
import org.talend.designer.mapper.language.ILanguage;
import org.talend.designer.mapper.language.generation.GenerationManagerFactory;
import org.talend.designer.mapper.language.generation.JavaGenerationManager;
import org.talend.designer.mapper.language.generation.HashedMetadataTable;
import org.talend.designer.mapper.language.LanguageProvider;
import org.talend.designer.mapper.model.tableentry.TableEntryLocation;
import org.talend.designer.mapper.utils.DataMapExpressionParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.mapper.language.generation.TableType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.BlockCode;
import org.talend.core.model.process.IMatchingMode;

public class TMapMainJava
{
  protected static String nl;
  public static synchronized TMapMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMapMainJava result = new TMapMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t  boolean ";
  protected final String TEXT_2 = " = false;" + NL + "            \t\t\t\t    \t\t\t\t\t\t\t\t  " + NL + "\t\t";
  protected final String TEXT_3 = NL + "\t\t              " + NL + "\t\t\t   \t  \t\t  if(" + NL + " \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_4 = NL + " \t\t\t\t  \t\t  \t\t\t!(" + NL + " \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_5 = NL + " \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_6 = NL + " \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_7 = NL + " \t\t\t\t  \t\t  \t\t\t)" + NL + "  \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_8 = NL + "\t  \t  \t\t  \t\t\t\t) {" + NL + "\t\t      \t  \t\t\t\tcontinue;" + NL + "\t\t    \t\t  \t  \t   }" + NL + "\t\t    \t  \t  \t  " + NL + "\t\t\t\t \t  \t   ";
  protected final String TEXT_9 = NL + "                        " + NL + "                        \t";
  protected final String TEXT_10 = NL + "                          ";
  protected final String TEXT_11 = NL + "                            " + NL + "\t\t\t\t  \t\t";
  protected final String TEXT_12 = NL + "\t \t\t\t\t\t    boolean forceLoop";
  protected final String TEXT_13 = " = false;" + NL + "\t       \t\t  \t    \tint sizeResultsFromLookup_";
  protected final String TEXT_14 = " = -1;" + NL + "       \t\t  \t    \t";
  protected final String TEXT_15 = NL + "       \t\t  \t    \t" + NL + "       \t\t  \t    \t" + NL + "       \t\t  \t    \t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t  \t\t";
  protected final String TEXT_17 = NL + " \t\t\t\t\t\t\t\t\t java.util.List<";
  protected final String TEXT_18 = "> listFromLookup_";
  protected final String TEXT_19 = " = null;" + NL + " \t\t\t\t\t\t\t";
  protected final String TEXT_20 = NL + " \t\t\t\t\t\t\t\t\t ";
  protected final String TEXT_21 = " ";
  protected final String TEXT_22 = "ObjectFromLookup = null;" + NL + "                          " + NL + "\t\t           \t\t  \t    if(!";
  protected final String TEXT_23 = ")" + NL + "\t\t           \t\t  \t    { // G 20" + NL + "\t\t                          \t\t  ";
  protected final String TEXT_24 = "HashKey.hashCodeDirty = true;" + NL + "\t  \t\t\t\t\t\t\t\t\t  tHash_Lookup_";
  protected final String TEXT_25 = ".get( ";
  protected final String TEXT_26 = "HashKey );" + NL + "" + NL + "\t  \t\t\t\t\t\t\t\t\t  if(tHash_Lookup_";
  protected final String TEXT_27 = ".hasResult()) { // G 90" + NL + "  \t\t\t\t\t\t\t\t\t  " + NL + "  \t\t\t\t\t\t\t\t\t  \t\t" + NL + "  \t\t\t\t\t\t\t\t\t  " + NL + "  \t\t\t\t\t\t\t\t\t  \t\t";
  protected final String TEXT_28 = NL + "  \t\t\t\t\t\t\t\t\t  \t\t" + NL + "\t\t  \t\t\t\t\t\t\t\t\t  if(tHash_Lookup_";
  protected final String TEXT_29 = ".resultIsObject()) { // G 49" + NL + "\t\t  \t\t\t\t\t\t\t\t\t  " + NL + "\t\t  \t\t\t\t\t\t\t\t\t ";
  protected final String TEXT_30 = NL + "\t  \t\t\t\t\t\t\t\t\t  " + NL + "\t  \t\t\t\t\t\t\t\t\t\t  \t\t";
  protected final String TEXT_31 = "ObjectFromLookup = (";
  protected final String TEXT_32 = "Struct) tHash_Lookup_";
  protected final String TEXT_33 = ".getResultObject();" + NL + "" + NL + "  \t\t\t\t\t\t\t\t\t  \t";
  protected final String TEXT_34 = NL + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tsizeResultsFromLookup_";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = "ObjectFromLookup != null ? 1 : -1;" + NL + "\t  \t\t\t\t\t\t\t\t\t  " + NL + "\t\t  \t\t\t\t\t\t\t\t\t  } else { // G 49" + NL + "\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlistFromLookup_";
  protected final String TEXT_37 = " = (java.util.List<";
  protected final String TEXT_38 = ">) tHash_Lookup_";
  protected final String TEXT_39 = ".getResultList();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tsizeResultsFromLookup_";
  protected final String TEXT_40 = " = listFromLookup_";
  protected final String TEXT_41 = " != null ? listFromLookup_";
  protected final String TEXT_42 = ".size() : -1;" + NL + "\t  \t\t\t\t\t\t\t\t\t  " + NL + "\t  \t\t\t\t\t\t\t\t\t\t  }" + NL + "\t\t  \t\t\t\t\t\t\t\t ";
  protected final String TEXT_43 = NL + "\t\t  \t\t\t\t\t\t\t\t  " + NL + "\t\t  \t\t\t\t\t\t\t\t\t} // G 90" + NL + "\t\t  \t\t\t\t\t\t\t\t\telse { // G 91" + NL + "\t\t  \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t  \t\t\t\t\t\t\t\t\t\t  ";
  protected final String TEXT_45 = " = true;" + NL + "\t\t  \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t  \t\t\t\t\t\t\t\t\t\t\tforceLoop";
  protected final String TEXT_48 = " = true;" + NL + "\t  \t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t  \t\t\t\t\t\t\t\t\t\t} // G 91" + NL + "\t  \t\t\t\t\t\t\t\t" + NL + "\t\t\t           \t\t  \t  } // G 20" + NL + "\t\t\t           \t\t  \t  " + NL + "\t\t\t\t\t\t\t\t  ";
  protected final String TEXT_50 = NL + "\t\t\t           \t\t  \t    else { // G 21" + NL + "   \t\t\t\t\t\t\t\t\t\t forceLoop";
  protected final String TEXT_51 = " = true;" + NL + "\t\t\t           \t\t  \t    } // G 21" + NL + "                    \t\t  \t   ";
  protected final String TEXT_52 = NL + "\t\t\t\t           \t\t  \t   \tif(tHash_Lookup_";
  protected final String TEXT_53 = ".getCount(";
  protected final String TEXT_54 = "HashKey) > 1) {" + NL + "\t\t\t  \t\t\t\t\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t\t\t\t \t\tSystem.out.println(";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t\t\t\t\t\t \t}" + NL + "\t\t\t\t\t\t\t\t\t ";
  protected final String TEXT_57 = NL + "                    \t\t  \t " + NL + "\t\t                      \t boolean hasAtLeastOneValidLookup_";
  protected final String TEXT_58 = " = false;" + NL + "\t\t                      \t Object[] ";
  protected final String TEXT_59 = "Array = null;" + NL + "\t\t                      \t " + NL + "\t\t\t           \t\t  \t    if(!";
  protected final String TEXT_60 = ")" + NL + "\t\t\t           \t\t  \t    { // G 35" + NL + "   \t                 \t\t  \t \t";
  protected final String TEXT_61 = "Array = tHash_Lookup_";
  protected final String TEXT_62 = ".getResultArray();" + NL + "\t\t\t\t\t\t\t\t\t   " + NL + "\t\t\t\t\t\t\t\t\t\t   if(";
  protected final String TEXT_63 = "Array.length == 0) {" + NL + "\t\t\t  \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t  \t\t\t\t\t\t\t\t\t  ";
  protected final String TEXT_65 = " = true;" + NL + "\t\t\t  \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t  \t\t\t\t\t\t\t\t\t\tforceLoop";
  protected final String TEXT_67 = " = true;" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t} // G 35" + NL + "\t\t\t\t\t\t\t\t\t\telse { // G 36" + NL + "\t  \t\t\t\t\t\t\t\t\t\tforceLoop";
  protected final String TEXT_68 = " = true;" + NL + "\t\t\t\t\t\t\t\t\t\t} // G 36" + NL + "\t\t\t\t\t\t\t\t\t   sizeResultsFromLookup_";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = "Array != null ? ";
  protected final String TEXT_71 = "Array.length : -1;" + NL + "                    \t\t  \t ";
  protected final String TEXT_72 = NL + NL + "                    \t\t  \t  for(int i";
  protected final String TEXT_73 = " = 0; sizeResultsFromLookup_";
  protected final String TEXT_74 = " != -1 && i";
  protected final String TEXT_75 = " < sizeResultsFromLookup_";
  protected final String TEXT_76 = " || forceLoop";
  protected final String TEXT_77 = " ;i";
  protected final String TEXT_78 = "++) { " + NL + "" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_79 = NL + "                    \t\t  \t " + NL + "                    \t\t  \t ";
  protected final String TEXT_80 = "   " + NL + "                    \t\t  \t " + NL + "                    \t\t  \t    ";
  protected final String TEXT_81 = "Struct fromLookup_";
  protected final String TEXT_82 = " = null;" + NL + "\t\t                            ";
  protected final String TEXT_83 = "Struct ";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = "Default;" + NL + "\t\t\t\t\t\t\t\t\t\t " + NL + "\t\t                          \t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\t\t\t\t\t if(!forceLoop";
  protected final String TEXT_87 = ") { // G 46" + NL + "                    \t\t  \t    ";
  protected final String TEXT_88 = NL + "\t\t                          \t  " + NL + "\t\t                          \t\t" + NL + "\t\t                          \t\tif(";
  protected final String TEXT_89 = "ObjectFromLookup != null) {" + NL + "\t\t                          \t\t" + NL + "\t      \t              \t\t   \t   \t\tfromLookup_";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = "ObjectFromLookup;" + NL + "\t\t                    \t\t  \t    ";
  protected final String TEXT_92 = " = fromLookup_";
  protected final String TEXT_93 = ";" + NL + "\t\t\t  \t\t\t\t\t\t\t} " + NL + "\t\t\t  \t\t\t\t\t\t\t" + NL + "\t\t                          \t  ";
  protected final String TEXT_94 = NL + "\t\t\t  \t\t\t\t\t\t\telse if(listFromLookup_";
  protected final String TEXT_95 = " != null) {" + NL + "\t      \t              \t\t   \t   \t\tfromLookup_";
  protected final String TEXT_96 = " = listFromLookup_";
  protected final String TEXT_97 = ".get(i";
  protected final String TEXT_98 = ");" + NL + "\t\t                    \t\t  \t    ";
  protected final String TEXT_99 = " = fromLookup_";
  protected final String TEXT_100 = ";" + NL + "\t      \t              \t\t   \t\t}" + NL + "\t                    \t\t  \t ";
  protected final String TEXT_101 = "   " + NL + "      \t              \t\t   \t";
  protected final String TEXT_102 = NL + "      \t              \t\t   \t\tif(i";
  protected final String TEXT_103 = " < ";
  protected final String TEXT_104 = "Array.length) {" + NL + "      \t              \t\t   \t\t\tfromLookup_";
  protected final String TEXT_105 = " = (";
  protected final String TEXT_106 = "Struct) ";
  protected final String TEXT_107 = "Array[i";
  protected final String TEXT_108 = "];" + NL + "\t\t                    \t\t  \t    \t";
  protected final String TEXT_109 = " = fromLookup_";
  protected final String TEXT_110 = ";" + NL + "      \t              \t\t   \t\t}" + NL + "      \t              \t\t   \t";
  protected final String TEXT_111 = NL + "                    \t\t  \t    " + NL + "                    \t\t  \t  \t   ";
  protected final String TEXT_112 = NL + "                    \t\t  \t  \t\t" + NL + "                    \t\t  \t  \t\t" + NL + "\t\t\t\t\t\t\t   \t  \t\t  if( !";
  protected final String TEXT_113 = " && " + NL + "\t\t\t\t\t \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\t\t \t\t\t\t  \t\t  \t\t\t!(" + NL + "\t\t\t\t\t \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\t \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\t \t\t\t\t  \t\t  \t\t\t)" + NL + "\t\t\t\t\t  \t\t\t\t  \t\t  \t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t\t\t  \t  \t\t  \t\t\t) { // G 16" + NL + "                    \t\t  \t  \t\t  " + NL + "  \t\t                    \t\t  \t    \tfromLookup_";
  protected final String TEXT_119 = " = null;" + NL + "                    \t\t  \t  \t\t  \t\t" + NL + "\t  \t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t         \t            \t\t  \t  \t\t\t";
  protected final String TEXT_121 = " = true;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t\t  \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = "Default;" + NL + "\t\t\t\t  \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\t                    \t\t  \t   \tif(sizeResultsFromLookup_";
  protected final String TEXT_126 = " != -1 " + NL + "\t\t\t\t\t                    \t\t  \t   \t\t&& i";
  protected final String TEXT_127 = " == sizeResultsFromLookup_";
  protected final String TEXT_128 = " - 1 " + NL + "\t\t\t\t\t                    \t\t  \t   \t\t&& !hasAtLeastOneValidLookup_";
  protected final String TEXT_129 = ") " + NL + "\t\t\t\t\t                    \t\t  \t   \t{ // G 15" + NL + "\t\t\t     \t  \t            \t\t  \t  \t\t\t";
  protected final String TEXT_130 = " = true;" + NL + "\t\t\t\t\t                    \t\t  \t   \t} // G 15" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_131 = NL + "     \t               \t\t  \t  \t  } // G 16" + NL + "     \t               \t\t  \t  \t  ";
  protected final String TEXT_132 = NL + "\t\t\t                    \t\t  \t if(fromLookup_";
  protected final String TEXT_133 = " == null && !";
  protected final String TEXT_134 = ") " + NL + "\t\t\t                    \t\t  \t { // 17" + NL + "\t\t\t\t  \t\t\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t                    \t\t } // 17" + NL + "\t\t\t\t                    \t\t ";
  protected final String TEXT_135 = NL + "\t\t\t\t\t  \t\t\t\t\t\t\t\t// 17" + NL + "\t\t\t\t                    \t\t \telse if(!";
  protected final String TEXT_136 = ")" + NL + "\t\t\t\t                    \t\t \t{ // 18" + NL + "\t\t\t\t\t                    \t   \thasAtLeastOneValidLookup_";
  protected final String TEXT_137 = " = true;" + NL + "\t\t\t\t\t                    \t\t} // 18" + NL + "\t\t\t\t                    \t\t ";
  protected final String TEXT_138 = "\t" + NL + "     \t               \t\t  \t  \t  ";
  protected final String TEXT_139 = NL + "     \t               \t\t  \t  \t  " + NL + "                    \t\t  \t  \t\t  " + NL + "\t                    \t\t  \t   ";
  protected final String TEXT_140 = "\t" + NL + "\t                    \t\t  \t" + NL + "\t\t                        ";
  protected final String TEXT_141 = NL + "\t                    \t\t  \t} // G 46" + NL + "\t                    \t\t  \t" + NL + "\t\t\t\t\t\t\t\t\t \tforceLoop";
  protected final String TEXT_142 = " = false;" + NL + "\t\t\t\t\t\t\t\t\t \t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t                    \t\t  \t" + NL + "\t  \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_144 = NL;
  protected final String TEXT_145 = NL + "\t";
  protected final String TEXT_146 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    


	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	MapperComponent node = (MapperComponent) codeGenArgument.getArgument();
	boolean stats = codeGenArgument.isStatistics(); 

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
        ILanguage currentLanguage = LanguageProvider.getJavaLanguage();
        
        List<IConnection> inputConnections = (List<IConnection>) node.getIncomingConnections();
        List<IConnection> outputConnections = (List<IConnection>) node.getOutgoingConnections();
        ExternalMapperData data = (ExternalMapperData) node.getExternalData();
        String uniqueNameComponent = node.getUniqueName();
        boolean checkingSyntax = codeGenArgument.isCheckingSyntax();

        String cr = "\n";
        String rejected = "rejected_" + uniqueNameComponent;
        String rejectedInnerJoin = "rejectedInnerJoin_" + uniqueNameComponent;

        List<ExternalMapperTable> inputTables = data.getInputTables();
        List<ExternalMapperTable> varsTables = data.getVarsTables();
        List<ExternalMapperTable> outputTables = data.getOutputTables();

        int indent = 1;

        DataMapExpressionParser expressionParser = new DataMapExpressionParser(currentLanguage);

        JavaGenerationManager gm = (JavaGenerationManager) node.getGenerationManager();

        StringBuilder sb = new StringBuilder();

        gm.setInputTables(inputTables);
        gm.setVarsTables(varsTables);

        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // INPUTS : initialization of input arrays from expressions keys and hashes
        // 
        sb.append(cr + gm.indent(indent));
        sb.append(cr + gm.indent(indent) + "// ###############################");
        sb.append(cr + gm.indent(indent) + "// # Input tables (lookups)");

        HashMap<String, IConnection> hNameToConnection = new HashMap<String, IConnection>();
        for (IConnection connection : inputConnections) {
            hNameToConnection.put(connection.getName(), connection);
        }

        ArrayList<ExternalMapperTable> inputTablesWithInnerJoin = new ArrayList<ExternalMapperTable>();
        ArrayList<ExternalMapperTable> lookupTables = new ArrayList<ExternalMapperTable>();
        boolean hasValidLookupTables = false;

		  int closeBracketCounter = 0;
		
    stringBuffer.append(TEXT_1);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_2);
    

        HashMap<String, ExternalMapperTableEntry> hExternalInputTableEntries = new HashMap<String, ExternalMapperTableEntry>();
        for (ExternalMapperTable externalTable : inputTables) {
            String tableName = externalTable.getName();
            IConnection connection = hNameToConnection.get(tableName);
            if (connection == null) {
                continue;
            }
            EConnectionType connectionType = connection.getLineStyle();
            if (connectionType == EConnectionType.FLOW_MAIN) {
            
			  	  	   if(externalTable.isActivateExpressionFilter() && externalTable.getExpressionFilter() != null && !externalTable.getExpressionFilter().trim().equals("")) { 

		                String key = CodeGenerationUtils.buildProblemKey(uniqueNameComponent,
   	                     JavaGenerationManager.PROBLEM_KEY_FIELD.FILTER.toString(), tableName);
					  	  	 
    stringBuffer.append(TEXT_3);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaStartFieldKey(key) : "" );
    stringBuffer.append(TEXT_4);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_5);
    stringBuffer.append( externalTable.getExpressionFilter());
    stringBuffer.append(TEXT_6);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_7);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaEndFieldKey(key) : "" );
    stringBuffer.append(TEXT_8);
    
			 	  	   }
                  continue;
                  
            } else if (connectionType == EConnectionType.FLOW_REF) {

                IMetadataTable metadataTable = connection.getMetadataTable();
                if (externalTable != null) {
                    if (externalTable.isInnerJoin()) {
                        inputTablesWithInnerJoin.add(externalTable);
                    }
                    lookupTables.add(externalTable);
                    hExternalInputTableEntries.clear();
                    List<ExternalMapperTableEntry> metadataTableEntries = externalTable.getMetadataTableEntries();
                    if (metadataTableEntries == null) {
                        continue;
                    }
                    for (ExternalMapperTableEntry externalTableEntry : metadataTableEntries) {
                        hExternalInputTableEntries.put(externalTableEntry.getName(), externalTableEntry);
                    }
                    List<IMetadataColumn> listColumns = metadataTable.getListColumns();
                    ArrayList<String> keysNames = new ArrayList<String>();
                    ArrayList<String> keysValues = new ArrayList<String>();
                    for (IMetadataColumn column : listColumns) {
                        String columnName = column.getLabel();
                        ExternalMapperTableEntry externalInputTableEntry = hExternalInputTableEntries.get(columnName);
                        if (externalInputTableEntry != null) {
                            String expressionKey = externalInputTableEntry.getExpression();
                            if (expressionKey != null && !"".equals(expressionKey.trim())) {
                                keysNames.add(columnName);
                                keysValues.add(expressionKey);
                            }
                        }
                    }
                    String[] aKeysNames = keysNames.toArray(new String[0]);
                    String[] aKeysValues = keysValues.toArray(new String[0]);
    		           
    		        String className = tableName + "Struct";

                    hasValidLookupTables = true;
                    
                    if (aKeysValues.length > 0 || checkingSyntax) {
                        sb.append(cr
                                + gm.buildLookupDataInstance(uniqueNameComponent, tableName, aKeysNames, aKeysValues,
                                        indent, checkingSyntax));
                        
    stringBuffer.append(TEXT_9);
    stringBuffer.append( sb.toString());
    stringBuffer.append(TEXT_10);
     
                     }


                     sb = new StringBuilder();
                     String matchingMode = externalTable.getMatchingMode();
					if(matchingMode == null) {
						if(aKeysValues.length > 0) {
							matchingMode = "UNIQUE_MATCH";
						} else {
							matchingMode = "ALL_ROWS";
						}
					}
                     boolean isMultipleResultMode = matchingMode.equals("ALL_ROWS") || matchingMode.equals("ALL_MATCHES");
                     
    stringBuffer.append(TEXT_11);
    if(isMultipleResultMode) { // T 55 
    stringBuffer.append(TEXT_12);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_14);
     } // T 55 
    stringBuffer.append(TEXT_15);
    
                        if(aKeysValues.length > 0) { // T 1
                        
    stringBuffer.append(TEXT_16);
    if(isMultipleResultMode) { // T 80 
    stringBuffer.append(TEXT_17);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_19);
     } // T 80 
    stringBuffer.append(TEXT_20);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_27);
    if(isMultipleResultMode) { // T 50 
    stringBuffer.append(TEXT_28);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_29);
     } // T 50 
    stringBuffer.append(TEXT_30);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_33);
    if(isMultipleResultMode) { // T 51 
    stringBuffer.append(TEXT_34);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_42);
     } // T 51 
		  								 
    stringBuffer.append(TEXT_43);
    
		  										if(externalTable.isInnerJoin()) {
		  										
    stringBuffer.append(TEXT_44);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_45);
    
	  											}
	  											
    stringBuffer.append(TEXT_46);
    if(isMultipleResultMode) { // T 56 
    stringBuffer.append(TEXT_47);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_48);
     } // T 56 
    stringBuffer.append(TEXT_49);
    if(isMultipleResultMode) { // T 57 
    stringBuffer.append(TEXT_50);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_51);
    
                    		  	   } // T 57

				           		  	  if(matchingMode.equals("UNIQUE_MATCH")) { // T 52 
				           		  	  
    stringBuffer.append(TEXT_52);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_54);
    
			  								StringBuilder sbMoreOneResult = new StringBuilder("\"WARNING: UNIQUE MATCH is configured for the lookup '"+ tableName +"' and it contains more one result from keys : ");
			  								for(int iKeys = 0; iKeys < aKeysNames.length; iKeys++) {
			  									if(iKeys > 0) {
					  								sbMoreOneResult.append(",");
			  								 	}
				  								sbMoreOneResult.append( " " + tableName + "."+ aKeysNames[iKeys] + " = '\" + " + tableName + "HashKey."+ aKeysNames[iKeys] + " + \"'");
									 		}
			  								sbMoreOneResult.append( "\"");
									 		
    stringBuffer.append(TEXT_55);
    stringBuffer.append( sbMoreOneResult.toString());
    stringBuffer.append(TEXT_56);
     
									 } // T 52 
                    		  	 } // T 1 
                    		  	 else { // T 2
                    		  	 
    stringBuffer.append(TEXT_57);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_63);
    
			  									if(externalTable.isInnerJoin()) {
			  									
    stringBuffer.append(TEXT_64);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_65);
    
		  										}
		  										
    stringBuffer.append(TEXT_66);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_71);
    
                    		  	 } // T 2
                    		  	
                    		  	if(isMultipleResultMode) { // T 60
                    		  	 
    stringBuffer.append(TEXT_72);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_77);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_78);
    
										gm.addBlocksCodeToClose(new BlockCode("close loop of lookup '" + tableName +"'"));
									  	
    stringBuffer.append(TEXT_79);
     } // T 60 
    stringBuffer.append(TEXT_80);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_85);
    if(isMultipleResultMode) { // T 69 
    stringBuffer.append(TEXT_86);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_87);
    
                    		  	    } // T 69
                    		  	    
		                          	if(aKeysValues.length > 0) { // T 10
		                          	
    stringBuffer.append(TEXT_88);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_93);
    if(isMultipleResultMode) { // 61 
    stringBuffer.append(TEXT_94);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_100);
     } // 61 
    stringBuffer.append(TEXT_101);
    
      	              		   	} // T 10
      	              		   	else { // T 11
      	              		   	
    stringBuffer.append(TEXT_102);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_110);
    
      	              		   	} // T 11
                    		  	    	
    stringBuffer.append(TEXT_111);
    
                    		  	  	   if(
                    		  	  	   		(externalTable.isInnerJoin() || matchingMode.equals("ALL_ROWS"))
                    		  	  	   		&& externalTable.isActivateExpressionFilter() 
                    		  	  	   		&& externalTable.getExpressionFilter() != null 
                    		  	  	   		&& !externalTable.getExpressionFilter().trim().equals("")
                    		  	  	   ) { // 12 
                    		  	  	   		
							                String key = CodeGenerationUtils.buildProblemKey(uniqueNameComponent,
			   		                     JavaGenerationManager.PROBLEM_KEY_FIELD.FILTER.toString(), tableName);
                    		  	  	   
    stringBuffer.append(TEXT_112);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaStartFieldKey(key) : "" );
    stringBuffer.append(TEXT_114);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_115);
    stringBuffer.append( externalTable.getExpressionFilter());
    stringBuffer.append(TEXT_116);
    // keep this line to allow comments in filter 
    stringBuffer.append(TEXT_117);
    stringBuffer.append( checkingSyntax ? CodeGenerationUtils.buildJavaEndFieldKey(key) : "" );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_119);
    
				  									if(externalTable.isInnerJoin() && aKeysValues.length > 0) {
				  									
    stringBuffer.append(TEXT_120);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_121);
    
				  									} else if(externalTable.isInnerJoin() && aKeysValues.length > 0){
				  									
    stringBuffer.append(TEXT_122);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_124);
    
				  									} else if(externalTable.isInnerJoin() && aKeysValues.length == 0){
				  									
    stringBuffer.append(TEXT_125);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_130);
    
				  									}
				  									
    stringBuffer.append(TEXT_131);
    
    	               		  	  	  if(aKeysValues.length == 0){
     	               		  	  	  
    stringBuffer.append(TEXT_132);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_134);
    
			  									 if(externalTable.isInnerJoin()) {
					  							 
    stringBuffer.append(TEXT_135);
    stringBuffer.append( rejectedInnerJoin );
    stringBuffer.append(TEXT_136);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_137);
    
				                    		 }
				                    		 
    stringBuffer.append(TEXT_138);
    
     	               		  	  	  }
     	               		  	  	  
    stringBuffer.append(TEXT_139);
    
	                    		  	   } // T 12
	                    		  	   
	                    		  	
    stringBuffer.append(TEXT_140);
    if(isMultipleResultMode) { // T 70 
    stringBuffer.append(TEXT_141);
    stringBuffer.append( tableName );
    stringBuffer.append(TEXT_142);
     } // T 70 
    stringBuffer.append(TEXT_143);
    
                } // if(externalTable != null) {
            } // else if(connectionType == EConnectionType.FLOW_REF) {
        } // for (ExternalMapperTable externalTable : inputTables) {
        boolean atLeastOneInputTableWithInnerJoin = !inputTablesWithInnerJoin.isEmpty();

        sb.append(cr);

        sb.append(cr + gm.indent(indent) + "// ###############################");
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // VARIABLES
        // 
        sb.append(cr);
        sb.append(cr + gm.indent(indent) + "{ // start of Var scope");
        indent++;
        sb.append(cr);
        sb.append(cr + gm.indent(indent) + "// ###############################");
        sb.append(cr + gm.indent(indent) + "// # Vars tables");
        for (ExternalMapperTable varsTable : varsTables) {
            List<ExternalMapperTableEntry> varsTableEntries = varsTable.getMetadataTableEntries();
            if (varsTableEntries == null) {
                continue;
            }
            String varsTableName = varsTable.getName();
            String instanceVarName = varsTableName + "__" + uniqueNameComponent;
            String className = instanceVarName + "__Struct";

            sb.append(cr + gm.indent(indent) + className + " " + varsTableName + " = " + instanceVarName + ";");
            for (ExternalMapperTableEntry varsTableEntry : varsTableEntries) {
                String varsColumnName = varsTableEntry.getName();
                String varExpression = varsTableEntry.getExpression();
                if (varExpression == null || varExpression.trim().length() == 0) {
                    varExpression = JavaTypesManager.getDefaultValueFromJavaIdType(varsTableEntry.getType(),
                            varsTableEntry.isNullable());
                }
                TableEntryLocation[] entryLocations = expressionParser.parseTableEntryLocations(varExpression);
                ArrayList<TableEntryLocation> listCoupleForAddTablePrefix = new ArrayList<TableEntryLocation>();
                for (TableEntryLocation location : entryLocations) {
                    if (gm.isInputTable(varExpression)) {
                        listCoupleForAddTablePrefix.add(location);
                    }
                }

                String key = CodeGenerationUtils.buildProblemKey(uniqueNameComponent,
                        JavaGenerationManager.PROBLEM_KEY_FIELD.METADATA_COLUMN.toString(), varsTableName,
                        varsColumnName);

                if (checkingSyntax) {
                    sb.append(cr).append(CodeGenerationUtils.buildJavaStartFieldKey(key));
                }

                String expression = gm.indent(indent)
                        + gm.getGeneratedCodeTableColumnVariable(uniqueNameComponent, varsTableName, varsColumnName, false) + " = " + varExpression
                        + ";";
                sb.append(cr).append(expression);

                if (checkingSyntax) {
                    sb.append(cr).append(CodeGenerationUtils.buildJavaEndFieldKey(key));
                }

            }
        }
        sb.append(cr + gm.indent(indent) + "// ###############################");
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////

        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////
        // OUTPUTS
        // 
        sb.append(cr + gm.indent(indent));
        sb.append(cr + gm.indent(indent) + "// ###############################");
        sb.append(cr + gm.indent(indent) + "// # Output tables");

        ArrayList<ExternalMapperTable> outputTablesSortedByReject = new ArrayList<ExternalMapperTable>(outputTables);
        // sorting outputs : rejects tables after not rejects table
        Collections.sort(outputTablesSortedByReject, new Comparator<ExternalMapperTable>() {

            public int compare(ExternalMapperTable o1, ExternalMapperTable o2) {
                if (o1.isReject() != o2.isReject()) {
                    if (o1.isReject()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                if (o1.isRejectInnerJoin() != o2.isRejectInnerJoin()) {
                    if (o1.isRejectInnerJoin()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return 0;
            }

        });

        boolean lastValueReject = false;
        boolean oneFilterForNotRejectTable = false;
        boolean allNotRejectTablesHaveFilter = true;
        boolean atLeastOneReject = false;
        boolean atLeastOneRejectInnerJoin = false;
        boolean closeTestInnerJoinConditionsBracket = false;

        Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
        for (IConnection outputConnection : outputConnections) {
            nameToOutputConnection.put(outputConnection.getName(), outputConnection);
        }

        int lstSizeOutputs = outputTablesSortedByReject.size();
        // ///////////////////////////////////////////////////////////////////
        // init of allNotRejectTablesHaveFilter and atLeastOneReject
        String lastValidOutputTableName = null;
        for (int i = 0; i < lstSizeOutputs; i++) {
            ExternalMapperTable outputTable = (ExternalMapperTable) outputTablesSortedByReject.get(i);

            String outputTableName = outputTable.getName();

            if (outputTable.isRejectInnerJoin()) {
                atLeastOneRejectInnerJoin = true;
            }
            List<ExternalMapperTableEntry> columnsEntries = outputTable.getMetadataTableEntries();
            List<ExternalMapperTableEntry> filters = outputTable.getConstraintTableEntries();
            boolean hasFilter = filters != null && filters.size() > 0 && !gm.checkFiltersAreEmpty(outputTable) 
            	|| outputTable.isActivateExpressionFilter() && outputTable.getExpressionFilter() != null && !outputTable.getExpressionFilter().trim().equals("");
            if (columnsEntries != null && columnsEntries.size() > 0) {
                if (!hasFilter && !(outputTable.isReject() || outputTable.isRejectInnerJoin())) {
                    allNotRejectTablesHaveFilter = false;
                }
                if (outputTable.isReject()) {
                    atLeastOneReject = true;
                }
            }

			IConnection outputConnection = nameToOutputConnection.get(outputTableName);
            if (outputConnection != null) {
                sb.append(cr + gm.indent(indent) + outputTableName + " = null;");
            }
                if(checkingSyntax 
                || !checkingSyntax && outputConnection != null) {
	            	lastValidOutputTableName = outputTableName;
	            }

        }
        // ///////////////////////////////////////////////////////////////////

		// System.out.println(uniqueNameComponent + " lastValidOutputTableName="+lastValidOutputTableName);

        sb.append(cr);

        if (allNotRejectTablesHaveFilter && atLeastOneReject) {
            // write rejected = false;
            sb.append(cr + gm.indent(indent) + "boolean " + rejected + " = true;");
        }

        // write conditions for inner join reject
        if (lastValidOutputTableName != null && hasValidLookupTables && lstSizeOutputs > 0 && atLeastOneInputTableWithInnerJoin) {
            sb.append(cr + gm.indent(indent) + "if(");
            sb.append("!" + rejectedInnerJoin);
            sb.append(" ) {");
            closeTestInnerJoinConditionsBracket = true;
            indent++;
        }

        // ///////////////////////////////////////////////////////////////////
        // run through output tables list for generating intilization of outputs arrays
        int dummyVarCounter = 0;
        for (int indexCurrentTable = 0; indexCurrentTable < lstSizeOutputs; indexCurrentTable++) {
            ExternalMapperTable outputTable = (ExternalMapperTable) outputTablesSortedByReject.get(indexCurrentTable);
            List<ExternalMapperTableEntry> outputTableEntries = outputTable.getMetadataTableEntries();
            String outputTableName = outputTable.getName();
            boolean connectionExists = true;
            IConnection outputConnection = nameToOutputConnection.get(outputTableName);
            HashedMetadataTable hashedMetadataTable = null;
            if (outputTableEntries == null || outputConnection == null) {
                connectionExists = false;
            } else {
            	hashedMetadataTable = new HashedMetadataTable(outputConnection.getMetadataTable());
            }

			// System.out.println("Output table: (1)" + outputTableName);

            List<ExternalMapperTableEntry> filters = outputTable.getConstraintTableEntries();

            boolean currentIsReject = outputTable.isReject();
            boolean currentIsRejectInnerJoin = outputTable.isRejectInnerJoin();

            boolean hasFilters = filters != null && filters.size() > 0 && !gm.checkFiltersAreEmpty(outputTable);
            boolean hasExpressionFilter = outputTable.isActivateExpressionFilter() && outputTable.getExpressionFilter() != null && !outputTable.getExpressionFilter().trim().equals("");

            boolean rejectValueHasJustChanged = lastValueReject != (currentIsReject || currentIsRejectInnerJoin);

            oneFilterForNotRejectTable = !(currentIsReject || currentIsRejectInnerJoin) && (hasFilters || hasExpressionFilter);

            if (rejectValueHasJustChanged) {

                if (closeTestInnerJoinConditionsBracket) {
                    indent--;
                    sb.append(cr + gm.indent(indent) + "} // closing inner join bracket (1)");
                    if (atLeastOneReject && allNotRejectTablesHaveFilter) {
                        sb.append(cr + " else {");
                        indent++;
                        sb.append(cr + gm.indent(indent) + rejected + " = false;");
                        indent--;
                        sb.append(cr + gm.indent(indent) + "} // closing else inner join bracket (1)");
                    }
                    closeTestInnerJoinConditionsBracket = false;
                }
            }

            // No connection matching and no checking errors
            if (connectionExists || checkingSyntax) {
	            if (rejectValueHasJustChanged) {
	                sb.append(cr + gm.indent(indent) + "// ###### START REJECTS ##### ");
	            }

	            // write filters conditions and code to execute
	            if (!currentIsReject && !currentIsRejectInnerJoin || rejectValueHasJustChanged
	                    && oneFilterForNotRejectTable || currentIsReject && allNotRejectTablesHaveFilter
	                    || currentIsRejectInnerJoin && atLeastOneInputTableWithInnerJoin || checkingSyntax) {

	                boolean closeFilterOrRejectBracket = false;
	                if (currentIsReject || currentIsRejectInnerJoin) {
	                    sb.append(cr + cr + gm.indent(indent) + "// # Output reject table : '" + outputTableName + "'");
	                } else {
	                    sb.append(cr + cr + gm.indent(indent) + "// # Output table : '" + outputTableName + "'");
	                }
	                if (hasFilters || hasExpressionFilter || currentIsReject || currentIsRejectInnerJoin && atLeastOneInputTableWithInnerJoin) {
	                    sb.append(cr + gm.indent(indent) + "// # Filter conditions ");
	
	                    String key = CodeGenerationUtils.buildProblemKey(uniqueNameComponent,
	                            JavaGenerationManager.PROBLEM_KEY_FIELD.FILTER.toString(), outputTableName, null);
	                    if (checkingSyntax) {
	                        sb.append("\n").append(CodeGenerationUtils.buildJavaStartFieldKey(key));
	                    }
	
	                    String ifConditions = gm.indent(indent) + "if( ";
	
	                    String rejectedTests = null;
	                    if (allNotRejectTablesHaveFilter && atLeastOneReject && currentIsReject && currentIsRejectInnerJoin
	                            && atLeastOneInputTableWithInnerJoin) {
	                        rejectedTests = rejected + " || " + rejectedInnerJoin;
	                        if (hasFilters || hasExpressionFilter) {
	                            rejectedTests = "(" + rejectedTests + ")";
	                        }
	                    } else if (allNotRejectTablesHaveFilter && atLeastOneReject && currentIsReject) {
	                        rejectedTests = rejected;
	                    } else if (currentIsRejectInnerJoin && atLeastOneInputTableWithInnerJoin) {
	                        rejectedTests = rejectedInnerJoin;
	                    }
	                    if (hasFilters && !hasExpressionFilter || hasExpressionFilter) {
	                        String filtersConditions = null;
	                        if(hasExpressionFilter) {
		                     	filtersConditions = outputTable.getExpressionFilter();
		                     } else {
		                        filtersConditions = gm.buildConditions(filters, expressionParser);
		                     }
	                        if (rejectedTests == null) {
	                            ifConditions += cr + cr + filtersConditions  + cr + cr;
	                        } else {
	                            ifConditions += rejectedTests + " && (" + cr + cr + filtersConditions + cr + cr +")";
	                        }
	                    } else {
	                        ifConditions += rejectedTests;
	                    }
	                    ifConditions += " ) {";
	
	                    sb.append(cr).append(ifConditions);
	
	                    if (checkingSyntax) {
	                        sb.append("\n").append(CodeGenerationUtils.buildJavaEndFieldKey(key));
	                    }
	
	                    indent++;
	                    closeFilterOrRejectBracket = true;
	                    if (allNotRejectTablesHaveFilter && !(currentIsReject || currentIsRejectInnerJoin)
	                            && atLeastOneReject) {
	                        sb.append(cr + gm.indent(indent) + rejected + " = false;");
	                    }
	                }

	                if (!currentIsReject && !currentIsRejectInnerJoin || currentIsReject || currentIsRejectInnerJoin
	                        && atLeastOneInputTableWithInnerJoin || checkingSyntax) {
	                    for (ExternalMapperTableEntry outputTableEntry : outputTableEntries) {
	                        String outputColumnName = outputTableEntry.getName();
	                        IMetadataColumn metadataColumn = null;
	                        if(connectionExists) {
		                        metadataColumn = hashedMetadataTable.getColumn(outputColumnName);
		                    }
	                        
	                        String outputExpression = outputTableEntry.getExpression();
	                        if (outputExpression == null || outputExpression.trim().length() == 0) {
	                        	if(metadataColumn == null) {
		                            outputExpression = JavaTypesManager.getDefaultValueFromJavaIdType(outputTableEntry
	    	                                .getType(), outputTableEntry.isNullable());
	    	                    } else {
		                            outputExpression = JavaTypesManager.getDefaultValueFromJavaIdType(metadataColumn
	    	                                .getTalendType(), metadataColumn.isNullable());
	    	                    }
	                        }
	
	                        String key = CodeGenerationUtils.buildProblemKey(uniqueNameComponent,
	                                JavaGenerationManager.PROBLEM_KEY_FIELD.METADATA_COLUMN.toString(), outputTableName,
	                                outputColumnName);
	                        if (checkingSyntax) {
	                            sb.append("\n").append(CodeGenerationUtils.buildJavaStartFieldKey(key));
	                        }
	
	                        String assignationVar = null;
	                        if (connectionExists) {
	                            assignationVar = gm.getGeneratedCodeTableColumnVariable(uniqueNameComponent, outputTableName + "_tmp",
	                                    outputColumnName, false);
	                        } else {
	                        	if(metadataColumn == null) {
		                            assignationVar = JavaTypesManager.getTypeToGenerate(outputTableEntry.getType(),
	                                    outputTableEntry.isNullable())
	                                    + " dummyVar" + (dummyVarCounter++);
	                            } else {
		                            assignationVar = JavaTypesManager.getTypeToGenerate(metadataColumn
	    	                                .getTalendType(), metadataColumn.isNullable())
	                                    + " dummyVar" + (dummyVarCounter++);
	                            }
	                        }
    	                    String expression = gm.indent(indent) + assignationVar + " = " + outputExpression + ";";
	
	                        sb.append(cr).append(expression);
	
	                        if (checkingSyntax) {
	                            sb.append("\n").append(CodeGenerationUtils.buildJavaEndFieldKey(key));
	                        }
	
	                    } // for entries
	
	                    if (connectionExists) {
	                        sb.append(cr + gm.indent(indent) + outputTableName + " = " + outputTableName + "_tmp;");
	                    }

	                }
	                if (closeFilterOrRejectBracket) {
	                    indent--;
	                    sb.append(cr + gm.indent(indent) + "} // closing filter/reject");
	                }
	
	            }
	            lastValueReject = currentIsReject || currentIsRejectInnerJoin;
	
	         }

			// System.out.println("Output table: (2)" + outputTableName);

            boolean isLastTable = indexCurrentTable == lstSizeOutputs - 1;
            if (closeTestInnerJoinConditionsBracket 
            	&& (isLastTable || !checkingSyntax && (outputTableName.equals(lastValidOutputTableName) || lastValidOutputTableName == null))) {
                indent--;
                sb.append(cr + gm.indent(indent) + "}  // closing inner join bracket (2)");
                closeTestInnerJoinConditionsBracket = false;
            }

        } // for output tables

        sb.append(cr + gm.indent(indent) + "// ###############################");

        
        sb.append(cr);
        indent--;
        sb.append(cr + gm.indent(indent) + "} // end of Var scope");
        
        sb.append(cr + cr + gm.indent(indent) + rejectedInnerJoin + " = false;");
        
        sb.append(cr);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    stringBuffer.append(TEXT_144);
    stringBuffer.append( sb.toString());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(TEXT_146);
    return stringBuffer.toString();
  }
}
