/**
 * 
 */
package com.hc.util;

/**
 * @author bhanuchander
 *
 */
public class NameValuePair {
    //Complete name, includes prefix, attribute name, and postfix
    String completeName;
    Object value;
    
    NameValuePair(){}
    
    public NameValuePair(String name, Object value){
    	this.completeName = name;
    	this.value = value;
    }
}
