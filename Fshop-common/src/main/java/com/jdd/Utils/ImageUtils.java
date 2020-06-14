package com.jdd.Utils;

import org.hibernate.validator.internal.util.privilegedactions.GetResources;

/**
 * @Author: L_earn
 * @Description：图片处理工具类
 * @ckassName：ImageUtils
 * @Date: 2020/6/14 13:56
 */
public class ImageUtils {
    //输入文件名+格式返回图片绝对路径
    public static String getImage(String imagePath){
        String path = GetResources.class.getClassLoader().getResource("images/"+imagePath).getPath();
        path=path.replaceFirst("/","");
        return path;
    }

    public static void main(String[] args) {
        System.out.printf(ImageUtils.getImage("defaultFace.png"));
    }
}
