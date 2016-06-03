package com.loolbuy.global.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.loolbuy.global.datatables.DataTablesReturnInfo;
import com.loolbuy.global.jdbc.SqlExecutor;

public class GenericBaseCommonDao{
    /**
     * SqlExecutor
     */
    @Autowired
    public SqlExecutor sqlExecutor;
//
//    /**
//     * 返回JQUERY datatables DataTableReturn模型对象
//     */
//    public DataTableReturn getDataTableReturn(final CriteriaQuery cq, final boolean isOffset) {
//
//        Criteria criteria = cq.getDetachedCriteria().getExecutableCriteria(getSession());
//        CriteriaImpl impl = (CriteriaImpl) criteria;
//        // 先把Projection和OrderBy条件取出来,清空两者来执行Count操作
//        Projection projection = impl.getProjection();
//        final int allCounts = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//        criteria.setProjection(projection);
//        if (projection == null) {
//            criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
//        }
//
//        // 判断是否有排序字段
//        if (cq.getOrdermap() != null) {
//            cq.setOrder(cq.getOrdermap());
//        }
//        int pageSize = cq.getPageSize();// 每页显示数
//        int curPageNO = PagerUtil.getcurPageNo(allCounts, cq.getCurPage(), pageSize);// 当前页
//        int offset = PagerUtil.getOffset(allCounts, curPageNO, pageSize);
//        if (isOffset) {// 是否分页
//            criteria.setFirstResult(offset);
//            criteria.setMaxResults(cq.getPageSize());
//        } else {
//            pageSize = allCounts;
//        }
//        DetachedCriteriaUtil.selectColumn(cq.getDetachedCriteria(), cq.getField().split(","), cq.getEntityClass(),
//                false);
//        return new DataTableReturn(allCounts, allCounts, cq.getDataTables().getEcho(), criteria.list());
//    }

