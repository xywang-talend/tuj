package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TWaitForFileBeginJava
{
  protected static String nl;
  public static synchronized TWaitForFileBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWaitForFileBeginJava result = new TWaitForFileBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "        class Util_";
  protected final String TEXT_2 = " {" + NL + "" + NL + "            private boolean flagt = false;" + NL + "" + NL + "            private java.util.regex.Pattern fileNamePatternt = null;" + NL + "" + NL + "            java.util.List<java.io.File> getFiles() {" + NL + "                String directoryt = ";
  protected final String TEXT_3 = ";" + NL + "                String filemaskt = ";
  protected final String TEXT_4 = "+\"$\";" + NL + "" + NL + "                if (filemaskt.indexOf(\"^\") == -1) {" + NL + "                    filemaskt = \"^\" + filemaskt;" + NL + "                }" + NL + "                if (!(filemaskt.lastIndexOf(\".*$\") == -1) && filemaskt.lastIndexOf(\"*.*$\") == -1) {" + NL + "                    filemaskt = filemaskt.substring(0, filemaskt.length() - 3) + \"$\";" + NL + "                    flagt = true;" + NL + "                } else {" + NL + "                    filemaskt = java.util.regex.Pattern.compile(\"[*]\").matcher(filemaskt).replaceAll(\".*\");" + NL + "                }" + NL + "" + NL + "                boolean case_sensitivet = ";
  protected final String TEXT_5 = ";" + NL + "                fileNamePatternt = java.util.regex.Pattern.compile(filemaskt);" + NL + "                if (!case_sensitivet) {" + NL + "                    fileNamePatternt = java.util.regex.Pattern.compile(filemaskt, java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "                }" + NL + "                java.io.File filet = new java.io.File(directoryt);" + NL + "                final java.util.List<java.io.File> list = new java.util.ArrayList<java.io.File>();" + NL + "                filet.listFiles(new java.io.FilenameFilter() {" + NL + "" + NL + "                    public boolean accept(java.io.File dir, String name) {" + NL + "                        java.io.File file = new java.io.File(dir, name);" + NL + "                        if (file.isFile()) {" + NL + "                            String fileNamet = name;" + NL + "                            if (flagt == true) {" + NL + "                                if (!(fileNamet.indexOf(\".\") == -1)) {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet.substring(0, fileNamet.indexOf(\".\"))).find()) {" + NL + "                                        list.add(file);" + NL + "" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                        list.add(file);" + NL + "                                    }" + NL + "                                }" + NL + "                            } else {" + NL + "                                if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                    list.add(file);" + NL + "                                }" + NL + "                            }" + NL + "" + NL + "                            return true;" + NL + "                        } ";
  protected final String TEXT_6 = "                          " + NL + "                        else {" + NL + "" + NL + "                            file.listFiles(this);" + NL + "                        }" + NL + "                      ";
  protected final String TEXT_7 = "                        " + NL + "                        return false;" + NL + "                    }" + NL + "" + NL + "                });" + NL + "" + NL + "                return list;" + NL + "            }" + NL + "        }" + NL + "            " + NL + "            Util_";
  protected final String TEXT_8 = " util_";
  protected final String TEXT_9 = " = new Util_";
  protected final String TEXT_10 = "();" + NL + "            java.util.List<java.io.File> originalFiles_";
  protected final String TEXT_11 = " = util_";
  protected final String TEXT_12 = ".getFiles();" + NL + "            java.util.List<java.io.File> changeList_";
  protected final String TEXT_13 = " = new java.util.ArrayList();" + NL + "            int count_";
  protected final String TEXT_14 = " = 0;" + NL + "            while (true) {";
  protected final String TEXT_15 = "                " + NL + "                if (count_";
  protected final String TEXT_16 = " == ";
  protected final String TEXT_17 = " ) {" + NL + "                    break;" + NL + "                }";
  protected final String TEXT_18 = "                " + NL + "" + NL + "                boolean found_";
  protected final String TEXT_19 = " = false;" + NL + "                java.util.List<java.io.File> fetchFilesOneTime_";
  protected final String TEXT_20 = " = util_";
  protected final String TEXT_21 = ".getFiles();";
  protected final String TEXT_22 = NL + "                for (java.io.File file_";
  protected final String TEXT_23 = " : originalFiles_";
  protected final String TEXT_24 = ") {" + NL + "                    if (!changeList_";
  protected final String TEXT_25 = ".contains(file_";
  protected final String TEXT_26 = ") && !fetchFilesOneTime_";
  protected final String TEXT_27 = ".contains(file_";
  protected final String TEXT_28 = ")) {" + NL + "                        globalMap.put(\"";
  protected final String TEXT_29 = "_DELETED_FILE\", file_";
  protected final String TEXT_30 = ".getAbsolutePath());" + NL;
  protected final String TEXT_31 = NL + "                for (java.io.File file_";
  protected final String TEXT_32 = " : fetchFilesOneTime_";
  protected final String TEXT_33 = ") {" + NL + "                    if (!changeList_";
  protected final String TEXT_34 = ".contains(file_";
  protected final String TEXT_35 = ") && !originalFiles_";
  protected final String TEXT_36 = ".contains(file_";
  protected final String TEXT_37 = ")) {" + NL + "                        globalMap.put(\"";
  protected final String TEXT_38 = "_CREATED_FILE\", file_";
  protected final String TEXT_39 = ".getAbsolutePath()); " + NL;
  protected final String TEXT_40 = NL + "                        changeList_";
  protected final String TEXT_41 = ".add(file_";
  protected final String TEXT_42 = ");" + NL + "                        found_";
  protected final String TEXT_43 = " = true;" + NL + "" + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                count_";
  protected final String TEXT_44 = "++;" + NL + "                " + NL + "                globalMap.put(\"";
  protected final String TEXT_45 = "_CURRENT_ITERATION\", count_";
  protected final String TEXT_46 = ");" + NL + "                " + NL + "                if (!found_";
  protected final String TEXT_47 = ") {" + NL + "                \tThread.currentThread().sleep(";
  protected final String TEXT_48 = "*1000);" + NL + "                    continue;" + NL + "                }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean incldSubdir=ElementParameterParser.getValue(node, "__INCLUDE_SUBDIR__").equals("true");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIRECTORY__") );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILEMASK__"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__") );
    stringBuffer.append(TEXT_5);
    
      if(incldSubdir==true)  {

    stringBuffer.append(TEXT_6);
    
      }   

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
 if(!ElementParameterParser.getValue(node,"__MAX_ITERATIONS__").equals("")){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAX_ITERATIONS__") );
    stringBuffer.append(TEXT_17);
    
 } 

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
  if(ElementParameterParser.getValue(node, "__ACTION_ON__").equals("filedeleted")){

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
    
 }else if(ElementParameterParser.getValue(node, "__ACTION_ON__").equals("filecreated")){

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
    
 }

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
    stringBuffer.append(ElementParameterParser.getValue(node, "__WAIT__"));
    stringBuffer.append(TEXT_48);
    return stringBuffer.toString();
  }
}
