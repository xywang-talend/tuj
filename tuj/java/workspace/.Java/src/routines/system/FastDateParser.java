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

import java.util.Locale;

public class FastDateParser {

    private static FastDateParser instance;

    public static FastDateParser getInstance() {
        if (instance == null) {
            instance = new FastDateParser();
        }
        return instance;
    }

    private FastDateParser() {
        super();
    }
    
    private static java.util.HashMap<DateFormatKey, java.text.DateFormat> cache = new java.util.HashMap<DateFormatKey, java.text.DateFormat>();

    private static DateFormatKey dateFormatKey = getInstance().new DateFormatKey();
    
    // Warning : DateFormat objects returned by this method are not thread safe
    public static java.text.DateFormat getInstance(String pattern) {
        return getInstance(pattern, null);
    }

    public static java.text.DateFormat getInstance(String pattern, Locale locale) {
        dateFormatKey.pattern = pattern;
        dateFormatKey.locale = locale;
        java.text.DateFormat format = cache.get(dateFormatKey);
        if (format == null) {
            if (pattern.equals("yyyy-MM-dd")) {
                format = new DateParser();
            } else if (pattern.equals("yyyy-MM-dd HH:mm:ss")) {
                format = new DateTimeParser();
            } else {
                if(locale != null) {
                    format = new java.text.SimpleDateFormat(pattern, locale);
                } else {
                    format = new java.text.SimpleDateFormat(pattern);
                }
            }
            cache.put(getInstance().new DateFormatKey(pattern, locale), format);
        }
        return format;
    }

    // Parse and format dates with yyyy-MM-dd format
    private static class DateParser extends java.text.DateFormat {

        private int year, month, day;

        public DateParser() {
            calendar = java.util.Calendar.getInstance();
        }

        public StringBuffer format(java.util.Date date, StringBuffer toAppendTo, java.text.FieldPosition fieldPosition) {
            calendar.setTime(date);

            // Year
            toAppendTo.append(calendar.get(java.util.Calendar.YEAR));
            while (toAppendTo.length() < 4)
                toAppendTo.insert(0, "0");
            toAppendTo.append("-");

            // Month
            month = calendar.get(java.util.Calendar.MONTH) + 1;
            if (month < 10)
                toAppendTo.append("0");
            toAppendTo.append(month);
            toAppendTo.append("-");

            // Day
            day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
            if (day < 10)
                toAppendTo.append("0");
            toAppendTo.append(day);

            return toAppendTo;
        }

        public java.util.Date parse(String source, java.text.ParsePosition pos) {
            int index = 0;
            try {
                year = Integer.parseInt(source.substring(0, 4));
                index = 5;
                month = Integer.parseInt(source.substring(5, 7)) - 1;
                index = 8;
                day = Integer.parseInt(source.substring(8, 10));

                pos.setIndex(source.length());

                calendar.clear();
                calendar.set(year, month, day, 0, 0, 0);
                return calendar.getTime();
            } catch (Exception e) {
                pos.setErrorIndex(index);
            }
            return null;
        }
    }

    // Parse dates with yyyy-MM-dd HH:mm:ss format
    private static class DateTimeParser extends java.text.DateFormat {

        private int year, month, day, hour, minute, second;

        public DateTimeParser() {
            calendar = java.util.Calendar.getInstance();
        }

        public StringBuffer format(java.util.Date date, StringBuffer toAppendTo, java.text.FieldPosition fieldPosition) {
            calendar.setTime(date);

            // Year
            toAppendTo.append(calendar.get(java.util.Calendar.YEAR));
            while (toAppendTo.length() < 4)
                toAppendTo.insert(0, "0");
            toAppendTo.append("-");

            // Month
            month = calendar.get(java.util.Calendar.MONTH) + 1;
            if (month < 10)
                toAppendTo.append("0");
            toAppendTo.append(month);
            toAppendTo.append("-");

            // Day
            day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
            if (day < 10)
                toAppendTo.append("0");
            toAppendTo.append(day);
            toAppendTo.append(" ");

            // Hour
            hour = calendar.get(java.util.Calendar.HOUR);
            if (hour < 10)
                toAppendTo.append("0");
            toAppendTo.append(hour);
            toAppendTo.append(":");

            // Minute
            minute = calendar.get(java.util.Calendar.MINUTE);
            if (minute < 10)
                toAppendTo.append("0");
            toAppendTo.append(minute);
            toAppendTo.append(":");

            // Second
            second = calendar.get(java.util.Calendar.SECOND);
            if (second < 10)
                toAppendTo.append("0");
            toAppendTo.append(second);

            return toAppendTo;
        }

        public java.util.Date parse(String source, java.text.ParsePosition pos) {
            int index = 0;
            try {
                year = Integer.parseInt(source.substring(0, 4));
                index = 5;
                month = Integer.parseInt(source.substring(5, 7)) - 1;
                index = 8;
                day = Integer.parseInt(source.substring(8, 10));
                index = 11;
                hour = Integer.parseInt(source.substring(11, 13));
                index = 14;
                minute = Integer.parseInt(source.substring(14, 16));
                index = 17;
                second = Integer.parseInt(source.substring(17, 19));

                pos.setIndex(source.length());

                calendar.clear();
                calendar.set(year, month, day, hour, minute, second);
                return calendar.getTime();
            } catch (Exception e) {
                pos.setErrorIndex(index);
            }
            return null;
        }
    }

    private class DateFormatKey {

        private String pattern;

        private Locale locale;

        public DateFormatKey() {
        }
        
        public DateFormatKey(String pattern, Locale locale) {
            this.pattern = pattern;
            this.locale = locale;
        }
        
        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((this.locale == null) ? 0 : this.locale.hashCode());
            result = prime * result + ((this.pattern == null) ? 0 : this.pattern.hashCode());
            return result;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final DateFormatKey other = (DateFormatKey) obj;
            if (this.locale == null) {
                if (other.locale != null)
                    return false;
            } else if (!this.locale.equals(other.locale))
                return false;
            if (this.pattern == null) {
                if (other.pattern != null)
                    return false;
            } else if (!this.pattern.equals(other.pattern))
                return false;
            return true;
        }

    }

}
