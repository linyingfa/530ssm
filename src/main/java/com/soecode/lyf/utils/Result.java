package com.soecode.lyf.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 封装的返回结果对象
 * @author Folo 2014年10月15日
 */
public class Result {
	
	/**
	 * 状态 10001 成功
	 */
	private int status;
	/**
	 * 消息内容 
	 */
	private String msg;
	/**
	 * 返回结果数据
	 */
	private JSONObject dataInfo;

	public JSONObject getDataInfo() {
		return dataInfo;
	}

	public void setDataInfo(JSONObject dataInfo) {
		this.dataInfo = dataInfo;
	}

	/**
	 * 返回结果数据
	 */
	private List<? extends Object> data;
	
	public List<? extends Object> getData() {
		return data;
	}

	public void setData(List<? extends Object> data) {
		this.data = data;
	}

	private  int recordsTotal ;
	
	private int recordsFiltered ;
	
	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	/**
	 * 服务器时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date time = null;
	
	public Result() {
		this.status = 10001;
		this.msg = "成功";
		this.recordsTotal = 0 ;
		this.recordsFiltered = 0 ;
		this.data = new ArrayList<Object>();
		this.dataInfo = new JSONObject();
	}
	
	public Result(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public Result setStatus() {
		this.status = 20001;
		return this;
	}

	public String getMsg() {
		return msg;
	}
	
	public Result put(String key, Object value){
		dataInfo.put(key, value);
		return this;
	}

	public Result setMsg(String msg) {
		this.msg = msg;
		this.setStatus();
		return this;
	}
	
	public Result setStatus(int stauts) {
		this.status = stauts;
		return this;
	}
	
	public Result setMsg(String msg,int stauts) {
		this.msg = msg;
		this.setStatus(stauts);
		return this;
	}

	public Date getTime() {
		return time == null ? new Date() : time;
	}

	public Result setTime(Date time) {
		this.time = time;
		return this;
	}
	
	public Result setError(MSG msg){
		this.setMsg(msg.getMsg());
		this.setStatus();
		return this;
	}
	
	/**
	 * 消息枚举
	 * @author Folo 2014年10月20日
	 */
	public static enum MSG{
		/** 1000X 成功 */
		OK(10001, "成功"),
		/** 2000X 失败 */
		ERROR(20001, "失败,未知错误"),
		NOT_FOUND(20003, "{0},找不到该{1}！"),
		PARAMS_ERROR(20004, "参数错误,{0}"),
		/** 身份认证失效  */
		TOKEN_FAILURE(21001, "身份认证失效,请重新登录!"),
		/** 自定义错误 */
		CUS_ERROR(20005, "{0}");
		
		private int status = 0;
		private String msg = null;
		MSG(int status, String msg){
			this.status = status;
			this.msg = msg;
		}
		
		public String getMsg(){
			return msg;
		}
		
		public int getStatus(){
			return status;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(MSG.ERROR.status);
	}
}

