package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TLDAPInputBeginJava
{
  protected static String nl;
  public static synchronized TLDAPInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPInputBeginJava result = new TLDAPInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint ";
  protected final String TEXT_3 = "_NB_LINE = 0;" + NL + "\tjava.util.Hashtable env_";
  protected final String TEXT_4 = " = new java.util.Hashtable();" + NL + "\tenv_";
  protected final String TEXT_5 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "    env_";
  protected final String TEXT_6 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"" + NL + "\tenv_";
  protected final String TEXT_7 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_8 = "\");" + NL + "\tenv_";
  protected final String TEXT_9 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_10 = "\");";
  protected final String TEXT_11 = NL + "\tenv_";
  protected final String TEXT_12 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_13 = "+\":\"+";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\tenv_";
  protected final String TEXT_16 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_17 = "+\":\"+";
  protected final String TEXT_18 = "+\"/\"+";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "    env_";
  protected final String TEXT_21 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_22 = ");" + NL + "    env_";
  protected final String TEXT_23 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, ";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\tenv_";
  protected final String TEXT_26 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\tenv_";
  protected final String TEXT_27 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_28 = NL + "\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "    javax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_33 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_34 = ", null);";
  protected final String TEXT_35 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_36 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "    javax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_37 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_38 = ".extendedOperation(tldsReq_";
  protected final String TEXT_39 = ");" + NL + "    javax.net.ssl.SSLSession session_";
  protected final String TEXT_40 = " = tls_";
  protected final String TEXT_41 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());";
  protected final String TEXT_42 = NL + "\tjavax.naming.directory.SearchControls searchCtls_";
  protected final String TEXT_43 = " = new javax.naming.directory.SearchControls();" + NL + "    searchCtls_";
  protected final String TEXT_44 = ".setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);" + NL + "    searchCtls_";
  protected final String TEXT_45 = ".setReturningAttributes(new String[]{";
  protected final String TEXT_46 = NL + "\t\t\"";
  protected final String TEXT_47 = "\",";
  protected final String TEXT_48 = "    " + NL + "    });" + NL + "    searchCtls_";
  protected final String TEXT_49 = ".setTimeLimit(";
  protected final String TEXT_50 = "*1000);";
  protected final String TEXT_51 = NL + "\t//get basce dn" + NL + "\tjavax.naming.directory.Attributes attrsNaming_";
  protected final String TEXT_52 = " = ctx_";
  protected final String TEXT_53 = ".getAttributes(\"\",new String[] {\"namingContexts\"});" + NL + "    javax.naming.directory.Attribute aNaming_";
  protected final String TEXT_54 = " = attrsNaming_";
  protected final String TEXT_55 = ".get(\"namingContexts\");" + NL + "    if(aNaming_";
  protected final String TEXT_56 = " == null)" + NL + "    {" + NL + "        aNaming_";
  protected final String TEXT_57 = " =attrsNaming_";
  protected final String TEXT_58 = ".get(\"namingcontexts\");" + NL + "    }" + NL + "    // String searchBase = (aNaming_";
  protected final String TEXT_59 = "==null)|())?\"\":aNaming_";
  protected final String TEXT_60 = ".get().toString();         " + NL + "\tString searchBase = ((aNaming_";
  protected final String TEXT_61 = " == null) || ((aNaming_";
  protected final String TEXT_62 = " != null)" + NL + "                    && (aNaming_";
  protected final String TEXT_63 = ".get().toString() != null)" + NL + "                    && (aNaming_";
  protected final String TEXT_64 = ".get().toString().length() > 0) && (Character" + NL + "                    .isIdentifierIgnorable(aNaming_";
  protected final String TEXT_65 = ".get().toString().charAt(0))))) ? \"\"" + NL + "                    : aNaming_";
  protected final String TEXT_66 = ".get().toString();" + NL + "\t" + NL + "    javax.naming.NamingEnumeration answer_";
  protected final String TEXT_67 = " = ctx_";
  protected final String TEXT_68 = ".search(searchBase, ";
  protected final String TEXT_69 = ", searchCtls_";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "\tjavax.naming.NamingEnumeration answer_";
  protected final String TEXT_72 = " = ctx_";
  protected final String TEXT_73 = ".search(\"\", ";
  protected final String TEXT_74 = ", searchCtls_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\tint entryCount_";
  protected final String TEXT_77 = " = 0;" + NL + "    while (answer_";
  protected final String TEXT_78 = " .hasMoreElements()) {//a" + NL + "    \tif(entryCount_";
  protected final String TEXT_79 = " >= ";
  protected final String TEXT_80 = "){" + NL + "    \t\tbreak;" + NL + "    \t}" + NL + "    \t";
  protected final String TEXT_81 = "_NB_LINE++;" + NL + "        javax.naming.directory.SearchResult sr_";
  protected final String TEXT_82 = "  = (javax.naming.directory.SearchResult) answer_";
  protected final String TEXT_83 = ".next();" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_84 = "_RESULT_NAME\",sr_";
  protected final String TEXT_85 = ".getName());" + NL + "        javax.naming.directory.Attributes attrs_";
  protected final String TEXT_86 = " = sr_";
  protected final String TEXT_87 = ".getAttributes();" + NL + "" + NL + "     // for output";
  protected final String TEXT_88 = NL + "                        " + NL + "        if (attrs_";
  protected final String TEXT_89 = " != null) {//b" + NL + "        \tentryCount_";
  protected final String TEXT_90 = "++;";
  protected final String TEXT_91 = "        \t" + NL + "\t\t\tjavax.naming.directory.Attribute attr_";
  protected final String TEXT_92 = "_";
  protected final String TEXT_93 = " = attrs_";
  protected final String TEXT_94 = ".get(\"";
  protected final String TEXT_95 = "\");" + NL + "\t\t\tif(attr_";
  protected final String TEXT_96 = "_";
  protected final String TEXT_97 = " != null)" + NL + "\t\t\t{" + NL + "    \t\t\tStringBuffer attrStr_";
  protected final String TEXT_98 = " = new StringBuffer();" + NL + "    \t\t\tfor (javax.naming.NamingEnumeration e_";
  protected final String TEXT_99 = " = attr_";
  protected final String TEXT_100 = "_";
  protected final String TEXT_101 = ".getAll(); e_";
  protected final String TEXT_102 = ".hasMore();){" + NL + "    \t\t\t\tif(attrStr_";
  protected final String TEXT_103 = ".length()>0){" + NL + "    \t\t\t\t\tattrStr_";
  protected final String TEXT_104 = ".append(";
  protected final String TEXT_105 = ");" + NL + "    \t\t\t\t}" + NL + "    \t\t\t\tattrStr_";
  protected final String TEXT_106 = ".append(e_";
  protected final String TEXT_107 = ".next().toString());" + NL + "    \t\t\t}" + NL + "    \t\t\t";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = " = attrStr_";
  protected final String TEXT_110 = ".toString();" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = " = null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_113 = NL + "                ";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = ";";
  protected final String TEXT_118 = NL + "///////////////////////////////////        ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	    if ((metadatas!=null)&&(metadatas.size()>0)) {
	        IMetadataTable metadata = metadatas.get(0);	        
	        if(metadata!=null) {

	List<IMetadataColumn> columnList = metadata.getListColumns();
	String cid = node.getUniqueName();
	String host=ElementParameterParser.getValue(node, "__HOST__");
	String port=ElementParameterParser.getValue(node, "__PORT__");
	String baseDN=ElementParameterParser.getValue(node, "__BASEDN__");
	String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
	String filter=ElementParameterParser.getValue(node, "__FILTER__");
	String separator=ElementParameterParser.getValue(node, "__MULTI_VALUE_SEPARATOR__");
	String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
	String storepath=ElementParameterParser.getValue(node, "__STORECA__");
	String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
	String aliases=ElementParameterParser.getValue(node, "__ALIASES__");
	String limit =ElementParameterParser.getValue(node, "__LIMIT__");
	String timeout =ElementParameterParser.getValue(node, "__TIMEOUT__");
	String authen =ElementParameterParser.getValue(node, "__AUTHENTIFICATION__");
	String user =ElementParameterParser.getValue(node, "__USER__");
	String passwd =ElementParameterParser.getValue(node, "__PASSWD__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_10);
    
	if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_14);
    
	}else{

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_19);
    
	}
    if(authen.equals("true")){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(passwd);
    stringBuffer.append(TEXT_24);
    
    }
    if(protocol.equals("LDAPS")){

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
		if(advanced.equals("true")){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_29);
    
		}
    }else if(protocol.equals("TLS")){
    	if(advanced.equals("true")){

    stringBuffer.append(TEXT_30);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_31);
    
		}
    }

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	if(protocol.equals("TLS")){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
	}

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
					for(IMetadataColumn column:columnList){		

    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_47);
    
                	}

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_50);
    
					if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
					}else{

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(filter);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
					}

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
            List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
            String firstConnName = "";
            if (conns!=null) {//1
                if (conns.size()>0) {//2
                
                    IConnection conn = conns.get(0); //the first connection
                    firstConnName = conn.getName();         
                    if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3

                        
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
					for(IMetadataColumn column:columnList){//5		

    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    
                	}//5

        }//3
        
        
        if (conns.size()>1) {
            for (int i=1;i<conns.size();i++) {
                IConnection conn2 = conns.get(i);
                if ((conn2.getName().compareTo(firstConnName)!=0)&&(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
                    for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(conn2.getName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_117);
    
                    }
                }
            }
        }
        
        
    }//2
    
}//1


    stringBuffer.append(TEXT_118);
    
  }
}  
 
    return stringBuffer.toString();
  }
}
