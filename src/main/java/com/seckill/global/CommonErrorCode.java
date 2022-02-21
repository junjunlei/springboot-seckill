package com.seckill.global;

import org.springframework.http.HttpStatus;

/**
 * @Author jerry
 * @Description TODO
 * @Date 2021-09-10 18:58
 * @Version 1.0
 **/
public enum CommonErrorCode
{

	NOT_FOUND("error.not_found",String.format("资源不存在(%s)", HttpStatus.NOT_FOUND.getReasonPhrase())),
	BAD_SQL("error.db.badSql","数据操作错误，请联系管理员"),
	ERROR_ERROR("error.error","程序出现错误，请联系管理员"),
	SQL_EXCEPTION("error.sql_exception","数据操作错误，请联系管理员");

	private String code;

	private String message;

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	CommonErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
