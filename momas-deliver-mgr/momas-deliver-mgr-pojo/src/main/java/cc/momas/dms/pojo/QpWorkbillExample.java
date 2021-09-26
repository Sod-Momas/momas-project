package cc.momas.dms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QpWorkbillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QpWorkbillExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWorkbillIdIsNull() {
            addCriterion("workbill_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdIsNotNull() {
            addCriterion("workbill_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdEqualTo(Integer value) {
            addCriterion("workbill_id =", value, "workbillId");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdNotEqualTo(Integer value) {
            addCriterion("workbill_id <>", value, "workbillId");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdGreaterThan(Integer value) {
            addCriterion("workbill_id >", value, "workbillId");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("workbill_id >=", value, "workbillId");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdLessThan(Integer value) {
            addCriterion("workbill_id <", value, "workbillId");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdLessThanOrEqualTo(Integer value) {
            addCriterion("workbill_id <=", value, "workbillId");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdIn(List<Integer> values) {
            addCriterion("workbill_id in", values, "workbillId");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdNotIn(List<Integer> values) {
            addCriterion("workbill_id not in", values, "workbillId");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdBetween(Integer value1, Integer value2) {
            addCriterion("workbill_id between", value1, value2, "workbillId");
            return (Criteria) this;
        }

        public Criteria andWorkbillIdNotBetween(Integer value1, Integer value2) {
            addCriterion("workbill_id not between", value1, value2, "workbillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdIsNull() {
            addCriterion("noticebill_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdIsNotNull() {
            addCriterion("noticebill_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdEqualTo(Integer value) {
            addCriterion("noticebill_id =", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdNotEqualTo(Integer value) {
            addCriterion("noticebill_id <>", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdGreaterThan(Integer value) {
            addCriterion("noticebill_id >", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("noticebill_id >=", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdLessThan(Integer value) {
            addCriterion("noticebill_id <", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdLessThanOrEqualTo(Integer value) {
            addCriterion("noticebill_id <=", value, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdIn(List<Integer> values) {
            addCriterion("noticebill_id in", values, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdNotIn(List<Integer> values) {
            addCriterion("noticebill_id not in", values, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdBetween(Integer value1, Integer value2) {
            addCriterion("noticebill_id between", value1, value2, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andNoticebillIdNotBetween(Integer value1, Integer value2) {
            addCriterion("noticebill_id not between", value1, value2, "noticebillId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPickstateIsNull() {
            addCriterion("pickstate is null");
            return (Criteria) this;
        }

        public Criteria andPickstateIsNotNull() {
            addCriterion("pickstate is not null");
            return (Criteria) this;
        }

        public Criteria andPickstateEqualTo(String value) {
            addCriterion("pickstate =", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateNotEqualTo(String value) {
            addCriterion("pickstate <>", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateGreaterThan(String value) {
            addCriterion("pickstate >", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateGreaterThanOrEqualTo(String value) {
            addCriterion("pickstate >=", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateLessThan(String value) {
            addCriterion("pickstate <", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateLessThanOrEqualTo(String value) {
            addCriterion("pickstate <=", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateLike(String value) {
            addCriterion("pickstate like", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateNotLike(String value) {
            addCriterion("pickstate not like", value, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateIn(List<String> values) {
            addCriterion("pickstate in", values, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateNotIn(List<String> values) {
            addCriterion("pickstate not in", values, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateBetween(String value1, String value2) {
            addCriterion("pickstate between", value1, value2, "pickstate");
            return (Criteria) this;
        }

        public Criteria andPickstateNotBetween(String value1, String value2) {
            addCriterion("pickstate not between", value1, value2, "pickstate");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNull() {
            addCriterion("buildtime is null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNotNull() {
            addCriterion("buildtime is not null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeEqualTo(Date value) {
            addCriterion("buildtime =", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotEqualTo(Date value) {
            addCriterion("buildtime <>", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThan(Date value) {
            addCriterion("buildtime >", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("buildtime >=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThan(Date value) {
            addCriterion("buildtime <", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThanOrEqualTo(Date value) {
            addCriterion("buildtime <=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIn(List<Date> values) {
            addCriterion("buildtime in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotIn(List<Date> values) {
            addCriterion("buildtime not in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeBetween(Date value1, Date value2) {
            addCriterion("buildtime between", value1, value2, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotBetween(Date value1, Date value2) {
            addCriterion("buildtime not between", value1, value2, "buildtime");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesIsNull() {
            addCriterion("attachbilltimes is null");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesIsNotNull() {
            addCriterion("attachbilltimes is not null");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesEqualTo(Integer value) {
            addCriterion("attachbilltimes =", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesNotEqualTo(Integer value) {
            addCriterion("attachbilltimes <>", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesGreaterThan(Integer value) {
            addCriterion("attachbilltimes >", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("attachbilltimes >=", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesLessThan(Integer value) {
            addCriterion("attachbilltimes <", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesLessThanOrEqualTo(Integer value) {
            addCriterion("attachbilltimes <=", value, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesIn(List<Integer> values) {
            addCriterion("attachbilltimes in", values, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesNotIn(List<Integer> values) {
            addCriterion("attachbilltimes not in", values, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesBetween(Integer value1, Integer value2) {
            addCriterion("attachbilltimes between", value1, value2, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andAttachbilltimesNotBetween(Integer value1, Integer value2) {
            addCriterion("attachbilltimes not between", value1, value2, "attachbilltimes");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}