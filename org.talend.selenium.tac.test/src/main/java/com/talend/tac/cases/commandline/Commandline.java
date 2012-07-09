package com.talend.tac.cases.commandline;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.testng.ITestContext;

import com.talend.tac.base.Base;

public class Commandline extends Base{
	protected String server = "localhost";
	protected int port = 8002;

	Socket socket = null;
	StringBuffer sb = new StringBuffer();
	int timeout = 3000;
	PrintWriter pw;
	BufferedReader br;
	
	Hashtable properties = new Hashtable();
	
	public String getJDKPath() {
		
		String jdkPath = System.getProperty("java.home").replace("\\", "/")+"/bin/java.exe";
		System.out.println(jdkPath);
		return "\""+jdkPath+"\"";
		
	}
	
	@Override
	public void initSelenium(String server, String port, String browser,
			String url, String language, String country, String root,
			ITestContext context) {
	}
	
	/**
	  * 根据传入的文件夹地址 遍历该文件夹下的所有文件名称
	  * @Method ReadAllFilesName
	  * @param filePath 文件夹地址
	  * @return LinkedHashMap
	  */
	 public void delFolder(String folderPath) {
	     try {
	        delAllFile(folderPath); //删除完里面所有内容
	        String filePath = folderPath;
	        filePath = filePath.toString();
	        java.io.File myFilePath = new java.io.File(filePath);
	        myFilePath.delete(); //删除空文件夹
	        System.err.println("delete successful");
	     } catch (Exception e) {
	       e.printStackTrace(); 
	     }
	 }
	 
   //删除指定文件夹下所有文件
   //param path 文件夹完整绝对路径
      public boolean delAllFile(String path) {
          boolean flag = false;
          File file = new File(path);
          if (!file.exists()) {
            return flag;
          }
          if (!file.isDirectory()) {
            return flag;
          }
          String[] tempList = file.list();
          File temp = null;
          for (int i = 0; i < tempList.length; i++) {
             if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
             } else {
                 temp = new File(path + File.separator + tempList[i]);
             }
             if (temp.isFile()) {
                temp.delete();
             }
             if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
             }
          }
          return flag;
        }
	
	
	 public static LinkedHashMap ReadAllFilesName(String filePath){
	  LinkedList list=new LinkedList();
	  LinkedHashMap map = new LinkedHashMap();
	  String fileName = "";
	  File tmp;
	   File dir=new File(filePath);
	   File file[]=dir.listFiles();
	   //遍历文件夹下的所有文件
	         for(int i=0;i<file.length;i++){
	          if(file[i].isDirectory()){//如果是文件夹，暂放集合中去
	            list.add(file[i]);
	          }else{
	          // System.out.println(file[i].getAbsolutePath());
	         fileName = file[i].getName();
	            map.put(fileName+i,fileName);
	          }//end if
	     }//end for
	        //开始循环遍历，次级文件夹下的所有文件
	         while(!list.isEmpty()){
	           tmp=(File)list.removeFirst();
	           if(tmp.isDirectory()){
	              file=tmp.listFiles();
	              if(file==null) continue;
	                for(int i=0;i<file.length;i++){
	                   if(file[i].isDirectory()){
	                      list.add(file[i]);
	                   }else{
	                   // System.out.println(file[i].getAbsolutePath());
	                   fileName = file[i].getName();
	                      map.put(fileName+i,fileName);
	                   }//end if
	                }//end for
	             }else{
	              fileName = tmp.getName();
	                 map.put(fileName,fileName);
	             } 
	         }//end while
	  return map;
	 }
	 
	 
	  public LinkedHashMap getFileNameList(String path) {
	   String filePath = path;
	   LinkedHashMap map = this.ReadAllFilesName(filePath);
//	   String out = "";
//	   for(Iterator keyItr = map.keySet().iterator();keyItr.hasNext();){
//	        Object i  =  keyItr.next();
//	           out = (String)map.get(i);
//	           System.out.println(out);
//	   }
	   return map;
	 }

	public int getCommandId(String commandResultInfo) {
		String[] ss = commandResultInfo.split("ADDED_COMMAND");
		System.err.println(">>>>>>>>>"+ss[1]);
		int commandId = Integer.valueOf(ss[1].trim()).intValue();
		return commandId;
		
	}
	
	public Commandline() {
		if(System.getProperty("commandline.server")!=null)
			this.server = System.getProperty("commandline.server");
		
		if(System.getProperty("commandline.port")!=null)
			this.port = Integer.parseInt(System.getProperty("commandline.port"));
	}
	
	public Commandline(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	public void init(String server, int port, int timeout) throws UnknownHostException, IOException{
		socket = new Socket(server, port);
		socket.setSoTimeout(timeout);
        boolean autoflush = false;
        pw = new PrintWriter(socket.getOutputStream(),autoflush);
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void closeConnection() throws IOException{
		pw.close();
		br.close();
		socket.close();
	}
	
	public String command(String server, int port, int timeout, String command) {
		String result = null;
		try {
			this.init(server, port, timeout);
            pw.println(command);
            pw.flush();
			result = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sb.append(result);
		System.out.println("- " + result);
		return result;
	}

	public String command(String command) {
		return this.command(server, port, timeout, command);
	}

	public List<String> command(String server, int port, int timeout, String command, String end) {
		List<String> results = new ArrayList<String>();
		String result = null;
		try {
			socket = new Socket(server, port);
			socket.setSoTimeout(timeout);
            boolean autoflush = false;
            pw = new PrintWriter(socket.getOutputStream(),autoflush);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
            pw.println(command);
            pw.flush();
			
			result = br.readLine();
			
			sb.append(result);
			results.add(result);
			
//			while(!"".equals(result) && null!=result && !"\n".equals(result))
			while(true){
				result = br.readLine();
//				System.out.println("==== " + result);
				sb.append(result.trim() + "\n");
				results.add(result);
				if(result.toLowerCase().contains(end)){
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				this.closeConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return results;
	}
	
	public List<String> command(String command, String end) {
		return this.command(server, port, timeout, command, end);
	}
}
