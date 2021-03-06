package com.hc.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Hashtable;


/**
 * BeanUtils 
 * This class is a utility class to parse the incoming Http 
 * request and create the appropriate Java Bean using the 
 * Reflection API.
 *
 * Modifed code to create custom classes like java.util.Date, 
 * java.math.BigDecimal, java.sql.Date etc. DVP
 *
 * Added discover set methods and discover get methods as a fix for upper case
 * problem. DVP
 *
 * Added exception handling to fit our needs - DVP
 *
 * @author bhanuchander
 */

public final class BeanUtils {


    // ------------------------------------------------------- Static Variables

    public static final String BOOLEAN_TRUE_VALUE = "true";
    /**
     * The cache of PropertyDescriptor arrays for beans we have already
     * introspected, keyed by the fully qualified class name of this bean.
     */
    private static Hashtable<String, PropertyDescriptor[]> descriptorsCache = new Hashtable<String, PropertyDescriptor[]>();
    
    public static final SimpleDateFormat BASE_DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");



    // --------------------------------------------------------- Public Classes


    /**
     * Return the input string with the first character capitalized.
     *
     * @param name The string to be modified and returned
     */
    public static String capitalize(String name) {

	    if ((name == null) || (name.length() < 1))
	        return name;
	    char chars[] = name.toCharArray();
	    chars[0] = Character.toUpperCase(chars[0]);
	    return new String(chars);
    }


    /**
     * Convert the specified value to an object of the specified class (if
     * possible).  Otherwise, return a String representation of the value.
     * If you specify <code>type</code> as the name of a Java primitive
     * type, an instance of the corresponding wrapper class (initialized
     * to the correct value) is returned instead.
     *
     * @param value Value to be converted (may be null)
     * @param clazz Java class to be converted to (must be String, one of
     *  the Java primitive types, or one of the primitive wrappers)
     */
    public static Object convert(String value, Class<?> clazz) throws InvalidConversionException {

	    String type = clazz.getName();
	    if ("java.lang.String".equals(type) ||
	        "String".equals(type)) {
	        if (value == null)
	            return ((String) null);
	        else
	            return value;
	    } else if ("java.lang.Boolean".equals(type) ||
		    Boolean.TYPE.getName().equals(type) ||
	            "boolean".equals(type)) {
	        return (convertBoolean(value));
	    } else if ("java.lang.Byte".equals(type) ||
		    Byte.TYPE.getName().equals(type) ||
	            "byte".equals(type)) {
	        return (convertByte(value));
            } else if ("java.lang.Character".equals(type) ||
		    Character.TYPE.getName().equals(type) ||
                    "char".equals(type)) {
	        return (convertCharacter(value));
	    } else if ("java.lang.Integer".equals(type) ||
		    Integer.TYPE.getName().equals(type) ||
		    "int".equals(type)) {
	        return (convertInteger(value));
	    } else if ("java.lang.Long".equals(type) ||
		    Long.TYPE.getName().equals(type) ||
		    "long".equals(type)) {
	        return (convertLong(value));
	    } else if ("java.lang.Float".equals(type) ||
		    Float.TYPE.getName().equals(type) ||
		    "float".equals(type)) {
	        return (convertFloat(value));
	    } else if ("java.lang.Double".equals(type) ||
		    Double.TYPE.getName().equals(type) ||
		    "double".equals(type)) {
	        return (convertDouble(value));
	    } else if ("java.sql.Date".equals(type)) {
	            return (convertSqlDate(value));
        } else if ("java.sql.Timestamp".equals(type)){
                return (convertTimestamp(value));	            
	    } else if ("java.math.BigDecimal".equals(type)) {
	            return (convertBigDecimal(value));
        } else if ("java.util.Date".equals(type)) {
                return (convertUtilDate(value));   
        }
        else {
	        if (value == null)
	            return ((String) null);
	        else
	            return (value.toString());
	    }
	}



