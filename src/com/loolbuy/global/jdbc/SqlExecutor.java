package com.loolbuy.global.jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class SqlExecutor{
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final DataSource dataSource;
    public SqlExecutor(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }
//    // //
//        // // query for single without exception. if no record return null, if multi records return first
//        // //
//
//        public Map<String, Object> queryForSingle(String sql) {
//            return queryForSingle(sql, EmptySqlParameterSource.INSTANCE,
//                    new SecureColumnMapRowMapper());
//        }
//
//        public <T> Map<String, Object> queryForSingle(String sql, T params) {
//            return queryForSingle(sql, new BeanPropertySqlParameterSource(params),
//                    new SecureColumnMapRowMapper());
//        }
//
//        public Map<String, Object> queryForSingle(String sql, Map<String, Object> params) {
//            return queryForSingle(sql, new MapSqlParameterSource(params),
//                    new SecureColumnMapRowMapper());
//        }
//
//        public <RT> RT queryForObjectSingle(String sql, Class<RT> elementType) {
//            return queryForSingle(sql, EmptySqlParameterSource.INSTANCE,
//                    new SecureBeanPropertyRowMapper<RT>(elementType));
//        }
//
//        public <RT, PT> RT queryForObjectSingle(String sql, PT params,
//                Class<RT> elementType) {
//            return queryForSingle(sql, new BeanPropertySqlParameterSource(params),
//                    new SecureBeanPropertyRowMapper<RT>(elementType));
//        }
//
//        public <RT> RT queryForObjectSingle(String sql, Map<String, Object> params,
//                Class<RT> elementType) {
//            return queryForSingle(sql, new MapSqlParameterSource(params),
//                    new SecureBeanPropertyRowMapper<RT>(elementType));
//        }
//
//        public <RT> RT queryForScalarSingle(String sql, Class<RT> elementType) {
//            return queryForSingle(sql, EmptySqlParameterSource.INSTANCE,
//                    new SecureSingleColumnRowMapper<RT>(elementType));
//        }
//
//        public <RT, PT> RT queryForScalarSingle(String sql, PT params,
//                Class<RT> elementType) {
//            return queryForSingle(sql, new BeanPropertySqlParameterSource(params),
//                    new SecureSingleColumnRowMapper<RT>(elementType));
//        }
//
//        public <RT> RT queryForScalarSingle(String sql, Map<String, Object> params,
//                Class<RT> elementType) {
//            return queryForSingle(sql, new MapSqlParameterSource(params),
//                    new SecureSingleColumnRowMapper<RT>(elementType));
//        }
//
//        private <T> T queryForSingle(String sql, SqlParameterSource params,
//                RowMapper<T> rowMapper) {
//            List<T> results = jdbcTemplate.query(sql, new SecureSqlParameterSource(params), rowMapper);
//            
//            if(results == null || results.isEmpty()) return null;
//            return results.get(0);
//        }
//
//        // //
//        // // query for single with exception if not return single
//        // //
//
//    // //
//    // // query for single
//    // //
//
//    public Map<String, Object> query(String sql) {
//        return query(sql, EmptySqlParameterSource.INSTANCE,
//                new SecureColumnMapRowMapper());
//    }
//
//    public <T> Map<String, Object> query(String sql, T params) {
//        return query(sql, new BeanPropertySqlParameterSource(params),
//                new SecureColumnMapRowMapper());
//    }
//
//    public Map<String, Object> query(String sql, Map<String, Object> params) {
//        return query(sql, new MapSqlParameterSource(params),
//                new SecureColumnMapRowMapper());
//    }
//
//    public <RT> RT queryForObject(String sql, Class<RT> elementType) {
//        return query(sql, EmptySqlParameterSource.INSTANCE,
//                new SecureBeanPropertyRowMapper<RT>(elementType));
//    }
//
//    public <RT, PT> RT queryForObject(String sql, PT params,
//            Class<RT> elementType) {
//        RT result = null;
//        try {
//            result = query(sql, new BeanPropertySqlParameterSource(params),
//                    new SecureBeanPropertyRowMapper<RT>(elementType));
//        }catch (EmptyResultDataAccessException e) {
//            result = null;
//        }
//        return result;
//    }
//
//    public <RT, PT> RT queryForObjectEx(String sql, PT params,
//            Class<RT> elementType) {
//        return query(sql, new BeanPropertySqlParameterSource(params),
//                new SecureBeanPropertyRowMapper<RT>(elementType));
//    }
//    /**
//     * 取得唯一一条记录，如不存在则抛出EmptyResultDataAccessException异常
//     * @param sql   SQL文
//     * @param params 参数
//     * @param elementType 实体类
//     * @return
//     */
//    public <RT> RT queryForObjectEx(String sql, Map<String, Object> params,
//            Class<RT> elementType) {
//        return query(sql, new MapSqlParameterSource(params),
//                new SecureBeanPropertyRowMapper<RT>(elementType));
//    }
//
//    /**
//     * 取得唯一一条记录，如不存在则返回null
//     * @param sql   SQL文
//     * @param params 参数
//     * @param elementType 实体类
//     * @return
//     */
//    public <RT> RT queryForObject(String sql, Map<String, Object> params,
//            Class<RT> elementType) {
//        RT result = null;
//        try {
//            result = query(sql, new MapSqlParameterSource(params),
//                new SecureBeanPropertyRowMapper<RT>(elementType));
//        } catch (EmptyResultDataAccessException e) {
//            result = null;
//        }
//        return result;
//    }
//
//    public <RT> RT queryForScalar(String sql, Class<RT> elementType) {
//        return query(sql, EmptySqlParameterSource.INSTANCE,
//                new SecureSingleColumnRowMapper<RT>(elementType));
//    }
//
//    public <RT, PT> RT queryForScalar(String sql, PT params,
//            Class<RT> elementType) {
//        return query(sql, new BeanPropertySqlParameterSource(params),
//                new SecureSingleColumnRowMapper<RT>(elementType));
//    }
//
//    public <RT> RT queryForScalar(String sql, Map<String, Object> params,
//            Class<RT> elementType) {
//        return query(sql, new MapSqlParameterSource(params),
//                new SecureSingleColumnRowMapper<RT>(elementType));
//    }
//
//    private <T> T query(String sql, SqlParameterSource params,
//            RowMapper<T> rowMapper) {
//        return jdbcTemplate.queryForObject(sql, new SecureSqlParameterSource(
//                params), rowMapper);
//    }
//
//    // //
//    // // query for list
//    // //
//
//    public List<Map<String, Object>> queryForList(String sql) {
//        return queryForList(sql, EmptySqlParameterSource.INSTANCE,
//                new SecureColumnMapRowMapper());
//    }
//
//    public <PT> List<Map<String, Object>> queryForList(String sql, PT params) {
//        return queryForList(sql, new BeanPropertySqlParameterSource(params),
//                new SecureColumnMapRowMapper());
//    }
//
//    public List<Map<String, Object>> queryForList(String sql,
//            Map<String, Object> params) {
//        return queryForList(sql, new MapSqlParameterSource(params),
//                new SecureColumnMapRowMapper());
//    }
//
//    public <RT> List<RT> queryForObjectList(String sql, Class<RT> elementType) {
//        return queryForList(sql, EmptySqlParameterSource.INSTANCE,
//                new SecureBeanPropertyRowMapper<RT>(elementType));
//    }
//
//    public <RT, PT> List<RT> queryForObjectList(String sql, PT params,
//            Class<RT> elementType) {
//        return queryForList(sql, new BeanPropertySqlParameterSource(params),
//                new SecureBeanPropertyRowMapper<RT>(elementType));
//    }
//
//    public <RT> List<RT> queryForObjectList(String sql,
//            Map<String, Object> params, Class<RT> elementType) {
//        return queryForList(sql, new MapSqlParameterSource(params),
//                new SecureBeanPropertyRowMapper<RT>(elementType));
//    }
//
//    public <RT> List<RT> queryForScalarList(String sql, Class<RT> elementType) {
//        return queryForList(sql, EmptySqlParameterSource.INSTANCE,
//                new SecureSingleColumnRowMapper<RT>(elementType));
//    }
//
//    public <RT, PT> List<RT> queryForScalarList(String sql, PT params,
//            Class<RT> elementType) {
//        return queryForList(sql, new BeanPropertySqlParameterSource(params),
//                new SecureSingleColumnRowMapper<RT>(elementType));
//    }
//
//    public <RT> List<RT> queryForScalarList(String sql,
//            Map<String, Object> params, Class<RT> elementType) {
//        return queryForList(sql, new MapSqlParameterSource(params),
//                new SecureSingleColumnRowMapper<RT>(elementType));
//    }
//
//    private <T> List<T> queryForList(String sql, SqlParameterSource params,
//            RowMapper<T> rowMapper) {
//        return jdbcTemplate.query(sql, new SecureSqlParameterSource(params),
//                rowMapper);
//    }
//
//    // //
//    // // update
//    // //
//
//    public int update(String sql) {
//        return update(sql, EmptySqlParameterSource.INSTANCE);
//    }
//
//    public <T> int update(String sql, T params) {
//        return update(sql, new BeanPropertySqlParameterSource(params));
//    }
//
//    public <T> int insert(String sql, T params) {
//        KeyHolder keyHolder = new GeneratedKeyHolder(); 
//        jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(params), keyHolder);
//        return keyHolder.getKey().intValue();
//    }
//
//    public int update(String sql, Map<String, Object> params) {
//        return update(sql, new MapSqlParameterSource(params));
//    }
//
//    private int update(String sql, SqlParameterSource params) {
//        return jdbcTemplate.update(sql, new SecureSqlParameterSource(params));
//    }
//
//    public <T> int[] batchUpdate(String sql, T[] params) {
//        int[] result = new int[params.length];
//        int i = 0;
//
//        for (T param : params) {
//            result[i++] = update(sql, param);
//        }
//
//        return result;
//    }
//
//    public int[] batchUpdate(String sql, Map<String, Object>[] params) {
//        int[] result = new int[params.length];
//        int i = 0;
//
//        for (Map<String, Object> param : params) {
//            result[i++] = update(sql, param);
//        }
//
//        return result;
//    }
//    public Map<String, Object> queryForPrc(String prcName, Map<String, Object> params, SqlParameter inParam, SqlOutParameter outParam) {
//        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource);
//        jdbcCall.withoutProcedureColumnMetaDataAccess().withProcedureName(prcName);
//        jdbcCall.declareParameters(outParam);       
//        jdbcCall.addDeclaredParameter(inParam);
//        params = jdbcCall.execute(params);
//        return params;
//    }
//    
//    public <RT> List<RT> queryForPrc(String prcName,String returnNm,Class<RT> classz,Map<String, Object> inParamMap ,
//            List<SqlParameter> inParams,List<SqlOutParameter> outParams) {
//        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName(prcName).returningResultSet(returnNm, new SecureSingleColumnRowMapper<RT>(classz));
//        if(outParams!=null){
//            for(SqlOutParameter outParam:outParams){    
//                jdbcCall.declareParameters(outParam);
//            }
//        }
//        if(inParams!=null){
//            for(SqlParameter inParam:inParams){ 
//                jdbcCall.addDeclaredParameter(inParam);
//            }
//        }
//        Map<String,Object> map = jdbcCall.execute(inParamMap);
//        return (List<RT>)map.get(returnNm);
//        //return (RT)resultMap.get(returnNm);
//    }
//    
//    
////  @SuppressWarnings({ "unchecked", "rawtypes" })
////  public int queryForPro(final String sql, final List<Object> params) {
////      return proJdbcTemplate.execute(new CallableStatementCreator() {
////
////          @Override
////          public CallableStatement createCallableStatement(Connection con)
////                  throws SQLException {
////                CallableStatement cs = (CallableStatement) con.prepareCall("{call SP_NEXT_KEY (?,?)}");
////                cs.setInt(1, 5);
////                cs.setString(2, "KEY_REFCODE_ID");
////                cs.registerOutParameter(1,Types.INTEGER);
////                
////              return cs;
////          } }, new CallableStatementCallback() {
////
////              @Override
////              public Object doInCallableStatement(CallableStatement arg0)
////                      throws SQLException, DataAccessException {
////                  arg0.execute();
////                  int res = -1;
////                  try{
////                      res =  arg0.getInt(1);
////                  }catch(Throwable t){
////                  }
////                  return res;
////                  
////                  
////              }});
////  }

}



