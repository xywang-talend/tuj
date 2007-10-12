package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TLDAPOutputMainJava
{
  protected static String nl;
  public static synchronized TLDAPOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPOutputMainJava result = new TLDAPOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjavax.naming.directory.Attributes entry_";
  protected final String TEXT_3 = " = new javax.naming.directory.BasicAttributes(true);" + NL;
  protected final String TEXT_4 = " " + NL + "\tString dn_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ".trim();";
  protected final String TEXT_8 = NL + "\tif(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " != null){" + NL + "    \tif(";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = ".trim().indexOf(";
  protected final String TEXT_13 = ")>0){" + NL + "    \t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_14 = " = new javax.naming.directory.BasicAttribute(\"";
  protected final String TEXT_15 = "\");" + NL + "    \t\tfor(String value_";
  protected final String TEXT_16 = " : ";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ".trim().split(";
  protected final String TEXT_19 = ")){" + NL + "    \t\t\tattr_";
  protected final String TEXT_20 = ".add(value_";
  protected final String TEXT_21 = ");    \t\t" + NL + "    \t\t}" + NL + "    \t\tentry_";
  protected final String TEXT_22 = ".put(attr_";
  protected final String TEXT_23 = ");" + NL + "    \t}else{" + NL + "    \t\tentry_";
  protected final String TEXT_24 = ".put(\"";
  protected final String TEXT_25 = "\",";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ");" + NL + "    \t}" + NL + "    }";
  protected final String TEXT_28 = " " + NL + "\tctx_";
  protected final String TEXT_29 = ".createSubcontext(dn_";
  protected final String TEXT_30 = ", entry_";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "    ctx_";
  protected final String TEXT_33 = ".modifyAttributes(dn_";
  protected final String TEXT_34 = ", javax.naming.directory.DirContext.REPLACE_ATTRIBUTE, entry_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\tctx_";
  protected final String TEXT_37 = ".destroySubcontext(dn_";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\tboolean found = false;" + NL + "\ttry{" + NL + "\t\tctx_";
  protected final String TEXT_40 = ".getAttributes(dn_";
  protected final String TEXT_41 = ");" + NL + "\t\tfound = true;" + NL + "\t}catch(javax.naming.NameNotFoundException nfEx_";
  protected final String TEXT_42 = ")" + NL + "\t{" + NL + "\t\tctx_";
  protected final String TEXT_43 = ".createSubcontext(dn_";
  protected final String TEXT_44 = ", entry_";
  protected final String TEXT_45 = ");" + NL + "\t}" + NL + "\tif(found)" + NL + "\t{" + NL + "\t\tctx_";
  protected final String TEXT_46 = ".modifyAttributes(dn_";
  protected final String TEXT_47 = ", javax.naming.directory.DirContext.REPLACE_ATTRIBUTE, entry_";
  protected final String TEXT_48 = ");" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String insertMode =ElementParameterParser.getValue(node, "__INSERT_MODE__");
	String separator=ElementParameterParser.getValue(node, "__MULTI_VALUE_SEPARATOR__");
	
	String cid = node.getUniqueName();
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		List<IMetadataColumn> columnList = metadata.getListColumns();
		
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for(IConnection conn:conns){
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
     			String firstConnName = conn.getName();
    			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
					int index = 0;
					for(IMetadataColumn column:columnList){		
						if(index == 0)
						{

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_7);
    
						}else if(!insertMode.equals("DELETE")){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(separator);
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
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_27);
    
						}
						index++;
					}
					if(insertMode.equals("INSERT")){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
					}else if(insertMode.equals("UPDATA")){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
					}else if(insertMode.equals("DELETE")){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
					}else if(insertMode.equals("INSERT_UPDATA")){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
					}
				}
			}
		}
	}

    return stringBuffer.toString();
  }
}
