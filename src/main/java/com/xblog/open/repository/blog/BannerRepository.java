package com.xblog.open.repository.blog;


import com.xblog.open.entity.blog.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * banner图
 * Created by lovebin on 2017/4/19.
 */

public interface BannerRepository extends JpaRepository<Banner, Integer> , JpaSpecificationExecutor<Banner>{
    List<Banner> findBannersByAppIdAndTypeOrderByIdDesc(int appId, int type);
}
