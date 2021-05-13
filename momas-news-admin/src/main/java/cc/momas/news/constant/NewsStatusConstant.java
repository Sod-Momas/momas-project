package cc.momas.news.constant;

/**
 * 这个接口用来存放状态值常量
 *
 * @author sothe
 *
 */
public interface NewsStatusConstant {
    // 置顶
    Byte TOP = 2;
    // 精品
    Byte GOOD = 1;
    // 普通
    Byte NORMAL = 0;
    // 审核
    Byte AUDIT = -1;
    // 已删除
    Byte DELETED = -2;
    // 已封禁
    Byte BAN = -3;
}
