package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsListServlet extends HttpServlet  {
    private static Logger logger = LoggerFactory.getLogger(SecondServlet.class);
    private ArrayList<Product> productsList;
    private final ArrayList<String> productNames = new ArrayList<>(List.of("Молоко", "Яблоки", "Пельмени", "Шоколадка", "Картофель", "Орехи", "Лимонад", "Булочка с маком", "Йогурт", "Бананы"));
    @Override
    public void init() {
        productsList = new ArrayList<>();
        Random random = new Random(1);
        for (int i = 0; i < productNames.size(); i++) {
            float cost = random.nextFloat() * 100;
            productsList.add(new Product(i, productNames.get(i), cost));
        }
        logger.debug("Продукты проинициализированы");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < productNames.size(); i++) {
            resp.getWriter().printf("<h1>" + productsList.get(i).toString()+ "</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
        logger.debug("Продукты выведены на экран");
    }

}
