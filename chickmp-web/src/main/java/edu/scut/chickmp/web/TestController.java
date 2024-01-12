package edu.scut.chickmp.web;

import com.alibaba.fastjson.JSON;
import edu.scut.chickmp.support.dao.MessageTemplateDao;
import edu.scut.chickmp.support.domain.MessageTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private MessageTemplateDao messageTemplateDao;

    @RequestMapping("/test")
    private String test() {
        log.info("Received!");
        return "Received.";
    }

    @RequestMapping("/database")
    private String testDatabase() {
        List<MessageTemplate> list = messageTemplateDao.findAllByIsDeletedEquals(0, PageRequest.of(0, 10));
        return JSON.toJSONString(list);
    }

}
