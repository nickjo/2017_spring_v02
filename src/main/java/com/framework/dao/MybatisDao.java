package com.framework.dao;

import java.util.List;
import java.util.Map;

public interface MybatisDao {
	/**
     * List 형식 조회 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     * @return 조회 결과
     */
    public List<Map<String, Object>> queryForList(String paramString, Object paramObject) throws Exception;

    /**
     * List 형식 조회 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @return 조회 결과
     */
    public List<Map<String, Object>> queryForList(String paramString) throws Exception;

    /**
     * Bean(domain) 형식 조회 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     * @return
     */
    public Object queryForBean(String paramString, Object paramObject) throws Exception;

    /**
     * Map 형식 조회 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     * @return 조회 결과
     */
    public Map<String, Object> queryForMap(String paramString, Object paramObject) throws Exception;

    /**
     * Map 형식 조회 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @return 조회 결과
     */
    public Map<String, Object> queryForMap(String paramString) throws Exception;

    /**
     * Integer 형식 단일 건 조회
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     * @return 조회 결과
     */
    public int getOneFieldInteger(String paramString, Object paramObject) throws Exception;

    /**
     * Integer 형식 단일 건 조회
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @return 조회 결과
     */
    public int getOneFieldInteger(String paramString) throws Exception;

    /**
     * String 형식 단일 건 조회
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     * @return 조회 결과
     */
    public String getOneFieldString(String paramString, Object paramObject) throws Exception;

    /**
     * String 형식 단일 건 조회
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @return 조회 결과
     */
    public String getOneFieldString(String paramString) throws Exception;

    /**
     * 조회 쿼리 안의 컬럼을 각각 키, 값으로 맵에 매핑해 반환하는 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param keyNm 조회된 컬럼중 키로 사용할 컬럼명
     * @param valNm 조회된 컬럼중 값으로 사용할 컬럼명
     * @return 매핑된 조회 결과
     */
    public Map<String, Object> queryForListMap(String paramString, Object paramObject, String keyNm, String valNm) throws Exception;

    /**
     * 조회 쿼리 안의 컬럼을 각각 키, 값으로 맵에 매핑해 반환하는 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     * @param keyNm 조회된 컬럼중 키로 사용할 컬럼명
     * @param valNm 조회된 컬럼중 값으로 사용할 컬럼명
     * @return 매핑된 조회 결과
     */
    public Map<String, Object> queryForListMap(String paramString, String keyNm, String valNm) throws Exception;

    /**
     * insert 처리 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     * @return 영향 받은 행 개수
     */
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)*/
    public int queryForInsert(String paramString, Object paramObject) throws Exception;

    /**
     * insert 처리 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @return 영향 받은 행 개수
     */
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)*/
    public int queryForInsert(String paramString) throws Exception;

    /**
     * update 처리 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     * @return 영향 받은 행 개수
     */
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)*/
    public int queryForUpdate(String paramString, Object paramObject) throws Exception;

    /**
     * update 처리 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @return 영향 받은 행 개수
     */
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)*/
    public int queryForUpdate(String paramString) throws Exception;

    /**
     * delete 처리 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     * @return 영향 받은 행 개수
     */
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)*/
    public int queryForDelete(String paramString, Object paramObject) throws Exception;

    /**
     * delete 처리 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @return 영향 받은 행 개수
     */
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)*/
    public int queryForDelete(String paramString) throws Exception;

    /**
     * 여러건의 insert 처리 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramList sql에 적용시킬 파라미터 리스트
     * @return 영향 받은 행 개수
     */
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)*/
    public int queryForMultiInsert(String paramString, List<Map<String, Object>> paramList) throws Exception;

    /**
     * 여러건의 update 처리 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramList sql에 적용시킬 파라미터 리스트
     * @return 영향 받은 행 개수
     */
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)*/
    public int queryForMultiUpdate(String paramString, List<Map<String, Object>> paramList) throws Exception;

    /**
     * 프로시저 실행 메서드
     * @param paramString mapper에 등록되어 있는 목록중 사용할 sql id
     * @param paramObject sql에 적용시킬 파라미터
     */
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)*/
    public void procedure(String paramString, Object paramObject) throws Exception;
}
