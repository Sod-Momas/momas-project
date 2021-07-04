package cc.momas.customer.pojo;

public class Exchanggifts {
    private Integer exchanggiftsExchangnum;
    private String exchanggiftsGiftcode;
    private String exchanggiftsGiftname;
    private Integer exchanggiftsId;
    private Integer exchanggiftsInteger;
    private Integer exchanggiftsIsdel;
    private String exchanggiftsPhoto;
    private Integer exchanggiftsPoint;
    private String exchanggiftsRemark;
    private Integer exchanggiftsState;
    private Integer shopId;
    
    private Shops shop;
    private Categories exchangeGiftState;
    
    public Shops getShop() {
		return shop;
	}

	public Categories getExchangeGiftState() {
		return exchangeGiftState;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
	}

	public void setExchangeGiftState(Categories exchangeGiftState) {
		this.exchangeGiftState = exchangeGiftState;
	}

	public Integer getExchanggiftsExchangnum() {
        return exchanggiftsExchangnum;
    }

    public String getExchanggiftsGiftcode() {
        return exchanggiftsGiftcode;
    }

    public String getExchanggiftsGiftname() {
        return exchanggiftsGiftname;
    }

    public Integer getExchanggiftsId() {
        return exchanggiftsId;
    }

    public Integer getExchanggiftsInteger() {
        return exchanggiftsInteger;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanggifts.EXCHANGGIFTS_ISDEL
     *
     * @return the value of exchanggifts.EXCHANGGIFTS_ISDEL
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getExchanggiftsIsdel() {
        return exchanggiftsIsdel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanggifts.EXCHANGGIFTS_PHOTO
     *
     * @return the value of exchanggifts.EXCHANGGIFTS_PHOTO
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public String getExchanggiftsPhoto() {
        return exchanggiftsPhoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanggifts.EXCHANGGIFTS_POINT
     *
     * @return the value of exchanggifts.EXCHANGGIFTS_POINT
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getExchanggiftsPoint() {
        return exchanggiftsPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanggifts.EXCHANGGIFTS_REMARK
     *
     * @return the value of exchanggifts.EXCHANGGIFTS_REMARK
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public String getExchanggiftsRemark() {
        return exchanggiftsRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanggifts.EXCHANGGIFTS_STATE
     *
     * @return the value of exchanggifts.EXCHANGGIFTS_STATE
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getExchanggiftsState() {
        return exchanggiftsState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exchanggifts.SHOP_ID
     *
     * @return the value of exchanggifts.SHOP_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.EXCHANGGIFTS_EXCHANGNUM
     *
     * @param exchanggiftsExchangnum the value for exchanggifts.EXCHANGGIFTS_EXCHANGNUM
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsExchangnum(Integer exchanggiftsExchangnum) {
        this.exchanggiftsExchangnum = exchanggiftsExchangnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.EXCHANGGIFTS_GIFTCODE
     *
     * @param exchanggiftsGiftcode the value for exchanggifts.EXCHANGGIFTS_GIFTCODE
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsGiftcode(String exchanggiftsGiftcode) {
        this.exchanggiftsGiftcode = exchanggiftsGiftcode == null ? null : exchanggiftsGiftcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.EXCHANGGIFTS_GIFTNAME
     *
     * @param exchanggiftsGiftname the value for exchanggifts.EXCHANGGIFTS_GIFTNAME
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsGiftname(String exchanggiftsGiftname) {
        this.exchanggiftsGiftname = exchanggiftsGiftname == null ? null : exchanggiftsGiftname.trim();
    }

    public void setExchanggiftsId(Integer exchanggiftsId) {
        this.exchanggiftsId = exchanggiftsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.EXCHANGGIFTS_INTEGER
     *
     * @param exchanggiftsInteger the value for exchanggifts.EXCHANGGIFTS_INTEGER
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsInteger(Integer exchanggiftsInteger) {
        this.exchanggiftsInteger = exchanggiftsInteger;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.EXCHANGGIFTS_ISDEL
     *
     * @param exchanggiftsIsdel the value for exchanggifts.EXCHANGGIFTS_ISDEL
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsIsdel(Integer exchanggiftsIsdel) {
        this.exchanggiftsIsdel = exchanggiftsIsdel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.EXCHANGGIFTS_PHOTO
     *
     * @param exchanggiftsPhoto the value for exchanggifts.EXCHANGGIFTS_PHOTO
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsPhoto(String exchanggiftsPhoto) {
        this.exchanggiftsPhoto = exchanggiftsPhoto == null ? null : exchanggiftsPhoto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.EXCHANGGIFTS_POINT
     *
     * @param exchanggiftsPoint the value for exchanggifts.EXCHANGGIFTS_POINT
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsPoint(Integer exchanggiftsPoint) {
        this.exchanggiftsPoint = exchanggiftsPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.EXCHANGGIFTS_REMARK
     *
     * @param exchanggiftsRemark the value for exchanggifts.EXCHANGGIFTS_REMARK
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsRemark(String exchanggiftsRemark) {
        this.exchanggiftsRemark = exchanggiftsRemark == null ? null : exchanggiftsRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.EXCHANGGIFTS_STATE
     *
     * @param exchanggiftsState the value for exchanggifts.EXCHANGGIFTS_STATE
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setExchanggiftsState(Integer exchanggiftsState) {
        this.exchanggiftsState = exchanggiftsState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exchanggifts.SHOP_ID
     *
     * @param shopId the value for exchanggifts.SHOP_ID
     *
     * @mbggenerated Mon Nov 20 16:13:07 CST 2017
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}