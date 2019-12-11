package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.dinner;

@Repository
public class dinnerRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	private static final RowMapper<dinner> dinnerRowMapper = (rs,i) ->{
		dinner Dinner = new dinner();
		Dinner.setId(rs.getInt("id"));
		Dinner.setFoodgenreid(rs.getInt("foodgenreid"));
		Dinner.setFoodname(rs.getString("foodname"));
		Dinner.setFoodpicture(rs.getString("foodpicture"));
		Dinner.setFoodid(rs.getInt("foodid"));

		return Dinner;
	};

	//ジャンルのIDをwhere句で
	//食べ物のIDをランダム関数で発生させる
	public List<dinner> serchDinner(int genreId,int tasteId) {
		double randomId = Math.floor(Math.random() * 9) + 1;//foodidに。
		String sql ="select id,foodgenreid,foodname,foodpicture,foodid from allfood "
					+ "where foodid = :randomId and foodgenreid = :genreId and tasteid = :tasteId;";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("randomId", randomId).addValue("genreId", genreId).addValue("tasteId", tasteId);
		List<dinner> dinnerList = jdbc.query(sql,param, dinnerRowMapper);
		return dinnerList;
	}


}
