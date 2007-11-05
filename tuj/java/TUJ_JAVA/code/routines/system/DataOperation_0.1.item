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
package routines;


public class DataOperation {

    /**
     * CHAR() Converts a numeric value to its ASCII character string equivalent.
     * 
     * {talendTypes} char | Character
     * 
     * {Category} DataOperation
     * 
     * {param} int(1) i: numeric value
     * 
     * {example} CHAR(1):int
     * 
     */
    public static char CHAR(int i) {
        return Character.forDigit(i, 10);
    }

    /**
     * DTX( ) Converts a decimal integer into its hexadecimal equivalent.
     * 
     * {talendTypes} String
     * 
     * {Category} DataOperation
     * 
     * {param} int(1) i:decimal integer
     * 
     * {example} DTX(1)
     * 
     */
    public static String DTX(int i) {
        return Integer.toHexString(i);
    }

    /**
     * FIX( ) Rounds an expression to a decimal number having the accuracy specified by the PRECISION statement.
     * 
     * {talendTypes} long | Long
     * 
     * {Category} DataOperation
     * 
     * {param} double (0.0) d:decimal number
     * 
     * {example} FIX(3.14)
     * 
     */
    public static long FIX(double d) {
        return Math.round(d);
    }

    /**
     * XTD( ) Converts a hexadecimal string into its decimal equivalent.
     * 
     * {talendTypes} int | Integer
     * 
     * {Category} DataOperation
     * 
     * {param} string ("0") text: hexadecimal string
     * 
     * {example} XTD(\"1\")
     * 
     */
    public static int XTD(String text) {
        return Integer.valueOf(text, 16);
    }
}
