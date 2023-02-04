package com.abao.learn.service.edu.service.impl;

import com.abao.learn.service.edu.entity.Comment;
import com.abao.learn.service.edu.mapper.CommentMapper;
import com.abao.learn.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author abao
 * @since 2023-01-31
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
