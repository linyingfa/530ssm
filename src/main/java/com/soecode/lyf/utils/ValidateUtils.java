package com.soecode.lyf.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 此工具类为校验工具类,校验字符串、数组、集合是否为空
 * @author dengwen  14-5-27
 */
public class ValidateUtils {

	/**
	 * 私有化构造函数,不允许创建实体
	 */
	private ValidateUtils(){} ;
	
	/**
	 * 校验数组是否为空，为空为true，反之为false 
	 */
	public static boolean isEmpty(Object... args){
		if(args != null && args.length > 0){
			return false ;
		}
		return true ;
	}
	
	/**
	 * 校验集合是否为空，为空为true，反之为false 
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmptyForCollection(Collection list){
		if(list != null && list.size() > 0){
			return false ;
		}
		return true ;
	}
	
	/**
	 * 判断数组是否为空，为空为TRUE，反之为FALSE
	 * @param obj
	 * @return
	 */
	public static boolean isempty(Object[] obj){
		if(obj != null && obj.length > 0){
			return false ;
		}else{
			return true ;
		}
	}
	
	/**
	 * 校验字符串是否为空，为空为true，反之为false
	 */
	public static boolean isBlank(Object... str){
		for (Object obj : str) {
			if(obj == null || "".equals(obj) || "null".equals(obj) || "(null)".equals(obj)){
				return true ;
			}
		}
		return false ;
	}
	
	/**
	 * 判断是否为固定电话，是为true,反之为false
	 */
	public static boolean isTelephone(String phone){
		String regex = "0\\d{2}-\\d{8}|0\\d{2}-\\d{7}|0\\d{3}-\\d{7}|0\\d{3}-\\d{8}" ;
		Pattern p = Pattern.compile(regex) ;
		if(!isBlank(phone)){
			Matcher m = p.matcher(phone) ;
			return m.matches() ;
		}else{
			return false ;
		}
	}
	
	/**
	 * 判断是否为手机号，是为true,反之为false
	 */
	public static boolean isMobilePhone(String phone){
		String regex = "1[3|4|5|7|8]\\d{9}" ;
		Pattern p = Pattern.compile(regex) ;
		if(!isBlank(phone)){
			Matcher m = p.matcher(phone) ;
			return m.matches() ;
		}else{
			return false ;
		}
	}
	
	/**
	 * 判断是否为邮箱，是为true,反之为false
	 */
	public static boolean isEmail(String email){
		String regex = "(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})" ;
		Pattern p = Pattern.compile(regex) ;
		if(!isBlank(email)){
			Matcher m = p.matcher(email) ;
			return m.matches() ;
		}else{
			return false ;
		}
	}
	
	/**
	 * 校验集合是否为空，为空为true，反之为false 
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmptyForMap(Map map){
		if(map != null && map.size() > 0){
			return false ;
		}
		return true ;
	}
	
	/** 
     * 大陆号码或香港号码均可 
     */  
    public static boolean isPhoneLegal(String str)throws PatternSyntaxException {  
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);  
    }  
  
    /** 
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 
     * 此方法中前三位格式有： 
     * 13+任意数 
     * 15+除4的任意数 
     * 18+除1和4的任意数 
     * 17+除9的任意数 
     * 147 
     */  
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {  
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
  
    /** 
     * 香港手机号码8位数，5|6|8|9开头+7位任意数 
     */  
    public static boolean isHKPhoneLegal(String str)throws PatternSyntaxException {  
        String regExp = "^(5|6|8|9)\\d{7}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
    
    /**
	 * 身份证验证 无效为true，反之为false 
	 */
//    public static boolean checkIDCard(String IDCard)throws PatternSyntaxException {
//        return IDCardValidate.checkIDCard(IDCard).length() > 0 ? true : false;
//    }
    
    /**
	 * 验证时间是否有效、默认5分钟
	 * @author dengwen 
	 * 2017-4-17下午5:42:11
	 */
	public static Boolean verifCodeDate(Date codeDate,Integer time) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		c.setTime(codeDate);
		c.add(Calendar.MINUTE, time == null ? 5 : time);
		return sf.format(c.getTime()).compareTo(sf.format(new Date())) >= 0;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(isBlank(new String("12"),null));
	}
}
