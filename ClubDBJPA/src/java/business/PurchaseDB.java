/**
 *
 * @author KBowe
 */
package business;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


public class PurchaseDB 
{
    public static List<Purchase> getPurchases(String memid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qS = "Select p FROM Purchase p " + 
                    " Where p.memid = :memid " + 
                    " Order by p.purchdt ";
        
        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
        
        q.setParameter("memid", memid);
        
        List<Purchase> p = null;
        
        try
        {
            p = q.getResultList();
            if(p==null || p.isEmpty())
            {
                p = null;
            }
        }
        catch(NoResultException e)
        {
            p = null;
        }
        finally
        {
            em.close();
        }
        return p;
    }
    
    public static List<Purchase> getPurchases(String memid, Date pd)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qS = "Select p FROM Purchase p " + 
                    " Where p.memid = :memid " + 
                    " AND p.purchdt >= :pd " +
                    " Order by p.purchdt ";
        
        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
        
        q.setParameter("memid", memid);
        q.setParameter("pd", pd);
        
        List<Purchase> p = null;
        
        try
        {
            p = q.getResultList();
            if(p==null || p.isEmpty())
            {
                p = null;
            }
        }
        catch(NoResultException e)
        {
            p = null;
        }
        finally
        {
            em.close();
        }
        return p;
    }
    
    public static List<Purchase> getPurchasesX(String memid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qS = "Select " +
                    "(Select SUM(p.amt) From Purchase p Where p.memid = :memid AND p.purchtype = 'D') - (Select SUM(p.amt) From Purchase p Where p.memid = :memid AND p.purchtype = 'C')" +
                    " Order by p.purchdt ";
        
//        String qS = "Select d - c ax X From " +
//                    "(Select sum(p.amt) c from Purchase p Where p.memid = :memid AND p.purchtype = 'C' ," +
//                    "(Select sum(p.amt) d from Purchase p Where p.memid = :memid AND p.purchtype = 'D' ," +
//                    " Order by p.purchdt ";
        
        
        
        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
        
        q.setParameter("memid", memid);
        
        List<Purchase> p = null;
        
        try
        {
            p = q.getResultList();
            if(p==null || p.isEmpty())
            {
                p = null;
            }
        }
        catch(NoResultException e)
        {
            p = null;
        }
        finally
        {
            em.close();
        }
        return p;
    }
    
//    public static List<Purchase> getPurchasesX(String memid, Date pd)
//    {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        String qS = "Select d - c as X From " +
//                    "(Select sum(p.amt) c from Purchase p Where p.memid = :memid AND p.purchdt >= :pd AND p.purchtype = 'C' ," +
//                    "(Select sum(p.amt) d from Purchase p Where p.memid = :memid AND p.purchdt >= :pd AND p.purchtype = 'D' ," +
//                    " Order by p.purchdt ";
//        
//        
//        
//        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
//        
//        q.setParameter("memid", memid);
//        
//        List<Purchase> p = null;
//        
//        try
//        {
//            p = q.getResultList();
//            if(p==null || p.isEmpty())
//            {
//                p = null;
//            }
//        }
//        catch(NoResultException e)
//        {
//            p = null;
//        }
//        finally
//        {
//            em.close();
//        }
//        return p;
//    }
    
    
    //    public static List<Purchase> getPurchasesD(String memid)
//    {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        String qS = "Select SUM (p.amt) FROM Purchase p " + 
//                    " Where p.memid = :memid " + 
//                    " AND p.purchtype = 'D'" +
//                    " Order by p.purchdt ";
//        
//        
//        
//        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
//        
//        q.setParameter("memid", memid);
//        
//        List<Purchase> p = null;
//        
//        try
//        {
//            p = q.getResultList();
//            if(p==null || p.isEmpty())
//            {
//                p = null;
//            }
//        }
//        catch(NoResultException e)
//        {
//            p = null;
//        }
//        finally
//        {
//            em.close();
//        }
//        return p;
//    }
//    
//    public static List<Purchase> getPurchasesC(String memid)
//    {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        String qS = "Select SUM (p.amt) FROM Purchase p " + 
//                    " Where p.memid = :memid " + 
//                    " AND p.purchtype = 'C'" +
//                    " Order by p.purchdt ";
//        
//        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
//        
//        q.setParameter("memid", memid);
//        
//        List<Purchase> p = null;
//        
//        try
//        {
//            p = q.getResultList();
//            if(p==null || p.isEmpty())
//            {
//                p = null;
//            }
//        }
//        catch(NoResultException e)
//        {
//            p = null;
//        }
//        finally
//        {
//            em.close();
//        }
//        return p;
//    }
//    
//    public static List<Purchase> getPurchasesD(String memid, Date pd)
//    {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        String qS = "Select SUM (p.amt) FROM Purchase p " + 
//                    " Where p.memid = :memid " + 
//                    " AND p.purchdt >= :pd " +
//                    " AND p.purchtype = 'D'" +
//                    " Order by p.purchdt ";
//        
//        
//        
//        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
//        
//        q.setParameter("memid", memid);
//        
//        List<Purchase> p = null;
//        
//        try
//        {
//            p = q.getResultList();
//            if(p==null || p.isEmpty())
//            {
//                p = null;
//            }
//        }
//        catch(NoResultException e)
//        {
//            p = null;
//        }
//        finally
//        {
//            em.close();
//        }
//        return p;
//    }
//    
//    public static List<Purchase> getPurchasesC(String memid, Date pd)
//    {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        String qS = "Select SUM (p.amt) FROM Purchase p " + 
//                    " Where p.memid = :memid " + 
//                    " AND p.purchdt >= :pd " +
//                    " AND p.purchtype = 'C'" +
//                    " Order by p.purchdt ";
//        
//        
//        
//        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
//        
//        q.setParameter("memid", memid);
//        
//        List<Purchase> p = null;
//        
//        try
//        {
//            p = q.getResultList();
//            if(p==null || p.isEmpty())
//            {
//                p = null;
//            }
//        }
//        catch(NoResultException e)
//        {
//            p = null;
//        }
//        finally
//        {
//            em.close();
//        }
//        return p;
//    }
    
}
