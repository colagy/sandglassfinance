package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.Accountbook;
import cn.js.sandglass.finance.util.response.RetResponse;
import cn.js.sandglass.finance.util.response.RetResult;
import cn.js.sandglass.finance.valid.*;
import cn.js.sandglass.finance.service.AccountbookService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "账本")
@RestController
public class AccountbookController {

    @Autowired
    private AccountbookService accountbookService;

    @ApiImplicitParam(name = "accountbookCreateValid",defaultValue = "{name:'566545'}")
    @PostMapping(value = "/accountbook")
    public RetResult<Accountbook> create(@Valid @RequestBody AccountbookCreateValid accountbookCreateValid) {
        var accountbookEntity=new Accountbook();
        accountbookEntity.setName(accountbookCreateValid.getName());
        return RetResponse.ok(accountbookService.create(accountbookEntity));
    }

    @GetMapping(value = "/accountbook.list")
    public RetResult<List<Accountbook>> get() {
        return RetResponse.ok(accountbookService.get());
    }

    @GetMapping(value = "/accountbook")
    public Accountbook getOne(@RequestParam(value = "id",required = true) String id){
        return accountbookService.getOne(id);
    }

    @PutMapping(value = "/accountbook")
    public Accountbook update(@Valid @RequestBody AccountbookUpdateValid accountbookUpdateValid){
        Accountbook accountbookEntity=new Accountbook();
        accountbookEntity.setId(accountbookUpdateValid.getId());
        accountbookEntity.setName(accountbookUpdateValid.getName());
        accountbookEntity.setMark(accountbookUpdateValid.getMark());
        return accountbookService.update(accountbookEntity);
    }

    @DeleteMapping(value = "/accountbook")
    public JSONObject delete(@Valid @RequestBody AccountbookDeleteValid accountbookDeleteValid){
        Accountbook accountbookEntity=new Accountbook();
        accountbookService.delete(accountbookEntity);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg","delete ok");
        jsonObject.put("status",201);
        return jsonObject;
    }

}
