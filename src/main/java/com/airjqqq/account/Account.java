package com.airjqqq.account;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Airj on 2016/9/15.
 */
@Data
public class Account {
    @Id
    String id;
    Double Participation = 0.5;
}
