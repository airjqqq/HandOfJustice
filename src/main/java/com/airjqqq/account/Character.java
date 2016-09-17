package com.airjqqq.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;

/**
 * Created by Airj on 2016/9/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {
    @Id
    String name;
    String itemLevel;
    String aClass;
    Role mainSpec;
    Role[] offSpecs;
    @DBRef
    Account account;
    enum Role{
        TANK,
        MELEE,
        RANGE,
        HEALER,
    }
}
