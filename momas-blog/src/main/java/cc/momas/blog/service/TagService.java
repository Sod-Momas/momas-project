package cc.momas.blog.service;

import cc.momas.blog.pojo.Tag;

import java.util.List;

public interface TagService {
    int saveTag(Tag tag);

    int deleteTag(Long id);

    int updateTag(Tag tag);

    Tag getById(Long id);

    Tag getByName(String name);

    List<Tag> getAllTag();

    List<Tag> getTagByString(String text);

    List<Tag> getAdminTag();
}
