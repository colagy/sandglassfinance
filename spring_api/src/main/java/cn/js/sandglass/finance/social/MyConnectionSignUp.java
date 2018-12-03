package cn.js.sandglass.finance.social;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class MyConnectionSignUp implements ConnectionSignUp {

    public String execute(Connection<?> connection) {
        //根据社交用户信息，默认创建用户并返回用户唯一标识
        return connection.getDisplayName();
    }

    public static class SocialConnectView extends AbstractView {
        @Override
        protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            String msg = "";
            response.setContentType("text/html;charset=UTF-8");
            if (model.get("connections") == null) {
                msg = "unBindingSuccess";
    //            response.getWriter().write("<h3>解绑成功</h3>");
            } else {
                msg = "bindingSuccess";
    //            response.getWriter().write("<h3>绑定成功</h3>");
            }

            response.sendRedirect("/message/" + msg);
        }
    }
}