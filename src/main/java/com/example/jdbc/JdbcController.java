package com.example.jdbc;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(JdbcController.class);

    @GetMapping("/dataList")
    public String index(Model model) {
        String sql = "SELECT * FROM テーブル名";
        // sql文実行（SELECT）
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        model.addAttribute("dataList", list);
        log.info(list.toString());
        return "view";
    }
}
