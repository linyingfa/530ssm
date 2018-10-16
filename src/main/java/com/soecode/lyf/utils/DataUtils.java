package com.soecode.lyf.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据转换工具类
 *
 * @author denwgen 14-5-30
 */
@Component
@SuppressWarnings("rawtypes")
public class DataUtils {



    public static void main(String[] args) {
        System.out.println(numberKArab2CN(12));
    }

    /**
     * 获取任意位数的随机数
     *
     * @author dengwen 2018年1月17日
     */
    public static String getRadom(int x) {
        String code = "";
        for (int i = 0; i < x; i++) {
            code += getCode() + "";
        }
        return code;
    }

    private static char getCode() {
        char d = '0';
        d = (char) (d + (int) (Math.random() * 10));
        return d;
    }

    public static Result mergeData(int count, List<Map<String, Object>> list, Result rs) {
        rs.setRecordsFiltered(count);
        rs.setRecordsTotal(count);
        rs.setData(list);
        return rs;
    }

    /**
     * 实体去空字符串
     *
     * @return
     * @author dengwen 2016-8-9下午4:11:52
     */
    public static <T> T trim(T object) {
        try {
            Class clazz = object.getClass();
            for (Field s : clazz.getDeclaredFields()) {
                s.setAccessible(true);
                s.set(object, "".equals(s.get(object)) ? null : s.get(object));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 数组去空
     *
     * @author dengwen 2016-10-25下午3:57:39
     */
    public static void trim(String[] str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = (null == str[i] || "".equals(str[i])) ? null : str[i].trim();
        }
    }

    /**
     * json字符转Map
     *
     * @author dengwen 2017-4-29下午4:31:39
     */
    public static Map<String, Object> stringToMap(String json) {
        Map<String, Object> map = new HashMap<String, Object>();
        json = json.replace(", ", ",").replace("{", "").replace("}", "");
        for (String str : json.split(",")) {
            String[] split = str.split("=");
            map.put(split[0], split[1]);
        }
        return map;
    }

    /**
     * 随机32位数 带 -
     *
     * @author dengwen 2018年1月17日
     */
    public static String generatorID() {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        return id;
    }

    /**
     * 过滤map的键值、值为空"" 时设置为null
     *
     * @author dengwen 2017-9-17
     */
    /*public static Map<String, Object> trimParam(Map<String, Object> param) {
        for (String key : param.keySet()) {
            if (ValidateUtils.isBlank(param.get(key)))
                param.put(key, null);
        }
        if (param.isEmpty() || ValidateUtils.isBlank(param.get("page"))) {
            param.put("page", 0);
            param.put("rows", 10);
            return param;
        }

        // 验证分页参数
        Integer page = Integer.parseInt((String) param.get("page"));
        Integer rows = 10;
        if(!ValidateUtils.isBlank(param.get("rows"))){
        	rows = Integer.parseInt((String) param.get("rows"));
        }
        param.put("rows", rows);
        if (ValidateUtils.isBlank(page))
            param.put("page", 0);
        else if (page > 0)
            param.put("page", (page - 1) * rows);
        return param;
    }*/
    public static Map<String, Object> trimParam(Map<String, Object> param) {
        for (String key : param.keySet()) {
            if (ValidateUtils.isBlank(param.get(key)))
                param.put(key, null);
        }
        if (param.isEmpty()) {
            param.put("page", 0);
            param.put("rows", 10);
            return param;
        }
        if (ValidateUtils.isBlank(param.get("page"))) {
            param.put("page", 0);
        }
        if (ValidateUtils.isBlank(param.get("rows"))) {
            param.put("rows", 10);
        }

        // 验证分页参数
        Integer page = Integer.parseInt(param.get("page").toString());
        Integer rows = Integer.parseInt(param.get("rows").toString());;

        if (ValidateUtils.isBlank(rows)) {
            param.put("rows", 10);
        }else {
            param.put("rows", rows);
        }

        if (ValidateUtils.isBlank(page))
            param.put("page", 0);
        else if (page > 0)
            param.put("page", (page - 1) * rows);
        return param;
    }


    /**
     * 随机生成数字，大小写字母
     *
     * @author dengwen 2018年1月17日
     */
    public static String createRandomCharData(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();// 随机用以下三个随机生成器
        Random randdata = new Random();
        int data = 0;
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(3);
            // 目的是随机选择生成数字，大小写字母
            switch (index) {
                case 0:
                    data = randdata.nextInt(10);// 仅仅会生成0~9
                    sb.append(data);
                    break;
                case 1:
                    data = randdata.nextInt(26) + 65;// 保证只会产生65~90之间的整数
                    sb.append((char) data);
                    break;
                case 2:
                    data = randdata.nextInt(26) + 97;// 保证只会产生97~122之间的整数
                    sb.append((char) data);
                    break;
            }
        }
        return sb.toString();
    }

    /**
     * 去除HTML代码
     *
     * @author dengwen 2018年1月17日
     */
    public static String delHTMLTag(String htmlStr) {
        if (!ValidateUtils.isBlank(htmlStr)) {
            String content = htmlStr.replaceAll("\\&[a-zA-Z]{0,9};", "").replaceAll("<[^>]*>", "");
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(content);
            return m.replaceAll("");
        } else
            return "";
    }

    public static String getRandomAZ(int length) {
        StringBuffer buffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }

    /**
     * 生成订单号
     */
    public static String getOrderNumber() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getRadom(4) + DateUtils.format("yyyyMMddHHmmss", new Date()) + getRadom(2));

