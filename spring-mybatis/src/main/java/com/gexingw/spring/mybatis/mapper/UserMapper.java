package com.gexingw.spring.mybatis.mapper;

import com.gexingw.spring.mybatis.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author GeXingW
 */
@Mapper
public interface UserMapper {

    UserVO getById(Long id);

}
