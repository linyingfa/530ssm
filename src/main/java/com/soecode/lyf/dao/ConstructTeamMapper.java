package com.soecode.lyf.dao;

import com.soecode.lyf.entity.ConstructTeam;

public interface ConstructTeamMapper extends BaseMapper<ConstructTeam,Long>{
    int deleteByPrimaryKey(Long id);

    int insert(ConstructTeam record);

    int insertSelective(ConstructTeam record);

    ConstructTeam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConstructTeam record);

    int updateByPrimaryKey(ConstructTeam record);
}