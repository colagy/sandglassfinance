package cn.js.sandglass.finance.controller;

import cn.js.sandglass.finance.entitiy.Accountbook;
import cn.js.sandglass.finance.util.response.RetResponse;
import cn.js.sandglass.finance.util.response.RetResult;
import cn.js.sandglass.finance.valid.*;
import cn.js.sandglass.finance.service.AccountbookService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("hasRole('DEV')")
@Api(tags = "账本")
@RestController
public class AccountbookController {

    @Autowired
    private AccountbookService accountbookService;

    @PostMapping(value = "/accountbook")
    public RetResult<Accountbook> create(@Valid @RequestBody AccountbookCreateValid accountbookCreateValid) {
        var accountbook = new Accountbook();
        accountbook.setName(accountbookCreateValid.getName());
        return RetResponse.ok(accountbookService.create(accountbook));
    }

    @GetMapping(value = "/accountbook.list")
    public RetResult<List<Accountbook>> get() {
        return RetResponse.ok(accountbookService.list());
    }

    @GetMapping(value = "/accountbook")
    public RetResult<Accountbook> getOne(@RequestParam(value = "id", required = true) String id) {
        return RetResponse.ok(accountbookService.get(id));
    }

    @PutMapping(value = "/accountbook")
    public RetResult<Accountbook> update(@Valid @RequestBody AccountbookUpdateValid accountbookUpdateValid) {
        Accountbook accountbook = new Accountbook();
        accountbook.setId(accountbookUpdateValid.getId());
        accountbook.setName(accountbookUpdateValid.getName());
        accountbook.setMark(accountbookUpdateValid.getMark());
        return RetResponse.ok(accountbookService.update(accountbook));
    }

    @DeleteMapping(value = "/accountbook")
    public RetResult delete(@Valid @RequestBody AccountbookDeleteValid accountbookDeleteValid) {
        Accountbook accountbook = new Accountbook();
        accountbookService.delete(accountbook);
        return RetResponse.ok();
    }

}
