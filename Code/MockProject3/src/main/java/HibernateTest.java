
import com.example.mockproject3.admin.Utils.HibernateUtils;
import com.example.mockproject3.admin.entity.Categories;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTest {

    public static void main(String[] args) {
        try {
            // Bắt đầu một phiên làm việc với Hibernate
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();

            // Truy vấn danh sách các danh mục
            Query<Categories> query = session.createQuery("from Categories", Categories.class);
            List<Categories> categoriesList = query.getResultList();

            // In ra thông tin của từng danh mục
            for (Categories category : categoriesList) {
                System.out.println("Category ID: " + category.getCid() + ", Name: " + category.getName());
            }

            // Commit và đóng phiên làm việc
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
}
