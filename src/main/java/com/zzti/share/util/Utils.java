package com.zzti.share.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
	public static List createRandomList(List list, int n) {  
        // TODO Auto-generated method stub  
        Map map = new HashMap();  
        List listNew = new ArrayList();  
        if(list.size()<=n){  
            return list;  
        }else{  
            while(map.size()<n){  
                int random = (int) (Math.random() * list.size());  
                if (!map.containsKey(random)) {  
                    map.put(random, "");  
                    System.out.println(random+"==========="+list.get(random));  
                    listNew.add(list.get(random));  
                }  
            }  
            return listNew;  
        }  
    }
}
