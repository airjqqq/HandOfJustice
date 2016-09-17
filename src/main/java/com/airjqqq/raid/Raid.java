package com.airjqqq.raid;

import com.airjqqq.account.Character;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Airj on 2016/9/15.
 */
@Data
public class Raid {
    @Id
    String id;
    List<Character> characters = new ArrayList<>();
    Date date = new Date();
    String name;
    String location;
    Difficulty difficulty;
    enum Difficulty{
        Normal,
        Heroic,
        Mythic,
    }
}
