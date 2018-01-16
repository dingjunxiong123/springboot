package com.boot.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes({String[].class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class ArrayToStringTypeHandler extends BaseTypeHandler<String[]> {
	
	private final static String array_sign = ",";

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, StringUtils.join(parameter, array_sign));
	}

	@Override
	public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if(rs.getObject(columnName) == null){
			return null;
		}
		return StringUtils.split(rs.getString(columnName), array_sign);
	}

	@Override
	public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		if(rs.getObject(columnIndex) == null){
			return null;
		}
		return StringUtils.split(rs.getString(columnIndex), array_sign);
	}

	@Override
	public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		if(cs.getObject(columnIndex) == null){
			return null;
		}
		return StringUtils.split(cs.getString(columnIndex), array_sign);
	}

}