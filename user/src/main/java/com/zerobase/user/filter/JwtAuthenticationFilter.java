package com.zerobase.user.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zerobase.user.common.properties.JwtConstant;
import com.zerobase.user.common.response.CommonResponse;
import com.zerobase.user.exception.BaseException;
import com.zerobase.user.security.TokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = resolveTokenFromRequest(request);

        try {
            if (StringUtils.hasText(token) && tokenProvider.isTokenValid(token)) {
                Authentication auth = tokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (BaseException e) {
            setErrorResponse(response, e);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void setErrorResponse(HttpServletResponse response, BaseException e) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(
            CommonResponse.fail(e.getErrorCode())
        ));
    }

    private String resolveTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader(JwtConstant.TOKEN_HEADER);

        if (!ObjectUtils.isEmpty(token) && token.startsWith(JwtConstant.TOKEN_PREFIX)) {
            return token.substring(JwtConstant.TOKEN_PREFIX.length());
        }

        return null;
    }

}
