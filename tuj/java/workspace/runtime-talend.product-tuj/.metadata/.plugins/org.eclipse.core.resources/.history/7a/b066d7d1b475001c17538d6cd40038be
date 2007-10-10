package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TPOPBeginJava
{
  protected static String nl;
  public static synchronized TPOPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPOPBeginJava result = new TPOPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t" + NL + "\tString popServer_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "    String popUser_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "    String popPassword_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "    " + NL + "    java.util.Properties props_";
  protected final String TEXT_9 = " = System.getProperties();" + NL + "    javax.mail.Session session_";
  protected final String TEXT_10 = " = javax.mail.Session.getDefaultInstance(props_";
  protected final String TEXT_11 = ", null);" + NL + "    " + NL + "    javax.mail.Store store_";
  protected final String TEXT_12 = " = session_";
  protected final String TEXT_13 = ".getStore(\"pop3\");" + NL + "    store_";
  protected final String TEXT_14 = ".connect(popServer_";
  protected final String TEXT_15 = ", popUser_";
  protected final String TEXT_16 = ", popPassword_";
  protected final String TEXT_17 = ");" + NL + "    " + NL + "    int nb_email_";
  protected final String TEXT_18 = " = 0;" + NL + "" + NL + "    javax.mail.Folder folder_";
  protected final String TEXT_19 = " = store_";
  protected final String TEXT_20 = ".getDefaultFolder();" + NL + "    if (folder_";
  protected final String TEXT_21 = " == null)" + NL + "    throw new Exception(\"No default folder\");" + NL + "" + NL + "    // its INBOX" + NL + "    folder_";
  protected final String TEXT_22 = " = folder_";
  protected final String TEXT_23 = ".getFolder(\"INBOX\");" + NL + "    if (folder_";
  protected final String TEXT_24 = " == null)" + NL + "        throw new Exception(\"No POP3 INBOX\");" + NL;
  protected final String TEXT_25 = NL + "     folder_";
  protected final String TEXT_26 = ".open(javax.mail.Folder.READ_WRITE);";
  protected final String TEXT_27 = " " + NL + "    folder_";
  protected final String TEXT_28 = ".open(javax.mail.Folder.READ_ONLY);";
  protected final String TEXT_29 = "\t" + NL + "    javax.mail.Message[] msgs_";
  protected final String TEXT_30 = " = folder_";
  protected final String TEXT_31 = ".getMessages();" + NL + "    for (int counter_";
  protected final String TEXT_32 = " = 0; counter_";
  protected final String TEXT_33 = " < msgs_";
  protected final String TEXT_34 = ".length; counter_";
  protected final String TEXT_35 = "++) {";
  protected final String TEXT_36 = NL + "    if(counter_";
  protected final String TEXT_37 = " >= ";
  protected final String TEXT_38 = ") break; ";
  protected final String TEXT_39 = "                " + NL + "    javax.mail.Message message_";
  protected final String TEXT_40 = " = msgs_";
  protected final String TEXT_41 = "[counter_";
  protected final String TEXT_42 = "];" + NL + "    message_";
  protected final String TEXT_43 = ".setFlag(javax.mail.Flags.Flag.DELETED, true);    " + NL + "    String filename_";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = ";" + NL + "    java.io.File file_";
  protected final String TEXT_46 = " = new java.io.File(";
  protected final String TEXT_47 = ", filename_";
  protected final String TEXT_48 = ");" + NL + "    java.io.OutputStream os_";
  protected final String TEXT_49 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_50 = ");" + NL + "    java.util.Enumeration enums_";
  protected final String TEXT_51 = " = message_";
  protected final String TEXT_52 = ".getAllHeaders();" + NL + "    while (enums_";
  protected final String TEXT_53 = ".hasMoreElements()) {" + NL + "      javax.mail.Header header_";
  protected final String TEXT_54 = " = (javax.mail.Header) enums_";
  protected final String TEXT_55 = ".nextElement();" + NL + "      os_";
  protected final String TEXT_56 = ".write(new StringBuffer(header_";
  protected final String TEXT_57 = ".getName()).append(\": \").append(header_";
  protected final String TEXT_58 = ".getValue()).append(\"\\r\\n\").toString().getBytes());" + NL + "    }" + NL + "    os_";
  protected final String TEXT_59 = ".write(\"\\r\\n\".getBytes());" + NL + "    java.io.InputStream in_";
  protected final String TEXT_60 = " = message_";
  protected final String TEXT_61 = ".getInputStream();" + NL + "    byte[] buffer_";
  protected final String TEXT_62 = " = new byte[1024];" + NL + "    int length_";
  protected final String TEXT_63 = " = 0;" + NL + "    while ((length_";
  protected final String TEXT_64 = " = in_";
  protected final String TEXT_65 = ".read(buffer_";
  protected final String TEXT_66 = ", 0, 1024)) != -1) {" + NL + "      os_";
  protected final String TEXT_67 = ".write(buffer_";
  protected final String TEXT_68 = ", 0, length_";
  protected final String TEXT_69 = ");                    " + NL + "    }" + NL + "    os_";
  protected final String TEXT_70 = ".close();" + NL + "    " + NL + "    nb_email_";
  protected final String TEXT_71 = "++;" + NL + "    globalMap.put(\"";
  protected final String TEXT_72 = "_CURRENT_FILE\", filename_";
  protected final String TEXT_73 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_74 = "_CURRENT_FILEPATH\", file_";
  protected final String TEXT_75 = ".getAbsolutePath());  ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();

	String host = ElementParameterParser.getValue(node, "__HOST__");
    String username = ElementParameterParser.getValue(node, "__USERNAME__");
    String password = ElementParameterParser.getValue(node, "__PASSWORD__");
    
    String outputDirectory = ElementParameterParser.getValue(node, "__OUTPUT_DIRECTORY__");
    String filenamePattern = ElementParameterParser.getValue(node, "__FILENAME_PATTERN__");
    String allEmails = ElementParameterParser.getValue(node, "__ALL_EMAILS__");

    String maxEmails = ElementParameterParser.getValue(node, "__MAX_EMAILS__");
    String deleteFromServer = ElementParameterParser.getValue(node, "__DELETE_FROM_SERVER__");
        
	// component id
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
   if (deleteFromServer.equals("true")) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
  } else
  {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
  }    

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
   if (allEmails.equals("false")) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(maxEmails);
    stringBuffer.append(TEXT_38);
    
    }

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
    stringBuffer.append(filenamePattern );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outputDirectory );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    return stringBuffer.toString();
  }
}
