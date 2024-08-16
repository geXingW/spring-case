package com.gexingw.spring.rocketmq.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author GeXingW
 */
@Data
@NoArgsConstructor
public class UserMessage implements Serializable {

    public final static String USER_TOPIC_1 = "USER-TOPIC-1";

    private Long id;

    private String name;

    public UserMessage(Long id) {
        this.id = id;
        this.name = "User-" + id;
    }

    public UserMessage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
