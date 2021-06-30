package com.shu.entity;


import com.shu.utils.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 
 * @author 596183363@qq.com
 * @time 2020-06-09 10:18:04
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Entity {



	/**
	 * 
	 */
	private String account;
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String remark;

    private Date now;

	private Integer type;


}