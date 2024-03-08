package com.example.lab06jspservletjdbc.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imagePath = "/com/example/lab06jspservletjdbc/images/anh3.jpg"; // Đường dẫn tới hình ảnh
        Path path = Paths.get(imagePath);

        // Kiểm tra xem tệp tồn tại
        if (Files.exists(path)) {
            // Đặt loại nội dung là hình ảnh JPEG
            response.setContentType("image/jpeg");

            // Đọc dữ liệu từ tệp hình ảnh và ghi vào OutputStream của phản hồi
            try (OutputStream outputStream = response.getOutputStream()) {
                Files.copy(path, outputStream);
            }
        } else {
            // Nếu tệp không tồn tại, gửi mã lỗi 404 (Not Found)
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
