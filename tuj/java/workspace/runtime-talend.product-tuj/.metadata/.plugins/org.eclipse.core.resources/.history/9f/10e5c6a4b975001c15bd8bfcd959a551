package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMomOutputMainJava
{
  protected static String nl;
  public static synchronized TMomOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputMainJava result = new TMomOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString msg_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = "\t\t\t\t\t" + NL + "    javax.jms.TextMessage messageQ_";
  protected final String TEXT_7 = " = session_";
  protected final String TEXT_8 = ".createTextMessage();" + NL + "    messageQ_";
  protected final String TEXT_9 = ".setText(msg_";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "    javax.jms.QueueSender queueSender_";
  protected final String TEXT_12 = "=session_";
  protected final String TEXT_13 = ".createSender(type_";
  protected final String TEXT_14 = ");" + NL + "    queueSender_";
  protected final String TEXT_15 = ".send(type_";
  protected final String TEXT_16 = ",messageQ_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\tjavax.jms.TopicPublisher topicPublisher_";
  protected final String TEXT_19 = "=session_";
  protected final String TEXT_20 = ".createPublisher(type_";
  protected final String TEXT_21 = ");" + NL + "    topicPublisher_";
  protected final String TEXT_22 = ".publish(type_";
  protected final String TEXT_23 = ",messageQ_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\tcom.ibm.mq.MQMessage message_";
  protected final String TEXT_26 = " = new com.ibm.mq.MQMessage();" + NL + "    message_";
  protected final String TEXT_27 = ".writeString(msg_";
  protected final String TEXT_28 = ");" + NL + "    remoteQ_";
  protected final String TEXT_29 = ".put(message_";
  protected final String TEXT_30 = ", opM_";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\t" + NL + "" + NL + "" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		List<IMetadataColumn> columns = metadata.getListColumns();
		List< ? extends IConnection> conns = node.getIncomingConnections();
		if((conns!=null)&&(conns.size()>0)) {
			IConnection conn = conns.get(0);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(((IMetadataColumn)columns.get(0)).getLabel() );
    stringBuffer.append(TEXT_5);
    
				if(serverType.equals("JBoss")){ // server judgement
					String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");


    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
                    if(msgType.equals("Queue")){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
                    }else{

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
					}
				}else{//server judgement   /***WebSphere MQ*****/

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
				}
			}
		}
	}  

    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
