package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 26.09.13
 * Time: 19:39
 * To change this template use File | Settings | File Templates.
 */


    public final class HibernateHelper
    {/*
        private static final ThreadLocal threadSession =
                new ThreadLocal();
        private static final ThreadLocal threadTransaction =
                new ThreadLocal();
        private static SessionFactory mSessionFactory;

        static {
            mSessionFactory = ServiceLocator.getInstance().getSessionFactory();
        }

        public static Session getCurrentSession() {
            Session s = threadSession.get();
            try {
                if (s == null || !s.isOpen()) {
                    if (mLogger.isInfoEnabled()) {
                        mLogger.info("Opening new Session for this thread.");
                    }
                    s = mSessionFactory.openSession();
                    threadSession.set(s);
                }
                else {
                    if (mLogger.isInfoEnabled()) {
                        mLogger.info("Using current session in this thread.");
                    }
                }
            }
            catch (HibernateException ex) {
                throw ("unable to open hibernate session");
            }
            return s;
        }

        public static void closeSession() {
            try {
                final Session s = threadSession.get();
                if (s != null && s.isOpen()) {
                    mLogger.info("Closing Session of this thread.");
                    s.close();
                }
            }
            catch (HibernateException ex) {
                Throw.loggable(HBM_CLOSE_SESSION, ex, false);
            }
            finally {
                threadSession.set(null);
            }
        }

        public static void beginTransaction() {
            Transaction tx = threadTransaction.get();
            try {
                if (tx != null && !tx.isActive()) {
                    tx = null;
                    threadTransaction.set(null);
                }
                if (tx == null) {
                    if (mLogger.isInfoEnabled()) {
                        mLogger.info("Starting new database transaction in this thread.");
                    }
                    if (threadSession.get() != null && threadSession.get().isOpen()) {
                        threadSession.get().close();
                        threadSession.set(null);
                    }
                    tx = getCurrentSession().beginTransaction();
                    threadTransaction.set(tx);
                }
                else {
                    if (mLogger.isInfoEnabled()) {
                        mLogger.info("Using current database transaction in this thread.");
                        mLogger.info("Opening new Session for this thread.");
                    }
                }
            }
            catch (HibernateException ex) {
                Throw.loggable(HBM_BEGIN_TRANSACTION, ex, false);
            }
            finally {
                if (threadSession.get() == null || !threadSession.get().isOpen()) {
                    getCurrentSession();
                }
                else {
                    threadSession.get().clear();
                }
            }
        }

        public static void commitTransaction() {
            final Transaction tx = threadTransaction.get();
            try {
                if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
                {
                    Session s = getCurrentSession();
                    s.flush();
                    if (mLogger.isInfoEnabled()) {
                        mLogger.info("Flushing session and committing transaction of this thread.");
                    }
                    tx.commit();
                }
            }
            catch (HibernateException ex) {
                rollbackTransaction();
                Throw.loggable(HBM_COMMIT_TRANSACTION, ex, false);
            }
            finally {
                threadTransaction.set(null);
                closeSession();
            }
        }

        public static void rollbackTransaction() {
            final Transaction tx = threadTransaction.get();
            try {
                if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
                    mLogger.info("Trying to rollback database transaction of this thread.");
                    tx.rollback();
                }
            }
            catch (HibernateException ex) {
                Throw.loggable(HBM_ROLLBACK_TRANSACTION, ex, false);
            }
            finally {
                threadTransaction.set(null);
                closeSession();
            }
        }*/
    }

