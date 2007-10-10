package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMsgBoxMainJava
{
  protected static String nl;
  public static synchronized TMsgBoxMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMsgBoxMainJava result = new TMsgBoxMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint messageIcon";
  protected final String TEXT_3 = " = javax.swing.JOptionPane.";
  protected final String TEXT_4 = ";" + NL + "\tString title";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\tString message";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "\tint result";
  protected final String TEXT_9 = " = 0;";
  protected final String TEXT_10 = NL + "\t\tjavax.swing.JOptionPane.showMessageDialog(null, message";
  protected final String TEXT_11 = ", title";
  protected final String TEXT_12 = ", messageIcon";
  protected final String TEXT_13 = ");" + NL + "\t\tresult";
  protected final String TEXT_14 = " = 1;";
  protected final String TEXT_15 = NL + "\t\tjavax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_16 = ", title";
  protected final String TEXT_17 = ", javax.swing.JOptionPane.YES_NO_OPTION, messageIcon";
  protected final String TEXT_18 = ", null, new String[] { \"OK\", \"Cancel\" }, null);" + NL + "\t\tresult";
  protected final String TEXT_19 = " = 1;";
  protected final String TEXT_20 = NL + "\t\tresult";
  protected final String TEXT_21 = " = javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_22 = ", title";
  protected final String TEXT_23 = ", javax.swing.JOptionPane.YES_NO_CANCEL_OPTION, messageIcon";
  protected final String TEXT_24 = ", null, new String[] { \"Abort\", \"Retry\", \"Ignore\" }, null);";
  protected final String TEXT_25 = NL + "\t\tresult";
  protected final String TEXT_26 = " = javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_27 = ", title";
  protected final String TEXT_28 = ", javax.swing.JOptionPane.YES_NO_CANCEL_OPTION, messageIcon";
  protected final String TEXT_29 = ", null, new String[] { \"Yes\", \"No\", \"Cancel\" }, null);";
  protected final String TEXT_30 = NL + "\t\tresult";
  protected final String TEXT_31 = " = javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_32 = ", title";
  protected final String TEXT_33 = ", javax.swing.JOptionPane.YES_NO_OPTION, messageIcon";
  protected final String TEXT_34 = ", null, new String[] { \"Yes\", \"No\" }, null);";
  protected final String TEXT_35 = NL + "\t\tresult";
  protected final String TEXT_36 = " = javax.swing.JOptionPane.showOptionDialog(null, message";
  protected final String TEXT_37 = ", title";
  protected final String TEXT_38 = ", javax.swing.JOptionPane.YES_NO_OPTION, messageIcon";
  protected final String TEXT_39 = ", null, new String[] { \"Retry\", \"Cancel\" }, null);";
  protected final String TEXT_40 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	int button = Integer.parseInt(ElementParameterParser.getValue(node, "__BUTTONS__"));	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ICON__") );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TITLE__") );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
	switch(button) {
		case 0:
		// 0) OK

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			break;
		case 1:
		// 1) OK and Cancel

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
			break;
		case 2:
		// 2) Abort Retry Ignore

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
			break;
		case 3:
		// 3) Yes No and Cancel

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			break;
		case 4:
		// 4) Yes and No

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
			break;
		case 5:
		// 5) Retry and Cancel

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
			break;
		default:
			//do nothing
			break;
	}

    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
