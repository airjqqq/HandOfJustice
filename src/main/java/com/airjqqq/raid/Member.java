package com.airjqqq.raid;

import com.airjqqq.account.Character;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Airj on 2016/9/15.
 */
@Data
public class Member {
    String name;
    List<Role> roles = new ArrayList<>();
    public Member(String name) {
        this.name = name;
    }
    enum Role{
        TANK,
        MELEE,
        RANGE,
        HEALER,
    }
}
