package com.company.domain;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReplyPageDTO {
	private int replyCnt;
	private List<ReplyDTO> list;
	
}
