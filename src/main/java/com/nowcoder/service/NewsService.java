package com.nowcoder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nowcoder.mapper.CommentMapper;
import com.nowcoder.mapper.NewsMapper;
import com.nowcoder.model.News;
import com.nowcoder.util.ToutiaoUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Resource
    protected CommentMapper commentMapper;

    public List<News> getLatestNews(int userId, int offset, int limit) {
        return newsMapper.getNewsList(userId, offset, limit);
    }

    public Map<String, Object> getNewsList(String name, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        if (StringUtils.isNotBlank(name)) {
            name = "'%" + name + "%'";
        } else {
            name = null;
        }
        List<Map<String, Object>> newsList = newsMapper.getAllNews(name);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(newsList);
        Map<String, Object> map = new HashMap<>();
        map.put("data", newsList);
        map.put("count", pageInfo.getTotal());
        map.put("code", "");
        map.put("msg", "");
        return map;
    }

    public int addNews(News news) {
        newsMapper.insert(news);
        return news.getId();
    }

    public int deleteNews(int id) {
        // 删除评论
        commentMapper.deleteByNewsId(id);

        News news = new News();
        news.setId(id);
        news.setIsDelete(1);
        return newsMapper.update(news);
    }

    public News getById(int newsId) {
        return newsMapper.getById(newsId);
    }

    public String saveImage(MultipartFile file) throws IOException {
        int dotPos = file.getOriginalFilename().lastIndexOf(".");
        if (dotPos < 0) {
            return null;
        }
        String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
        if (!ToutiaoUtil.isFileAllowed(fileExt)) {
            return null;
        }

        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
        Files.copy(file.getInputStream(), new File(ToutiaoUtil.IMAGE_DIR + fileName).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        return ToutiaoUtil.TOUTIAO_DOMAIN + "image?name=" + fileName;
    }

    public int updateCommentCount(int id, int count) {
        return newsMapper.updateCommentCount(id, count);
    }

    public int updateLikeCount(int id, int count) {
        return newsMapper.updateLikeCount(id, count);
    }
}
