package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TAdvancedFileOutputXMLMainJava
{
  protected static String nl;
  public static synchronized TAdvancedFileOutputXMLMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedFileOutputXMLMainJava result = new TAdvancedFileOutputXMLMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tnb_line_";
  protected final String TEXT_2 = "++;" + NL + "\t" + NL + "\torg.dom4j.Element group4Loop_";
  protected final String TEXT_3 = "=null;" + NL + "" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_4 = ") {";
  protected final String TEXT_5 = NL + "\t\tdoc_";
  protected final String TEXT_6 = ".getRootElement().addAttribute(\"";
  protected final String TEXT_7 = "\",";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t\t";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = ".addAttribute(\"";
  protected final String TEXT_12 = "\",";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_15 = "_";
  protected final String TEXT_16 = " = org.dom4j.DocumentHelper.makeElement(doc_";
  protected final String TEXT_17 = ",\"";
  protected final String TEXT_18 = "\");\t\t";
  protected final String TEXT_19 = NL + "\t\t";
  protected final String TEXT_20 = "_";
  protected final String TEXT_21 = ".setText(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\tneedRoot_";
  protected final String TEXT_24 = "=false;" + NL + "\t}" + NL + "\t" + NL + "\t// build group xml tree ";
  protected final String TEXT_25 = NL + "\tboolean isNewElememt = false;";
  protected final String TEXT_26 = NL + "\t";
  protected final String TEXT_27 = "_";
  protected final String TEXT_28 = ".addAttribute(\"";
  protected final String TEXT_29 = "\",";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\tif(isNewElememt || groupRootList_";
  protected final String TEXT_32 = ".size()<=";
  protected final String TEXT_33 = " || groupRootList_";
  protected final String TEXT_34 = ".get(";
  protected final String TEXT_35 = ")==null";
  protected final String TEXT_36 = NL + "\t\t|| !groupRootList_";
  protected final String TEXT_37 = ".get(";
  protected final String TEXT_38 = ").attribute(\"";
  protected final String TEXT_39 = "\").getText().equals(";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = ".attribute(\"";
  protected final String TEXT_42 = "\").getText())";
  protected final String TEXT_43 = NL + "\t){" + NL + "        group4Loop_";
  protected final String TEXT_44 = ".add(";
  protected final String TEXT_45 = "_";
  protected final String TEXT_46 = ");" + NL + "        group4Loop_";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = ";" + NL + "        if(groupRootList_";
  protected final String TEXT_50 = ".size()<=";
  protected final String TEXT_51 = "){" + NL + "        \tgroupRootList_";
  protected final String TEXT_52 = ".add(";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = ");" + NL + "        }else{" + NL + "        \tgroupRootList_";
  protected final String TEXT_55 = ".set(";
  protected final String TEXT_56 = ", ";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = ");" + NL + "        }" + NL + "        isNewElememt=true;" + NL + "\t} else {" + NL + "        group4Loop_";
  protected final String TEXT_59 = " = groupRootList_";
  protected final String TEXT_60 = ".get(";
  protected final String TEXT_61 = ");" + NL + "    }";
  protected final String TEXT_62 = NL + "\tgroup4Loop_";
  protected final String TEXT_63 = " = (org.dom4j.Element)doc_";
  protected final String TEXT_64 = ".selectSingleNode(\"";
  protected final String TEXT_65 = "\");";
  protected final String TEXT_66 = NL + "\torg.dom4j.Element ";
  protected final String TEXT_67 = "_";
  protected final String TEXT_68 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_69 = "\");";
  protected final String TEXT_70 = NL + "\torg.dom4j.Element ";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = " = " + NL + "\t\torg.dom4j.DocumentHelper.makeElement(";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = ",\"";
  protected final String TEXT_75 = "\");";
  protected final String TEXT_76 = NL + "\t";
  protected final String TEXT_77 = "_";
  protected final String TEXT_78 = ".setText(";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + "\tif(isNewElememt || groupRootList_";
  protected final String TEXT_81 = ".size()<=";
  protected final String TEXT_82 = " ||groupRootList_";
  protected final String TEXT_83 = ".get(";
  protected final String TEXT_84 = ")==null";
  protected final String TEXT_85 = NL + "\t\t|| !groupRootList_";
  protected final String TEXT_86 = ".get(";
  protected final String TEXT_87 = ").attribute(\"";
  protected final String TEXT_88 = "\").getText().equals(";
  protected final String TEXT_89 = "_";
  protected final String TEXT_90 = ".attribute(\"";
  protected final String TEXT_91 = "\").getText())";
  protected final String TEXT_92 = NL + "\t){" + NL + "        group4Loop_";
  protected final String TEXT_93 = ".add(";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = ");" + NL + "        group4Loop_";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = "_";
  protected final String TEXT_98 = ";" + NL + "        if(groupRootList_";
  protected final String TEXT_99 = ".size()<=";
  protected final String TEXT_100 = "){" + NL + "        \tgroupRootList_";
  protected final String TEXT_101 = ".add(";
  protected final String TEXT_102 = "_";
  protected final String TEXT_103 = ");" + NL + "        }else{" + NL + "        \tgroupRootList_";
  protected final String TEXT_104 = ".set(";
  protected final String TEXT_105 = ", ";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = ");" + NL + "        }" + NL + "\t} else {" + NL + "        group4Loop_";
  protected final String TEXT_108 = " = groupRootList_";
  protected final String TEXT_109 = ".get(";
  protected final String TEXT_110 = ");" + NL + "    }";
  protected final String TEXT_111 = NL + "\t// build loop xml tree ";
  protected final String TEXT_112 = NL + "\t";
  protected final String TEXT_113 = "_";
  protected final String TEXT_114 = ".addAttribute(\"";
  protected final String TEXT_115 = "\",";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "\tif(group4Loop_";
  protected final String TEXT_118 = " == null)" + NL + "\t{" + NL + "\t\tgroup4Loop_";
  protected final String TEXT_119 = " = (org.dom4j.Element)doc_";
  protected final String TEXT_120 = ".selectSingleNode(\"";
  protected final String TEXT_121 = "\");" + NL + "\t}" + NL + "\torg.dom4j.Element ";
  protected final String TEXT_122 = "_";
  protected final String TEXT_123 = " = " + NL + "\t\torg.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_124 = "\");//\"";
  protected final String TEXT_125 = "\".replaceFirst(group4Loop_";
  protected final String TEXT_126 = ".getPath(), \"\"));" + NL + "\tgroup4Loop_";
  protected final String TEXT_127 = ".add(";
  protected final String TEXT_128 = "_";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\torg.dom4j.Element ";
  protected final String TEXT_131 = "_";
  protected final String TEXT_132 = " = " + NL + "\t\torg.dom4j.DocumentHelper.makeElement(";
  protected final String TEXT_133 = "_";
  protected final String TEXT_134 = ",\"";
  protected final String TEXT_135 = "\");";
  protected final String TEXT_136 = NL + "\t";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = ".setText(";
  protected final String TEXT_139 = ");";
  protected final String TEXT_140 = NL + "    currentRowCount_";
  protected final String TEXT_141 = "++;" + NL + "    if(currentRowCount_";
  protected final String TEXT_142 = " == ";
  protected final String TEXT_143 = "){" + NL + "        org.dom4j.io.XMLWriter output_";
  protected final String TEXT_144 = " = new org.dom4j.io.XMLWriter(new java.io.FileWriter(" + NL + "        \tnew java.io.File(fileName_";
  protected final String TEXT_145 = ")), format_";
  protected final String TEXT_146 = ");" + NL + "        output_";
  protected final String TEXT_147 = ".write(doc_";
  protected final String TEXT_148 = ");" + NL + "        output_";
  protected final String TEXT_149 = ".close();" + NL + "        " + NL + "        currentRowCount_";
  protected final String TEXT_150 = " = 0;" + NL + "        currentFileCount_";
  protected final String TEXT_151 = "++;" + NL + "        doc_";
  protected final String TEXT_152 = "  = org.dom4j.DocumentHelper.createDocument();" + NL + "    \tneedRoot_";
  protected final String TEXT_153 = "  = true;" + NL + "    \tfileName_";
  protected final String TEXT_154 = " = file_";
  protected final String TEXT_155 = " + currentFileCount_";
  protected final String TEXT_156 = " + \".xml\";" + NL + "    \tgroupRootList_";
  protected final String TEXT_157 = ".clear();" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
            	List<Map<String, String>> rootTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
                List<Map<String, String>> groupTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
                List<Map<String, String>> loopTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
                String split = ElementParameterParser.getValue(node, "__SPLIT__");
                String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
                
                //mark the main group in groupTable
                if(loopTable.size() > 0){
                    String loopPath=loopTable.get(0).get("PATH");
                    boolean isMainGroupAttribute = false;
                    for(Map<String, String> map:groupTable){
                    	if (map.get("ATTRIBUTE").equals("true")) {
                    		if(isMainGroupAttribute){
                    			map.put("TYPE","Group");
                    		}
                    	}else{
                    		if( loopPath.startsWith(map.get("PATH"))){
                    			map.put("TYPE","Main");
                    			isMainGroupAttribute = true;
                    		}else{
                    			isMainGroupAttribute = false;
                    		}
                    	}
                    }
                }

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
				//sort the name of Element for adding attributes, as attributes record on table must follow its ownner's
        		String currEleName=null;
        		int elementCount = 0;
        		boolean isRootAttribute = false;
            	for(Map<String, String> map:rootTable){
            		String value = null;
            		if( map.get("COLUMN")!=null && map.get("COLUMN").length()>0){
            			value = conn.getName()+"."+map.get("COLUMN");
        			}else if(map.get("VALUE") != null && map.get("VALUE").length()>0){
        				value = map.get("VALUE");
        			}
            		String path = map.get("PATH");
                    if (map.get("ATTRIBUTE").equals("true")) {
                        if(isRootAttribute){ //it is the attirbute of root

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(value==null?"\"\"":value);
    stringBuffer.append(TEXT_8);
    
						}else{

    stringBuffer.append(TEXT_9);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(value==null?"\"\"":value);
    stringBuffer.append(TEXT_13);
    
						}
            		}else{
            			if(currEleName==null){
            				isRootAttribute = true;
            			}else{
            				isRootAttribute = false;
            			}
            			currEleName = "element"+elementCount;
            			elementCount++;

    stringBuffer.append(TEXT_14);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_18);
    
						if(value!=null){

    stringBuffer.append(TEXT_19);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_22);
    
						}
            		}
            	}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
				if(groupTable.size()>0){

    stringBuffer.append(TEXT_25);
    
				}
				//sort current attributes name for grouping judgement.
				List<String> currAttributeNameList = new ArrayList<String>();
				String currentGroupRoot = null;
				String currentGroupRootPath = null;
				int groupRootCount = 0;
				for(Map<String, String> map:groupTable){
            		String value = null;
            		if( map.get("COLUMN")!=null && map.get("COLUMN").length()>0){
            			value = conn.getName()+"."+map.get("COLUMN");
        			}else if(map.get("VALUE") != null && map.get("VALUE").length()>0){
        				value = map.get("VALUE");
        			}

        			String path = map.get("PATH");
                    if (map.get("ATTRIBUTE").equals("true")) {
                    	if(map.get("TYPE")!=null && map.get("TYPE").length()>0){
                    		currAttributeNameList.add(path);
                    	}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(value==null?"\"\"":value);
    stringBuffer.append(TEXT_30);
    
                    }else{
                    	currEleName =  "element"+elementCount;
            			elementCount++;
                    	if(map.get("TYPE")!=null && map.get("TYPE").length()>0){
                    		currentGroupRootPath = path;
                    		if(currentGroupRoot!=null){ // process previous group root

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_35);
    
								for(String attr:currAttributeNameList)
								{

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(attr);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(attr);
    stringBuffer.append(TEXT_42);
    
								}
								currAttributeNameList.clear();

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_61);
    
								groupRootCount++;
                    		}else{ //currentGroupRoot == null

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(path.substring(0,path.lastIndexOf("/") ));
    stringBuffer.append(TEXT_65);
    
                    		}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(path.substring(path.lastIndexOf("/") + 1));
    stringBuffer.append(TEXT_69);
    
							currentGroupRoot = currEleName;
                    	}else{ //not group element

    stringBuffer.append(TEXT_70);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(path.replaceFirst(currentGroupRootPath,""));
    stringBuffer.append(TEXT_75);
    
							if(value!=null){

    stringBuffer.append(TEXT_76);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_79);
    
							}
                    	}
                    }
        		}
        		if(currentGroupRoot!=null){ // process last group root

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_84);
    
					for(String attr:currAttributeNameList)
					{

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(attr);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(attr);
    stringBuffer.append(TEXT_91);
    
					}
					currAttributeNameList.clear();

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(currentGroupRoot);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(groupRootCount);
    stringBuffer.append(TEXT_110);
    
						groupRootCount++;
            		}

    stringBuffer.append(TEXT_111);
    
				String loopRootName=null;
				String loopRootPath = null;
				for(Map<String, String> map:loopTable){
            		String value = null;
            		if( map.get("COLUMN")!=null && map.get("COLUMN").length()>0){
            			value = conn.getName()+"."+map.get("COLUMN");
        			}else if(map.get("VALUE") != null && map.get("VALUE").length()>0){
        				value = map.get("VALUE");
        			}
        			
            		String path = map.get("PATH");
                     if (map.get("ATTRIBUTE").equals("true")) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(value==null?"\"\"":value);
    stringBuffer.append(TEXT_116);
    
                    }else{
                    	if(loopRootName == null){// the first one
                   			loopRootName = path.substring(path.lastIndexOf("/") + 1);
                   			loopRootPath = path;
                   			currEleName = loopRootName;

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(path.substring(0,path.lastIndexOf("/") ));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(loopRootName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
						}else{
							currEleName =  "element"+elementCount;
            				elementCount++;

    stringBuffer.append(TEXT_130);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(loopRootName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(path.replaceFirst(loopRootPath,""));
    stringBuffer.append(TEXT_135);
    
						}
						if(value!=null){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_139);
    
						}
                    }
				}
				
				//split
				if(split.equals("true")){

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append( splitEvery);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
				}
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
