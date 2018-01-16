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

@MappedTypes({Long[].class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class ArrayLongToStringTypeHandler extends BaseTypeHandler<Long[]> {
	
	private final static String array_sign = ",";

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Long[] parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, StringUtils.join(parameter, array_sign));
	}

	@Override
	public Long[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if(rs.getObject(columnName) == null){
			return null;
		}
		return convert(rs.getString(columnName));
	}

	@Override
	public Long[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		if(rs.getObject(columnIndex) == null){
			return null;
		}
		return convert(rs.getString(columnIndex));
	}

	@Override
	public Long[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		if(cs.getObject(columnIndex) == null){
			return null;
		}
		return convert(cs.getString(columnIndex));
	}

	private Long[] convert(String value){
		if(StringUtils.isBlank(value)){
			return null;
		}
		String[] str = StringUtils.split(value, array_sign);
		Long[] result = new Long[str.length];
		for (int i = 0; i < str.length; i++) {
			result[i] = Long.parseLong(str[i]);
		}
		return result;
	}
}