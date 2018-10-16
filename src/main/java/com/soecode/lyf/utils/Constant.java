package com.soecode.lyf.utils;
/**
 * 全平台常量值,状态值维护类
 * @author chenjian
 *
 */
public class Constant {
	/***************** 全平台通用常量 ******************/
	
	/** 分页参数;*/
	public static final Integer DEFAULT_PAGE = 0; // 分页查询默认页码;
	public static final Integer DEFAULT_PAGE_ROWS = 10; // 分页查询默认每页数据条数;
	
	/** 上传墙体用户类型,:app用户 */
	public static final Integer WALL_APP_USER_TYPE = 1;
	/** 上传墙体用户类型,后台用户*/
	public static final Integer WALL_WEB_USER_TYPE = 2;
	
	/** 墙体表 --> 是否开启维护 1:开启 0:关闭*/
	public static final Integer WALL_MAINTAIN_STATE_OPEN = 1;
	public static final Integer WALL_MAINTAIN_STATE_SHUT = 0;
	
	/**墙体表  --> 审核状态	0:待审核 1:通过 2:不通过*/
	public static final Integer WALL_AUDIT_STATE_WAIT = 0;
	public static final Integer WALL_AUDIT_STATE_RELEASE = 1;
	public static final Integer WALL_AUDIT_STATE_CLOSE = 2;
	
	/** 广告申请图片表 --> 图片的状态: 0为APP端上传   为1 就是后台上传的图片*/
	public static final Integer ADVERT_APP_STATUS = 0;
	public static final Integer ADVERT_WEB_STATUS = 1;
	
	/**设置进行中项目，倒计时时间,最多5天*/
	public static final Integer COUNT_DOWN_TIME = 5;
	
	//项目状态
	/** 项目状态，咨询中*/
	public static final Integer PROJECT_ADVISORY_STATE = 1;
	/** 项目状态，施工中*/
	public static final Integer PROJECT_CONSTRUCT_STATE = 2;
	/** 项目状态，维护中*/
	public static final Integer PROJECT_MAINTAIN_STATE = 3;
	/**项目状态，已完成*/
	public static final Integer PROJECT_FINISH_STATE = 4;
	
	//注册用户来源   1:用户注册 2:系统创建 3:广告商创建
	/** 注册用户来源   1:用户注册*/
	public static final Integer USER_SOURCE_REGIST = 1;
	/** 注册用户来源   2:系统创建 */
	public static final Integer USER_SOURCE_SYSTEM = 2;
	/** 注册用户来源   3:广告商创建*/
	public static final Integer USER_SOURCE_ADVERTISER = 3;
	
}
