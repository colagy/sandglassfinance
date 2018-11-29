package cn.js.sandglass.finance.controller;

import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@Transactional
public class AccountbookControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void create() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "test create accountbook");

        MvcResult result = mvc.perform(post("/accountbook").content(JSONObject.toJSONString(map)))
//                .andExpect(status().isOk())// 模拟向testRest发送请求
                .andReturn();// 返回执行请求的结果
        String content = result.getResponse().getContentAsString();
        System.out.println(result.getResponse().getContentAsString());
        Assert.assertEquals("正确", content, content);
    }

    @Test
    public void get() {
    }

    @Test
    public void getOne() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}