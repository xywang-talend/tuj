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

public class RunStat implements Runnable {

    private class StatBean {

        private String connectionId;

        private int nbLine;

        private int state;

        public StatBean(String connectionId) {
            this.connectionId = connectionId;
        }

        public String getConnectionId() {
            return this.connectionId;
        }

        public void setConnectionId(String connectionId) {
            this.connectionId = connectionId;
        }

        public int getNbLine() {
            return this.nbLine;
        }

        public void setNbLine(int nbLine) {
            this.nbLine = nbLine;
        }

        public int getState() {
            return this.state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }

    private java.util.concurrent.ConcurrentHashMap<String, StatBean> processStats = new java.util.concurrent.ConcurrentHashMap<String, StatBean>();

    private java.net.Socket s;

    private java.io.PrintWriter pred;

    private boolean jobIsFinished = false;

    private String str = "";

    private long startTime = 0;

    private long currentTime = 0;

    public void startThreadStat(String clientHost, int portStats) throws java.io.IOException,
            java.net.UnknownHostException {
        System.out.println("[statistics] connecting to socket on port " + portStats);
        s = new java.net.Socket(clientHost, portStats);
        startTime = java.util.Calendar.getInstance().getTimeInMillis();
        pred = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(s.getOutputStream())),
                true);
        System.out.println("[statistics] connected");
        Thread t = new Thread(this);
        t.start();

    }

    public void run() {
        synchronized (this) {
            try {
                while (!jobIsFinished) {
                    sendMessages();
                    wait(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("[statistics] interrupted");
            }
        }
    }

    public void stopThreadStat() {
        jobIsFinished = true;
        try {
            sendMessages();
            pred.close();
            s.close();
            System.out.println("[statistics] disconnected");
        } catch (java.io.IOException ie) {
        }
    }

    public void sendMessages() {
        for (StatBean sb : processStats.values()) {
            currentTime = java.util.Calendar.getInstance().getTimeInMillis();
            str = sb.getConnectionId() + "|" + sb.getNbLine() + "|" + (currentTime - startTime);
            if (sb.getState() != 1) {
                str += "|" + ((sb.getState() == 0) ? "start" : "stop");
                processStats.remove(sb.getConnectionId());
            }
            pred.println(str); // envoi d'un message
        }
    }


    public void updateStatOnConnection(String connectionId, int mode, int nbLine) {
        StatBean bean;
        if (processStats.containsKey(connectionId)) {
            bean = processStats.get(connectionId);
        } else {
            bean = new StatBean(connectionId);
        }
        bean.setState(mode);
        bean.setNbLine(bean.getNbLine() + nbLine);
        processStats.put(connectionId, bean);
    }
}
