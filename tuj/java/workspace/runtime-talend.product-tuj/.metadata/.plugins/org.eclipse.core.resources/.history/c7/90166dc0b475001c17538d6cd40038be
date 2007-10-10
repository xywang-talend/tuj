package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSendMailMainJava
{
  protected static String nl;
  public static synchronized TSendMailMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSendMailMainJava result = new TSendMailMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t String message_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\t java.util.Properties props_";
  protected final String TEXT_5 = " = System.getProperties();     " + NL + "     props_";
  protected final String TEXT_6 = ".put(\"mail.smtp.host\", smtpHost_";
  protected final String TEXT_7 = ");" + NL + "     props_";
  protected final String TEXT_8 = ".put(\"mail.smtp.port\", smtpPort_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = "  " + NL + "     props_";
  protected final String TEXT_11 = ".put(\"mail.smtp.auth\", \"false\");" + NL + "     javax.mail.Session session_";
  protected final String TEXT_12 = " = javax.mail.Session.getDefaultInstance(props_";
  protected final String TEXT_13 = ", null);    ";
  protected final String TEXT_14 = "   " + NL + "\t props_";
  protected final String TEXT_15 = ".put(\"mail.smtp.auth\", \"true\");" + NL + "     javax.mail.Session session_";
  protected final String TEXT_16 = " = javax.mail.Session.getDefaultInstance(props_";
  protected final String TEXT_17 = ", new  javax.mail.Authenticator ()" + NL + "        {         " + NL + "         protected javax.mail.PasswordAuthentication getPasswordAuthentication() {" + NL + "             return new javax.mail.PasswordAuthentication(";
  protected final String TEXT_18 = ",";
  protected final String TEXT_19 = "); " + NL + "         }         " + NL + "       }     " + NL + "     );   ";
  protected final String TEXT_20 = NL + "     javax.mail.Message msg_";
  protected final String TEXT_21 = " = new javax.mail.internet.MimeMessage(session_";
  protected final String TEXT_22 = ");" + NL + "     msg_";
  protected final String TEXT_23 = ".setFrom(new javax.mail.internet.InternetAddress(from_";
  protected final String TEXT_24 = "));" + NL + "     msg_";
  protected final String TEXT_25 = ".setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_";
  protected final String TEXT_26 = ", false));" + NL + "     if(cc_";
  protected final String TEXT_27 = "!=null)  msg_";
  protected final String TEXT_28 = ".setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_";
  protected final String TEXT_29 = ", false));" + NL + "     if(bcc_";
  protected final String TEXT_30 = "!=null)  msg_";
  protected final String TEXT_31 = ".setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_";
  protected final String TEXT_32 = ", false));" + NL + "     " + NL + "     msg_";
  protected final String TEXT_33 = ".setSubject(subject_";
  protected final String TEXT_34 = ");     " + NL + "" + NL + "\tfor (int i_";
  protected final String TEXT_35 = " = 0; i_";
  protected final String TEXT_36 = " < headers_";
  protected final String TEXT_37 = ".size(); i_";
  protected final String TEXT_38 = "++) {" + NL + "   \t\tjava.util.Map<String, String> header_";
  protected final String TEXT_39 = " = headers_";
  protected final String TEXT_40 = ".get(i_";
  protected final String TEXT_41 = ");" + NL + "\t    msg_";
  protected final String TEXT_42 = ".setHeader(header_";
  protected final String TEXT_43 = ".get(\"KEY\"), header_";
  protected final String TEXT_44 = ".get(\"VALUE\"));\t\t" + NL + "\t}" + NL + "\t\t" + NL + "     msg_";
  protected final String TEXT_45 = ".setSentDate(new Date());     " + NL + "     javax.mail.Multipart mp_";
  protected final String TEXT_46 = " = new javax.mail.internet.MimeMultipart();" + NL + "     javax.mail.internet.MimeBodyPart mbpText_";
  protected final String TEXT_47 = " = new javax.mail.internet.MimeBodyPart();     " + NL + "     mbpText_";
  protected final String TEXT_48 = ".setText(message_";
  protected final String TEXT_49 = ");" + NL + "\t mp_";
  protected final String TEXT_50 = ".addBodyPart(mbpText_";
  protected final String TEXT_51 = ");" + NL + "\t \t" + NL + "     for(int i_";
  protected final String TEXT_52 = " = 0; i_";
  protected final String TEXT_53 = " < attachments_";
  protected final String TEXT_54 = ".size(); i_";
  protected final String TEXT_55 = "++)" + NL + "     {" + NL + "       javax.mail.internet.MimeBodyPart mbpFile_";
  protected final String TEXT_56 = " = new javax.mail.internet.MimeBodyPart();" + NL + "       String filename_";
  protected final String TEXT_57 = " = attachments_";
  protected final String TEXT_58 = ".get(i_";
  protected final String TEXT_59 = ");        " + NL + "       javax.activation.FileDataSource fds_";
  protected final String TEXT_60 = " = new javax.activation.FileDataSource(filename_";
  protected final String TEXT_61 = " );" + NL + "       mbpFile_";
  protected final String TEXT_62 = ".setDataHandler(new javax.activation.DataHandler(fds_";
  protected final String TEXT_63 = "));" + NL + "       mbpFile_";
  protected final String TEXT_64 = ".setFileName(fds_";
  protected final String TEXT_65 = ".getName());" + NL + "       mp_";
  protected final String TEXT_66 = ".addBodyPart(mbpFile_";
  protected final String TEXT_67 = ");" + NL + "     }    " + NL + "       " + NL + "     // -- set the content --   " + NL + "      msg_";
  protected final String TEXT_68 = ".setContent(mp_";
  protected final String TEXT_69 = ");" + NL + "           " + NL + "     // -- Send the message --" + NL + "     javax.mail.Transport.send(msg_";
  protected final String TEXT_70 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String needAuth = ElementParameterParser.getValue(node, "__NEED_AUTH__");
	String authUsername = ElementParameterParser.getValue(node, "__AUTH_USERNAME__");
	String authPassword = ElementParameterParser.getValue(node, "__AUTH_PASSWORD__");
	// component id
	String cid = node.getUniqueName();
	String message     = ElementParameterParser.getValue(node, "__MESSAGE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append((message==null || "".equals(message))?"\"\"":message );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
     
   if ("false".equals(needAuth)) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
  } else  
  {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(authUsername );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(authPassword );
    stringBuffer.append(TEXT_19);
    
  }

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    return stringBuffer.toString();
  }
}