    /**
     * Convert an array of specified values to an array of objects of the
     * specified class (if possible).  If you specify <code>type</code>
     * as one of the Java primitive types, an array of that type will be
     * returned; otherwise an array of the requested type (must be String
     * or a Java wrapper class for the primitive types) will be returned.
     *
     * @param value Value to be converted (may be null)
     * @param clazz Java array class to be converted to (must be String, one of
     *  the Java primitive types, or one of the primitive wrappers)
     */
    public static Object convert(String values[], Class<?> clazz) 
            throws InvalidConversionException {

	    String type = clazz.getComponentType().getName();
	    if ("java.lang.String".equals(type) ||
	        "String".equals(type)) {
	        if (values == null)
		    return ((String[]) null);
	        else
	            return (values);
	    }

	    int len = values.length;
	    if ("java.lang.Boolean".equals(type)) {
	        Boolean array[] = new Boolean[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertBoolean(values[i]);
	        return array;
	    } else if ("boolean".equals(type) ||
		    Boolean.TYPE.getName().equals(type)) {
	        boolean array[] = new boolean[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertBoolean(values[i]).booleanValue();
	    } else if ("java.lang.Byte".equals(type)) {
	        Byte array[] = new Byte[len];
	        for (int i = 0; i < len; i++)
	            array[i] = convertByte(values[i]);
	        return array;
	    } else if ("byte".equals(type) ||
		    Byte.TYPE.getName().equals(type)) {
	        byte array[] = new byte[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertByte(values[i]).byteValue();
	    } else if ("java.lang.Character".equals(type)) {
	        Character array[] = new Character[len];
	        for (int i = 0; i < len; i++)
	            array[i] = convertCharacter(values[i]);
	        return array;
	    } else if ("char".equals(type) ||
		    Character.TYPE.getName().equals(type)) {
	        char array[] = new char[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertCharacter(values[i]).charValue();
	    } else if ("java.lang.Integer".equals(type)) {
	        Integer array[] = new Integer[len];
	        for (int i = 0; i < len; i++)
	            array[i] = convertInteger(values[i]);
	        return array;
	    } else if ("int".equals(type) ||
		    Integer.TYPE.getName().equals(type)) {
	        int array[] = new int[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertInteger(values[i]).intValue();
	        return array;
	    } else if ("java.lang.Long".equals(type)) {
	        Long array[] = new Long[len];
	        for (int i = 0; i < len; i++)
	            array[i] = convertLong(values[i]);
	        return array;
	    } else if ("long".equals(type) ||
		    Long.TYPE.getName().equals(type)) {
	        long array[] = new long[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertLong(values[i]).longValue();
	        return array;
            } else if ("java.lang.Float".equals(type)) {
	        Float array[] = new Float[len];
	        for (int i = 0; i < len; i++)
	            array[i] = convertFloat(values[i]);
	        return array;
	    } else if ("float".equals(type) ||
		    Float.TYPE.getName().equals(type)) {
	        float array[] = new float[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertFloat(values[i]).floatValue();
	        return array;
	    } else if ("java.lang.Double".equals(type)) {
	        Double array[] = new Double[len];
	        for (int i = 0; i < len; i++)
	            array[i] = convertDouble(values[i]);
	        return array;
	    } else if ("double".equals(type) ||
		    Double.TYPE.getName().equals(type)) {
	        double array[] = new double[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertDouble(values[i]).doubleValue();
	        return array;
	    } else if ("java.sql.Date".equals(type)) {
	        java.sql.Date array[] = new java.sql.Date[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertSqlDate(values[i]);
	        return array;
	    } else if ("java.util.Date".equals(type)) {
	        java.util.Date array[] = new java.util.Date[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertUtilDate(values[i]);
	        return array;
	    } else if ("java.sql.Timestamp".equals(type)) {
	        java.sql.Timestamp array[] = new java.sql.Timestamp[len];
	        for (int i = 0; i < len; i++)
	        array[i] = convertTimestamp(values[i]);
            return array;
	    } else if ("java.math.BigDecimal".equals(type)) {
	        BigDecimal array[] = new BigDecimal[len];
	        for (int i = 0; i < len; i++)
		    array[i] = convertBigDecimal(values[i]);
	        return array;
	    } 
	    else {
	        if (values == null)
	            return ((String[]) null);
	        else {
		    String array[] = new String[len];
		    for (int i = 0; i < len; i++)
		        array[i] = values[i].toString();
		    return array;
	        }
	    }

	    return ((String[]) null);	// Make the compiler shut up

    }


    /**
     * Filter the specified string for characters that are senstive to
     * HTML interpreters, returning the string with these characters replaced
     * by the corresponding character entities.
     *
     * @param value The string to be filtered and returned
     */
    public static String filter(String value) {

	    if (value == null)
	        return (null);

	    StringBuffer result = new StringBuffer();
	    for (int i = 0; i < value.length(); i++) {
	        char ch = value.charAt(i);
	        if (ch == '<')
		    result.append("&lt;");
	        else if (ch == '>')
		    result.append("&gt;");
	        else if (ch == '&')
		    result.append("&amp;");
	        else if (ch == '"')
		    result.append("&quot;");
	        else
		    result.append(ch);
	    }
	    return result.toString();

    }


    /**
     * Return the value of the specified array property of the specified
     * bean, as a String array.
     *
     * @param bean Bean whose property is to be extracted
     * @param name Name of the property to be extracted
     *
     * @exception Exception if any problem occurs while acquiring or
     *  converting this property value.
     */
    public static String[] getArrayProperty(Object bean, String name)
	throws Exception {

	    Object value = getPropertyValue(bean, name);
	    if (value == null) {
	        return (null);
	    } else if (value.getClass().isArray()) {
	        Object values[] = (Object[]) value;
	        String results[] = new String[values.length];
	        for (int i = 0; i < values.length; i++)
		    results[i] = values[i].toString();
	        return results;
	    } else {
	        String results[] = new String[1];
	        results[0] = value.toString();
	        return results;
	    }
    }


    /**
     * Return the PropertyDescriptor for the specified property of the
     * specified bean, if there is one;  Otherwise, return <code>null</code>.
     *
     * @param bean The JavaBean that the property belongs to
     * @param name Name of the property whose setter method is requested
     */
    public static PropertyDescriptor getPropertyDescriptor(Object bean,
							   String name) {

	    if ((bean == null) || (name == null))
	        return null;
	    PropertyDescriptor descriptors[] = getPropertyDescriptors(bean);
	    if (descriptors == null)
	        return null;
	    for (int i = 0; i < descriptors.length; i++) {
	        if (name.equals(descriptors[i].getName()))
		    return (descriptors[i]);
	    }
	    return null;

    }


    /**
     * Return an array of PropertyDescriptors for the JavaBeans properties
     * belonging to the specified bean.  If the bean has no properties,
     * a zero-length array is returned.
     *
     * @param bean Bean whose property descriptors are required
     */
    public static PropertyDescriptor[] getPropertyDescriptors(Object bean) {

	    if (bean == null)
	        return (new PropertyDescriptor[0]);

	    // Look up any cached descriptors for this bean class
	    String beanClassName = bean.getClass().getName();
	    PropertyDescriptor descriptors[] =
	        (PropertyDescriptor[]) descriptorsCache.get(beanClassName);
	    if (descriptors != null)
	        return descriptors;

	    // Introspect the bean and cache the generated descriptors
	    BeanInfo beanInfo = null;
	    try {
	        beanInfo = Introspector.getBeanInfo(bean.getClass());
	    } catch (IntrospectionException e) {
	        return (new PropertyDescriptor[0]);
	    }
	    descriptors = beanInfo.getPropertyDescriptors();
	    if (descriptors == null)
	        descriptors = new PropertyDescriptor[0];
	    descriptorsCache.put(beanClassName, descriptors);
	    return descriptors;

    }


    /**
     * Return the value of the specified property of the specified
     * bean, with no type conversinos.
     *
     * @param bean Bean whose property is to be extracted
     * @param name Name of the property to be extracted
     *
     * @exception Exception if any problem occurs while acquiring
     *  this property value.  
     * @deprecated use getPropertyValueOf method
     */
    public static Object getPropertyValue(Object bean, String name)
	throws Exception {

	    // Retrieve the property getter method for the specified property
	    PropertyDescriptor descriptor =
	        getPropertyDescriptor(bean, name);
	    if (descriptor == null)
	        throw new NoSuchMethodException("Unknown property '" +
					        name + "'");
	    Method readMethod = descriptor.getReadMethod();
	    if (readMethod == null)
	        throw new NoSuchMethodException("Property '" + name +
					        "' has no getter method");

	    // Call the property getter and return the value
	    Object value = readMethod.invoke(bean, new Object[0]);
	    return value;

    }


    /**
     * Return the value of the specified scalar property of the specified
     * bean, as a String.
     *
     * @param bean Bean whose property is to be extracted
     * @param name Name of the property to be extracted
     *
     * @exception Exception if any problem occurs while acquiring or
     *  converting this property value.
     */
    public static String getScalarProperty(Object bean, String name)
	throws Exception {

	    Object value = getPropertyValue(bean, name);
	    if (value == null) {
	        return null;
	    } else if (value.getClass().isArray()) {
	        Object values[] = (Object[]) value;
	        return values[0].toString();
	    } else {
	        return value.toString();
	    }

    }
    
    /** 
     * This method creates an array list of objects, it runs through the parameter values
     * and gets the attributes which match the value passed. 
     * Important NOTE: This method assumes that the request parameters are postfixed with 
     * numbers 0 through n
     * @author Deviprasad Malladi
     */
/*    public static void populateArray(ArrayList arrayOfBeans, String attribute, String value, Class beanClass, HttpServletRequest request ) 
            throws DataException {
                
        if (arrayOfBeans == null)
            return;
            
        DataException dataEx = null;
        
        //Hashtable setMethods = discoverSetMethods(beanClass);
        try {
            for (int suffix=0; true; suffix++) { //Break out when all the values are read            
                Object requiredAttributeValue = request.getParameter(attribute + suffix);
                //If the value of the parameter is absent then we reached the end
                if (requiredAttributeValue == null)
                    break;
                Object bean = createBean(attribute, "" + suffix, value, beanClass, request);                
                if (bean != null) {
                    arrayOfBeans.add(bean);            
//                    try {
//                       if (((DataBean)bean).getErrorListSize() > 0) {
//                        if (dataEx == null)
//                            dataEx = new DataException("Bean has errors");
//                       }
//                    } catch (ClassCastException classEx) {
//                        System.out.println("Warning: trying to populate a non data bean");
//                    }
                }                    
            } 
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
            if (dataEx == null)
                dataEx = new DataException("Bean has errors");
        }
        if (dataEx != null)
            throw dataEx;
    }*/
    
    /**
     * Internal helper method
     * DVP
     */
/*    protected static Object createBean(String attribute, String suffix, String value, 
            Class beanClass, HttpServletRequest request) throws DataException {
                
        String paramValue = request.getParameter(attribute + suffix);
        if (paramValue == null)
            return null;
        //System.out.println("createBean " + attribute+suffix + " Param Value " + paramValue + "=? Value " + value);
        if (value != null && !paramValue.equals(value)) {
            //Create a bean out of this suffix, other
            //System.out.println("Param is not equal to filter value, returning null " );
            return null;
        }
        Object bean = null;
        try {
            bean = beanClass.newInstance();
        } catch (Exception ex) {
            System.out.println("Cannot create a new instance of bean: " + ex);
            return null;            
        }
        //Create a bean with this suffix
        try { 
        populate(bean, null, suffix, request);
        } catch (DataException dataEx) {
            System.out.println("Warning: Errors populating bean");
        }
        return bean;
    }*/
        
    
    /** 
     * This method creates an array list of objects of the given type from
     * the http request parameters. 
     * The method goes through the list of setMethods in the beans and 
     * get the corresponding values
     * @author Deviprasad Malladi
     */
/*    public static ArrayList populateArray(int start, int end, Class beanClass, HttpServletRequest request) {
        ArrayList arrayOfBeans = new ArrayList();
        try {
            for (int ii=start; ii < end; ii++) {            
                Object bean = beanClass.newInstance();
                populate(bean, null, ""+ii, request);
                arrayOfBeans.add(bean);            
            } 
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
        return arrayOfBeans;        
    }
*/
    /**
     * Populate the properties of the specified JavaBean from the specified
     * HTTP request, based on matching each parameter name against the
     * corresponding JavaBeans "property setter" methods in the bean's class.
     * Suitable conversion is done for argument types as described under
     * <code>convert()</code>.
     * <p>
     * <strong>IMPLEMENTATION NOTE</strong>:  If you have more than one setter
     * for the same property name (with different argument types supported by
     * this logic), the setter method that is actually called will be
     * arbitrarily determined.
     *
     * @param bean The JavaBean whose properties are to be set
     * @param request The HTTP request whose parameters are to be used
     *                to populate bean properties
     *
     * @exception ServletException if an exception is thrown while setting
     *            property values
     */
/*    public static void populate(Object bean,
				HttpServletRequest request)
	throws DataException {

    	populate(bean, null, null, request);

    }*/
    
/*    public static Hashtable readPropertyValues(String prefix, String suffix,
				HttpServletRequest request) {
	    // Build a list of relevant request parameters from this request
	    Hashtable properties = new Hashtable();
	    String[] paramVals = null;
	    
	    Enumeration names = request.getParameterNames();
	    while (names.hasMoreElements()) {
	        String name = (String) names.nextElement();

	        String completeName = name;
	        if (prefix != null) {
		        if (!name.startsWith(prefix))
		            continue;
		        name = name.substring(prefix.length());
	        }
	        
	        if (suffix != null) {
		        if (!name.endsWith(suffix))
		            continue;
		        name = name.substring(0, name.length() - suffix.length());
	        }

	        if (name == null || name.trim().length() == 0) 
	            continue;	            
	        
	        paramVals = request.getParameterValues(completeName);
	        NameValuePair propertyValue = new NameValuePair();
	        propertyValue.completeName = completeName;
	        propertyValue.value = null;

	        if (paramVals != null && paramVals.length > 0 && !(paramVals[0].equals(""))){	            
	            propertyValue.value = request.getParameterValues(completeName);
	            
	        }
	        
	        properties.put(name, propertyValue);
	    }
	    return properties;
    }
*/

    /**
     * Populate the properties of the specified JavaBean from the specified
     * HTTP request, based on matching each parameter name (plus an optional
     * prefix and/or suffix) against the corresponding JavaBeans "property
     * setter" methods in the bean's class.  Suitable conversion is done for
     * argument types as described under <code>setProperties()</code>.
     * <p>
     * <strong>IMPLEMENTATION NOTE</strong>:  If you have more than one setter
     * for the same property name (with different argument types supported by
     * this logic), the setter method that is actually called will be
     * arbitrarily determined.
     *
     * @param bean The JavaBean whose properties are to be set
     * @param prefix The prefix (if any) to be prepend to bean property
     *               names when looking for matching parameters
     * @param suffix The suffix (if any) to be appended to bean property
     *               names when looking for matching parameters
     * @param request The HTTP request whose parameters are to be used
     *                to populate bean properties
     *
     * @exception ServletException if an exception is thrown while setting
     *            property values
     */
/*    public static void populate(Object bean, String prefix, String suffix,
				HttpServletRequest request)
	        throws DataException {

	    // Build a list of relevant request parameters from this request
	    Hashtable properties = readPropertyValues(prefix, suffix, request);
	    // Set the corresponding properties of our bean
	    populate(bean, properties);
    }*/
    
    public static String getFormattedPropertyValueOf(Object bean, String name) {
        Object value = getPropertyValueOf(bean, name);
        if (value == null)
            return "";
            
        String type = value.getClass().getName();
        /* 
        //Test code
        if (type.equals("java.util.Date") || type.equals("java.sql.Date")) {
            System.out.println("Type : " + type + " name " + name + " Bean " + bean);
        }
        //End test code
        */
        
	    if ("java.lang.String".equals(type) ||
	        "String".equals(type)) {
	            return (String)value;
	    } else if ("java.lang.Boolean".equals(type) ||
		    Boolean.TYPE.getName().equals(type) ||
	            "boolean".equals(type)) {
	        return (value.toString());
	    } else if ("java.lang.Byte".equals(type) ||
		    Byte.TYPE.getName().equals(type) ||
	            "byte".equals(type)) {
	        return value.toString();
            } else if ("java.lang.Character".equals(type) ||
		    Character.TYPE.getName().equals(type) ||
                    "char".equals(type)) {
	        return value.toString();
	    } else if ("java.lang.Integer".equals(type) ||
		    Integer.TYPE.getName().equals(type) ||
		    "int".equals(type)) {
	        return value.toString();
	    } else if ("java.lang.Long".equals(type) ||
		    Long.TYPE.getName().equals(type) ||
		    "long".equals(type)) {
	        return value.toString();
	    } else if ("java.lang.Float".equals(type) ||
		    Float.TYPE.getName().equals(type) ||
		    "float".equals(type)) {
	        return value.toString();
	    } else if ("java.lang.Double".equals(type) ||
		    Double.TYPE.getName().equals(type) ||
		    "double".equals(type)) {
	        return value.toString();
	    } else if ("java.sql.Date".equals(type)) {
	        return (convertSqlDateToString((java.sql.Date)value));
	    } else if ("java.math.BigDecimal".equals(type)) {
	        return value.toString();
        } else if ("java.util.Date".equals(type)) {
            //System.out.println("Found java.util.Date");
            return (convertUtilDateToString((java.util.Date)value));   
        }
        else {
	        return value.toString();
	    }
    }
    
    /**
     * getPropertyValue method uses the property descriptors, which behave funny
     * with cases. this method is a simpler version
     */
    public static Object getPropertyValueOf(Object bean, String name) {

	    // Retrieve the property getter method for the specified property
        Hashtable<String, Method> getMethods = discoverGetMethods(bean);
	    Method readMethod = (Method)getMethods.get(name);
	    if (readMethod == null) {
	        //System.out.println("Unable to find the get method for property:" + name + " on bean:" + bean);
	        return null;
	    }

	    // Call the property getter and return the value
	    try {
	        Object value = invokeMethod(bean, readMethod, null);
	        return value;
	    } catch (Exception ex) {
	        System.out.println("Exception invoking method : " + readMethod.getName() + " on bean :" + bean);
	        return null;
	    }
    }
    
    /** 
    * This method copies one bean properties to another bean. The bean properties are expected
    * to match and non-matched properties are ignored
    *
    * @param bean DataBean object 
    * @return Hashtable with the key as method name and value as the Method object
    */
    public static void convertBeanToBean(Object source, Object destination, boolean ignoreNulls) {
        Hashtable<String, Method> setMethods = discoverSetMethods(destination);
        Hashtable<String, Method> getMethods = discoverGetMethods(source);
        for (Enumeration<String> en=setMethods.keys(); en.hasMoreElements();) {
            String property = (String)en.nextElement();
            Method getMethod = (Method)getMethods.get(property);
            if (getMethod == null) {
//                System.out.println("Get method not available in " + source + " corresponding to a set method in " 
//                    + destination + " for the property : " + property);
                continue;
            } 
            Object[] getValue = new Object[1];
            getValue[0] = invokeMethod(source, getMethod, null);
            if (ignoreNulls && getValue[0] == null) {
            	continue;
            }
            Method setMethod = (Method)setMethods.get(property);
            invokeMethod(destination, setMethod, getValue);
        }
    }
    
 	/**
 	 * This method does a deep copy of source bean properties to destination bean. If the property is a bean object and if it belongs to the package specified 
 	 * customTypeNames then it traverses through the inner bean object and copies its properties.  The bean properties are expected
    * to match and non-matched properties are ignored
 	 * @param source The source bean object from which the properties are copied
 	 * @param destination The destination bean object into which the properties are copied
 	 * @param customTypeNames If the object is part of this package name then only the deep copy is performed
 	 * @param ignoreNulls If this is true and a property value is null then they are ignored.
 	 */
 	public static void convertBeanToBeanWithDeepCopy(Object source, 
 				Object destination, 
 				String customTypeNames, 
 				boolean ignoreNulls) 
 		throws ClassNotFoundException, IllegalAccessException, InstantiationException
 	{
      Hashtable<String, Method> setMethods = discoverSetMethods(destination);
      Hashtable<String, Method> getMethods = discoverGetMethods(source);
      Hashtable<String, Method> destGetMethods = discoverGetMethods(destination);
      
      for (Enumeration<String> en=setMethods.keys(); en.hasMoreElements();) {
          String property = (String)en.nextElement();
          Method getMethod = (Method)getMethods.get(property);

          Method tempGetMethod = (Method)destGetMethods.get(property);
//          System.out.println("Set Method Type: " + tempGetMethod.getReturnType().getName());
          
          if (getMethod == null) {
//              System.out.println("Get method not available in " + source + " corresponding to a set method in " 
//                  + destination + " for the property : " + property);
              continue;
          }
          
          Object[] getValue = new Object[1];
          getValue[0] = invokeMethod(source, getMethod, null);
          if (ignoreNulls && getValue[0] == null) {
          	continue;
          }

          Method setMethod = (Method)setMethods.get(property);
          if(tempGetMethod.getReturnType().getName().startsWith(customTypeNames))
          {
          		Object customTypeObj[] = new Object[1];
          		Object tmpObj = Class.forName(tempGetMethod.getReturnType().getName()).newInstance();
          		convertBeanToBeanWithDeepCopy(getValue[0], tmpObj, customTypeNames, ignoreNulls);
          		customTypeObj[0] = tmpObj;
          		invokeMethod(destination, setMethod, customTypeObj);
          } else {
          	invokeMethod(destination, setMethod, getValue);
          }
      }
  }
    
    
    /** 
    * This method, invokes the given method on the given object with the given parameter array.
    * It ignores any exception. 
    *
    * @param bean DataBean object on which the method needs to be invoked
    * @param method Method to be invoked
    * @param params Object[] array of object parameters
    * @return Object returned by the method invocation
    */    
    public static Object invokeMethod(Object object, Method m, Object[] params) {
        try {
            return m.invoke(object, params);
        } catch (InvocationTargetException invokeEx) {
        	//logger.error(""+invokeEx.getMessage());
        } catch (Exception ex) {
        	//logger.error(""+ex.getMessage());
        }
        return null;
    }
    
     /** 
      * This method is responsible for discovering the set methods of the
      * given bean.
      *
      * @param bean DataBean object 
      * @return Hashtable with the key as method name and value as the Method object
      */
     public static Hashtable<String, Method> discoverSetMethods(Object bean) {
        return discoverSetMethods(bean.getClass());
     }
        
     /** 
      * This method is responsible for discovering the set methods of the
      * given bean.
      *
      * @param beanClass DataBeanClass object 
      * @return Hashtable with the key as method name and value as the Method object
      */
     public static Hashtable<String, Method> discoverSetMethods(Class<?> beanClass) {
        Hashtable<String, Method> setMethods = new Hashtable<String, Method>();
        //Class beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        for (int ii=0; ii < methods.length; ii++) {
            String methodName = methods[ii].getName();
            if (methodName.startsWith("set") && methodName.length() > 3) {                
                char leadingChar = Character.toLowerCase(methodName.charAt(3));
                setMethods.put("" + leadingChar + methodName.substring(4), methods[ii]);
            }
        }
        return setMethods;
     }

     /** 
      * This method is responsible for discovering the set methods of the
      * given bean.
      *
      * @param bean DataBean object 
      * @return Hashtable with the key as method name and value as the Method object
      */
     public static Hashtable<String, Method> discoverGetMethods(Object bean) {
        Hashtable<String, Method> getMethods = new Hashtable<String, Method>();
        Class<?> beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        for (int ii=0; ii < methods.length; ii++) {
            String methodName = methods[ii].getName();
            //For boolean methods you could have isXXX where xXX is the property name
            
            if (methodName.startsWith("get") && methodName.length() > 3) {                
                char leadingChar = Character.toLowerCase(methodName.charAt(3));
                getMethods.put("" + leadingChar + methodName.substring(4), methods[ii]);
            } else if (methodName.startsWith("is") && methodName.length() > 2) {
                char leadingChar = Character.toLowerCase(methodName.charAt(2));
                getMethods.put("" + leadingChar + methodName.substring(3), methods[ii]);
            }
        }
        return getMethods;
     }
     
    


    /**
     * Populate the JavaBeans properties of the specified bean, based on
     * the specified name/value pairs.  This method uses Java reflection APIs
     * to identify corresponding "property setter" method names, and deals
     * with setter arguments of type <code>String</code>, <code>boolean</code>,
     * <code>int</code>, <code>long</code>, <code>float</code>, and
     * <code>double</code>.  In addition, array setters for these types (or the
     * corresponding primitive types) can also be identified.
     *
     * @param bean JavaBean whose properties are being populated
     * @param properties Hashtable keyed by property name, with the
     *  corresponding (String or String[]) value(s) to be set
     *
     * @exception Exception if thrown while setting properties
     */
    public static void populate(Object bean, Hashtable<String, NameValuePair> properties)
	    throws Exception {

	    if ((bean == null) || (properties == null))
	        return;
    	    
        Hashtable<String, Method> setMethods = discoverSetMethods(bean);

    /* 
	    // Identify the property descriptors supported by our JavaBean
	    PropertyDescriptor descriptors[] = getPropertyDescriptors(bean);
	    if (descriptors.length < 1)
	        return;
	        */

        //Create a cms data exception to keep the list of error messages
        Exception dataEx = null;
	    // Loop through the property name/value pairs to be set
	    Enumeration<String> names = properties.keys();
	    while (names.hasMoreElements()) {

	        // Identify the property name and value(s) to be assigned
	        String name = (String) names.nextElement();
	        //System.out.println("BeanUtil:: Dealing with : " + name);
	        //The value is actually NameValuePair object
	        NameValuePair httpValue = (NameValuePair)properties.get(name);	// String or String[]
	        Object value = httpValue.value;
	        /* Allow setting null values
	        if (value == null) {
	            //For checkboxes we need to set the value to false. 
		        continue;
		    }
		    DVP
		    */

	        // Identify the relevant setter method (if there is one)
	        Method setter = null;
	        Class<?> parameterTypes[] = null;
            setter = (Method)setMethods.get(name);
	        /*
	        for (int i = 0; i < descriptors.length; i++) {
		    if (!name.equals(descriptors[i].getName()))
		        continue;
		    setter = descriptors[i].getWriteMethod();
		    */
    		
		    if (setter == null)
		        continue;

		    parameterTypes = setter.getParameterTypes();
		    if (parameterTypes.length != 1) {
		        setter = null;
		        continue;
		    }
	        if (setter == null)
		        continue;


	        // Convert the parameter value as required for this setter method
	        Object parameters[] = new Object[1];	
	        try {
	            if (parameterTypes[0].isArray()) {
	                if (value == null)
        	            parameters[0] = null;
        	        else {
		                if (value instanceof String) {
		                    String values[] = new String[1];
		                    values[0] = (String) value;
		                    parameters[0] = convert((String[]) values,
					                parameterTypes[0]);
		                } else {
		                    parameters[0] = convert((String[]) value,
					                parameterTypes[0]);
		                }
		            }
	            } else {
	                if (value == null)
        	            parameters[0] = null;
        	        else {
		                if (value instanceof String) {
		                    parameters[0] = convert((String) value,
					                parameterTypes[0]);
		                } else {
		                    parameters[0] = convert( ((String[]) value)[0],
					                parameterTypes[0]);
		                }
		            }
	            }
	        } catch (InvalidConversionException invalidConversionEx) {
	            System.out.println("VAlue : " + ((String[]) value)[0]);
	            String msg = "Incompatible value: '" + ((String[]) value)[0].toString() + "' entered for property: '" + name + "'";
	            //Avoiding instance of 
	            //if (bean.getClass().getName().endsWith("DataObject")) {
	            try {
	                System.out.println("Adding error to databean in populate: " + msg);
	                //If the user did not use 
//	                if (! name.equals(httpValue.completeName)) {
//	                    System.out.println("Complete name is different from name");	                    
//	                    ((DataBean)bean).addError(name, httpValue.completeName, msg);
//	                } else {	                
//	                    ((DataBean)bean).addError(name, msg);
//	                }
    	                    
	            } catch (ClassCastException classEx) {
	                //Ignore this, the given object is not a databean
	                System.out.println("Warning, trying to populate a non databean class");
	            }
	            if (dataEx == null) {
	                dataEx = new Exception(msg);
	            } else {
	                dataEx = new Exception(msg);
	            }
	            System.out.println("Continuing after the exception in BeanUtil");
	            continue;
	        }

	        // Invoke the setter method
	        try {
	            setter.invoke(bean, parameters);
	        } catch (IllegalAccessException illegalEx) {
	            System.out.println("Unable to set property :" + name + " on bean " + bean + " params " + parameters + " Ex " + illegalEx);
	        } catch (InvocationTargetException invokeEx) {
	            System.out.println("Unable to set property :" + name + " on bean " + bean + " params " + parameters + " Ex " + invokeEx);
	        } catch (IllegalArgumentException illegalArgEx) {
	            System.out.println("Unable to set property :" +  name + " on bean " + bean + " params " + parameters + " Ex " + illegalArgEx);
	        }
	    }
	    
	    if (dataEx != null) {
	        System.out.println("Throwing the ApplicationException in BeanUtil");
	        throw dataEx;
	    }
    }


    // -------------------------------------------------------- Private Methods


    /**
     * Convert a String value to a corresponding Boolean value.
     *
     * @param value The string value to convert
     */
    public static Boolean convertBoolean(String value) 
            throws InvalidConversionException {

        //System.out.println("Converting to boolean : '" + value + "'");
	    if (value == null)
	    	return Boolean.FALSE;
	        //return (new Boolean(false));
	    else if (value.equalsIgnoreCase("yes") ||
	            value.equalsIgnoreCase("true") ||
	            value.equalsIgnoreCase("on"))
	    	return Boolean.TRUE;
	        //return (new Boolean(true));
	    else if (value.equalsIgnoreCase("no") ||
	            value.equalsIgnoreCase("false") ||
	            value.equalsIgnoreCase("off") ||
	            value.equals(""))
	    	return Boolean.FALSE;
	        //return (new Boolean(false));
        throw new InvalidConversionException();
    }


    /**
     * Convert a String value to a corresponding Byte value.
     *
     * @param value The string value to convert
     */
    public static Byte convertByte(String value) throws InvalidConversionException {

	    try {
	        return (new Byte(value));
	    } catch (NumberFormatException e) {
	        throw new InvalidConversionException();
	        //return (new Byte((byte) 0));
        }
    }


    /**
     * Convert a String value to a corresponding Character value.
     *
     * @param value The string value to convert
     */
    public static Character convertCharacter(String value) {

	    if (value == null)
	        return (new Character(' '));
	    else if (value.length() == 0)
	        return (new Character(' '));
	    else
	        return (new Character(value.charAt(0)));
    }


    /**
     * Convert a String value to a corresponding Double value.
     *
     * @param value The string value to convert
     */
    public static Double convertDouble(String value) throws InvalidConversionException {

	    try {
	        return (new Double(value));
	    } catch (NumberFormatException e) {
	        throw new InvalidConversionException();
	        //return (new Double(0.0));
        }
    }


    /**
     * Convert a String value to a corresponding Float value.
     *
     * @param value The string value to convert
     */
    public static Float convertFloat(String value) {
        if (value == null || value.trim().length() == 0) {
            return null;
        }

	    try {
	        return (new Float(value));
	    } catch (NumberFormatException e) {
	        return (new Float(0.0));
        }
    }


    /**
     * Convert a String value to a corresponding Integer value.
     *
     * @param value The string value to convert
     */
    public static Integer convertInteger(String value) throws InvalidConversionException {
        if (value == null || value.trim().length() == 0) {
            return null;
        }

	    try {
	        return (new Integer(value));
	    } catch (NumberFormatException e) {
	        throw new InvalidConversionException();
	        //return (new Integer(0));
        }
    }


    /**
     * Convert a String value to a corresponding Long value.
     *
     * @param value The string value to convert
     */
    public static Long convertLong(String value) throws InvalidConversionException {
        if (value == null || value.trim().length() == 0) {
            return null;
        }

	    try {
	        return (new Long(value));
	    } catch (NumberFormatException e) {
	        throw new InvalidConversionException();
	        //return (new Long(0));
        }
    }
    
    public static String convertSqlDateToString(java.sql.Date date) {        
        return date.toString();
    }
    
    public static String convertUtilDateToString(java.util.Date date) {
        String str = (date == null) ? "" : BASE_DATE_FORMATTER.format(date);
        //System.out.println("Date String : " + str);
        return str;
    }
    
    /**
     * Convert a String value to a corresponding java.sql.Date value.
     *
     * @param value The string value to convert
     */
    public static java.sql.Date convertSqlDate(String value) {	
        if (value == null || value.trim().length() == 0) {
            return null;
        }
        
	    SimpleDateFormat formatter  = new SimpleDateFormat("MM/dd/yyyy");
	    formatter.setLenient(false);
	    ParsePosition parsePosition = new ParsePosition(0);
	    java.sql.Date dt = new java.sql.Date(((java.util.Date)formatter.parse(value,parsePosition)).getTime());
	    return dt;
    }

    /**
     * Convert a String value to a corresponding java.sql.Timestamp value.
     *
     * @param value The string value to convert
     */
    public static java.sql.Timestamp convertTimestamp(String value) {	
        if (value == null || value.trim().length() == 0) {
            return null;
        }
        
	    java.sql.Timestamp ts = java.sql.Timestamp.valueOf(value);
	    return ts;
    }    

    /**
     * Convert a String value to a corresponding java.util.Date value.
     *
     * @param value The string value to convert
     */
    public static java.util.Date convertUtilDate(String value) 
            throws InvalidConversionException {
        
        if (value == null || value.trim().length() == 0) {
            return null;
        }

	    SimpleDateFormat formatter  = new SimpleDateFormat("MM/dd/yyyy");
	    formatter.setLenient(false);
	    ParsePosition parsePosition = new ParsePosition(0);
	    java.util.Date dt = formatter.parse(value,parsePosition);
	    if (dt == null) {
	        System.out.println("Throwing invalid conversion exception: Invalid util.date");
	        throw new InvalidConversionException();	
	    }
	    return dt;
    }

    /**
     * Convert a String value to a corresponding BigDecimal value.
     *
     * @param value The string value to convert
     */
    public static BigDecimal convertBigDecimal(String value) throws InvalidConversionException {

        if (value == null || value.trim().length() == 0) {
            return null;
        }
        try {
	        return (new BigDecimal(value));
	    } catch (NumberFormatException numEx) {
	        System.out.println("Number exception : " + numEx);
	        throw new InvalidConversionException();	        
	    }
    }

    public static void main(String args[]) {
        try {
            System.out.println("Big Decimal :" + BeanUtils.convertBigDecimal("12.32"));
            System.out.println("Util Date :" + BeanUtils.convertUtilDate("09/23/1999"));
            System.out.println("SQL Date :" + BeanUtils.convertSqlDate("05/22/2001"));
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
    }
    
    static class InvalidConversionException extends Exception {
        public InvalidConversionException() {
        }
    }        
}

