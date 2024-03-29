package cc.momas.customer.mapper;

import cc.momas.customer.pojo.Exchanggifts;
import cc.momas.customer.pojo.ExchanggiftsExample;
import cc.momas.customer.pojo.Pager;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExchanggiftsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int countByExample(ExchanggiftsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int deleteByExample(ExchanggiftsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int deleteByPrimaryKey(Integer exchanggiftsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int insert(Exchanggifts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int insertSelective(Exchanggifts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    List<Exchanggifts> selectByExample(ExchanggiftsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    Exchanggifts selectByPrimaryKey(Integer exchanggiftsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByExampleSelective(@Param("record") Exchanggifts record, @Param("example") ExchanggiftsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByExample(@Param("record") Exchanggifts record, @Param("example") ExchanggiftsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByPrimaryKeySelective(Exchanggifts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table exchanggifts
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    int updateByPrimaryKey(Exchanggifts record);

	List<Exchanggifts> selectByPager(Pager<Exchanggifts, ExchanggiftsExample> pager);
}