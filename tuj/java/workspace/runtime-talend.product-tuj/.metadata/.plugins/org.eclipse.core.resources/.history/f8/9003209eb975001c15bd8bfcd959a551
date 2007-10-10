package org.talend.designer.codegen.translators.common;

import org.talend.designer.codegen.config.NodesSubTree;
import org.talend.core.model.process.INode;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IHashableInputConnections;
import org.talend.core.model.process.IHashConfiguration;
import org.talend.core.model.process.IHashableColumn;

public class Subprocess_headerJava
{
  protected static String nl;
  public static synchronized Subprocess_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Subprocess_headerJava result = new Subprocess_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "private class ";
  protected final String TEXT_3 = "Struct";
  protected final String TEXT_4 = " {";
  protected final String TEXT_5 = NL + "\tprivate static final int DEFAULT_HASHCODE = 1;" + NL + "    private static final int PRIME = 31;" + NL + "    private int hashCode = DEFAULT_HASHCODE;" + NL + "    public boolean hashCodeDirty = true;";
  protected final String TEXT_6 = NL + "    " + NL + "\t";
  protected final String TEXT_7 = NL + "    \tprivate ";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = ";" + NL + "\t";
  protected final String TEXT_10 = NL + "    ";
  protected final String TEXT_11 = NL + "    " + NL + "\t@Override" + NL + "\tpublic int hashCode() {" + NL + "\t\tif (this.hashCodeDirty) {" + NL + "\t\t\tfinal int prime = PRIME;" + NL + "\t\t\tint result = DEFAULT_HASHCODE;" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\t\t\tresult = prime * result + (int) this.";
  protected final String TEXT_13 = ";" + NL + "\t";
  protected final String TEXT_14 = NL + "\t\t\t\tresult = prime * result + ((this.";
  protected final String TEXT_15 = " == null) ? 0 : this.";
  protected final String TEXT_16 = ".hashCode());" + NL + "\t";
  protected final String TEXT_17 = NL + "    \t\tthis.hashCode = result;" + NL + "    \t\tthis.hashCodeDirty = false;\t\t" + NL + "\t\t}" + NL + "\t\treturn this.hashCode;" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (this == obj) return true;" + NL + "\t\tif (obj == null) return false;" + NL + "\t\tif (getClass() != obj.getClass()) return false;" + NL + "\t\tfinal ";
  protected final String TEXT_18 = "Struct";
  protected final String TEXT_19 = " other = (";
  protected final String TEXT_20 = "Struct";
  protected final String TEXT_21 = ") obj;" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\tif (this.";
  protected final String TEXT_23 = " != other.";
  protected final String TEXT_24 = ") " + NL + "\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tif (this.";
  protected final String TEXT_26 = " == null) {" + NL + "\t\t\t\t\t\tif (other.";
  protected final String TEXT_27 = " != null) " + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t} else if (!this.";
  protected final String TEXT_28 = ".equals(other.";
  protected final String TEXT_29 = ")) " + NL + "\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\treturn true;" + NL + "    }" + NL + "    ";
  protected final String TEXT_31 = NL + "    " + NL + "}";
  protected final String TEXT_32 = NL + NL + "public void ";
  protected final String TEXT_33 = "Process() throws TalendException {";
  protected final String TEXT_34 = NL + "\tString currentComponent = \"\";";
  protected final String TEXT_35 = "\t\t\t\t" + NL + "\ttry {";
  protected final String TEXT_36 = NL + "\t\t";
  protected final String TEXT_37 = "Process();";
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = NL + "\t\t";
  protected final String TEXT_40 = "\t\t  " + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t";

    public String createPrivateClassInstance(INode n, String parentLastRoot, boolean force) {
        String toReturn = "";
        // declare root structs (all main outgoing connections)
        for (IConnection conn : n.getOutgoingConnections()) {
            if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) {
                if ((force)||(n.isSubProcessStart() || !(n.getComponent().isDataAutoPropagated()))) {
                    // new Instance
                    toReturn += conn.getName() + "Struct " + conn.getName() + " = new " + conn.getName()
                            + "Struct();\n";
                    parentLastRoot = conn.getName();
                } else {
                    // copy
                    toReturn += parentLastRoot + "Struct " + conn.getName() + " = " + parentLastRoot + ";\n";
                }
                if(!conn.getTarget().getComponent().useMerge()) {
                   toReturn += createPrivateClassInstance(conn.getTarget(), parentLastRoot, false);
                }
            } else if (conn.getLineStyle().equals(EConnectionType.ITERATE)) {
            	toReturn += createPrivateClassInstance(conn.getTarget(), parentLastRoot, true);
            }
        }
        return toReturn;
    }
		 
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	NodesSubTree subTree = (NodesSubTree) codeGenArgument.getArgument();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();

