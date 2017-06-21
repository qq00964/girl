package com.shonlee.reflect;

import com.shonlee.domain.Girl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ShonLee on 2017/6/21.
 */
public class GetReflectMessageTest {
    @Test
    public void getMessage() throws Exception {
        GetReflectMessage.getMethodsMessage("Hello World");
        System.out.println("-----------------------------------------------------");
        GetReflectMessage.getVariablesMessage("和义信666");
        System.out.println("-----------------------------------------------------");
        GetReflectMessage.GetConstructorMessage(new Integer(1));
    }
}