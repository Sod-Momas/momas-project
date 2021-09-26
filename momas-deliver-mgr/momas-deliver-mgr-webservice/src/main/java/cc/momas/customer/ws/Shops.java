
package cc.momas.customer.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>shops complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="shops">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categories" type="{http://ws.customer.momas.cc/}categories" minOccurs="0"/>
 *         &lt;element name="shopAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopCategoryId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="shopContactname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopContacttel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopCreatetime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="shopId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="shopIsdel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="shopIshassetadmin" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="shopName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shops", propOrder = {
    "categories",
    "shopAddress",
    "shopCategoryId",
    "shopContactname",
    "shopContacttel",
    "shopCreatetime",
    "shopId",
    "shopIsdel",
    "shopIshassetadmin",
    "shopName",
    "shopRemark"
})
public class Shops {

    protected Categories categories;
    protected String shopAddress;
    protected Integer shopCategoryId;
    protected String shopContactname;
    protected String shopContacttel;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar shopCreatetime;
    protected Integer shopId;
    protected Integer shopIsdel;
    protected Integer shopIshassetadmin;
    protected String shopName;
    protected String shopRemark;

    /**
     * 获取categories属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Categories }
     *     
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * 设置categories属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Categories }
     *     
     */
    public void setCategories(Categories value) {
        this.categories = value;
    }

    /**
     * 获取shopAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopAddress() {
        return shopAddress;
    }

    /**
     * 设置shopAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopAddress(String value) {
        this.shopAddress = value;
    }

    /**
     * 获取shopCategoryId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getShopCategoryId() {
        return shopCategoryId;
    }

    /**
     * 设置shopCategoryId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setShopCategoryId(Integer value) {
        this.shopCategoryId = value;
    }

    /**
     * 获取shopContactname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopContactname() {
        return shopContactname;
    }

    /**
     * 设置shopContactname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopContactname(String value) {
        this.shopContactname = value;
    }

    /**
     * 获取shopContacttel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopContacttel() {
        return shopContacttel;
    }

    /**
     * 设置shopContacttel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopContacttel(String value) {
        this.shopContacttel = value;
    }

    /**
     * 获取shopCreatetime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShopCreatetime() {
        return shopCreatetime;
    }

    /**
     * 设置shopCreatetime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShopCreatetime(XMLGregorianCalendar value) {
        this.shopCreatetime = value;
    }

    /**
     * 获取shopId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置shopId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setShopId(Integer value) {
        this.shopId = value;
    }

    /**
     * 获取shopIsdel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getShopIsdel() {
        return shopIsdel;
    }

    /**
     * 设置shopIsdel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setShopIsdel(Integer value) {
        this.shopIsdel = value;
    }

    /**
     * 获取shopIshassetadmin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getShopIshassetadmin() {
        return shopIshassetadmin;
    }

    /**
     * 设置shopIshassetadmin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setShopIshassetadmin(Integer value) {
        this.shopIshassetadmin = value;
    }

    /**
     * 获取shopName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置shopName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopName(String value) {
        this.shopName = value;
    }

    /**
     * 获取shopRemark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopRemark() {
        return shopRemark;
    }

    /**
     * 设置shopRemark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopRemark(String value) {
        this.shopRemark = value;
    }

}
