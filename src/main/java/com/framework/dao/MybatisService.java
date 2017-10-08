package com.framework.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;

public class MybatisService implements MybatisDao{

    private static final Log	log	= LogFactory.getLog(MybatisService.class);

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Map<String, Object>> queryForList(String paramString, Object paramObject) throws Exception
    {
        try
        {
            return sqlSession.selectList(paramString, paramObject);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public List<Map<String, Object>> queryForList(String paramString) throws Exception
    {
        try
        {
            return sqlSession.selectList(paramString);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public Object queryForBean(String paramString, Object paramObject) throws Exception
    {
        try
        {
            return sqlSession.selectOne(paramString, paramObject);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> queryForMap(String paramString, Object paramObject) throws Exception
    {
        Map<String, Object> ret = new LinkedHashMap<String, Object>();

        try
        {
            ret = (Map<String, Object>) sqlSession.selectOne(paramString, paramObject);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }

        if (ret == null)
        {
            return new LinkedHashMap<String, Object>();
        }
        return ret;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> queryForMap(String paramString) throws Exception
    {
        Map<String, Object> ret = new LinkedHashMap<String, Object>();

        try
        {
            ret = (Map<String, Object>) sqlSession.selectOne(paramString);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }

        if (ret == null)
        {
            return new LinkedHashMap<String, Object>();
        }
        return ret;
    }

    @Override
    public int getOneFieldInteger(String paramString, Object paramObject) throws Exception
    {
        try
        {
            return ((Integer) sqlSession.selectOne(paramString, paramObject)).intValue();
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public int getOneFieldInteger(String paramString) throws Exception
    {
        try
        {
            return ((Integer) sqlSession.selectOne(paramString)).intValue();
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public String getOneFieldString(String paramString, Object paramObject) throws Exception
    {
        try
        {
            return (String) sqlSession.selectOne(paramString, paramObject);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public String getOneFieldString(String paramString) throws Exception
    {
        try
        {
            return (String) sqlSession.selectOne(paramString);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public Map<String, Object> queryForListMap(String paramString, Object paramObject, String keyNm, String valNm) throws Exception
    {
        Map<String, Object> ret = new LinkedHashMap<String, Object>();
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();

        try
        {
            retList = sqlSession.selectList(paramString, paramObject);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }

        for (int i = 0; i < retList.size(); i++)
        {
            Map<String, Object> map = retList.get(i);

            ret.put((String) map.get(keyNm), map.get(valNm));
        }

        return ret;
    }

    @Override
    public Map<String, Object> queryForListMap(String paramString, String keyNm, String valNm) throws Exception
    {
        Map<String, Object> ret = new LinkedHashMap<String, Object>();
        List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();

        try
        {
            retList = sqlSession.selectList(paramString);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }

        for (int i = 0; i < retList.size(); i++)
        {
            Map<String, Object> map = retList.get(i);

            ret.put((String) map.get(keyNm), map.get(valNm));
        }

        return ret;
    }

    @Override
    public int queryForInsert(String paramString, Object paramObject) throws Exception
    {
        try
        {
            return sqlSession.insert(paramString, paramObject);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public int queryForInsert(String paramString) throws Exception
    {
        try
        {
            return sqlSession.insert(paramString);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public int queryForUpdate(String paramString, Object paramObject) throws Exception
    {
        try
        {
            return sqlSession.update(paramString, paramObject);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public int queryForUpdate(String paramString) throws Exception
    {
        try
        {
            return sqlSession.update(paramString);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public int queryForDelete(String paramString, Object paramObject) throws Exception
    {
        try
        {
            return sqlSession.delete(paramString, paramObject);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public int queryForDelete(String paramString) throws Exception
    {
        try
        {
            return sqlSession.delete(paramString);
        }
        catch (DataAccessException e)
        {
            throw new RuntimeException(getErrorMsg(e));
        }
    }

    @Override
    public int queryForMultiInsert(String paramString, List<Map<String, Object>> paramList) throws Exception
    {
        int i = 0;

        for (i = 0; i < paramList.size(); i++)
        {
            try
            {
                sqlSession.insert(paramString, paramList.get(i));
            }
            catch (DataAccessException e)
            {
                throw new RuntimeException(getErrorMsg(e));
            }
        }
        return i;
    }

    @Override
    public int queryForMultiUpdate(String paramString, List<Map<String, Object>> paramList) throws Exception
    {
        int i = 0;
        int rtn = 0;

        for (i = 0; i < paramList.size(); i++)
        {
            try
            {
                rtn += sqlSession.update(paramString, paramList.get(i));
            }
            catch (DataAccessException e)
            {
                throw new RuntimeException(getErrorMsg(e));
            }
        }

        return rtn;
    }

    @Override
    public void procedure(String paramString, Object paramObject) throws Exception
    {
        try
        {
            try
            {
                sqlSession.update(paramString, paramObject);
            }
            catch (DataAccessException e)
            {
                throw new RuntimeException(getErrorMsg(e));
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        catch (UncategorizedSQLException ue)
        {
            log.debug(ue.getCause());
        }
    }

    public String getErrorMsg(DataAccessException e)
    {
        String errMsg;

        log.error("=======================================================");
        log.error(" 실행에러::" + e.getMessage());
        log.error("=======================================================");

//		errMsg = "내부 오류 :: " + e.getRootCause().getMessage();
//
//		if ((e.getRootCause() instanceof SQLException))
//		{
//			SQLException se = (SQLException) e.getRootCause();
//			errMsg = "내부(DB)오류 : " + se.getMessage();
//		}

        errMsg = e.getMessage();

        return errMsg;
    }
}