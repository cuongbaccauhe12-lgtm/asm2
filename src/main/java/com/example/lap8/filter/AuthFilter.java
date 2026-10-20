package com.example.lap8.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {
        "/khach-hang",
        "/nhan-vien",
        "/san-pham",
        "/ban-hang",
        "/hoa-don"
})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String role = (String) session.getAttribute("role");
        String uri = req.getRequestURI();

        // Chỉ Quản lý mới vào /nhan-vien
        if (uri.contains("/nhan-vien") && (role == null || !role.contains("Quản lý"))) {
            resp.sendRedirect(req.getContextPath() + "/khach-hang");
            return;
        }

        chain.doFilter(request, response);
    }
}