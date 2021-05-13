package cc.momas.announcer.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

/**
 * @author Sod-Momas
 * @since 2019.12.19
 **/
@Entity
public class Announce {
  private Integer id;
  private String title;
  private String titleImageUrl;
  private String content;
  private Boolean isShow;
  private Integer sortNo;
  private String senderName;
  private Date deprecateDatetime;
  private String tag;
  private Long insertUserId;
  private Long updateUserId;
  private Date insertDatetime;
  private Date updateDatetime;

  @Id
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Basic
  @Column(name = "title_image_url")
  public String getTitleImageUrl() {
    return titleImageUrl;
  }

  public void setTitleImageUrl(String titleImageUrl) {
    this.titleImageUrl = titleImageUrl;
  }

  @Basic
  @Column(name = "content")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Basic
  @Column(name = "is_show")
  public Boolean getIsShow() {
    return isShow;
  }

  public void setIsShow(Boolean isShow) {
    this.isShow = isShow;
  }

  @Basic
  @Column(name = "sort_no")
  public Integer getSortNo() {
    return sortNo;
  }

  public void setSortNo(Integer sortNo) {
    this.sortNo = sortNo;
  }

  @Basic
  @Column(name = "sender_name")
  public String getSenderName() {
    return senderName;
  }

  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  @Basic
  @Column(name = "deprecate_datetime")
  public Date getDeprecateDatetime() {
    return deprecateDatetime;
  }

  public void setDeprecateDatetime(Date deprecateDatetime) {
    this.deprecateDatetime = deprecateDatetime;
  }

  @Basic
  @Column(name = "tag")
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  @Basic
  @Column(name = "insert_user_id")
  public Long getInsertUserId() {
    return insertUserId;
  }

  public void setInsertUserId(Long insertUserId) {
    this.insertUserId = insertUserId;
  }

  @Basic
  @Column(name = "update_user_id")
  public Long getUpdateUserId() {
    return updateUserId;
  }

  public void setUpdateUserId(Long updateUserId) {
    this.updateUserId = updateUserId;
  }

  @Basic
  @Column(name = "insert_datetime")
  public Date getInsertDatetime() {
    return insertDatetime;
  }

  public void setInsertDatetime(Date insertDatetime) {
    this.insertDatetime = insertDatetime;
  }

  @Basic
  @Column(name = "update_datetime")
  public Date getUpdateDatetime() {
    return updateDatetime;
  }

  public void setUpdateDatetime(Date updateDatetime) {
    this.updateDatetime = updateDatetime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Announce announce = (Announce) o;
    return Objects.equals(id, announce.id) &&
      Objects.equals(title, announce.title) &&
      Objects.equals(titleImageUrl, announce.titleImageUrl) &&
      Objects.equals(content, announce.content) &&
      Objects.equals(isShow, announce.isShow) &&
      Objects.equals(sortNo, announce.sortNo) &&
      Objects.equals(senderName, announce.senderName) &&
      Objects.equals(deprecateDatetime, announce.deprecateDatetime) &&
      Objects.equals(tag, announce.tag) &&
      Objects.equals(insertUserId, announce.insertUserId) &&
      Objects.equals(updateUserId, announce.updateUserId) &&
      Objects.equals(insertDatetime, announce.insertDatetime) &&
      Objects.equals(updateDatetime, announce.updateDatetime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, titleImageUrl, content, isShow, sortNo, senderName, deprecateDatetime, tag, insertUserId, updateUserId, insertDatetime, updateDatetime);
  }
}
