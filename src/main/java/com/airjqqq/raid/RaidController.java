package com.airjqqq.raid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Airj on 2016/9/16.
 */
@Controller
public class RaidController {
    @RequestMapping(value = "/raid")
    public String raid(@RequestParam(value="name", required=false, defaultValue="Raid") String name, Model model) {
        model.addAttribute("raidName", name);
        List members = new ArrayList();
        Member member1 = new Member("王小呆");
        member1.setRoles(Arrays.asList(Member.Role.TANK));
        members.add(member1);
        Member member2 = new Member("袁小萌");
        member2.setRoles(Arrays.asList(Member.Role.RANGE,Member.Role.HEALER));
        members.add(member2);
        model.addAttribute("members", members);
//        Member.Role.HEALER.toString().substring()
        return "raid";
    }
}
