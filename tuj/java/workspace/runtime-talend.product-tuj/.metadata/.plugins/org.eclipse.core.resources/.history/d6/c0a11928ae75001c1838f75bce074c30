package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TRSSOutputMainJava
{
  protected static String nl;
  public static synchronized TRSSOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRSSOutputMainJava result = new TRSSOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  ";
  protected final String TEXT_2 = "\t" + NL + "\t\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_3 = " && file";
  protected final String TEXT_4 = ".exists())" + NL + "\t\t\t{" + NL + "\t\t\t\tjava.util.List list";
  protected final String TEXT_5 = "= document";
  protected final String TEXT_6 = ".selectNodes(\"/rss/channel\" );" + NL + "        \t\tchannelElement";
  protected final String TEXT_7 = "=(org.dom4j.Element)list";
  protected final String TEXT_8 = ".get(0);" + NL + "        \t\tlist";
  protected final String TEXT_9 = "= document";
  protected final String TEXT_10 = ".selectNodes(\"/rss/channel/title\" );" + NL + "        \t\ttitleHElement";
  protected final String TEXT_11 = "=(org.dom4j.Element)list";
  protected final String TEXT_12 = ".get(0);" + NL + "        \t\ttitleHElement";
  protected final String TEXT_13 = ".setText(";
  protected final String TEXT_14 = ");" + NL + "        \t\tlist";
  protected final String TEXT_15 = "= document";
  protected final String TEXT_16 = ".selectNodes(\"/rss/channel/description\" );" + NL + "        \t\tdescriptionHElement";
  protected final String TEXT_17 = "=(org.dom4j.Element)list";
  protected final String TEXT_18 = ".get(0);" + NL + "        \t\tdescriptionHElement";
  protected final String TEXT_19 = ".setText(";
  protected final String TEXT_20 = ");" + NL + "        \t\tlist";
  protected final String TEXT_21 = "= document";
  protected final String TEXT_22 = ".selectNodes(\"/rss/channel/pubdate\" );" + NL + "        \t\tpubdateHElement";
  protected final String TEXT_23 = "=(org.dom4j.Element)list";
  protected final String TEXT_24 = ".get(0);" + NL + "        \t\tpubdateHElement";
  protected final String TEXT_25 = ".setText(";
  protected final String TEXT_26 = ");" + NL + "        \t\tlist";
  protected final String TEXT_27 = "= document";
  protected final String TEXT_28 = ".selectNodes(\"/rss/channel/link\" );" + NL + "        \t\tlinkHElement";
  protected final String TEXT_29 = "=(org.dom4j.Element)list";
  protected final String TEXT_30 = ".get(0);" + NL + "        \t\tlinkHElement";
  protected final String TEXT_31 = ".setText(";
  protected final String TEXT_32 = ");" + NL + "        \t\t" + NL + "        \t}" + NL + "  \t\t \torg.dom4j.Element itemElement = channelElement";
  protected final String TEXT_33 = ".addElement(\"item\");" + NL;
  protected final String TEXT_34 = " \t" + NL + "   \t\torg.dom4j.Element ";
  protected final String TEXT_35 = "Element=itemElement.addElement(\"";
  protected final String TEXT_36 = "\");";
  protected final String TEXT_37 = "\t" + NL + "\t\t" + NL + " \t\t\t\t";
  protected final String TEXT_38 = "Element.setText(";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " ==null ? \"\" : ";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ");" + NL + "\t";
  protected final String TEXT_43 = NL + "\t\t\t\tjava.text.SimpleDateFormat sdfTemp";
  protected final String TEXT_44 = " = new java.text.SimpleDateFormat(\"EEE, d MMM yyyy HH:mm:ss z\",java.util.Locale.US);" + NL + "\t\t\t\t java.util.SimpleTimeZone aZone";
  protected final String TEXT_45 = " = new java.util.SimpleTimeZone(8,\"GMT\");" + NL + "\t\t\t\t sdfTemp";
  protected final String TEXT_46 = ".setTimeZone(aZone";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_48 = "Element.setText(";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " ==null ? \"\" : sdfTemp";
  protected final String TEXT_51 = ".format( ";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = "));" + NL + "\t";
  protected final String TEXT_54 = NL + " \t\t\t\t" + NL + " \t\t\t\t";
  protected final String TEXT_55 = "Element.setText(String.valueOf(";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = "));" + NL + " \t\t\t\t";
  protected final String TEXT_58 = "\t\t " + NL + "\t\t nb_line_";
  protected final String TEXT_59 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    String cid = node.getUniqueName();
    String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
	String title= ElementParameterParser.getValue(node,"__TITLE__");
  	String description= ElementParameterParser.getValue(node,"__DESCRIPTION__");
  	String pubdate= ElementParameterParser.getValue(node,"__PUBDATE__");
  	String link= ElementParameterParser.getValue(node,"__LINK__");
    File file=new File(filename);
    boolean isAppend = ElementParameterParser.getValue(node,"__APPEND__").equals("true");
    List< ? extends IConnection> conns = node.getIncomingConnections();
  
    stringBuffer.append(TEXT_1);
        	
    	if(conns!=null){
    		if (conns.size()>0){
       		IConnection conn =conns.get(0);
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(title);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(description);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(pubdate);
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
    stringBuffer.append(link);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
      			
    			for (int i = 0; i < sizeColumns; i++) {
    			IMetadataColumn column = columns.get(i);
    			String coluLabel=column.getLabel();
    			coluLabel=coluLabel.toLowerCase();
    			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
   
    stringBuffer.append(TEXT_34);
    stringBuffer.append(coluLabel);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(coluLabel);
    stringBuffer.append(TEXT_36);
    		
    			if(javaType == JavaTypesManager.STRING )
				{
	
    stringBuffer.append(TEXT_37);
    stringBuffer.append(coluLabel);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_42);
    		
				}else if(javaType == JavaTypesManager.DATE )
				{
				
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(coluLabel);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_53);
    			
				}else
				{
 	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(coluLabel);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_57);
    						}
					}
				}
			}
		 }

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    		 	
		}
	}

    return stringBuffer.toString();
  }
}
