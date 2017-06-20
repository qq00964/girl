package com.shonlee.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ShonLee on 2017/6/12.
 */
public class WeChatIsMonday {
    /**
     * 得到本周周一的日期
     * @return yyyy-MM-dd，
     */
    public static String getMondayOfThisWeek(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //得到今天星期几
        int dayOfWeek=c.get(Calendar.DAY_OF_WEEK)-1;
        //对星期天的特殊处理
        if(dayOfWeek==0){
            dayOfWeek=7;
        }
        //假如今天星期四,往前推3天就是星期一，即 (4-1)
        c.add(Calendar.DATE , -(dayOfWeek-1));
        return df.format(c.getTime());
    }
}
