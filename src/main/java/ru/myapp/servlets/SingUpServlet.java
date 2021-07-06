package ru.myapp.servlets;

import ru.myapp.models.User;
import ru.myapp.repositories.UserRepositoriesImpl;
import ru.myapp.repositories.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * аннотация @WebServlet("/signUp") указывает что данный класс - это сервлет
 *
 * GET-запрос к сервлету SingUpServlet будет считаться "/signUp"
 * на этот запрос отвечает переопределенный метод doGet(), и отправляет данные
 *
 * данные - создаем объект, который в себе несет коллекцию Users,
 * и по контракту может отдать Users как List<User>
 */

@WebServlet("/signUp")
public class SingUpServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = new UserRepositoriesImpl();
    }

    /**
     *  позволяет получить список List пользователей
     *
     * @param req установит атрибут "usersFromServer"и положит в него список List users
     * @param resp
     *
     *  userRepository.findAll(); - создаем данные, для передачи в JSP
     *  передача данных осуществляется с помощью метода setAttribute(name, value),
     *  где name - строковое название данных, а value - сами данные, которые могут представлять различные данные.
     *  установливаем атрибут "userFromServer"
     *
     *  RequestDispatcher используется для работы с дополнительными ресурсами(jsp страницы)
     *  ServletContext позволяет получить доступ к параметрам WEB-приложения, определен для всего приложения
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userRepository.findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     *  Добавляем пользователя
     *  @param req хранит полученные поля User
     *
     *      получим все поля User, они пришли в POST запросе
     *      создаем User, отдаем все полученные поля
     *      поле userRepository сохраняет(добавляет) User
     *      направляем сохраненного User на страницу signUp.jsp
     *
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // вытащили данные регистрации
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        // создали пользователя и сохранили его в хранилище
        User user = new User(name, password, birthDate);
        userRepository.save(user);
        doGet(req, resp);
    }
}
