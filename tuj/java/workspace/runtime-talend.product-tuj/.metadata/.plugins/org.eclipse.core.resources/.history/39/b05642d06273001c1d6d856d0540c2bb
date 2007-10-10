package org.talend.designer.codegen.translators.business.vtigercrm;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TVtigerCRMInputEndJava
{
  protected static String nl;
  public static synchronized TVtigerCRMInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVtigerCRMInputEndJava result = new TVtigerCRMInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String method = ElementParameterParser.getValue(node, "__METHODNAME__");
List<IMetadataColumn> metadataColumns = null;
List<IMetadataTable> metadataTables = node.getMetadataList();
if(metadataTables != null && metadataTables.size() > 0) {
    IMetadataTable metadataTable = metadataTables.get(0);
    if(metadataTable != null) {
        metadataColumns = metadataTable.getListColumns();
        if(metadataColumns != null && metadataColumns.size() > 0) {
            if(method.equals("searchContactsByEmail") || method.equals("getContacts") || method.equals("getTasks") || method.equals("getClndr") || method.equals("get_KBase_details")) {
                
    stringBuffer.append(TEXT_2);
    
            }
        }
    }
}

    return stringBuffer.toString();
  }
}
