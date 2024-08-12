package com.gexingw.transaction.message.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

/**
 * @author GeXingW
 */
@TableName("trans_event")
public class TransEventPO {

    private Long id;

    private Long creatorId;

    private LocalDateTime createTime;

    private Long updaterId;

    private LocalDateTime updateTime;

}
