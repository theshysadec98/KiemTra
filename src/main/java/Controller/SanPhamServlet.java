package Controller;

import Models.SanPham;
import Services.SanPhamService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/sanpham"})
public class SanPhamServlet extends HttpServlet {
    SanPhamService sanPhamService = new SanPhamService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                resp.sendRedirect("Views/Create.jsp");
                break;
            case "edit":
                int indexEdit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("sanpham", sanPhamService.list.get(indexEdit));
                requestDispatcher = req.getRequestDispatcher("Views/Edit.jsp");
                requestDispatcher.forward(req, resp);
                break;

            case "delete":
                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    sanPhamService.delete(index);
                    resp.sendRedirect("/sanpham");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "findName":
                String name = req.getParameter("findName");
                try {
                    req.setAttribute("listSanPham", sanPhamService.findByName(name));
                    requestDispatcher = req.getRequestDispatcher("Views/Show.jsp");
                    requestDispatcher.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            default:
                req.setAttribute("listSanPham", sanPhamService.list);
                requestDispatcher = req.getRequestDispatcher("Views/Show.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        switch (action) {
            case "create":
                try {
                    int id = Integer.parseInt(req.getParameter("id"));
                    String name = req.getParameter("name");
                    double price = Double.parseDouble(req.getParameter("price"));
                    int quantity = Integer.parseInt(req.getParameter("quantity"));
                    String color = req.getParameter("color");
                    String description = req.getParameter("description");
                    String directory = req.getParameter("directory");

                    SanPham sanPham = new SanPham(id, name, price, quantity,color, description, directory );
                    sanPhamService.save(sanPham);
                    req.setAttribute("listSanPham", sanPhamService.list);
                    requestDispatcher = req.getRequestDispatcher("Views/Show.jsp");
                    requestDispatcher.forward(req, resp);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case "edit":
                try {
                    int id = Integer.parseInt(req.getParameter("id"));
                    String name = req.getParameter("name");
                    double price = Double.parseDouble(req.getParameter("price"));
                    int quantity = Integer.parseInt(req.getParameter("quantity"));
                    String color = req.getParameter("color");
                    String description = req.getParameter("description");
                    String directory = req.getParameter("directory");

                    SanPham sanPham = new SanPham(id, name, price, quantity,color, description, directory );

                    int index = Integer.parseInt(req.getParameter("index"));
                    sanPhamService.edit(sanPham, index);
                    req.setAttribute("listSanPham", sanPhamService.list);
                    requestDispatcher = req.getRequestDispatcher("Views/Show.jsp");
                    requestDispatcher.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
