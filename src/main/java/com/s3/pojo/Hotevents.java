package com.s3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotevents {
    private Integer id;
    private String keyWord;
    private String hotContent;
    private Integer searchSum;
    private String createDate;
}
