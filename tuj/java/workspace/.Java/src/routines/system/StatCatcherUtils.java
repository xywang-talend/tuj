// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2007 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package routines.system;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;

public class StatCatcherUtils {
    public class StatCatcherMessage {
        private String origin;
        private String message;
        private Long duration = null;
        private Date moment;
        private String messageType;
        private String jobVersion;
        private String jobId;
        private Long systemPid;
        
        public StatCatcherMessage(String message, String messageType, String origin, Long duration, String jobVersion, String jobId) {
            this.origin = origin;
            this.message = message;
            this.duration = duration;
            this.moment = java.util.Calendar.getInstance().getTime();
            this.messageType = messageType;
            this.jobVersion = jobVersion;
            this.jobId = jobId;
            this.systemPid = StatCatcherUtils.getPid();
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }
        
        public Date getMoment() {
            return moment;
        }

        public void setMoment(Date d) {
            this.moment = d;
        }
        
        public Long getDuration() {
            return duration;
        }

        public void setDuration(Long duration) {
            this.duration = duration;
        }
        
        public String getJobId() {
            return jobId;
        }
        
        public void setJobId(String jobId) {
            this.jobId = jobId;
        }
        
        public String getJobVersion() {
            return jobVersion;
        }
        
        public void setJobVersion(String jobVersion) {
            this.jobVersion = jobVersion;
        }
        
        public String getMessageType() {
            return messageType;
        }
        
        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }
        
        public Long getSystemPid() {
            return systemPid;
        }
        
        public void setSystemPid(Long systemPid) {
            this.systemPid = systemPid;
        }
    }

    java.util.List<StatCatcherMessage> messages = new java.util.ArrayList<StatCatcherMessage>();
    
    String jobId = "";
    String jobVersion = "";
    public StatCatcherUtils(String jobId, String jobVersion) {
        this.jobId = jobId;
        this.jobVersion = jobVersion;
    }

    public void addMessage(String message, String origin, Long duration) {
        String messageType="";
        if (message.compareTo("begin")==0) {
            messageType = message;
            message = null;
        } else if (message.compareTo("end")==0) {
            messageType = message;
            message = "success";
        } else if (message.compareTo("failure")==0) {
            messageType = "end";
        }
        StatCatcherMessage scm = new StatCatcherMessage(message, messageType, origin, duration, this.jobVersion, this.jobId);
        messages.add(scm);
    }
    
    public void addMessage(String message, String origin) {
        addMessage(message, origin, null);
    }
    
    public void addMessage(String message, Long duration) {
        addMessage(message, "", duration);
    }
    
    public void addMessage(String message) {
        addMessage(message, "", null);
    }

    public java.util.List<StatCatcherMessage> getMessages() {
        java.util.List<StatCatcherMessage> messagesToSend = new java.util.ArrayList<StatCatcherMessage>();
        for (StatCatcherMessage scm : messages) {
            messagesToSend.add(scm);
        }
        messages.clear();
        return messagesToSend;
    }
    
    public static long getPid() {
        RuntimeMXBean mx = ManagementFactory.getRuntimeMXBean();
        String[] mxNameTable = mx.getName().split("@");
        if (mxNameTable.length==2) {
            return Long.parseLong(mxNameTable[0]);
        } else {
            return Thread.currentThread().getId();
        }
    }
}