        return buffer.toString();
    }

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description: TODO(将json格式字符串转换成List<?>) @param key :json字符串名称 @param
     * element: List<element>中的元素 @return List<?> 返回类型 @throws
     */
    public static List<?> getJsonToList(String jsonStr, Class<?> element) {
        // String jsonStr = this.getParaToStr(key);
        if (StringUtils.isBlank(jsonStr))
            return null;
        JavaType javaType = getCollectionType(ArrayList.class, element);
        try {
            return mapper.readValue(jsonStr, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取泛型的Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * json 转 List<Map>
     *
     * @param params
     * @return
     */
    public static List<Map<String, Object>> getJsonToList(String params) {
        JSONArray array = JSONArray.parseArray(params);

        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            JSONObject object = array.getJSONObject(i);
            Set<String> set = object.keySet();
            for (String key : set) {
                map.put(key, object.get(key));
            }
            list.add(map);
        }
        return list;
    }

    /**
     * 获取利用反射获取类里面的值和名称
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        System.out.println(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            map.put(fieldName, value);
        }
        return map;
    }

    private static char numZero = '零';
    private static final String[] units = {"千", "百", "十", ""};//个位
    private static final char[] numChars = {'一', '二', '三', '四', '五', '六', '七', '八', '九'};
    public static String numberKArab2CN(Integer num) {
        char[] numChars = (num + "").toCharArray();
        String tempStr = "";
        int inc = units.length - numChars.length;
        for (int i = 0; i < numChars.length; i++) {
            if (numChars[i] != '0') {
                tempStr += numberCharArab2CN(numChars[i]) + units[i + inc];
            } else {
                tempStr += numberCharArab2CN(numChars[i]);
            }
        }
        //将连续的零保留一个
        tempStr = tempStr.replaceAll(numZero + "+", numZero + "");

        //去掉未位的零
        tempStr = tempStr.replaceAll(numZero + "$", "");
        return tempStr;
    }
    public static char numberCharArab2CN(char onlyArabNumber) {
        if (onlyArabNumber == '0') {
            return numZero;
        }
        if (onlyArabNumber > '0' && onlyArabNumber <= '9') {
            return numChars[onlyArabNumber - '0' - 1];
        }
        return onlyArabNumber;
    }

}
