package org.talend.designer.codegen.translators.dataquality;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.commons.utils.StringUtils;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;

public class TAddCRCRowMainJava
{
  protected static String nl;
  public static synchronized TAddCRCRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAddCRCRowMainJava result = new TAddCRCRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    String crcComputedValue";
  protected final String TEXT_2 = "=\"\";";
  protected final String TEXT_3 = NL + "    \tStringBuffer strBuffer_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "    \t\t\tstrBuffer_";
  protected final String TEXT_6 = ".append(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ");" + NL + "    \t\t\t";
  protected final String TEXT_9 = NL + "   \t\t" + NL + "    \t\tjava.util.zip.CRC32 crc32";
  protected final String TEXT_10 = " = new java.util.zip.CRC32();  " + NL + "    \t\tcrc32";
  protected final String TEXT_11 = ".update(strBuffer_";
  protected final String TEXT_12 = ".toString().getBytes());" + NL + "    \t    crcComputedValue";
  protected final String TEXT_13 = "=Long.toOctalString(crc32";
  protected final String TEXT_14 = ".getValue());" + NL + " \t\t";
  protected final String TEXT_15 = NL + "   \t\t" + NL + "   \t\tcrcComputedValue";
  protected final String TEXT_16 = "= Integer.toString(com.dalsemi.onewire.utils.CRC8.compute(strBuffer_";
  protected final String TEXT_17 = ".toString().getBytes()));\t";
  protected final String TEXT_18 = "      " + NL + "   \t\tcrcComputedValue";
  protected final String TEXT_19 = "=Integer.toString(com.dalsemi.onewire.utils.CRC16.compute(strBuffer_";
  protected final String TEXT_20 = ".toString().getBytes()));\t\t";
  protected final String TEXT_21 = NL + "   \t\t\t";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = "=";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = NL + "\t\t\t\t";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = "=crcComputedValue";
  protected final String TEXT_29 = ";" + NL + "\t";
  protected final String TEXT_30 = NL + "\tnb_line_";
  protected final String TEXT_31 = "++;";
  protected final String TEXT_32 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String crcType = ElementParameterParser.getValue(node,"__CRC_TYPE__");
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null)
     {
        String cid = node.getUniqueName();
        List<Map<String, String>> implication =(List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__IMPLICATION__");
        List keyCols = new ArrayList();
		for (int i=0; i<implication.size(); i++) {
            Map<String, String> col = implication.get(i);
            if (col.get("USE_IN_CRC").equals("true")) {
                keyCols.add(i);
            }
        }
       List< ? extends IConnection> conns = node.getIncomingConnections();
  
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
      if(conns!=null){
   		if (conns.size()>0){
       
       	IConnection conn =conns.get(0);
       	List<IMetadataColumn> columns = metadata.getListColumns();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
    	for (int i = 0; i < columns.size()-1; i++) {
    		IMetadataColumn column = columns.get(i);
    		if(keyCols.contains(i))
    		{
    		

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_8);
    	
  			}
		 
    	}
   if(crcType.equals("crc32")){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    	   		
        	}   
       if(crcType.equals("crc8")){
          
   
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
           
          }	
          if(crcType.equals("crc16")){
          
    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
          
          }
          List< ? extends IConnection> connsout = node.getOutgoingConnections(); 
           if (connsout!=null) {
           List<IMetadataColumn> columnsout = metadata.getListColumns();
			 for(int i=0;i<connsout.size();i++) {
			 	IConnection connout = connsout.get(i);
			 if(connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			 	{
			 	int columnSize=columnsout.size()-1;
    			for (int j = 0; j < columnSize; j++) {
    			   IMetadataColumn columnout=columnsout.get(j);
    			   
   
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnout.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(columnout.getLabel() );
    stringBuffer.append(TEXT_25);
     			  
		          }  
		        IMetadataColumn columnout=columnsout.get(columnSize); 
	
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnout.getLabel() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    	                
				}
				}
			}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
		}   
     } 
        		
	}
}

    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
