package cc.momas.customer.mapper;

import cc.momas.customer.pojo.Cardlevels;
import cc.momas.customer.pojo.CardlevelsExample;
import cc.momas.customer.pojo.Pager;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardlevelsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int countByExample(CardlevelsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int deleteByExample(CardlevelsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int deleteByPrimaryKey(Integer cardlevelsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int insert(Cardlevels record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int insertSelective(Cardlevels record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    List<Cardlevels> selectByExample(CardlevelsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    Cardlevels selectByPrimaryKey(Integer cardlevelsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByExampleSelective(@Param("record") Cardlevels record, @Param("example") CardlevelsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByExample(@Param("record") Cardlevels record, @Param("example") CardlevelsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByPrimaryKeySelective(Cardlevels record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardlevels
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByPrimaryKey(Cardlevels record);

	List<Cardlevels> selectByPager(Pager<Cardlevels, CardlevelsExample> pager);
}