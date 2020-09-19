package day7;

import java.io.File;
import java.io.FileFilter;

/*
创建过滤器FileFilter的实现类，重写过滤方法accept，定义过滤规则
 */
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        // 如果pathname是一个文件夹也返回true，继续遍历这个文件夹

        if (pathname.isDirectory()){
            return true;
        }
         return pathname.getName().toLowerCase().endsWith(".java");
    }
}
