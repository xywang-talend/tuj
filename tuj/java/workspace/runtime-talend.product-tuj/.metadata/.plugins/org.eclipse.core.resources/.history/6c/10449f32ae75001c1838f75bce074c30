package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TLDAPOutputBeginJava
{
  protected static String nl;
  public static synchronized TLDAPOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPOutputBeginJava result = new TLDAPOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.Hashtable env_";
  protected final String TEXT_3 = " = new java.util.Hashtable();" + NL + "\tenv_";
  protected final String TEXT_4 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, \"com.sun.jndi.ldap.LdapCtxFactory\");" + NL + "    env_";
  protected final String TEXT_5 = ".put(javax.naming.Context.SECURITY_AUTHENTICATION, \"simple\");// \"none\",\"simple\",\"strong\"" + NL + "    env_";
  protected final String TEXT_6 = ".put(javax.naming.Context.SECURITY_PRINCIPAL, ";
  protected final String TEXT_7 = ");" + NL + "    env_";
  protected final String TEXT_8 = ".put(javax.naming.Context.SECURITY_CREDENTIALS, ";
  protected final String TEXT_9 = ");" + NL + "\tenv_";
  protected final String TEXT_10 = ".put(javax.naming.Context.REFERRAL, \"";
  protected final String TEXT_11 = "\");" + NL + "\tenv_";
  protected final String TEXT_12 = ".put(\"java.naming.ldap.derefAliases\",\"";
  protected final String TEXT_13 = "\");";
  protected final String TEXT_14 = NL + "\tenv_";
  protected final String TEXT_15 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_16 = "+\":\"+";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\tenv_";
  protected final String TEXT_19 = ".put(javax.naming.Context.PROVIDER_URL, \"ldap://\"+";
  protected final String TEXT_20 = "+\":\"+";
  protected final String TEXT_21 = "+\"/\"+";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\tenv_";
  protected final String TEXT_24 = ".put(javax.naming.Context.SECURITY_PROTOCOL, \"ssl\");" + NL + "\tenv_";
  protected final String TEXT_25 = ".put(\"java.naming.ldap.factory.socket\", \"talend.ssl.AdvancedSocketFactory\");";
  protected final String TEXT_26 = NL + "\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\ttalend.ssl.AdvancedSocketFactory.setCertStorePath(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "    javax.naming.ldap.InitialLdapContext ctx_";
  protected final String TEXT_31 = " = new javax.naming.ldap.InitialLdapContext(env_";
  protected final String TEXT_32 = ", null);";
  protected final String TEXT_33 = NL + "\tjavax.naming.ldap.StartTlsRequest tldsReq_";
  protected final String TEXT_34 = " = new javax.naming.ldap.StartTlsRequest();" + NL + "    javax.naming.ldap.StartTlsResponse tls_";
  protected final String TEXT_35 = " =(javax.naming.ldap.StartTlsResponse)ctx_";
  protected final String TEXT_36 = ".extendedOperation(tldsReq_";
  protected final String TEXT_37 = ");" + NL + "    javax.net.ssl.SSLSession session_";
  protected final String TEXT_38 = " = tls_";
  protected final String TEXT_39 = ".negotiate((javax.net.ssl.SSLSocketFactory)talend.ssl.AdvancedSocketFactory.getDefault());";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String host=ElementParameterParser.getValue(node, "__HOST__");
	String port=ElementParameterParser.getValue(node, "__PORT__");
	String baseDN=ElementParameterParser.getValue(node, "__BASEDN__");
	String protocol=ElementParameterParser.getValue(node, "__PROTOCOL__");
	String advanced=ElementParameterParser.getValue(node, "__ADVANCEDCA__");
	String storepath=ElementParameterParser.getValue(node, "__STORECA__");
	String user =ElementParameterParser.getValue(node, "__USER__");
	String passwd =ElementParameterParser.getValue(node, "__PASSWD__");
	String referrals=ElementParameterParser.getValue(node, "__REFERRALS__");
	String aliases=ElementParameterParser.getValue(node, "__ALIASES__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(passwd);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(referrals);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(aliases);
    stringBuffer.append(TEXT_13);
    
	if(baseDN == null || baseDN.length()<=2){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_17);
    
	}else{

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(baseDN);
    stringBuffer.append(TEXT_22);
    
	}
    if(protocol.equals("LDAPS")){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
		if(advanced.equals("true")){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_27);
    
		}
    }else if(protocol.equals("TLS")){
    	if(advanced.equals("true")){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(storepath);
    stringBuffer.append(TEXT_29);
    
		}
    }

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	if(protocol.equals("TLS")){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
	}

    return stringBuffer.toString();
  }
}
