package com.s3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    private Integer id;
    private Integer hotEventsId;
    private String commentDate;
    private String content;
}
