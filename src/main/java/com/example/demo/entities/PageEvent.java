package com.example.demo.entities;


import lombok.*;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@ToString @Builder
public class PageEvent {
    private String name ;
    private String userName;
    private Date date;
    private long duration ;
}
