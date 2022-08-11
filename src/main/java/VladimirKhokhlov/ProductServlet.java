package VladimirKhokhlov;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() {
        this.productRepository = new ProductRepository();
        productRepository.insert(new Product("Product 1", 12.00));
        productRepository.insert(new Product("Product 2", 18.20));
        productRepository.insert(new Product("Product 3", 99.99));
        productRepository.insert(new Product("Product 4", 54.64));
        productRepository.insert(new Product("Product 5", 43.00));
        productRepository.insert(new Product("Product 6", 34.50));
        productRepository.insert(new Product("Product 7", 56.87));
        productRepository.insert(new Product("Product 8", 77.45));
        productRepository.insert(new Product("Product 9", 123.45));
        productRepository.insert(new Product("Product 10", 555.77));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();

        wr.println("<table>");
        wr.println("<tr>");
        wr.println("<th>Id</th>");
        wr.println("<th>Title</th>");
        wr.println("<th>Cost</th>");
        wr.println("</tr>");

        for (Product product : productRepository.findAll()) {
            wr.println("<tr>");
            wr.println("<td><a href ='" + getServletContext().getContextPath() + "/products/" + product.getId() + "'>" + product.getId() + "</td>");
            wr.println("<td>" + product.getTitle() + "</td>");
            wr.println("<td>" + product.getCost() + "</td>");
            wr.println("</tr>");
        }
        wr.println("</table>");
    }

}
