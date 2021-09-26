
package cc.momas.customer.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>users complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="users">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CAN_DEL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CAN_NOT_DEL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IS_DEL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IS_NOT_DEL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="role" type="{http://ws.customer.momas.cc/}categories" minOccurs="0"/>
 *         &lt;element name="shop" type="{http://ws.customer.momas.cc/}shops" minOccurs="0"/>
 *         &lt;element name="shopId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="usersCandelete" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="usersId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="usersIsdel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="usersLoginname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usersPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usersRealname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usersRole" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="usersSex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usersTelephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "users", propOrder = {
    "candel",
    "cannotdel",
    "isdel",
    "isnotdel",
    "role",
    "shop",
    "shopId",
    "usersCandelete",
    "usersId",
    "usersIsdel",
    "usersLoginname",
    "usersPassword",
    "usersRealname",
    "usersRole",
    "usersSex",
    "usersTelephone"
})
public class Users {

    @XmlElement(name = "CAN_DEL")
    protected int candel;
    @XmlElement(name = "CAN_NOT_DEL")
    protected int cannotdel;
    @XmlElement(name = "IS_DEL")
    protected int isdel;
    @XmlElement(name = "IS_NOT_DEL")
    protected int isnotdel;
    protected Categories role;
    protected Shops shop;
    protected Integer shopId;
    protected Integer usersCandelete;
    protected Integer usersId;
    protected Integer usersIsdel;
    protected String usersLoginname;
    protected String usersPassword;
    protected String usersRealname;
    protected Integer usersRole;
    protected String usersSex;
    protected String usersTelephone;

    /**
     * 获取candel属性的值。
     * 
     */
    public int getCANDEL() {
        return candel;
    }

    /**
     * 设置candel属性的值。
     * 
     */
    public void setCANDEL(int value) {
        this.candel = value;
    }

    /**
     * 获取cannotdel属性的值。
     * 
     */
    public int getCANNOTDEL() {
        return cannotdel;
    }

    /**
     * 设置cannotdel属性的值。
     * 
     */
    public void setCANNOTDEL(int value) {
        this.cannotdel = value;
    }

    /**
     * 获取isdel属性的值。
     * 
     */
    public int getISDEL() {
        return isdel;
    }

    /**
     * 设置isdel属性的值。
     * 
     */
    public void setISDEL(int value) {
        this.isdel = value;
    }

    /**
     * 获取isnotdel属性的值。
     * 
     */
    public int getISNOTDEL() {
        return isnotdel;
    }

    /**
     * 设置isnotdel属性的值。
     * 
     */
    public void setISNOTDEL(int value) {
        this.isnotdel = value;
    }

    /**
     * 获取role属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Categories }
     *     
     */
    public Categories getRole() {
        return role;
    }

    /**
     * 设置role属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Categories }
     *     
     */
    public void setRole(Categories value) {
        this.role = value;
    }

    /**
     * 获取shop属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Shops }
     *     
     */
    public Shops getShop() {
        return shop;
    }

    /**
     * 设置shop属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Shops }
     *     
     */
    public void setShop(Shops value) {
        this.shop = value;
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
     * 获取usersCandelete属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUsersCandelete() {
        return usersCandelete;
    }

    /**
     * 设置usersCandelete属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUsersCandelete(Integer value) {
        this.usersCandelete = value;
    }

    /**
     * 获取usersId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUsersId() {
        return usersId;
    }

    /**
     * 设置usersId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUsersId(Integer value) {
        this.usersId = value;
    }

    /**
     * 获取usersIsdel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUsersIsdel() {
        return usersIsdel;
    }

    /**
     * 设置usersIsdel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUsersIsdel(Integer value) {
        this.usersIsdel = value;
    }

    /**
     * 获取usersLoginname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsersLoginname() {
        return usersLoginname;
    }

    /**
     * 设置usersLoginname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsersLoginname(String value) {
        this.usersLoginname = value;
    }

    /**
     * 获取usersPassword属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsersPassword() {
        return usersPassword;
    }

    /**
     * 设置usersPassword属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsersPassword(String value) {
        this.usersPassword = value;
    }

    /**
     * 获取usersRealname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsersRealname() {
        return usersRealname;
    }

    /**
     * 设置usersRealname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsersRealname(String value) {
        this.usersRealname = value;
    }

    /**
     * 获取usersRole属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUsersRole() {
        return usersRole;
    }

    /**
     * 设置usersRole属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUsersRole(Integer value) {
        this.usersRole = value;
    }

    /**
     * 获取usersSex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsersSex() {
        return usersSex;
    }

    /**
     * 设置usersSex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsersSex(String value) {
        this.usersSex = value;
    }

    /**
     * 获取usersTelephone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsersTelephone() {
        return usersTelephone;
    }

    /**
     * 设置usersTelephone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsersTelephone(String value) {
        this.usersTelephone = value;
    }

}
