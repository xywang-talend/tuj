package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMomOutputBeginJava
{
  protected static String nl;
  public static synchronized TMomOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputBeginJava result = new TMomOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.Hashtable props_";
  protected final String TEXT_3 = "=new java.util.Hashtable();";
  protected final String TEXT_4 = NL + "\tprops_";
  protected final String TEXT_5 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\tprops_";
  protected final String TEXT_6 = ".put(javax.naming.Context.PROVIDER_URL, \"";
  protected final String TEXT_7 = ":";
  protected final String TEXT_8 = "\");" + NL + "\tprops_";
  protected final String TEXT_9 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t" + NL + "\tjavax.naming.Context context_";
  protected final String TEXT_10 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_11 = ");" + NL + "\tjavax.jms.";
  protected final String TEXT_12 = "ConnectionFactory factory_";
  protected final String TEXT_13 = NL + "\t\t= (javax.jms.";
  protected final String TEXT_14 = "ConnectionFactory)context_";
  protected final String TEXT_15 = ".lookup(\"ConnectionFactory\");\t" + NL + "\tjavax.jms.";
  protected final String TEXT_16 = "Connection connection_";
  protected final String TEXT_17 = NL + "\t\t= factory_";
  protected final String TEXT_18 = ".create";
  protected final String TEXT_19 = "Connection();" + NL + "\tjavax.jms.";
  protected final String TEXT_20 = "Session session_";
  protected final String TEXT_21 = NL + "\t\t= connection_";
  protected final String TEXT_22 = ".create";
  protected final String TEXT_23 = "Session(false, javax.jms.Session.AUTO_ACKNOWLEDGE);" + NL + "\tjavax.jms.";
  protected final String TEXT_24 = " type_";
  protected final String TEXT_25 = "=(javax.jms.";
  protected final String TEXT_26 = ")context_";
  protected final String TEXT_27 = ".lookup(\"";
  protected final String TEXT_28 = "\");" + NL;
  protected final String TEXT_29 = NL + "    props_";
  protected final String TEXT_30 = ".put(\"hostname\", \"";
  protected final String TEXT_31 = "\");" + NL + "    props_";
  protected final String TEXT_32 = ".put(\"port\", new Integer(";
  protected final String TEXT_33 = "));" + NL + "    props_";
  protected final String TEXT_34 = ".put(\"channel\", \"";
  protected final String TEXT_35 = "\");" + NL + "    props_";
  protected final String TEXT_36 = ".put(\"CCSID\", new Integer(1208));" + NL + "    props_";
  protected final String TEXT_37 = ".put(\"transport\", \"MQSeries\");" + NL + "" + NL + "\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_38 = " = new com.ibm.mq.MQQueueManager(\"";
  protected final String TEXT_39 = "\", props_";
  protected final String TEXT_40 = ");" + NL + "    com.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_41 = " = qMgr_";
  protected final String TEXT_42 = ".accessQueue(\"";
  protected final String TEXT_43 = "\", 16);" + NL + "    com.ibm.mq.MQPutMessageOptions opM_";
  protected final String TEXT_44 = " = new com.ibm.mq.MQPutMessageOptions();";
  protected final String TEXT_45 = NL + "\t" + NL + "" + NL + "" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	IMetadataTable metadata=null;
	List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if(serverType.equals("JBoss")){ // server judgement
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	String to = ElementParameterParser.getValue(node, "__TO__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_28);
    
}else{ //server judgement   /***WebSphere MQ*****/
	String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
	String qm=ElementParameterParser.getValue(node, "__QM__");
	String queue = ElementParameterParser.getValue(node, "__QUEUE__");

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
}

    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}
