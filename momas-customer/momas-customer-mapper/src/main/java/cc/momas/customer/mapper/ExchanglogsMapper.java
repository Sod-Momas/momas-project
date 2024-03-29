package cc.momas.customer.mapper;

import cc.momas.customer.pojo.Exchanglogs;
import cc.momas.customer.pojo.ExchanglogsExample;
import cc.momas.customer.pojo.Pager;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExchanglogsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int countByExample(ExchanglogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int deleteByExample(ExchanglogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int deleteByPrimaryKey(Integer exchanglogsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int insert(Exchanglogs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int insertSelective(Exchanglogs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    List<Exchanglogs> selectByExample(ExchanglogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    Exchanglogs selectByPrimaryKey(Integer exchanglogsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByExampleSelective(@Param("record") Exchanglogs record, @Param("example") ExchanglogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByExample(@Param("record") Exchanglogs record, @Param("example") ExchanglogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByPrimaryKeySelective(Exchanglogs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanglogs
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByPrimaryKey(Exchanglogs record);

	List<Exchanglogs> selectByPager(Pager<Exchanglogs, ExchanglogsExample> pager);

}