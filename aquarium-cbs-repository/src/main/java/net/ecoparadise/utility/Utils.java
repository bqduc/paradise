/*
 * Copyleft 2007-2011 Ozgur Yazilim A.S.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 * http://www.gnu.org/licenses/lgpl.html
 *
 * www.tekir.com.tr
 * www.ozguryazilim.com.tr
 *
 */

package net.ecoparadise.utility;

import java.util.ArrayList;
import java.util.List;

import net.ecoparadise.framework.BaseConsts;

/**
 * @author sinan.yumak
 *
 */
public class Utils {

	public static boolean isEmpty( String aString ){
        return ( aString == null ) ? true : aString.length() > 0 ? false : true;
    }
    
    public static boolean isNotEmpty( String s ){
        return !isEmpty(s);
    }

    public static String getFileSeperator() {
    	return System.getProperty("file.separator");
    }
    
    public static String getExceptionMessage(Exception ex) {
    	StringBuilder result = new StringBuilder().append("Exception: ").append(ex.getMessage());
    	return result.toString();
    }

    @SuppressWarnings("unchecked")
    public static <F> List<F> changeListType(List aList, Class<F> a) {
    	List<F> result = new ArrayList<F>();
    	
    	for (int i=0;i<aList.size();i++) {
    		result.add( (F)aList.get(i) );
    	}
    	return result;
    }

    public static boolean isSystemCurrency(String currency) {
    	return currency.equals(BaseConsts.SYSTEM_CURRENCY_CODE);
    }
}