    stringBuffer.append(TEXT_1);
    
	HashSet<String> hSet = new HashSet<String>();
	for (INode node : subTree.getNodes()) {
		List<IMetadataTable> metadatas = node.getMetadataList();
			List< ? extends IConnection> conns = node.getOutgoingConnections();
			for (IConnection conn : conns) {
				// templateOrigin is used for Virtual COmponents
				String templateOrigin = "";
				if (conn.getTarget()!=null) {
					templateOrigin = ElementParameterParser.getValue(conn.getTarget(), "__ORIGIN__");
				}
				if (
					(templateOrigin.compareTo("")!=0) ||
					(conn.getLineStyle().equals(EConnectionType.FLOW_MAIN))||
					(conn.getLineStyle().equals(EConnectionType.FLOW_REF)) ||
					(conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) 
				) {
					if (!hSet.contains(conn.getName() + templateOrigin)) {
						hSet.add(conn.getName() + templateOrigin);
						IMetadataTable metadata = conn.getMetadataTable();
						
						Set<String> hashableColumnsNames = new HashSet<String>();
						if(conn.getTarget() instanceof IHashableInputConnections) {
							IHashableInputConnections target = (IHashableInputConnections) conn.getTarget();
							IHashConfiguration hashConfiguration = target.getHashConfiguration(conn.getName());
							if(hashConfiguration != null) {
								for(IHashableColumn hashableColumn : hashConfiguration.getHashableColumns()) {
									hashableColumnsNames.add(hashableColumn.getName());
								}
							}
						} else {
							if (metadata!=null) { 
								for (IMetadataColumn column: metadata.getListColumns()) {
									if (column.isKey()) {
										hashableColumnsNames.add(column.getLabel());
									}
								}
							}
						}
						boolean hasAtLeastOneKey = hashableColumnsNames.size() > 0;
						

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(templateOrigin );
    stringBuffer.append(TEXT_4);
    
	if(hasAtLeastOneKey) {

    stringBuffer.append(TEXT_5);
    
	}

    stringBuffer.append(TEXT_6);
    
		if (metadata !=null) {
			for (IMetadataColumn column: metadata.getListColumns()) {
    
    stringBuffer.append(TEXT_7);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_9);
    
			}
		}
    
    stringBuffer.append(TEXT_10);
    
	if(hasAtLeastOneKey) {
	
    stringBuffer.append(TEXT_11);
    
		if (metadata !=null) {
			for (IMetadataColumn column: metadata.getListColumns()) {
				if (hashableColumnsNames.contains(column.getLabel())) {
					if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
	
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    
				} else {
	
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    
					}
				}
			}
		}
    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(templateOrigin );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(templateOrigin );
    stringBuffer.append(TEXT_21);
    	
		if (metadata !=null) {
			for (IMetadataColumn column: metadata.getListColumns()) {
				if (hashableColumnsNames.contains(column.getLabel())) {
					if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
				
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    
					} else {
				
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    
					}
				}
			}
    	}
    
    stringBuffer.append(TEXT_30);
    
	}
	
    stringBuffer.append(TEXT_31);
    
						}
					}
				}
	}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(subTree.getName() );
    stringBuffer.append(TEXT_33);
    
	if(isRunInMultiThread){

    stringBuffer.append(TEXT_34);
    
	}

    stringBuffer.append(TEXT_35);
    
	// Call for RUN AFTER links
	for (String after : subTree.getAfterSubProcesses()) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(after );
    stringBuffer.append(TEXT_37);
    
	}

    stringBuffer.append(TEXT_38);
    
	if(!subTree.isMergeSubTree()) {
	List< ? extends IConnection> rootConns = subTree.getRootNode().getOutgoingConnections();
	if ((rootConns!=null)&&(rootConns.size()>0)) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(createPrivateClassInstance(subTree.getRootNode(), rootConns.get(0).getName(), false));
    
	}
  } else {  
  
    List<INode> sortedMergeBranchStarts = subTree.getSortedMergeBranchStarts();    
    for (INode startNode : sortedMergeBranchStarts) {
       List< ? extends IConnection> rootConns = startNode.getOutgoingConnections();
       if ((rootConns!=null)&&(rootConns.size()>0)) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(createPrivateClassInstance(startNode, rootConns.get(0).getName(), false));
    
      }
    }
    
	List< ? extends IConnection> rootConns = subTree.getMergeNode().getOutgoingConnections();
	if ((rootConns!=null)&&(rootConns.size()>0)) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(createPrivateClassInstance(subTree.getMergeNode(), rootConns.get(0).getName(), false));
    
	}
    
  }

    return stringBuffer.toString();
  }
}