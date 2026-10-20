package com.example.lap8.controller;

import com.example.lap8.entity.KhachHang;
import com.example.lap8.repository.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = "/khach-hang")
public class Servlet extends HttpServlet {

    private KhachHangRepository repo;


    public Servlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        repo = new KhachHangRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "view-add":
                req.getRequestDispatcher("/views/khachhang/add.jsp").forward(req, resp);
                break;
            case "detail":
                detail(req, resp);
                break;
            case "view-update":
                viewUpdate(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default:
                list(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if ("add".equals(action)) {
            add(req, resp);
        } else if ("update".equals(action)) {
            update(req, resp);
        } else {
            list(req, resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String keyword = req.getParameter("keyword");
        int page = 1;
        int size = 5;

        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (Exception ignored) {
        }

        List<KhachHang> list;
        long total;

        if (keyword == null || keyword.trim().isEmpty()) {
            list = repo.getPage(page, size);
            total = repo.countAll();
        } else {
            list = repo.searchPage(keyword, page, size);
            total = repo.countSearch(keyword);
        }

        int totalPages = (int) Math.ceil((double) total / size);
        if (totalPages == 0) totalPages = 1;

        req.setAttribute("list", list);
        req.setAttribute("keyword", keyword);
        req.setAttribute("page", page);
        req.setAttribute("totalPages", totalPages);

        req.getRequestDispatcher("/views/khachhang/list.jsp").forward(req, resp);
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        req.setAttribute("kh", repo.getOne(id));
        req.getRequestDispatcher("/views/khachhang/detail.jsp").forward(req, resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        req.setAttribute("kh", repo.getOne(id));
        req.getRequestDispatcher("/views/khachhang/update.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        repo.delete(id);
        resp.sendRedirect(req.getContextPath() + "/khach-hang");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        try {
            KhachHang kh = new KhachHang();
            BeanUtils.populate(kh, req.getParameterMap());
            repo.add(kh);
            resp.sendRedirect(req.getContextPath() + "/khach-hang");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        try {
            KhachHang kh = new KhachHang();
            BeanUtils.populate(kh, req.getParameterMap());
            kh.setId(UUID.fromString(req.getParameter("id")));
            repo.update(kh);
            resp.sendRedirect(req.getContextPath() + "/khach-hang");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}