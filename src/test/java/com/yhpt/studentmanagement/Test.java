package com.yhpt.studentmanagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: hjj
 * @Date: 2020/11/17 9:56
 * @Description:
 */
public class Test {
    public static void main(String[] args){
        //集合一
        List _first=new ArrayList();
        _first.add("jim");
        _first.add("tom");
        _first.add("jack");
        //集合二
        List _second=new ArrayList();
        _second.add("jack");
        _second.add("happy");
        _second.add("sun");
        _second.add("good");
        Collection exists=new ArrayList(_second);
        Collection notexists=new ArrayList(_second);
        exists.removeAll(_first);
        System.out.println(exists);
        notexists.removeAll(exists);
        System.out.println(notexists);
    }
}
