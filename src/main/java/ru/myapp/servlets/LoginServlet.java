package ru.myapp.servlets;

import ru.myapp.repositories.UserRepositoriesImpl;
import ru.myapp.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserRepository userRepository;

    /**
     *  при загрузке сервлета загружается класс который предоставит интерфейс для работы с хранилищем пользователей
     */
    @Override
    public void init() throws ServletException {
        this.userRepository = new UserRepositoriesImpl();
    }

    /**
     *  при GET запроссе отдаем страницу для залогиниться на login.jsp
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    /**
     *  проверяем есть ли пользователь в системе и создаем сессию с атрибутом "user" присваиваем name
     *  отправляем авторизованного пользователя на /home
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if(userRepository.isExist(name, password)){
            HttpSession session = req.getSession();
            session.setAttribute("user", name);
            req.getServletContext().getRequestDispatcher("/home").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}