package com.gexingw.spring.mybatis.adapter.web;

import com.gexingw.spring.mybatis.mapper.UserMapper;
import com.gexingw.spring.mybatis.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GeXingW
 */
@RestController
@RequestMapping("/web/user")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class WebUserAdapter {

    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public Object info(@PathVariable Long id) {
        UserVO byId = userMapper.getById(id);
        return byId;
    }

}
