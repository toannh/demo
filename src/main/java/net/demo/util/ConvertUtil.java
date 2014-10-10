package net.demo.util;

/**
 * Created by toannh on 10/10/14.
 */
public class ConvertUtil {
  public static boolean getEnable(String value, boolean defaultValue){
    if("on".equals(value)){
      return true;
    }
    return defaultValue;
  }
}
