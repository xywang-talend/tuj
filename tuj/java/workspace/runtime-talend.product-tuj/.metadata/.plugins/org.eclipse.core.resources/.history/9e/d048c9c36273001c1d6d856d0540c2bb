package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import java.util.Enumeration;

public class TFileInputMailBeginJava
{
  protected static String nl;
  public static synchronized TFileInputMailBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputMailBeginJava result = new TFileInputMailBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " " + NL + "\tif(!";
  protected final String TEXT_3 = ".endsWith(\"/\")){" + NL + "           globalMap.put(\"";
  protected final String TEXT_4 = "_EXPORTED_FILE_PATH\",";
  protected final String TEXT_5 = " + \"/\");" + NL + "        \t\t}else" + NL + "        \t\t{" + NL + "        globalMap.put(\"";
  protected final String TEXT_6 = "_EXPORTED_FILE_PATH\",";
  protected final String TEXT_7 = ");" + NL + "        \t\t}" + NL + "" + NL + "///////////////////////////////////     " + NL + "   String [] mailParts_";
  protected final String TEXT_8 = " = new String [] {";
  protected final String TEXT_9 = NL + "\t \t";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = NL + "\t};" + NL + "   String [] mailChecked_";
  protected final String TEXT_12 = " = new String [] {";
  protected final String TEXT_13 = NL + "\t \t\"";
  protected final String TEXT_14 = "\",";
  protected final String TEXT_15 = NL + "\t};" + NL + "\t   String [] mailSeparator_";
  protected final String TEXT_16 = " = new String [] {";
  protected final String TEXT_17 = NL + "\t\t\t";
  protected final String TEXT_18 = ",";
  protected final String TEXT_19 = NL + "\t \t\t";
  protected final String TEXT_20 = ",";
  protected final String TEXT_21 = NL + "\t};" + NL + "\tjavax.mail.Session session_";
  protected final String TEXT_22 = " = javax.mail.Session.getDefaultInstance(System.getProperties(), null);" + NL + "    javax.mail.internet.MimeMessage msg_";
  protected final String TEXT_23 = " = new javax.mail.internet.MimeMessage(session_";
  protected final String TEXT_24 = ", new java.io.FileInputStream(";
  protected final String TEXT_25 = "));" + NL + "\tjava.util.List<String> list_";
  protected final String TEXT_26 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "\tfor (int i_";
  protected final String TEXT_27 = " =0;i_";
  protected final String TEXT_28 = " < mailParts_";
  protected final String TEXT_29 = ".length;i_";
  protected final String TEXT_30 = "++)" + NL + "\t{\t\t\t\t" + NL + "\t\tString part_";
  protected final String TEXT_31 = " = mailParts_";
  protected final String TEXT_32 = "[i_";
  protected final String TEXT_33 = "];" + NL + "       \tString sep_";
  protected final String TEXT_34 = "= mailSeparator_";
  protected final String TEXT_35 = "[i_";
  protected final String TEXT_36 = "];" + NL + "        if(part_";
  protected final String TEXT_37 = ".equalsIgnoreCase(\"body\"))" + NL + "        { " + NL + "           java.io.InputStream in_";
  protected final String TEXT_38 = " = msg_";
  protected final String TEXT_39 = ".getInputStream();" + NL + "           byte[] buffer_";
  protected final String TEXT_40 = " = new byte[1024];" + NL + "           int length_";
  protected final String TEXT_41 = " = 0;" + NL + "           java.io.ByteArrayOutputStream baos_";
  protected final String TEXT_42 = " =  new java.io.ByteArrayOutputStream();              " + NL + "           while ((length_";
  protected final String TEXT_43 = " = in_";
  protected final String TEXT_44 = ".read(buffer_";
  protected final String TEXT_45 = ", 0, 1024)) != -1) {               " + NL + "               baos_";
  protected final String TEXT_46 = ".write(buffer_";
  protected final String TEXT_47 = ", 0, length_";
  protected final String TEXT_48 = ");                                       " + NL + "           }" + NL + "           list_";
  protected final String TEXT_49 = ".add(baos_";
  protected final String TEXT_50 = ".toString());" + NL + "           in_";
  protected final String TEXT_51 = ".close();" + NL + "           baos_";
  protected final String TEXT_52 = ".close();      " + NL + " " + NL + "        }else if(part_";
  protected final String TEXT_53 = ".equalsIgnoreCase(\"header\")){" + NL + "            java.util.Enumeration em = msg_";
  protected final String TEXT_54 = ".getAllHeaderLines();" + NL + "            int em_count=0;" + NL + "            " + NL + "            String tempStr_";
  protected final String TEXT_55 = "=\"\";" + NL + "            " + NL + "\t\t\twhile (em.hasMoreElements()) {" + NL + "\t\t\t\ttempStr_";
  protected final String TEXT_56 = " = tempStr_";
  protected final String TEXT_57 = " + (String) em.nextElement() + sep_";
  protected final String TEXT_58 = " ;" + NL + "\t\t\t}" + NL + "\t\t\tlist_";
  protected final String TEXT_59 = ".add(tempStr_";
  protected final String TEXT_60 = ");" + NL + "        }else{" + NL + "        \tif(mailChecked_";
  protected final String TEXT_61 = "[i_";
  protected final String TEXT_62 = "].equals(\"true\")){   " + NL + "\t\t\t\tString[] sa_";
  protected final String TEXT_63 = " = msg_";
  protected final String TEXT_64 = ".getHeader(part_";
  protected final String TEXT_65 = ");" + NL + "\t\t\t\tString tempStr_";
  protected final String TEXT_66 = "=\"\";" + NL + "\t\t\t\tfor(int i=0;i<sa_";
  protected final String TEXT_67 = ".length;i++){" + NL + "\t\t\t\t\ttempStr_";
  protected final String TEXT_68 = "=tempStr_";
  protected final String TEXT_69 = "+sa_";
  protected final String TEXT_70 = "[i] + sep_";
  protected final String TEXT_71 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t\tlist_";
  protected final String TEXT_72 = ".add(tempStr_";
  protected final String TEXT_73 = ");" + NL + "        \t}else{ " + NL + "\t           String content_";
  protected final String TEXT_74 = " = msg_";
  protected final String TEXT_75 = ".getHeader(part_";
  protected final String TEXT_76 = ", null);" + NL + "\t           list_";
  protected final String TEXT_77 = ".add(content_";
  protected final String TEXT_78 = ");" + NL + "           \t}    " + NL + "        }   " + NL + " \t}           " + NL + " \t//attachment Deal" + NL + " \tif(msg_";
  protected final String TEXT_79 = ".isMimeType(\"multipart/*\")){" + NL + " \t      javax.mail.Multipart mp";
  protected final String TEXT_80 = " = (javax.mail.Multipart) msg_";
  protected final String TEXT_81 = ".getContent();" + NL + " \t      String attachfileName";
  protected final String TEXT_82 = " = \"\";" + NL + " \t      String path";
  protected final String TEXT_83 = " = \"\";" + NL + " \t      java.io.BufferedOutputStream out";
  protected final String TEXT_84 = " = null;" + NL + " \t      java.io.BufferedInputStream in";
  protected final String TEXT_85 = " = null;" + NL + "            for (int i = 0; i < mp";
  protected final String TEXT_86 = ".getCount(); i++) {" + NL + "                javax.mail.BodyPart mpart";
  protected final String TEXT_87 = " = mp";
  protected final String TEXT_88 = ".getBodyPart(i);" + NL + "                String disposition";
  protected final String TEXT_89 = " = mpart";
  protected final String TEXT_90 = ".getDisposition();" + NL + "                if ((disposition";
  protected final String TEXT_91 = " != null)" + NL + "                        && ((disposition";
  protected final String TEXT_92 = ".equals(javax.mail.Part.ATTACHMENT)) || (disposition";
  protected final String TEXT_93 = ".equals(javax.mail.Part.INLINE)))) {" + NL + "                    attachfileName";
  protected final String TEXT_94 = " = mpart";
  protected final String TEXT_95 = ".getFileName();" + NL + "                     if(!";
  protected final String TEXT_96 = ".endsWith(\"/\")){" + NL + "           \t\t\t\t path";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = " + \"/\";" + NL + "        \t\t\t\t}else" + NL + "        \t\t\t\t{" + NL + "        \t\t\t\t\tpath";
  protected final String TEXT_99 = " =";
  protected final String TEXT_100 = ";" + NL + "        \t\t\t\t}" + NL + "                    path";
  protected final String TEXT_101 = " = path";
  protected final String TEXT_102 = " + attachfileName";
  protected final String TEXT_103 = ";" + NL + "                    java.io.File attachFile  = new java.io.File(path";
  protected final String TEXT_104 = ");" + NL + "                    out";
  protected final String TEXT_105 = " = new java.io.BufferedOutputStream(new java.io.FileOutputStream(attachFile));" + NL + "                    in";
  protected final String TEXT_106 = " = new java.io.BufferedInputStream(mpart";
  protected final String TEXT_107 = ".getInputStream());" + NL + "                    int buffer";
  protected final String TEXT_108 = " = 0;" + NL + "                    while ((buffer";
  protected final String TEXT_109 = " = in";
  protected final String TEXT_110 = ".read()) != -1) {" + NL + "                           out";
  protected final String TEXT_111 = ".write(buffer";
  protected final String TEXT_112 = ");" + NL + "                           out";
  protected final String TEXT_113 = ".flush();" + NL + "                         }   " + NL + "                        out";
  protected final String TEXT_114 = ".close();" + NL + "                        in";
  protected final String TEXT_115 = ".close();    " + NL + "                }" + NL + "            }" + NL + " \t}" + NL + " \t         " + NL + " \t          " + NL + "// for output";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_117 = " < list_";
  protected final String TEXT_118 = ".size() && list_";
  protected final String TEXT_119 = ".get(";
  protected final String TEXT_120 = ")!=null){\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\t\t";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = " = (String)list_";
  protected final String TEXT_124 = ".get(";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\t\t\t\t";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " = ParserUtils.parseTo_Date(list_";
  protected final String TEXT_129 = ".get(";
  protected final String TEXT_130 = "), ";
  protected final String TEXT_131 = ");";
  protected final String TEXT_132 = NL + "\t\t\t\t\t";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " = list_";
  protected final String TEXT_135 = ".get(";
  protected final String TEXT_136 = ").getBytes();";
  protected final String TEXT_137 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = ParserUtils.parseTo_";
  protected final String TEXT_140 = "(list_";
  protected final String TEXT_141 = ".get(";
  protected final String TEXT_142 = "));";
  protected final String TEXT_143 = NL + "\t\t\t" + NL + "\t\t\t} else { " + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = " = ";
  protected final String TEXT_146 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_147 = NL + "      \t\t\t";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = " = ";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_152 = " " + NL + "////////////////////////////";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        // component id
        String cid = node.getUniqueName();
        String filename = ElementParameterParser.getValue(node,"__FILENAME__");
        String directory = ElementParameterParser.getValue(node,"__ATTACHMENT_PATH__");
        List<Map<String, String>> mailParts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAIL_PARTS__");
      

    stringBuffer.append(TEXT_2);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
	for (int i=0; i<mailParts.size(); i++) {
	   Map<String, String> lineValue = mailParts.get(i);

    stringBuffer.append(TEXT_9);
    stringBuffer.append( lineValue.get("MAIL_PART") );
    stringBuffer.append(TEXT_10);
    
	}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
	for (int i=0; i<mailParts.size(); i++) {
	   Map<String, String> lineValue = mailParts.get(i);

    stringBuffer.append(TEXT_13);
    stringBuffer.append( lineValue.get("MULTI_VALUE") );
    stringBuffer.append(TEXT_14);
    
	}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
	for (int i=0; i<mailParts.size(); i++) {
	   Map<String, String> lineValue = mailParts.get(i);
	   if(lineValue.get("PART_SEPARATOR").equals("")){

    stringBuffer.append(TEXT_17);
    stringBuffer.append("\"\"");
    stringBuffer.append(TEXT_18);
    		}else{
    stringBuffer.append(TEXT_19);
    stringBuffer.append( lineValue.get("PART_SEPARATOR") );
    stringBuffer.append(TEXT_20);
    
		}
	}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {//1
		if (conns.size()>0) {//2
		
			IConnection conn = conns.get(0); //the first connection
			firstConnName = conn.getName();			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

			List<IMetadataColumn> columns=metadata.getListColumns();
			int columnSize = columns.size();
			for (int i=0;i<columnSize;i++) {//4
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_120);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { //String and Object

    stringBuffer.append(TEXT_121);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_125);
    
					} else if(javaType == JavaTypesManager.DATE) { //Date

    stringBuffer.append(TEXT_126);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_131);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_132);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_136);
    
					}else  { //other

    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_142);
    
					}

    stringBuffer.append(TEXT_143);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_146);
    			
			} //4
		}//3
		
		
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn2 = conns.get(i);
				if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_151);
    
				 	}
				}
			}
		}
		
		
	}//2
	
}//1


    stringBuffer.append(TEXT_152);
    
  }
}  
 
    return stringBuffer.toString();
  }
}
