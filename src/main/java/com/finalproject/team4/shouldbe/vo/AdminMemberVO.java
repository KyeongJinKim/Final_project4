package com.finalproject.team4.shouldbe.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMemberVO {
    private String profile_img;
    private String user_name;
    private String user_id;
    private String time;
    // private int posts_count;
    // private int comments_count;
    private int count_report;
}