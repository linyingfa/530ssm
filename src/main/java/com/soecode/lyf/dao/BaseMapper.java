package com.soecode.lyf.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * dao操作接口，用于继承
 * @author dengwen 2015-4-28
 */
public interface BaseMapper<M, T> {
	
	/**
	 * 后台查询列表
	 * @author dengwen 
	 * 2017-5-24下午3:29:31
	 */
	public List<Map<String,Object>> searchList(Map<String, Object> param);

	/**
	 * 后台查询列表总条数
	 * @author dengwen 2015-4-28
	 */
	public int searchListCount(Map<String, Object> param);
	/**
	 * 分页查找数据
	 * @author dengwen 2015-4-28
	 */
	public List<M> findByPage(@Param("param") M m, @Param("offset") int offset, @Param("pageSize") int pageSize);

	/**
	 * 分页查找总条数
	 * @author dengwen 2015-4-28
	 */
	public int findByPageCount(@Param("param") M m);

	/**
	 * 根据id查询数据
	 * @author dengwen 2015-4-28
	 */
	public M findById(T id);

	/**
	 * 根据ids查询数据
	 * @author dengwen 2015-4-28
	 */
	public List<M> load(List<T> ids);

	/**
	 * 更新数据
	 * @author dengwen 2015-4-28
	 */
	public int update(M m);

	/**
	 * 添加数据
	 * @author dengwen 2015-4-28
	 */
	public int insert(M m);

	/**
	 * 添加多条数据（直接添加到数据库 不做非空判断）
	 * @author dengwen 2015-4-28
	 */
	public int inserts(List<M> list);

	/**
	 * 删除单条数据
	 * @author dengwen 2015-4-28
	 */
	public int delete(T id);

	/**
	 * 删除多条数据
	 * @author dengwen 2015-4-28
	 */
	public int deletes(@Param("ids") List<T> ids);
	
	/**
	 * 通过实体中的条件删除数据
	 * @author dengwen 2015-4-28
	 */
	public int deleteByEntity(@Param("param") M m);
	
	/**
	 * 通过实体中的条件查询所有
	 * @author dengwen 2015-4-28
	 */
	public List<M> findAll(@Param("param") M m);
	
	/**
	 * 通过实体条件查询唯一实体
	 * @author dengwen 2015-4-28
	 */
	public M findEntityByCondition(@Param("param") M m);

	/**
	 * 执行更新sql
	 * @author dengwen 2015-4-28
	 */
	int upstateBySql(String sql);

	/**
	 * 执行插入sql
	 * @author dengwen 2015-4-28
	 */
	int insertBySql(String sql);

	/**
	 * 执行删除sql
	 * @author dengwen 2015-4-28
	 */
	int deleteBySql(String sql);

	/**
	 * 执行查询String集合
	 * @author dengwen
	 * 2017-5-24下午3:29:31
	 */
	public List<String> searchStringBySql(String sql);

	/**
	 * 执行查询Long集合
	 * @author dengwen
	 * 2017-5-24下午3:29:31
	 */
	public List<Long> searchLongBySql(String sql);

	/**
	 * 执行查询Map集合
	 * @author dengwen
	 * 2017-5-24下午3:29:31
	 */
	public List<Map<String,Object>> searchListBySql(String sql);

	/**
	 * 执行查询总数
	 * @author dengwen
	 * 2017-5-24下午3:29:31
	 */
	public int searchCountBySql(String sql);

	/**
	 * 执行查询Map
	 * @author dengwen
	 * 2017-5-24下午3:29:31
	 */
	public Map<String,Object> searchInfoBySql(String sql);

}
