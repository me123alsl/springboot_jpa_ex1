package jpashop;

import jpashop.domain.Member;
import jpashop.domain.Movie;
import jpashop.domain.Order;
import jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

//            ** JPQL
//            List<Member> resultList = em.createQuery("select m from Member m where m.name like '%kim%'", Member.class).getResultList();

//            ** Criteria
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//            Root<Member> m = query.from(Member.class);
//            CriteriaQuery<Member> cq = query.select(m);
//
//            String username ="test";
//            if (username != null) {
//                cq = cq.where(cb.equal(m.get("name"), "kim"));
//            }
//            List<Member> resultList = em.createQuery(cq).getResultList();
//

            List<Member> resultList = em.createNativeQuery("select user, city from member", Member.class).getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
