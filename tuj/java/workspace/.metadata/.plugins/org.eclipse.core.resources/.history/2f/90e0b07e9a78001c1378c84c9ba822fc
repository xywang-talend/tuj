package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.commons.utils.StringUtils;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;

public class TRSSInputBeginJava
{
  protected static String nl;
  public static synchronized TRSSInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRSSInputBeginJava result = new TRSSInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "    String rssurl";
  protected final String TEXT_3 = "=";
  protected final String TEXT_4 = ";" + NL + "    int aMount";
  protected final String TEXT_5 = "=";
  protected final String TEXT_6 = ";" + NL + "    java.net.URL url";
  protected final String TEXT_7 = " = new java.net.URL(rssurl";
  protected final String TEXT_8 = ");" + NL + "    it.sauronsoftware.feed4j.bean.Feed feed";
  protected final String TEXT_9 = "= it.sauronsoftware.feed4j.FeedParser.parse(url";
  protected final String TEXT_10 = " );" + NL + "   \tString row";
  protected final String TEXT_11 = "[]=new String [4];" + NL + "  \t int items";
  protected final String TEXT_12 = "=feed";
  protected final String TEXT_13 = ".getItemCount();" + NL + "  \t " + NL + "  \t ";
  protected final String TEXT_14 = NL + "  \t   \t\tif(aMount";
  protected final String TEXT_15 = "< items";
  protected final String TEXT_16 = ")" + NL + "  \t   \t\t{" + NL + "  \t   \t\t\titems";
  protected final String TEXT_17 = "=aMount";
  protected final String TEXT_18 = ";" + NL + "  \t   \t\t}" + NL + "  \t " + NL + "  \t ";
  protected final String TEXT_19 = NL + "      for (int i_";
  protected final String TEXT_20 = "; i_";
  protected final String TEXT_21 = " = feed";
  protected final String TEXT_22 = ".getItem(i_";
  protected final String TEXT_23 = "[0]=itm";
  protected final String TEXT_24 = ".getTitle();" + NL + "          row";
  protected final String TEXT_25 = "[1]=itm";
  protected final String TEXT_26 = ".getDescriptionAsText();" + NL + "          row";
  protected final String TEXT_27 = "[2]=(itm";
  protected final String TEXT_28 = ".getPubDate()==null ? \"\" :itm";
  protected final String TEXT_29 = ".getPubDate().toGMTString());" + NL + "          row";
  protected final String TEXT_30 = "[3]=(itm";
  protected final String TEXT_31 = ".getLink()==null ? \"\" :itm";
  protected final String TEXT_32 = ".getLink().toString());";
  protected final String TEXT_33 = "       \t" + NL + "          \tjava.util.Date d";
  protected final String TEXT_34 = "=new java.util.Date();" + NL + "          \tjava.text.SimpleDateFormat formatterDate";
  protected final String TEXT_35 = "=new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "          \td";
  protected final String TEXT_36 = "=formatterDate";
  protected final String TEXT_37 = ".parse(";
  protected final String TEXT_38 = ");" + NL + "          \t java.util.Date pubDate";
  protected final String TEXT_39 = "=new java.util.Date(row";
  protected final String TEXT_40 = "[2]);" + NL + "         \t int value";
  protected final String TEXT_41 = "=pubDate";
  protected final String TEXT_42 = ".compareTo(d";
  protected final String TEXT_43 = ");" + NL + "         \t if(value";
  protected final String TEXT_44 = "<0)" + NL + "         \t {" + NL + "         \t \tcontinue;" + NL + "         \t }";
  protected final String TEXT_45 = "        " + NL;
  protected final String TEXT_46 = NL + " \t\t\t" + NL + " \t\t\t";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "=row";
  protected final String TEXT_49 = "[";
  protected final String TEXT_50 = "];";
  protected final String TEXT_51 = NL + NL + NL + NL;
  protected final String TEXT_52 = NL;

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
        String rss= ElementParameterParser.getValue(node,"__RSS__");
        boolean isDate=ElementParameterParser.getValue(node,"__ARTICLE_DATE__").equals("true");
        boolean isAmount=ElementParameterParser.getValue(node,"__ARTICLE_AMOUNT__").equals("true");
        String  dateTime=ElementParameterParser.getValue(node,"__DATE__");
        String  amount=ElementParameterParser.getValue(node,"__AMOUNT__");
       	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rss);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(amount);
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
    
  	 if(isAmount){
  	 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
  	  }
  	 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid> = 0; i_<%=cid> < items<%=cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid>++) {
         it.sauronsoftware.feed4j.bean.FeedItem itm<%=cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid>);
          row<%=cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
            if(isDate)
          {
  
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dateTime);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
           	
          }
  
    stringBuffer.append(TEXT_45);
    
	if(conns!=null){
    		if (conns.size()>0){
       		IConnection conn =conns.get(0);
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			for (int j = 0; j < sizeColumns; j++) {
    			IMetadataColumn column = columns.get(j);
    			
 
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_50);
    
    				}
				}
		
			}
		}
	}
}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
