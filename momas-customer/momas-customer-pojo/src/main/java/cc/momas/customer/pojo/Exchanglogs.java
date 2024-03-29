package cc.momas.customer.pojo;

import java.util.Date;

public class Exchanglogs {
    private Integer exchanglogsId;
    private Integer shopId;
    private Integer usersId;
    private Integer memcardsId;
    private String memcardsCardid;
    private String memcardsName;
    private Integer exchanggiftsId;
    private String exchanggiftsGiftcode;
    private String exchanggiftsGiftname;
    private Integer exchanglogsNumber;
    private Integer exchanglogsPoint;
    private Date exchanglogsCreatetime;
    private Integer exchanglogsIsdel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.EXCHANGLOGS_ID
     *
     * @return the value of exchanglogs.EXCHANGLOGS_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getExchanglogsId() {
        return exchanglogsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.EXCHANGLOGS_ID
     *
     * @param exchanglogsId the value for exchanglogs.EXCHANGLOGS_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanglogsId(Integer exchanglogsId) {
        this.exchanglogsId = exchanglogsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.SHOP_ID
     *
     * @return the value of exchanglogs.SHOP_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.SHOP_ID
     *
     * @param shopId the value for exchanglogs.SHOP_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.USERS_ID
     *
     * @return the value of exchanglogs.USERS_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getUsersId() {
        return usersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.USERS_ID
     *
     * @param usersId the value for exchanglogs.USERS_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.MEMCARDS_ID
     *
     * @return the value of exchanglogs.MEMCARDS_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getMemcardsId() {
        return memcardsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.MEMCARDS_ID
     *
     * @param memcardsId the value for exchanglogs.MEMCARDS_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setMemcardsId(Integer memcardsId) {
        this.memcardsId = memcardsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.MEMCARDS_CARDID
     *
     * @return the value of exchanglogs.MEMCARDS_CARDID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public String getMemcardsCardid() {
        return memcardsCardid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.MEMCARDS_CARDID
     *
     * @param memcardsCardid the value for exchanglogs.MEMCARDS_CARDID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setMemcardsCardid(String memcardsCardid) {
        this.memcardsCardid = memcardsCardid == null ? null : memcardsCardid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.MEMCARDS_NAME
     *
     * @return the value of exchanglogs.MEMCARDS_NAME
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public String getMemcardsName() {
        return memcardsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.MEMCARDS_NAME
     *
     * @param memcardsName the value for exchanglogs.MEMCARDS_NAME
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setMemcardsName(String memcardsName) {
        this.memcardsName = memcardsName == null ? null : memcardsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.EXCHANGGIFTS_ID
     *
     * @return the value of exchanglogs.EXCHANGGIFTS_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getExchanggiftsId() {
        return exchanggiftsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.EXCHANGGIFTS_ID
     *
     * @param exchanggiftsId the value for exchanglogs.EXCHANGGIFTS_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsId(Integer exchanggiftsId) {
        this.exchanggiftsId = exchanggiftsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.EXCHANGGIFTS_GIFTCODE
     *
     * @return the value of exchanglogs.EXCHANGGIFTS_GIFTCODE
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public String getExchanggiftsGiftcode() {
        return exchanggiftsGiftcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.EXCHANGGIFTS_GIFTCODE
     *
     * @param exchanggiftsGiftcode the value for exchanglogs.EXCHANGGIFTS_GIFTCODE
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsGiftcode(String exchanggiftsGiftcode) {
        this.exchanggiftsGiftcode = exchanggiftsGiftcode == null ? null : exchanggiftsGiftcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.EXCHANGGIFTS_GIFTNAME
     *
     * @return the value of exchanglogs.EXCHANGGIFTS_GIFTNAME
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public String getExchanggiftsGiftname() {
        return exchanggiftsGiftname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.EXCHANGGIFTS_GIFTNAME
     *
     * @param exchanggiftsGiftname the value for exchanglogs.EXCHANGGIFTS_GIFTNAME
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsGiftname(String exchanggiftsGiftname) {
        this.exchanggiftsGiftname = exchanggiftsGiftname == null ? null : exchanggiftsGiftname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.EXCHANGLOGS_NUMBER
     *
     * @return the value of exchanglogs.EXCHANGLOGS_NUMBER
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getExchanglogsNumber() {
        return exchanglogsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.EXCHANGLOGS_NUMBER
     *
     * @param exchanglogsNumber the value for exchanglogs.EXCHANGLOGS_NUMBER
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanglogsNumber(Integer exchanglogsNumber) {
        this.exchanglogsNumber = exchanglogsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.EXCHANGLOGS_POINT
     *
     * @return the value of exchanglogs.EXCHANGLOGS_POINT
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getExchanglogsPoint() {
        return exchanglogsPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.EXCHANGLOGS_POINT
     *
     * @param exchanglogsPoint the value for exchanglogs.EXCHANGLOGS_POINT
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanglogsPoint(Integer exchanglogsPoint) {
        this.exchanglogsPoint = exchanglogsPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.EXCHANGLOGS_CREATETIME
     *
     * @return the value of exchanglogs.EXCHANGLOGS_CREATETIME
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Date getExchanglogsCreatetime() {
        return exchanglogsCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.EXCHANGLOGS_CREATETIME
     *
     * @param exchanglogsCreatetime the value for exchanglogs.EXCHANGLOGS_CREATETIME
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanglogsCreatetime(Date exchanglogsCreatetime) {
        this.exchanglogsCreatetime = exchanglogsCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanglogs.EXCHANGLOGS_ISDEL
     *
     * @return the value of exchanglogs.EXCHANGLOGS_ISDEL
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getExchanglogsIsdel() {
        return exchanglogsIsdel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanglogs.EXCHANGLOGS_ISDEL
     *
     * @param exchanglogsIsdel the value for exchanglogs.EXCHANGLOGS_ISDEL
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanglogsIsdel(Integer exchanglogsIsdel) {
        this.exchanglogsIsdel = exchanglogsIsdel;
    }
}