    /**
     * 返回dataTable用数据
     * 
     * @param sql
     * @param values
     * @param dt
     * @return
     */
//    public <T> DataTablesReturnInfo getDataTableReturnBySQL(String sql, String orderSql, final DataTablesInfo dtParams, T paramObj, Class<T> classType) {
//        
//        // 查询总件数
//        String countSQL = " Select count(*) "
//                        + " From (" + sql + ") t";
//        
//        final int allCounts = sqlExecutor.queryForScalarSingle(countSQL, paramObj, Integer.class);
//        // // 判断是否有排序字段
//        // if (!cq.getOrdermap().isEmpty()) {
//        // cq.setOrder(cq.getOrdermap());
//        // }
//        // 排序字段
//        SortInfo[] sortInfo = dtParams.getSortColumns();
//        // 字段
//        String[] sColumns = dtParams.getsColumns().split(",");
//
//        // if(sortInfo.length > 0) {
//        // hql = hql + " order by ";
//        // if (StringUtil.isNotEmpty(dt.getSortTableName())) {
//        // hql = hql + dt.getSortTableName() + ".";
//        // }
//        // for (SortInfo sort : sortInfo) {
//        // hql = hql + sColumns[sort.getColumnId()] + " " + sort.getSortOrder();
//        // }
//        // }
// 
//        // 每页显示数
//        int pageSize = dtParams.getDisplayLength();
//        // 当前页
//        int curPageNo = PagerUtil.getcurPageNo(allCounts, dtParams.getDisplayStart(), pageSize);
//        int offset = PagerUtil.getOffset(allCounts, curPageNo, pageSize);
// 
//        // 查询数据
// 
//        String querySQL = " Select * From ( "
//                        + "    select ROW_NUMBER() over(" + orderSql + ") as rowNumber,*   "
//                        + "    From (" + sql + ") t "
//                        + " ) pv " 
//                        + "  where pv.rowNumber >=" + dtParams.getDisplayStart()
//                        + "  and pv.rowNumber <=" + (dtParams.getDisplayStart() + pageSize);
////         String querySQL = sql + " limit " + dtParams.getDisplayStart() + ", " + pageSize;
//       
//        List<T> list = sqlExecutor.queryForObjectList(querySQL, paramObj, classType);
//        
//        return new DataTablesReturnInfo(allCounts, allCounts, dtParams.getEcho(), list);
//
//    }
//    /**
//     * 返回dataTable用数据
//     * 
//     * @param sql
//     * @param values
//     * @param dt
//     * @return
//     */
//    public <T> DataTablesReturnInfo getDataTableReturnBySQL(String sql, final DataTablesInfo dtParams, T paramObj, Class<T> classType) {
//        
//        // 查询总件数
//        String countSQL = " Select count(*) "
//                        + " From (" + sql + ") t";
//        
//        final int allCounts = sqlExecutor.queryForScalarSingle(countSQL, paramObj, Integer.class);
//        // // 判断是否有排序字段
//        // if (!cq.getOrdermap().isEmpty()) {
//        // cq.setOrder(cq.getOrdermap());
//        // }
//        // 排序字段
//        SortInfo[] sortInfo = dtParams.getSortColumns();
//        // 字段
//        String[] sColumns = dtParams.getsColumns().split(",");
//
//        // if(sortInfo.length > 0) {
//        // hql = hql + " order by ";
//        // if (StringUtil.isNotEmpty(dt.getSortTableName())) {
//        // hql = hql + dt.getSortTableName() + ".";
//        // }
//        // for (SortInfo sort : sortInfo) {
//        // hql = hql + sColumns[sort.getColumnId()] + " " + sort.getSortOrder();
//        // }
//        // }
// 
//        // 每页显示数
//        int pageSize = dtParams.getDisplayLength();
//        // 当前页
//        int curPageNo = PagerUtil.getcurPageNo(allCounts, dtParams.getDisplayStart(), pageSize);
//        int offset = PagerUtil.getOffset(allCounts, curPageNo, pageSize);
// 
//        // 查询数据
// 
//        String querySQL = " Select * From ( "
//                        + "    select ROW_NUMBER() over(order by id desc) as rowNumber,*   "
//                        + "    From (" + sql + ") t "
//                        + " ) pv " 
//                        + "  where pv.rowNumber >" + dtParams.getDisplayStart()
//                        + "  and pv.rowNumber <=" + (dtParams.getDisplayStart() + pageSize);
////         String querySQL = sql + " limit " + dtParams.getDisplayStart() + ", " + pageSize;
//
//        List<T> list = sqlExecutor.queryForObjectList(querySQL, paramObj, classType);
//        
//        return new DataTablesReturnInfo(allCounts, allCounts, dtParams.getEcho(), list);
//    }
//
//    /**
//     * 返回dataTable用数据(无分页)
//     * 
//     * @param sql
//     * @param values
//     * @param dt
//     * @return
//     */
//    public <T> DataTablesReturnInfo getDataTableReturnBySQLNoPage(String sql, final DataTablesInfo dtParams, T paramObj, Class<T> classType) {
//        
//        // 查询总件数
//        String countSQL = " Select count(*) "
//                        + " From (" + sql + ") t";
// 
//        // 查询数据
// 
//        List<T> list = sqlExecutor.queryForObjectList(sql, paramObj, classType);
//        
//        int allCounts = 0;
//        if(list != null) {
//            allCounts = list.size();
//        }
//        return new DataTablesReturnInfo(allCounts, allCounts, dtParams.getEcho(), list);
//
//    }
//
//    /**
//     * 返回dataTable用数据
//     * 
//     * @param sql
//     * @param values
//     * @param dt
//     * @return
//     */
//    public <T> DataTablesReturnInfo getDataTableReturnBySQL2(String sql, final DataTablesInfo dtParams, T paramObj, Class<T> classType) {
//        
//        String countSQL =  sql.substring(sql.indexOf("From"));
//        // 查询总件数
//        countSQL = " Select count(1) " + countSQL ;
//        
//        final int allCounts = sqlExecutor.queryForScalarSingle(countSQL, paramObj, Integer.class);
//        // // 判断是否有排序字段
//        // if (!cq.getOrdermap().isEmpty()) {
//        // cq.setOrder(cq.getOrdermap());
//        // }
//        // 排序字段
//        SortInfo[] sortInfo = dtParams.getSortColumns();
//        // 字段
//        String[] sColumns = dtParams.getsColumns().split(",");
//
//        // if(sortInfo.length > 0) {
//        // hql = hql + " order by ";
//        // if (StringUtil.isNotEmpty(dt.getSortTableName())) {
//        // hql = hql + dt.getSortTableName() + ".";
//        // }
//        // for (SortInfo sort : sortInfo) {
//        // hql = hql + sColumns[sort.getColumnId()] + " " + sort.getSortOrder();
//        // }
//        // }
// 
//        // 每页显示数
//        int pageSize = dtParams.getDisplayLength();
//        // 当前页
//        int curPageNo = PagerUtil.getcurPageNo(allCounts, dtParams.getDisplayStart(), pageSize);
//        int offset = PagerUtil.getOffset(allCounts, curPageNo, pageSize);
// 
//        // 查询数据
// 
//        String querySQL = " Select * From ( "
//                        + "    select ROW_NUMBER() over(order by id desc) as rowNumber,*   "
//                        + "    From (" + sql + ") t "
//                        + " ) pv " 
//                        + "  where pv.rowNumber >" + dtParams.getDisplayStart()
//                        + "  and pv.rowNumber <=" + (dtParams.getDisplayStart() + pageSize);
////         String querySQL = sql + " limit " + dtParams.getDisplayStart() + ", " + pageSize;
//
//        List<T> list = sqlExecutor.queryForObjectList(querySQL, paramObj, classType);
//        
//        return new DataTablesReturnInfo(allCounts, allCounts, dtParams.getEcho(), list);
//    }
}
