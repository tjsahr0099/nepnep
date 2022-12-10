package com.nepnep.querymaker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardVO {

    private Integer seq;
    private String title;
    private String cont;
    private Date regDate;
    private String regUser;
    private Date upDate;
    private String updUser;

}
