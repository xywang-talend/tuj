package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TAggregateSortedRowMainJava
{
  protected static String nl;
  public static synchronized TAggregateSortedRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateSortedRowMainJava result = new TAggregateSortedRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "if(flag_";
  protected final String TEXT_3 = "){" + NL + "\tflag_";
  protected final String TEXT_4 = " = false;";
  protected final String TEXT_5 = "group_";
  protected final String TEXT_6 = "_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = "count_";
  protected final String TEXT_16 = "_";
  protected final String TEXT_17 = " = 1;";
  protected final String TEXT_18 = "_";
  protected final String TEXT_19 = "_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = "sum_";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = " = 0;";
  protected final String TEXT_26 = "sum_";
  protected final String TEXT_27 = "_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = "sum_";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = " = 0;";
  protected final String TEXT_34 = "count_";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = " = 1;";
  protected final String TEXT_37 = "list_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = " = new StringBuilder();" + NL + "list_";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = ".append(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = " = null;";
  protected final String TEXT_45 = "flag2_";
  protected final String TEXT_46 = " = false;";
  protected final String TEXT_47 = "}else{" + NL + "boolean sameGroup_";
  protected final String TEXT_48 = " = true;" + NL + "while(true){";
  protected final String TEXT_49 = "if(group_";
  protected final String TEXT_50 = "_";
  protected final String TEXT_51 = " == null){" + NL + "\tif(";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = " != null){" + NL + "\t\tsameGroup_";
  protected final String TEXT_54 = " = false;" + NL + "\t\tbreak;" + NL + "\t}" + NL + "}else{" + NL + "\tif(group_";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = " == null || !group_";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = ".equals(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ")){" + NL + "\t\tsameGroup_";
  protected final String TEXT_61 = " = false;" + NL + "\t\tbreak;" + NL + "\t}" + NL + "}";
  protected final String TEXT_62 = "if(group_";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = " != ";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = "){" + NL + "\tsameGroup_";
  protected final String TEXT_67 = " = false;" + NL + "\tbreak;" + NL + "}";
  protected final String TEXT_68 = "break;";
  protected final String TEXT_69 = "}" + NL + "if(sameGroup_";
  protected final String TEXT_70 = "){" + NL + "\tif(flag2_";
  protected final String TEXT_71 = "){";
  protected final String TEXT_72 = " = null;";
  protected final String TEXT_73 = "flag2_";
  protected final String TEXT_74 = " = false;" + NL + "\t}";
  protected final String TEXT_75 = "_";
  protected final String TEXT_76 = "_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = "if(";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = " !=null){" + NL + "\tif(";
  protected final String TEXT_83 = "_";
  protected final String TEXT_84 = "_";
  protected final String TEXT_85 = " == null || ";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = "_";
  protected final String TEXT_88 = ".compareTo(";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = ") > 0){" + NL + "\t\t";
  protected final String TEXT_91 = "_";
  protected final String TEXT_92 = "_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = ";" + NL + "\t}" + NL + "}";
  protected final String TEXT_96 = "if(!";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = " && ";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = "_";
  protected final String TEXT_101 = "){" + NL + "\t";
  protected final String TEXT_102 = "_";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = " = true;" + NL + "}";
  protected final String TEXT_105 = "if(";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = "_";
  protected final String TEXT_108 = " > ";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = "){" + NL + "\t";
  protected final String TEXT_111 = "_";
  protected final String TEXT_112 = "_";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = ";" + NL + "}";
  protected final String TEXT_116 = "if(";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " !=null){" + NL + "\tif(";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = "_";
  protected final String TEXT_121 = " == null || ";
  protected final String TEXT_122 = "_";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = ".compareTo(";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = ") < 0){" + NL + "\t\t";
  protected final String TEXT_127 = "_";
  protected final String TEXT_128 = "_";
  protected final String TEXT_129 = " = ";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = ";" + NL + "\t}" + NL + "}";
  protected final String TEXT_132 = "if(";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " && !";
  protected final String TEXT_135 = "_";
  protected final String TEXT_136 = "_";
  protected final String TEXT_137 = "){" + NL + "\t";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = "_";
  protected final String TEXT_140 = " = true;" + NL + "}";
  protected final String TEXT_141 = "if(";
  protected final String TEXT_142 = "_";
  protected final String TEXT_143 = "_";
  protected final String TEXT_144 = " < ";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = "){" + NL + "\t";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = "_";
  protected final String TEXT_149 = " = ";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = ";" + NL + "}";
  protected final String TEXT_152 = "_";
  protected final String TEXT_153 = "_";
  protected final String TEXT_154 = "++;";
  protected final String TEXT_155 = "sum_";
  protected final String TEXT_156 = "_";
  protected final String TEXT_157 = " += ";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = ";";
  protected final String TEXT_160 = "sum_";
  protected final String TEXT_161 = "_";
  protected final String TEXT_162 = " += ";
  protected final String TEXT_163 = ".";
  protected final String TEXT_164 = ";";
  protected final String TEXT_165 = "count_";
  protected final String TEXT_166 = "_";
  protected final String TEXT_167 = "++;";
  protected final String TEXT_168 = "_";
  protected final String TEXT_169 = "_";
  protected final String TEXT_170 = ".append(\",\");";
  protected final String TEXT_171 = NL;
  protected final String TEXT_172 = "_";
  protected final String TEXT_173 = "_";
  protected final String TEXT_174 = ".append(";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = ");";
  protected final String TEXT_177 = "}else{";
  protected final String TEXT_178 = " = new ";
  protected final String TEXT_179 = "Struct();";
  protected final String TEXT_180 = "\tflag2_";
  protected final String TEXT_181 = " = true;";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = " = group_";
  protected final String TEXT_184 = "_";
  protected final String TEXT_185 = ";";
  protected final String TEXT_186 = "String temp_";
  protected final String TEXT_187 = " = \"\";";
  protected final String TEXT_188 = "temp_";
  protected final String TEXT_189 = " = new String(group_";
  protected final String TEXT_190 = "_";
  protected final String TEXT_191 = ");";
  protected final String TEXT_192 = "temp_";
  protected final String TEXT_193 = " = \"\"+group_";
  protected final String TEXT_194 = "_";
  protected final String TEXT_195 = ";";
  protected final String TEXT_196 = "if(temp_";
  protected final String TEXT_197 = ".length() > 0) {";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = " = temp_";
  protected final String TEXT_200 = ";";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_203 = ", ";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = " = ParserUtils.parseTo_";
  protected final String TEXT_207 = "(temp_";
  protected final String TEXT_208 = ");";
  protected final String TEXT_209 = "} else {\t\t\t\t\t\t";
  protected final String TEXT_210 = "throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_211 = "', value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = ";
  protected final String TEXT_214 = ";";
  protected final String TEXT_215 = "}";
  protected final String TEXT_216 = ".";
  protected final String TEXT_217 = " = ";
  protected final String TEXT_218 = "_";
  protected final String TEXT_219 = "_";
  protected final String TEXT_220 = ";";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = " = (";
  protected final String TEXT_223 = ")";
  protected final String TEXT_224 = "_";
  protected final String TEXT_225 = "_";
  protected final String TEXT_226 = ";";
  protected final String TEXT_227 = "String temp_";
  protected final String TEXT_228 = " = \"\";";
  protected final String TEXT_229 = "temp_";
  protected final String TEXT_230 = " = new String(";
  protected final String TEXT_231 = "_";
  protected final String TEXT_232 = "_";
  protected final String TEXT_233 = ");";
  protected final String TEXT_234 = "temp_";
  protected final String TEXT_235 = " = \"\"+";
  protected final String TEXT_236 = "_";
  protected final String TEXT_237 = "_";
  protected final String TEXT_238 = ";";
  protected final String TEXT_239 = "if(temp_";
  protected final String TEXT_240 = ".length() > 0) {";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = " = temp_";
  protected final String TEXT_243 = ";";
  protected final String TEXT_244 = ".";
  protected final String TEXT_245 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_246 = ", ";
  protected final String TEXT_247 = ");";
  protected final String TEXT_248 = ".";
  protected final String TEXT_249 = " = temp_";
  protected final String TEXT_250 = ".getBytes();";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = " = ParserUtils.parseTo_";
  protected final String TEXT_253 = "(temp_";
  protected final String TEXT_254 = ");";
  protected final String TEXT_255 = "} else {\t\t\t\t\t\t";
  protected final String TEXT_256 = "throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_257 = "', value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_258 = ".";
  protected final String TEXT_259 = " = ";
  protected final String TEXT_260 = ";";
  protected final String TEXT_261 = "}";
  protected final String TEXT_262 = ".";
  protected final String TEXT_263 = " = (";
  protected final String TEXT_264 = ")";
  protected final String TEXT_265 = "_";
  protected final String TEXT_266 = "_";
  protected final String TEXT_267 = ";";
  protected final String TEXT_268 = ".";
  protected final String TEXT_269 = " = \"\"+";
  protected final String TEXT_270 = "_";
  protected final String TEXT_271 = "_";
  protected final String TEXT_272 = ";";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = " = (\"\"+";
  protected final String TEXT_275 = "_";
  protected final String TEXT_276 = "_";
  protected final String TEXT_277 = ").getBytes();";
  protected final String TEXT_278 = ".";
  protected final String TEXT_279 = " = (";
  protected final String TEXT_280 = ")";
  protected final String TEXT_281 = "_";
  protected final String TEXT_282 = "_";
  protected final String TEXT_283 = ";";
  protected final String TEXT_284 = ".";
  protected final String TEXT_285 = " = \"\"+";
  protected final String TEXT_286 = "_";
  protected final String TEXT_287 = "_";
  protected final String TEXT_288 = ";";
  protected final String TEXT_289 = ".";
  protected final String TEXT_290 = " = (\"\"+";
  protected final String TEXT_291 = "_";
  protected final String TEXT_292 = "_";
  protected final String TEXT_293 = ").getBytes();";
  protected final String TEXT_294 = "double avg_";
  protected final String TEXT_295 = "_";
  protected final String TEXT_296 = " = sum_";
  protected final String TEXT_297 = "_";
  protected final String TEXT_298 = "/count_";
  protected final String TEXT_299 = "_";
  protected final String TEXT_300 = ";";
  protected final String TEXT_301 = ".";
  protected final String TEXT_302 = " = (";
  protected final String TEXT_303 = ")avg_";
  protected final String TEXT_304 = "_";
  protected final String TEXT_305 = ";";
  protected final String TEXT_306 = ".";
  protected final String TEXT_307 = " = \"\"+avg_";
  protected final String TEXT_308 = "_";
  protected final String TEXT_309 = ";";
  protected final String TEXT_310 = ".";
  protected final String TEXT_311 = " = (\"\"+avg_";
  protected final String TEXT_312 = "_";
  protected final String TEXT_313 = ").getBytes();";
  protected final String TEXT_314 = "if(";
  protected final String TEXT_315 = "_";
  protected final String TEXT_316 = "_";
  protected final String TEXT_317 = ".toString().length() > 0) {";
  protected final String TEXT_318 = ".";
  protected final String TEXT_319 = " = ";
  protected final String TEXT_320 = "_";
  protected final String TEXT_321 = "_";
  protected final String TEXT_322 = ".toString();";
  protected final String TEXT_323 = ".";
  protected final String TEXT_324 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_325 = "_";
  protected final String TEXT_326 = "_";
  protected final String TEXT_327 = ".toString(), ";
  protected final String TEXT_328 = ");";
  protected final String TEXT_329 = ".";
  protected final String TEXT_330 = " = ParserUtils.parseTo_";
  protected final String TEXT_331 = "(";
  protected final String TEXT_332 = "_";
  protected final String TEXT_333 = "_";
  protected final String TEXT_334 = ".toString());";
  protected final String TEXT_335 = "} else {\t\t\t\t\t\t";
  protected final String TEXT_336 = "throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_337 = "', value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_338 = ".";
  protected final String TEXT_339 = " = ";
  protected final String TEXT_340 = ";";
  protected final String TEXT_341 = "}";
  protected final String TEXT_342 = ".";
  protected final String TEXT_343 = " = ";
  protected final String TEXT_344 = ".";
  protected final String TEXT_345 = ";    \t\t\t\t";
  protected final String TEXT_346 = "nb_line_";
  protected final String TEXT_347 = "++;";
  protected final String TEXT_348 = "group_";
  protected final String TEXT_349 = "_";
  protected final String TEXT_350 = " = ";
  protected final String TEXT_351 = ".";
  protected final String TEXT_352 = ";";
  protected final String TEXT_353 = "_";
  protected final String TEXT_354 = "_";
  protected final String TEXT_355 = " = ";
  protected final String TEXT_356 = ".";
  protected final String TEXT_357 = ";";
  protected final String TEXT_358 = "count_";
  protected final String TEXT_359 = "_";
  protected final String TEXT_360 = " = 1;";
  protected final String TEXT_361 = "sum_";
  protected final String TEXT_362 = "_";
  protected final String TEXT_363 = " = 0;";
  protected final String TEXT_364 = "sum_";
  protected final String TEXT_365 = "_";
  protected final String TEXT_366 = " = ";
  protected final String TEXT_367 = ".";
  protected final String TEXT_368 = ";";
  protected final String TEXT_369 = "sum_";
  protected final String TEXT_370 = "_";
  protected final String TEXT_371 = " = 0;";
  protected final String TEXT_372 = "count_";
  protected final String TEXT_373 = "_";
  protected final String TEXT_374 = " = 1;";
  protected final String TEXT_375 = "list_";
  protected final String TEXT_376 = "_";
  protected final String TEXT_377 = " = new StringBuilder();" + NL + "list_";
  protected final String TEXT_378 = "_";
  protected final String TEXT_379 = ".append(";
  protected final String TEXT_380 = ".";
  protected final String TEXT_381 = ");";
  protected final String TEXT_382 = "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    List< ? extends IConnection> conns = node.getIncomingConnections();
    IMetadataTable inMetadata = null;
    String connName = "";
    if(conns != null){
    for (IConnection conn : conns) { 
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
			inMetadata = conn.getMetadataTable();
			connName = conn.getName();
    		break;
		}
	}
    if (metadata != null && inMetadata != null) { 
		List<IMetadataColumn> columns = metadata.getListColumns();
    	List<IMetadataColumn> inColumns = inMetadata.getListColumns();
		List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
		IMetadataColumn[][] column_op = new IMetadataColumn[operations.size()][2];
		String[] functions = new String[operations.size()];
		List<Map<String, String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
		IMetadataColumn[][] column_gr = new IMetadataColumn[groupbys.size()][2];
		for(int i = 0; i < column_op.length; i++){
			Map<String, String> operation = operations.get(i);
			String in = operation.get("INPUT_COLUMN");
			String out = operation.get("OUTPUT_COLUMN");
			functions[i] = operation.get("FUNCTION");
			for (IMetadataColumn column: inColumns) {
				if(column.getLabel().equals(in)){
					column_op[i][0] = column;
					break;
				}
			}
    		for (IMetadataColumn column: columns) {
				if(column.getLabel().equals(out)){
					column_op[i][1] = column;
					break;
				}
			}
		}
		for(int i = 0; i < column_gr.length; i++){
			Map<String, String> groupby = groupbys.get(i);
			String in = groupby.get("INPUT_COLUMN");
			String out = groupby.get("OUTPUT_COLUMN");
			for (IMetadataColumn column: inColumns) {
				if(column.getLabel().equals(in)){
					column_gr[i][0] = column;
					break;
				}
			}
    		for (IMetadataColumn column: columns) {
				if(column.getLabel().equals(out)){
					column_gr[i][1] = column;
					break;
				}
			}
		}
	if(column_gr.length > 0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    	}
	for(int i = 0; i < column_gr.length; i++){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_9);
    	}
	for(int i = 0; i < column_op.length; i++){
		boolean duplicate = false;
		for(int j = 0; j < i; j++){
			if(functions[j].equals(functions[i]) && column_op[j][0].getLabel().equals(column_op[i][0].getLabel())){
				duplicate = true;
				break;
			}
		}
		if(duplicate){
			continue;
		}
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column_op[i][0].getTalendType());
		if(functions[i].equals("min") || functions[i].equals("max") || functions[i].equals("first") || functions[i].equals("last")){

    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_14);
    		}else if(functions[i].equals("count")){
			boolean countHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(functions[j].equals("avg") && column_op[j][0].getLabel().equals(column_op[i][0].getLabel())){
					countHasAvg = true;
					break;
				}
			}
			if(!countHasAvg){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    			}
		}else if(functions[i].equals("sum")){
			boolean sumHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(functions[j].equals("avg") && column_op[j][0].getLabel().equals(column_op[i][0].getLabel())){
					sumHasAvg = true;
					break;
				}
			}
			if(!sumHasAvg){
				if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
					|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
					|| javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT 
					|| javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_22);
    				}else{

    stringBuffer.append(TEXT_23);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    				}
			}
		}else if(functions[i].equals("avg")){
			if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
					|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
					|| javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT 
					|| javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_30);
    				}else{

    stringBuffer.append(TEXT_31);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    			}

    stringBuffer.append(TEXT_34);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    		}else{

    stringBuffer.append(TEXT_37);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_43);
    		}
	}
	if(column_gr.length > 0){
		conns = null;
		conns = node.getOutgoingSortedConnections();
		if (conns!=null) {
			for(IConnection conn:conns){
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 

    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    				}
			}
		}

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    	}else{
	}
	if(column_gr.length > 0){//

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    	for(int i = 0; i < column_gr.length; i++){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column_gr[i][0].getTalendType());
		if(javaType == JavaTypesManager.BYTE_ARRAY || javaType == JavaTypesManager.OBJECT 
					|| javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    		}else{

    stringBuffer.append(TEXT_62);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    		}
		if(i+1 == column_gr.length){

    stringBuffer.append(TEXT_68);
    		}
	}

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    	conns = null;
	conns = node.getOutgoingSortedConnections();
	if (conns!=null) {
		for(IConnection conn:conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 

    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_72);
    			}
		}
	}
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    	for(int i = 0; i < column_op.length; i++){
		boolean duplicate = false;
		for(int j = 0; j < i; j++){
			if(functions[j].equals(functions[i]) && column_op[j][0].getLabel().equals(column_op[i][0].getLabel())){
				duplicate = true;
				break;
			}
		}
		if(duplicate){
			continue;
		}
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column_op[i][0].getTalendType());
		if(functions[i].equals("first")){
			//do nothing here
		}else if(functions[i].equals("last")){

    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_79);
    		}else if(functions[i].equals("min")){
			if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.BYTE_ARRAY){
			//do nothing
			}else if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_80);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_95);
    			}else if(javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_96);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    			}else{

    stringBuffer.append(TEXT_105);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_115);
    			}
		}else if(functions[i].equals("max")){
			if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.BYTE_ARRAY){
			//do nothing
			}else if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_131);
    			}else if(javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_132);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    			}else{

    stringBuffer.append(TEXT_141);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_151);
    			}
		}else if(functions[i].equals("count")){
			boolean countHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(functions[j].equals("avg") && column_op[j][0].getLabel().equals(column_op[i][0].getLabel())){
					countHasAvg = true;
					break;
				}
			}
			if(!countHasAvg){

    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    			}
		}else if(functions[i].equals("sum")){
			boolean sumHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(functions[j].equals("avg") && column_op[j][0].getLabel().equals(column_op[i][0].getLabel())){
					sumHasAvg = true;
					break;
				}
			}
			if(!sumHasAvg){
				if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
					|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
					|| javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT 
					|| javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_155);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_159);
    				}
			}
		}else if(functions[i].equals("avg")){
				if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
					|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
					|| javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT 
					|| javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_160);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_164);
    				}

    stringBuffer.append(TEXT_165);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    		}else if(functions[i].equals("list")){

    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_176);
    		}
	}

    stringBuffer.append(TEXT_177);
    		conns = null;
		conns = node.getOutgoingSortedConnections();
		if (conns!=null) {
			for(IConnection conn:conns){
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 

    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_179);
    				}
			}
		}

    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    	}//line 157 if(column_gr.length > 0)
	//do out start ...
	conns = null;
	conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				boolean flag = true;
				next_column:
				for (int valueN=0; valueN < sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					for(int i = 0; i < column_gr.length; i++){
						if(column.getLabel().equals(column_gr[i][1].getLabel())){
							JavaType inJavaType = JavaTypesManager.getJavaTypeFromId(column_gr[i][0].getTalendType());
							if(inJavaType == javaType){

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    							}else{//for different data type
								if(flag){
									flag = false;

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    								}
								if(inJavaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    								}else{

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    								}

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    								if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    								} else if(javaType == JavaTypesManager.DATE) { 

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_204);
    								} else {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    								}

    stringBuffer.append(TEXT_209);
    								String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
								if(defaultValue == null) {

    stringBuffer.append(TEXT_210);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_211);
    								} else {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_214);
    								}

    stringBuffer.append(TEXT_215);
    							}							
							continue next_column;
						}
					}					
					for(int i = 0; i < column_op.length; i++){
						if(column.getLabel().equals(column_op[i][1].getLabel())){
							if(functions[i].equals("min") || functions[i].equals("max") || functions[i].equals("first") || functions[i].equals("last")){
								JavaType inJavaType = JavaTypesManager.getJavaTypeFromId(column_op[i][0].getTalendType());
								if(inJavaType == javaType){

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    								}else{//for different data type
									if((javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
										|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
										|| javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT 
										|| javaType == JavaTypesManager.DOUBLE)&&(inJavaType == JavaTypesManager.BYTE || inJavaType == JavaTypesManager.CHARACTER 
										|| inJavaType == JavaTypesManager.SHORT || inJavaType == JavaTypesManager.INTEGER 
										|| inJavaType == JavaTypesManager.LONG || inJavaType == JavaTypesManager.FLOAT 
										|| inJavaType == JavaTypesManager.DOUBLE)){

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    									}else{
										if(flag){
											flag = false;

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    										}
										if(inJavaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    										}else{

    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    										}

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    										if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    										} else if(javaType == JavaTypesManager.DATE) { 

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_247);
    										} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    										} else {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    										}

    stringBuffer.append(TEXT_255);
    										String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
										if(defaultValue == null) {

    stringBuffer.append(TEXT_256);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_257);
    										} else {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_260);
    										}

    stringBuffer.append(TEXT_261);
    									}
								}
							}else if(functions[i].equals("count")){
								if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
									|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
									|| javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT 
									|| javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    								}else if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    								}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    								}
							}else if(functions[i].equals("sum")){
								if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
									|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
									|| javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT 
									|| javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    								}else if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    								}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    								}
							}else if(functions[i].equals("avg")){

    stringBuffer.append(TEXT_294);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    								if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
									|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
									|| javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT 
									|| javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    								}else if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    								}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    								}
							}else{

    stringBuffer.append(TEXT_314);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    								if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    								} else if(javaType == JavaTypesManager.DATE) { 

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_328);
    								} else {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_330);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    								}

    stringBuffer.append(TEXT_335);
    								String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
								if(defaultValue == null) {

    stringBuffer.append(TEXT_336);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_337);
    								} else {

    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_340);
    								}

    stringBuffer.append(TEXT_341);
    							}
							continue next_column;
						}
					}
				}
			}
		}
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	 for (IMetadataColumn column: metadata.getListColumns()) {
			    	 
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_345);
    				 	}
				}
			}
		}
	}

    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    	//do out end ...
	//do first
	for(int i = 0; i < column_gr.length; i++){

    stringBuffer.append(TEXT_348);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(column_gr[i][0].getLabel() );
    stringBuffer.append(TEXT_352);
    	}
	for(int i = 0; i < column_op.length; i++){
		boolean duplicate = false;
		for(int j = 0; j < i; j++){
			if(functions[j].equals(functions[i]) && column_op[j][0].getLabel().equals(column_op[i][0].getLabel())){
				duplicate = true;
				break;
			}
		}
		if(duplicate){
			continue;
		}
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column_op[i][0].getTalendType());
		if(functions[i].equals("min") || functions[i].equals("max") || functions[i].equals("first") || functions[i].equals("last")){

    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_357);
    		}else if(functions[i].equals("count")){
			boolean countHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(functions[j].equals("avg") && column_op[j][0].getLabel().equals(column_op[i][0].getLabel())){
					countHasAvg = true;
					break;
				}
			}
			if(!countHasAvg){

    stringBuffer.append(TEXT_358);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    			}
		}else if(functions[i].equals("sum")){
			boolean sumHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(functions[j].equals("avg") && column_op[j][0].getLabel().equals(column_op[i][0].getLabel())){
					sumHasAvg = true;
					break;
				}
			}
			if(!sumHasAvg){

    stringBuffer.append(TEXT_361);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    			}
		}else if(functions[i].equals("avg")){
			if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.CHARACTER 
					|| javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.INTEGER 
					|| javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT 
					|| javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_364);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_368);
    			}else{

    stringBuffer.append(TEXT_369);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    			}

    stringBuffer.append(TEXT_372);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    		}else{

    stringBuffer.append(TEXT_375);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(column_op[i][0].getLabel() );
    stringBuffer.append(TEXT_381);
    		}
	}
	if(column_gr.length > 0){

    stringBuffer.append(TEXT_382);
    	}
	}
	}
}

    return stringBuffer.toString();
  }
}
