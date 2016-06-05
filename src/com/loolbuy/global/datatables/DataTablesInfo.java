package com.loolbuy.global.datatables;

import java.text.MessageFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DataTablesInfo
{
 // 内部使用的 Request 对象
    private HttpServletRequest request; 
    //json参数转换为map
    private HashMap<String,String> data; 
    
    private String sEchoParameter = "sEcho";

    // 起始索引和长度
    private String iDisplayStartParameter = "iDisplayStart";
    private String iDisplayLengthParameter = "iDisplayLength";

    // 列数
    private String iColumnsParameter = "iColumns";
    private String sColumnsParameter = "sColumns";
    private String sColumns;

    // 参与排序列数
    private String iSortingColsParameter = "iSortingCols";
    // 排序列的索引
    private String iSortColPrefixParameter = "iSortCol_";
    // 排序的方向 asc, desc
    private String sSortDirPrefixParameter = "sSortDir_";

    // 每一列的可排序性
    private String bSortablePrefixParameter = "bSortable_";

    // 全局搜索
    private String sSearchParameter = "sSearch";
    private String bRegexParameter = "bRegex";

    // 每一列的搜索
    private String bSearchablePrefixParameter = "bSearchable_";
    private String sSearchPrefixParameter = "sSearch_";
    private String bEscapeRegexPrefixParameter = "bRegex_";

    private Integer echo;

    private int displayStart;

    private int displayLength;

    // 参与排序的列
    private int sortingCols;
    public int iSortingCols;

    // 排序列
    private SortInfo[] sortColumns;

    // 排序列的表名
    private String sortTableName;
    private int ColumnCount;

    private ColumnInfo[] columns;

    private String search;

    private Boolean regex;
    

    public void DataTablePram(HttpServletRequest httpRequest) {
        this.request = httpRequest;
    }

    /**
     * 构造函数
     * 
     * @param request
     */
    public DataTablesInfo(HttpServletRequest request) 
    {
        this.request = request;
        
        // 解析datables的参数
        getDataMap();

        this.echo = this.ParseIntParameter(sEchoParameter);
        this.displayStart = this.ParseIntParameter(iDisplayStartParameter);
        this.displayLength = this.ParseIntParameter(iDisplayLengthParameter);
        this.sortingCols = this.ParseIntParameter(iSortingColsParameter);

        this.search = this.ParseStringParameter(sSearchParameter);
        this.regex = this.ParseStringParameter(bRegexParameter) == "true";

        // 排序的列
        int count = sortingCols;
        this.sortColumns = new SortInfo[count];
        
        MessageFormat formatter = new MessageFormat("");
        
        SortInfo sortInfo = null;
        for (int i = 0; i < count; i++) {
            sortInfo = new SortInfo();
            // 排序列Id
            int columnId = this.ParseIntParameter(formatter.format("iSortCol_{0}", i));
            sortInfo.setColumnId(columnId);
            
            // 排序类型
            String aString = this.ParseStringParameter(formatter.format("sSortDir_{0}", i));
            if (aString.equals("desc")) {
                sortInfo.setSortOrder(SortDirection.asc);
            } else {
                sortInfo.setSortOrder(SortDirection.desc);
            }
            this.sortColumns[i] = sortInfo;
        }

        this.ColumnCount = this.ParseIntParameter(iColumnsParameter);

        count = this.ColumnCount;
        this.columns = new ColumnInfo[count];

        //String[] names = this.ParseStringParameter(sColumnsParameter).split(",");
        this.sColumns = "";

        for (int i = 0; i < count; i++) {
            ColumnInfo col = new ColumnInfo();
            String name = this.ParseStringParameter(formatter.format("mDataProp_{0}", i));
            sColumns =  sColumns + "," + name;
            col.setName(name);
            col.setSortable(this.ParseBooleanParameter(formatter.format("bSortable_{0}", i)));
            col.setSearchable(this.ParseBooleanParameter(formatter.format("bSearchable_{0}", i)));
            col.setSearch(this.ParseStringParameter(formatter.format("sSearch_{0}", i)));
            col.setRegex(this.ParseStringParameter(formatter.format("bRegex_{0}", i)) == "true");
            columns[i] = col;
        }
        if (sColumns.length()>0) {
            sColumns = sColumns.substring(1);
        }
    }

    /**
     * 获取datatable的参数
     */
    public void getDataMap() {
        String aoData = request.getParameter("aoData");
        this.data = new HashMap<String,String>();
        
        JSONArray jsonArray = JSONArray.fromObject(aoData);
        for(int i=0;i<jsonArray.size();i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            if(!jsonObj.isNullObject()){
                String name = jsonObj.getString("name");
                String value = jsonObj.getString("value");
                
                this.data.put(name,value);
            }
        }
    }
    
    public String getsColumns() {
        return sColumns;
    }

    public void setsColumns(String sColumns) {
        this.sColumns = sColumns;
    }

     // 解析为整数
    private int ParseIntParameter(String name)  {
        int result = 0;
        //String parameter = this.request.getParameter(name);
        String parameter = data.get(name);
        if (parameter != null) {
            result = Integer.parseInt(parameter);
        }
        return result;
    }
    
    // 解析为字符串
    private String ParseStringParameter(String name) {
        //return this.request.getParameter(name);
        return data.get(name);
    }

     // 解析为布尔类型
    private Boolean ParseBooleanParameter(String name) {
        Boolean result = false;
        //String parameter = this.request.getParameter(name);
        String parameter = data.get(name);
        if (parameter != null) {
            result = Boolean.parseBoolean(parameter);
        }
        return result;
    }

    public String getSortTableName() {
        return sortTableName;
    }

    public void setSortTableName(String sortTableName) {
        this.sortTableName = sortTableName;
    }

    public SortInfo[] getSortColumns() {
        return sortColumns;
    }

    public void setSortColumns(SortInfo[] sortColumns) {
        this.sortColumns = sortColumns;
    }

    public int getColumnCount() {
        return ColumnCount;
    }

    public void setColumnCount(int columnCount) {
        ColumnCount = columnCount;
    }

    public ColumnInfo[] getColumns() {
        return columns;
    }

    public void setColumns(ColumnInfo[] columns) {
        this.columns = columns;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Boolean getRegex() {
        return regex;
    }

    public void setRegex(Boolean regex) {
        this.regex = regex;
    }

    public Integer getEcho() {
        return echo;
    }

    public int getDisplayStart() {
        return displayStart;
    }

    public int getDisplayLength() {
        return displayLength;
    }

    public int getSortingCols() {
        return sortingCols;
    }

}
