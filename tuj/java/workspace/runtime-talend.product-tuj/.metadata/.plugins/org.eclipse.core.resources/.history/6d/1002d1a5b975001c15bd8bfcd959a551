package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSSHBeginJava
{
  protected static String nl;
  public static synchronized TSSHBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSSHBeginJava result = new TSSHBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    String hostname_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "    String username_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "" + NL + "" + NL + "\t/* Create a connection instance */";
  protected final String TEXT_7 = NL + "\t\t\t  ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_8 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t\t  ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_11 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_12 = ",";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "              /* Now connect */";
  protected final String TEXT_15 = NL + "\t\t\t  conn_";
  protected final String TEXT_16 = ".connect(null,0,";
  protected final String TEXT_17 = "*1000);";
  protected final String TEXT_18 = NL + "\t\t\t  conn_";
  protected final String TEXT_19 = ".connect();";
  protected final String TEXT_20 = NL + "        java.io.File keyfile_";
  protected final String TEXT_21 = " = new java.io.File(";
  protected final String TEXT_22 = "); " + NL + "\t\t    boolean isAuthenticated_";
  protected final String TEXT_23 = " = conn_";
  protected final String TEXT_24 = ".authenticateWithPublicKey(username_";
  protected final String TEXT_25 = ", keyfile_";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ");" + NL + "\t\t\t  if (isAuthenticated_";
  protected final String TEXT_28 = " == false)" + NL + "\t\t\t\t      throw new java.io.IOException(\"Authentication failed.\");";
  protected final String TEXT_29 = NL + "        boolean isAuthenticated_";
  protected final String TEXT_30 = " = conn_";
  protected final String TEXT_31 = ".authenticateWithPassword(username_";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ");" + NL + "\t\tif (isAuthenticated_";
  protected final String TEXT_34 = " == false)" + NL + "\t\t\tthrow new java.io.IOException(\"Authentication failed.\");";
  protected final String TEXT_35 = NL + "         /* Create a session */" + NL + "\t     ch.ethz.ssh2.Session sess_";
  protected final String TEXT_36 = " = conn_";
  protected final String TEXT_37 = ".openSession();";
  protected final String TEXT_38 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean stats = codeGenArgument.isStatistics();

List<IMetadataTable> metadatas = node.getMetadataList();
String cid = node.getUniqueName();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {

        String host = ElementParameterParser.getValue(
            node,
            "__HOST__"
        );

        String port = ElementParameterParser.getValue(
            node,
            "__PORT__"
        );

        String user = ElementParameterParser.getValue(
            node,
            "__USER__"
        );

        String authMethod = ElementParameterParser.getValue(
            node,
            "__AUTH_METHOD__"
        );

        String privatekey = ElementParameterParser.getValue(
            node,
            "__PRIVATEKEY__"
        );

        String password = ElementParameterParser.getValue(
            node,
            "__PASSWORD__"
        );
        
        String passphrase = ElementParameterParser.getValue(
            node,
            "__PASSPHRASE__"
        );
        
        String useTimeout = ElementParameterParser.getValue(
            node,
            "__USE_TIMEOUT__"
        );

        String timeout = ElementParameterParser.getValue(
            node,
            "__TIMEOUT__"
        );

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_6);
    
        if(port.equals("")){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
        } else {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_13);
    
        }

    stringBuffer.append(TEXT_14);
    
        if(useTimeout.equals("true")){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_17);
    
        } else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
        }
        
        if (authMethod.equals("PUBLICKEY")) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(passphrase);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
        }
        if (authMethod.equals("PASSWORD")) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
        }

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
    }
}

    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
