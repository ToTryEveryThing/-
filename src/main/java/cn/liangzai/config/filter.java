package cn.liangzai.config;

import cn.liangzai.mapper.UserMapper;
import cn.liangzai.pojo.user;
import cn.liangzai.service.utils.UserDetailsImpl;
import cn.liangzai.utils.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.istack.internal.NotNull;
import io.jsonwebtoken.Claims;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * @author 睡醒继续做梦
 * @date 2023/5/22 11:00
 */
@Component
public class filter extends OncePerRequestFilter {

    @Autowired
    private UserMapper userMapper;



    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
//        判断为空
        if (!StringUtils.hasText(token) || !token.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        token = token.substring(7);


        String name;
        user user;

        Claims claims = JwtUtil.parseJWT(token);
        name = claims.getSubject();

        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        user = userMapper.selectOne(queryWrapper);
        if(user == null){
            System.out.println("用户不存在");
            throw new RuntimeException("用户不存在");
        }


        UserDetailsImpl loginUser = new UserDetailsImpl(user);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, null);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        filterChain.doFilter(request, response);
    }
}